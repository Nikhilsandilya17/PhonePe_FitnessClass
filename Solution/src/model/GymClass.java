package model;

import enums.FitnessClassType;

import static constants.ApplicationConstants.GYM_CLASS_DURATION;
import static constants.ApplicationConstants.GYM_CLASS_MAX_ATTENDEES;
import static constants.ApplicationConstants.GYM_CLASS_PRICE;

public class GymClass extends FitnessClass{

    public GymClass(String instructorName) {
        super(instructorName, GYM_CLASS_PRICE, GYM_CLASS_DURATION, FitnessClassType.GYM, GYM_CLASS_MAX_ATTENDEES);
    }
}
