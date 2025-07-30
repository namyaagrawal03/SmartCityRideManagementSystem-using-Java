package SmartCityRideSharingSystem;

import java.util.Optional;

abstract class User{
    private String id;
    private String name;
    private Optional<String> email;
    private double walletBalance;

    public User(String id, String name, Optional<String> email) {
        this.id = id;
        this.name = name;
        this.email = email;
        walletBalance=0.0;
    }

    public Optional<String> getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public double getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(double amount){
        walletBalance=amount;
    }



    public void deductBalance(double fare) throws InsufficientBalanceException {
        if(walletBalance<fare){
            throw new InsufficientBalanceException("The balance is insufficient for the transaction. Please recharge your wallet!!");
        }

        walletBalance-=fare;
        System.out.println("The fare amount is deducted from account of user");
        System.out.println("New balance is "+walletBalance);
    }


}