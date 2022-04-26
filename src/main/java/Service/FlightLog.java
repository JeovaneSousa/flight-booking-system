package Service;

import java.time.LocalDate;
import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightLog flightLog = (FlightLog) o;
        return Double.compare(flightLog.tickerPrice, tickerPrice) == 0 && Objects.equals(departureCity, flightLog.departureCity) && Objects.equals(destinationCity, flightLog.destinationCity) && Objects.equals(purchaseDate, flightLog.purchaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departureCity, destinationCity, tickerPrice, purchaseDate);
    }

    @Override
    public String toString() {
        return  "Transaction made on " + purchaseDate +
                ". Flight departing from " + departureCity +
                " to " + destinationCity +
                ", With a price of: " + tickerPrice + "$";
    }
}
