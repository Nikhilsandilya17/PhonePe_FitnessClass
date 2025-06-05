package service;

import enums.FitnessClassType;
import enums.UserTier;
import exceptions.BookingException;
import exceptions.CancelTimeExceededException;
import exceptions.UserNotFoundException;

public interface UserService {
    void registerUser(String name, String email, UserTier userTier);
    void bookFitnessClass(String email, FitnessClassType fitnessClassType) throws BookingException;
    void cancelFitnessClass(String id, FitnessClassType fitnessClassType) throws CancelTimeExceededException;

    void getUserBookings(String id) throws UserNotFoundException;
}
