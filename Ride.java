package SmartCityRideSharingSystem;

class Ride{

    static int counter = 1;
    String rideId;
    Rider rider;
    Driver driver;
    String source;
    String destination;
    VehicleType vehicleType;
    double fare;
    double rating;
    RideStatus status;

    public Ride(Rider rider, Driver driver, String source, String destination, VehicleType vehicleType) {
        this.rideId = "RIDE" + (counter++);
        this.rider = rider;
        this.driver = driver;
        this.source = source;
        this.destination = destination;
        this.vehicleType = vehicleType;

    }



}
