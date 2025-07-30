package SmartCityRideSharingSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public class Driver extends User {

    VehicleType vehicleType;
    boolean isAvailable = true;
    double averageRating = 0.0;
     List<Double> ratings = new ArrayList<>();



    public Driver(String id, String name, Optional<String> email, List<Double> ratings, VehicleType vehicleType, String plateNo) {
        super(id, name, email);
        this.ratings = ratings;
        this.vehicleType = vehicleType;

        averageRating = calculateAverageRating();



        System.out.println("Driver Registered: " + name + " [Rating: " + averageRating + " | Vehicle: " + vehicleType + " | Plate Number: " + plateNo);
    }


    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Double calculateAverageRating(){
       return ratings.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }

    public Double getAverageRating(){
        return averageRating;
    }

    public void addRating(double rating){
        ratings.add(rating);
        averageRating=calculateAverageRating();
        System.out.println("New average rating of driver "+ getName()+" is : "+averageRating);
    }

    public void creditWalletBalance(double amount){
        setWalletBalance(getWalletBalance()+amount);

        System.out.println("The fare of Rs. "+amount+"is credited in account of  "+getName());
        System.out.println("New balance of driver is "+getWalletBalance());
    }
}

