package SmartCityRideSharingSystem;

public enum VehicleType {
    SEDAN(1.0), XUV(1.5), BIKE(0.8);

    private final double multiplier;

    VehicleType(double multiplier) {
        this.multiplier = multiplier;
    }

    public double getMultiplier() {
        return multiplier;
    }
}


