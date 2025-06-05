package enums;

public enum UserTier {
    SILVER(1),
    GOLD(2),
    PLATINUM(3);

    private final int maxClassesPerDay;

    UserTier(int maxClassesPerDay) {
        this.maxClassesPerDay = maxClassesPerDay;
    }

    public int getMaxClassesPerDay() {
        return maxClassesPerDay;
    }
}
