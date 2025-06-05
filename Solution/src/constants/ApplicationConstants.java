package constants;

public final class ApplicationConstants {

    private ApplicationConstants() {

    }

    public static final double YOGA_CLASS_PRICE = 50.00;
    public static final double GYM_CLASS_PRICE = 100.00;
    public static final double DANCE_CLASS_PRICE = 150.00;

    public static final int YOGA_CLASS_DURATION = 60;
    public static final int GYM_CLASS_DURATION = 45;
    public static final int DANCE_CLASS_DURATION = 30;

    public static final int YOGA_CLASS_MAX_ATTENDEES = 100;
    public static final int GYM_CLASS_MAX_ATTENDEES = 50;
    public static final int DANCE_CLASS_MAX_ATTENDEES = 30;

    public static final String CLASS_IS_FULL = "Class is full, adding to waitlist.";
    public static final int MINUTES_BEFORE_CLASS_TO_CANCEL = 30;
    public static final String CLASS_CANCELLED_SUCCESSFULLY = " class cancelled successfully for ";
    public static final String NEXT_USER_IN_WAITLIST_ADDED = "Next user in waitlist has been booked for the class.";
    public static final String CLASS_BOOKED_SUCCESSFULLY = "Class booked successfully for ";
    public static final String MAX_BOOKINGS_PER_DAY_REACHED = "Maximum booking limit reached for the day for user: ";

    public static final String USER_NOT_FOUND = "User not found with email: ";
    public static final String CLASS_CANCEL_DURATION_PASSED = "Class cancel duration has passed";


}
