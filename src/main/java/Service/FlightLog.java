package Service;

import java.time.LocalDate;

public class FlightLog {
    String departureCity;
    String destinationCity;
    double tickerPrice;
    LocalDate purchaseDate;

    public FlightLog(String departureCity, String destinationCity, double tickerPrice){
        this.departureCity = departureCity;
        this.destinationCity = destinationCity;
        this.tickerPrice = tickerPrice;
        this.purchaseDate = LocalDate.now();
    }

    @Override
    public String toString() {
        return  "Flight departing from " + departureCity +
                " to " + destinationCity +
                ", made on " + purchaseDate +
                ", With a price of: " + tickerPrice + "$";
    }
}
