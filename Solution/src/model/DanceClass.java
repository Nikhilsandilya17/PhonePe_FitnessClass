package model;

import enums.FitnessClassType;

import static constants.ApplicationConstants.DANCE_CLASS_DURATION;
import static constants.ApplicationConstants.DANCE_CLASS_MAX_ATTENDEES;
import static constants.ApplicationConstants.DANCE_CLASS_PRICE;

public class DanceClass extends FitnessClass {

    public DanceClass(String instructorName) {
        super(instructorName, DANCE_CLASS_PRICE, DANCE_CLASS_DURATION, FitnessClassType.DANCE, DANCE_CLASS_MAX_ATTENDEES);
    }

}
