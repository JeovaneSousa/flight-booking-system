package Model;

import Service.BookingSystem;
import Service.Flight;


import java.util.LinkedList;
import java.util.List;

public class RegisteredClient extends Client {
    private final String accountName;
    private final String cpf;
    private int loginPin;
    private List<Flight> bookedFlights;

    public RegisteredClient(String accountName, String cpf,int loginPin ) {
        this.accountName = accountName;
        this.cpf = cpf;
        this.loginPin = loginPin;
        this.bookedFlights = new LinkedList();
    }

    public void bookFlight(Integer code, BookingSystem bookingSystem) {
        this.bookedFlights.add(bookingSystem.getFlightList().get(code));

        String departureCity = bookingSystem.getFlightList().get(code).getDepartureCity();
        String destinationCity = bookingSystem.getFlightList().get(code).getDestinationCity();
        double ticketPrice = bookingSystem.getFlightList().get(code).getTicketPrice();

        bookingSystem.addToPurchaseLog(departureCity, destinationCity, ticketPrice);
    }

    public void showBookedFlights() {
        int code = 1;
        System.out.println("\n\nHere is a list of the Flights you've booked:");
        for(Flight flight : bookedFlights){
            System.out.println("Code: " + code + ". " + flight);
            code++;
        }
    }

    public void cancelReservation(int code){
        this.bookedFlights.remove(code -1);
        this.showBookedFlights();
    }
    
    public int getLoginPin() {
        return loginPin;
    }

    public String getAccountName() {
        return accountName;
    }

    public List<Flight> getBookedFlights() {
        return bookedFlights;
    }
}













