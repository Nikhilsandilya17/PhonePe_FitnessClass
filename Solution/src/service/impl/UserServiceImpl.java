package service.impl;

import enums.FitnessClassType;
import enums.UserTier;
import exceptions.BookingException;
import exceptions.CancelTimeExceededException;
import exceptions.UserNotFoundException;
import factory.FitnessClassFactory;
import model.FitnessClass;
import model.User;
import repository.UserRepository;
import repository.impl.UserRepositoryImpl;
import service.UserService;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

import static constants.ApplicationConstants.CLASS_BOOKED_SUCCESSFULLY;
import static constants.ApplicationConstants.CLASS_CANCELLED_SUCCESSFULLY;
import static constants.ApplicationConstants.CLASS_CANCEL_DURATION_PASSED;
import static constants.ApplicationConstants.CLASS_IS_FULL;
import static constants.ApplicationConstants.MAX_BOOKINGS_PER_DAY_REACHED;
import static constants.ApplicationConstants.MINUTES_BEFORE_CLASS_TO_CANCEL;
import static constants.ApplicationConstants.NEXT_USER_IN_WAITLIST_ADDED;
import static constants.ApplicationConstants.USER_NOT_FOUND;

public class UserServiceImpl implements UserService {

    private static UserServiceImpl instance;
    private final UserRepository userRepository;
    private final FitnessClassFactory fitnessClassFactory;

    private UserServiceImpl() {
        userRepository = new UserRepositoryImpl();
        fitnessClassFactory = new FitnessClassFactory();
    }

    public static UserServiceImpl getInstance() {
        if (instance == null) {
            instance = new UserServiceImpl();
        }
        return instance;
    }

    @Override
    public void registerUser(String name, String email, UserTier userTier) {
        User user = createUser(generateId(), name, email, userTier);
        userRepository.saveUser(user);
    }

    @Override
    public void bookFitnessClass(String email, FitnessClassType fitnessClassType) throws BookingException {
        User user = getUser(email);
        FitnessClass fitnessClass = fitnessClassFactory.getFitnessClass(fitnessClassType);

        if (fitnessClass.getCurrentCapacity() >= fitnessClass.getMaxAttendees()) {
            fitnessClass.getWaitlist().offer(user);
            throw new BookingException(CLASS_IS_FULL);
        }

        if (user.getBookedClasses().size() >= user.getUserTier().getMaxClassesPerDay()) {
            throw new BookingException(MAX_BOOKINGS_PER_DAY_REACHED + user.getName());
        }

        fitnessClass.setScheduledTime(LocalDateTime.now().plusHours(10));
        user.getBookedClasses().add(fitnessClass);
        System.out.println(CLASS_BOOKED_SUCCESSFULLY + user.getName());
    }

    private User getUser(String email) {
        return userRepository.findUserById(email);
    }

    @Override
    public void cancelFitnessClass(String id, FitnessClassType fitnessClassType) throws CancelTimeExceededException {
        User user = getUser(id);
        for (FitnessClass fitnessClass : user.getBookedClasses()) {
            if (fitnessClass.getFitnessClassType() == fitnessClassType) {
                Duration durationUntilClass = Duration.between(LocalDateTime.now(), fitnessClass.getScheduledTime());
                if (!durationUntilClass.isNegative() && durationUntilClass.toMinutes() >= MINUTES_BEFORE_CLASS_TO_CANCEL) {
                    user.getBookedClasses().remove(fitnessClass);
                    fitnessClass.setCurrentCapacity(fitnessClass.getCurrentCapacity() - 1);
                    assignToNextWaitingUser(fitnessClass);
                    System.out.println(fitnessClass.getFitnessClassType().toString() + CLASS_CANCELLED_SUCCESSFULLY + user.getName());
                    break;
                }
                else {
                    throw new CancelTimeExceededException(CLASS_CANCEL_DURATION_PASSED);
                }
            }
        }
    }

    @Override
    public void getUserBookings(String id) throws UserNotFoundException {
        User user = getUser(id);
        if (user != null) {
            System.out.println("Current bookings for user " + user.getName() + ":");
            for (FitnessClass fitnessClass : user.getBookedClasses()) {
                System.out.println(fitnessClass.getFitnessClassType().toString());
            }
        } else {
            throw new UserNotFoundException(USER_NOT_FOUND + id);
        }
    }

    private void assignToNextWaitingUser(FitnessClass fitnessClass) {
        if(!fitnessClass.getWaitlist().isEmpty()) {
            User nextUser = fitnessClass.getWaitlist().poll();
            if (nextUser != null) {
                nextUser.getBookedClasses().add(fitnessClass);
                fitnessClass.setCurrentCapacity(fitnessClass.getCurrentCapacity() + 1);
                System.out.println(NEXT_USER_IN_WAITLIST_ADDED);
            }
        }
    }

    private String generateId() {
        return UUID.randomUUID().toString();
    }

    private User createUser(String id, String name, String email, UserTier userTier) {
        return new User(id, name, email, userTier);
    }


}
