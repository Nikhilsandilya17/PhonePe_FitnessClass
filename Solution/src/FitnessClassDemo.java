import enums.FitnessClassType;
import enums.UserTier;
import exceptions.BookingException;
import exceptions.UserNotFoundException;
import service.UserService;
import service.impl.UserServiceImpl;

public class FitnessClassDemo {
    public static void main(String[] args) throws BookingException, UserNotFoundException {
        UserService userService = UserServiceImpl.getInstance();
        // Register a new user
        userService.registerUser("Nikhil", "nikhil@gcom", UserTier.PLATINUM);
        userService.registerUser("Sandy", "sandy@gcom", UserTier.GOLD);
        userService.registerUser("Ravi", "ravi@gcom", UserTier.SILVER);

        // Book fitness classes for the user
        userService.bookFitnessClass("nikhil@gcom", FitnessClassType.YOGA);
        userService.bookFitnessClass("sandy@gcom", FitnessClassType.GYM);
        userService.bookFitnessClass("ravi@gcom", FitnessClassType.DANCE);
        userService.bookFitnessClass("nikhil@gcom", FitnessClassType.GYM);


        // Attempt to book a class that is full
        try {
            userService.bookFitnessClass("ravi@gcom", FitnessClassType.YOGA);
        } catch (BookingException e) {
            System.out.println(e.getMessage());
        }

        //Get all booking for a user
        userService.getUserBookings("nikhil@gcom");

        // Cancel a fitness class
        try {
            userService.cancelFitnessClass("nikhil@gcom", FitnessClassType.YOGA);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        userService.getUserBookings("nikhil@gcom");
        try{
            userService.getUserBookings("abc@gcom");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
