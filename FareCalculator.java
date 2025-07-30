package SmartCityRideSharingSystem;

public class FareCalculator {
    public static double calculateFare(VehicleType type, double baseFare) {
        return type.getMultiplier()*baseFare;
    }
}
