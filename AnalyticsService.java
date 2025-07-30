package SmartCityRideSharingSystem;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnalyticsService {

    public static void totalRides(List<Ride> rides) {
        long completed = rides.stream().filter(r -> r.status == RideStatus.COMPLETED).count();
        long cancelled = rides.stream().filter(r -> r.status == RideStatus.CANCELLED).count();

        System.out.println("✅ Total Rides Completed: " + completed);
        System.out.println("✅ Total Rides Cancelled: " + cancelled);
    }

    public static void topRatedDriver(List<Driver> drivers) {

        Driver topDriver = drivers.stream()
                .max(Comparator.comparing(driver->driver.averageRating)).orElse(null);

        System.out.println("Top Driver is: "+topDriver.getName()+" ("+topDriver.averageRating+")");

    }

    public static void printRideHistory(Rider rider) {
        System.out.println("\n" + rider.getName() + "'s Ride History:");
        rider.getRideHistory().forEach(ride -> {
            System.out.println("- " + ride.rideId +
                    " | Destination: " + ride.destination +
                    " | Vehicle: " + ride.vehicleType +
                    " | Fare: ₹" + ride.fare);
        });
    }

    public static void printAvailableDrivers(List<Driver> drivers) {
        System.out.println("\nAvailable Drivers:");
        drivers.stream()
                .filter(d -> d.isAvailable)
                .forEach(d -> System.out.println("- " + d.getName() + " [" + d.vehicleType + "]"));
    }

    public static void riderNamesWithE(List<Rider> riderList){
        System.out.println("Riders with names starting with 'E': ");
        riderList.stream()
                .filter(rider->rider.getName().startsWith("E"))
                .forEach(rider ->System.out.println(rider.getName()));
    }

    public static void sortedDrivers(List<Driver> drivers){
        System.out.println("Drivers sorted by rating: ");
        drivers.stream()
                .sorted(Comparator.comparing(Driver::getAverageRating).reversed())
                .forEach(driver-> System.out.println(driver.getName()+" - "+driver.averageRating));

    }

    public static void sortedRides(List<Ride> ridesList){
        System.out.println(" Rides by Vehicle Type: ");
        Map<VehicleType, Long> resultMap = ridesList.stream()
                .collect(Collectors.groupingBy(ride->ride.vehicleType, Collectors.counting()));

       resultMap.forEach((type, count)-> System.out.println(type+" : "+count));

    }




}
