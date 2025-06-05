package model;

import enums.FitnessClassType;

import static constants.ApplicationConstants.YOGA_CLASS_DURATION;
import static constants.ApplicationConstants.YOGA_CLASS_MAX_ATTENDEES;
import static constants.ApplicationConstants.YOGA_CLASS_PRICE;

public class YogaClass extends FitnessClass{

    public YogaClass(String instructorName) {
        super(instructorName, YOGA_CLASS_PRICE, YOGA_CLASS_DURATION, FitnessClassType.YOGA, YOGA_CLASS_MAX_ATTENDEES);
    }


}
