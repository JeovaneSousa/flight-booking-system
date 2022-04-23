package Service;

import java.time.LocalDate;
import java.time.LocalTime;

public class Flight {
    private String departureCity;
    private LocalDate departureDate;
    private LocalTime departureTime;
    private String destinationCity;
    private LocalDate destinationDate;
    private LocalTime destinationTime;
    private double ticketPrice;

    public Flight(String departureCity, int departureYear, int departureMonth, int departureDay, int departureHour, int departureMinutes,
                  String destinationCity, int destinationlYear, int destinationlMonth, int destinationlDay, int destinationlHour, int destinationlMinutes,
                  Double ticketPrice ){
        this.departureCity = departureCity;
        this.departureDate = LocalDate.of(departureYear,departureMonth,departureDay);
        this.departureTime = LocalTime.of(departureHour,departureMinutes);
        this.destinationCity = destinationCity;
        this.destinationDate = LocalDate.of(destinationlYear, destinationlMonth, destinationlDay);
        this.destinationTime = LocalTime.of(destinationlHour,destinationlMinutes);
        this.ticketPrice = ticketPrice;
    }

    @Override
    public String toString() {
        return  "City of Departure = " + departureCity +
                ", Leaving at: " + departureTime + "h" +
                ", on: " + departureDate +
                ", Destination = " + destinationCity +
                ", Arriving at: " + destinationTime + "h" +
                ", on: " + destinationDate +
                ", Price = " + ticketPrice + "$" +
                '.';
    }









    public String getDepartureCity() {
        return departureCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }
}
