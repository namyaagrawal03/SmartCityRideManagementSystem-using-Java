package SmartCityRideSharingSystem;

import java.util.*;


    public class Rider extends User {
        private List<Ride> rideHistory = new ArrayList<>();

        public Rider(String id, String name, Optional<String> email) {
            super(id, name, email);
            System.out.println("Rider Registered: "+name+" [Email: "+email+"]");
        }

        public List<Ride> getRideHistory(){
            return rideHistory;
        }

        public void addRide(Ride ride) {
            rideHistory.add(ride);
        }

        public void rechargeWalletBalance(double amount){
            setWalletBalance(getWalletBalance()+amount);
            System.out.println("The balance of rider "+getName()+" is recharged with Rs."+amount);
            System.out.println("New balance is "+getWalletBalance());
        }

    }


