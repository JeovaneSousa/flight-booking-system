package Service;

import Model.RegisteredClient;
import java.util.*;

public class BookingSystem {

    private Map<String,RegisteredClient> clientList;
    private Map<Integer,Flight> flightList;
    private List<FlightLog> flightLog;

    public BookingSystem(){
        this.clientList = new HashMap<>();
        this.flightList = new HashMap<>();
        this.flightLog = new ArrayList<>();
        this.flightList.put(1,
                    new Flight(
                    "Fortaleza", 2022, 4, 28, 10, 30,
                    "Paris", 2022, 4, 28, 22, 30,
                    2000.00
                    ));
        this.flightList.put(2,
                    new Flight(
                    "Paris", 2022, 5, 10, 10, 30,
                    "Fortaleza", 2022, 5, 10, 22, 30,
                    1500.00
                    ));
        this.flightList.put(3,
                    new Flight(
                    "Fortaleza", 2022, 8, 25, 10, 30,
                    "Toronto", 2022, 8, 25, 22, 30,
                    3000.00
                    ));
        this.flightList.put(4,
                    new Flight(
                    "Toronto", 2022, 9, 15, 10, 30,
                    "Fortaleza", 2022, 9, 25, 22, 30,
                    4000.00
                    ));
    }

    public void checkFlights(){
        System.out.println("\n\nHere is a list of the available flights:");
        for(Integer key : this.flightList.keySet()){
            System.out.println("Code: " + key + " - " + this.flightList.get(key));
        }
    }

    public void registerClient(String accountName, String cpf, int loginPin){
            RegisteredClient newClient = new RegisteredClient(accountName, cpf, loginPin);
            System.out.println("Great !\n");
            System.out.println("User created successfully! \n" +
                               "Login: " + accountName + " and CPF: " + cpf);
            this.clientList.put(cpf,newClient);
    }

    public RegisteredClient logIn(String loginCPF) {
     System.out.println("Successfullly logged in. \n\n" + "Welcome, " + this.getClientList().get(loginCPF).getAccountName() + ". to Booking System for Registered Users. ");
     return this.getClientList().get(loginCPF);
    }

    public void addToPurchaseLog(String departureCity, String destinationCity, double tickerPrice){
        FlightLog newPurchase = new FlightLog(departureCity,destinationCity, tickerPrice);
        this.flightLog.add(newPurchase);
        System.out.println("Your purchase of a " + newPurchase + " was successfull.");

    }
    public boolean logStatus(RegisteredClient registeredClient){
        return registeredClient != null;
    }

    public boolean logOut(){
        System.out.println("Successfullly logged out. \n\n");
        return false;
    }

    public Map<String, RegisteredClient> getClientList() {
        return clientList;
    }

    public Map<Integer, Flight> getFlightList() {
        return flightList;
    }

    public List<FlightLog> getFlightLog() {
        return flightLog;
    }
}
