package Model;

import Service.BookingSystem;
import Service.Flight;
import Service.FlightLog;


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

    public void bookFlight(Integer flightCode, BookingSystem bookingSystem) {

        if (bookingSystem.getFlightList().containsKey(flightCode)) {

            this.bookedFlights.add(bookingSystem.getFlightList().get(flightCode));

            String departureCity = bookingSystem.getFlightList().get(flightCode).getDepartureCity();
            String destinationCity = bookingSystem.getFlightList().get(flightCode).getDestinationCity();
            double ticketPrice = bookingSystem.getFlightList().get(flightCode).getTicketPrice();

            bookingSystem.addToPurchaseLog(departureCity, destinationCity, ticketPrice);
        }
        else
            System.out.println("There's no Flight assigned to this code.");

    }

    public void showBookedFlights() {
        int code = 1;
        System.out.println("\n\nHere is a list of the Flights you've booked:");
        for(Flight flight : bookedFlights){
            System.out.println("Code: " + code + ". " + flight);
            code++;
        }
    }

    public void cancelReservation(int reservationIndex, BookingSystem bookingSystem) {
        if ((reservationIndex > 0) && (reservationIndex <= this.bookedFlights.size())) {
            String departureCity = this.bookedFlights.get(reservationIndex - 1).getDepartureCity();
            String destinationCity = this.bookedFlights.get(reservationIndex - 1).getDestinationCity();
            double ticketPrice = this.bookedFlights.get(reservationIndex - 1).getTicketPrice();
            FlightLog mockLog = new FlightLog(departureCity,destinationCity,ticketPrice);
            bookingSystem.getFlightLog().remove(mockLog);

            this.bookedFlights.remove(reservationIndex - 1);
            this.showBookedFlights();
        }
        else
            System.out.println("There's no reservation assigned to this code.");
    }
    
    public int getLoginPin() {
        return loginPin;
    }

    public String getAccountName() {
        return accountName;
    }

}













