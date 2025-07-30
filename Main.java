package SmartCityRideSharingSystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        List<Driver> driverList = new ArrayList<>();
        List<Rider> riderList = new ArrayList<>();

        System.out.println("--- Initializing System ---\n");
        Driver d1 = new Driver("d101", "Alice", Optional.of("alice@123"), new ArrayList<>(Arrays.asList(4.0, 3.5)), VehicleType.SEDAN, "AL1234");
        Driver d2 = new Driver("d102", "Charlie", Optional.of("charlie@123"), new ArrayList<>(Arrays.asList(5.0, 3.5)), VehicleType.XUV, "BO9987");
        Driver d3 = new Driver("d103", "Darcy", Optional.of("darcy@123.com"), new ArrayList<>(Arrays.asList(4.5, 3.5)), VehicleType.BIKE, "CL5678");

        driverList.add(d1);
        driverList.add(d2);
        driverList.add(d3);

        Rider r1 = new Rider("r101", "Namya", Optional.of("namya@123"));
        Rider r2 = new Rider("r102", "Emma", Optional.of("bob@123"));
        riderList.add(r1);
        riderList.add(r2);

        System.out.println("\n------------------------------------------------------\n");

        RideManager rideManager = new RideManager();

        // Ride 1


        try {
            r1.rechargeWalletBalance(100);
            System.out.println();
            rideManager.bookRide(r1, VehicleType.SEDAN, null, "City Center", driverList, false);

            System.out.println();
            rideManager.rateRide(d1, 5.0);
        }

        catch (InsufficientBalanceException e) {
            System.out.println("Payment failed: " + e.getMessage());
        } catch (InvalidInputException e) {
            System.out.println("Invalid Input: "+ e.getMessage());
        }


        System.out.println("\n------------------------------------------------------\n");

        //Rode 1
        try {
            r1.rechargeWalletBalance(100);
            System.out.println();
            rideManager.bookRide(r1, VehicleType.SEDAN, "Airport", "City Center", driverList, false);

            System.out.println();
            rideManager.rateRide(d1, 5.0);
        }

        catch (InsufficientBalanceException e) {
            System.out.println("Payment failed: " + e.getMessage());
        } catch (InvalidInputException e) {
            System.out.println("Invalid Input: "+ e.getMessage());
        }


        System.out.println("\n------------------------------------------------------\n");

        try {
            rideManager.bookRide(r2, VehicleType.BIKE, "Museum", "Hotel Grand", driverList, false);
        } catch (InsufficientBalanceException e) {
            System.out.println("Payment failed: " + e.getMessage());
        }
        catch (InvalidInputException e){
            System.out.println("Invalid Input: "+ e.getMessage());
        }

        System.out.println("\n------------------------------------------------------\n");

        System.out.println("\n--- Reporting & Analytics ---");
        AnalyticsService.totalRides(rideManager.getAllRides());
        AnalyticsService.topRatedDriver(driverList);

        AnalyticsService.printRideHistory(r1);
        AnalyticsService.printRideHistory(r2);
        AnalyticsService.printAvailableDrivers(driverList);

        System.out.println("\n------------------------------------------------------\n");
        System.out.println("--- Data Queries (Streams & Filters) ---");
        System.out.println();

        AnalyticsService.riderNamesWithE(riderList);
        System.out.println();
        AnalyticsService.sortedDrivers(driverList);
        System.out.println();

        AnalyticsService.sortedRides(rideManager.getAllRides());
        System.out.println();


    }

}
