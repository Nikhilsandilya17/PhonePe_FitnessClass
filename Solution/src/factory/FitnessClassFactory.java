package factory;

import enums.FitnessClassType;
import model.DanceClass;
import model.FitnessClass;
import model.GymClass;
import model.YogaClass;

public class FitnessClassFactory {

    private static final String FITNESS_CLASS_TYPE_UNSUPPORTED = "Unsupported fitness class type: ";

    public FitnessClass getFitnessClass(FitnessClassType fitnessClassType) {
        return switch (fitnessClassType) {
            case YOGA -> new YogaClass("Instructor1");
            case GYM -> new GymClass("Instructor2");
            case DANCE -> new DanceClass("Instructor3");
            default -> throw new IllegalArgumentException(FITNESS_CLASS_TYPE_UNSUPPORTED + fitnessClassType);
        };
    }
}
