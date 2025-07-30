package SmartCityRideSharingSystem;

import java.util.*;

public class RideManager {

    private List<Ride> rideHistory = new ArrayList<>();

    // Booking a ride
    public void bookRide(Rider rider, VehicleType vehicleTypeNeeded, String source, String destination, List<Driver> driverList, boolean simulateCancellation) throws InsufficientBalanceException ,InvalidInputException {

        if (source == null || source.isEmpty() || destination == null || destination.isEmpty()) {
            throw new InvalidInputException("Pickup and drop locations must be provided.");
        }

        if (rider == null) {
            throw new InvalidInputException("Rider information is missing.");
        }

        if (vehicleTypeNeeded == null) {
            throw new InvalidInputException("Vehicle type must be specified.");
        }

        System.out.println(rider.getName() + " requested a " + vehicleTypeNeeded + " from '" + source + "' to '" + destination + "'");
        System.out.println("Searching for available drivers...");


        Optional<Driver> matchedDriver = driverList.stream()
                .filter(driver -> driver.vehicleType.equals(vehicleTypeNeeded) && driver.isAvailable)
                .findFirst();

        if (matchedDriver.isPresent()) {
            Driver driver = matchedDriver.get();
            System.out.println("Driver matched: " + driver.getName() + " (" + driver.vehicleType + ")");
            driver.setAvailable(false); // Mark driver unavailable

            Ride ride = new Ride(rider, driver, source, destination, vehicleTypeNeeded);
            ride.status = RideStatus.ONGOING;
            rideHistory.add(ride);
            rider.addRide(ride);


            if (simulateCancellation) {
                ride.status = RideStatus.CANCELLED;
                driver.setAvailable(true);
                System.out.println("Ride " + ride.rideId + " has been CANCELLED by the driver.");
                return;
            }

            System.out.println("Driver " + driver.getName() + " accepted the ride");
            System.out.println("Ride ID " + ride.rideId + " is now ONGOING");


            // Simulate successful ride completion
            ride.fare = FareCalculator.calculateFare(vehicleTypeNeeded, 20.0); // Example base fare
            ride.status = RideStatus.COMPLETED;

            driver.setAvailable(true);

            System.out.println("Driver " + driver.getName() + " completed the ride");
            System.out.println("Ride completed successfully");
            System.out.println("Fare: ₹" + ride.fare);



            rider.deductBalance(ride.fare);

            driver.creditWalletBalance(ride.fare);
            System.out.println("Transaction sucessfull!!");


        } else {
            System.out.println("No drivers available for vehicle type: " + vehicleTypeNeeded);
        }
    }


//    private int simulateFeedback(Rider rider) {
//        if (rider.getName().equalsIgnoreCase("Emma")) return 5;
//        else return 4;
//    }

    public void rateRide(Driver driver, double rating){

        System.out.println("Feedback recorded: " + rating + " stars");
        driver.addRating(rating);
        //return rating;

    }

    public List<Ride> getAllRides() {
        return rideHistory;
    }
}
