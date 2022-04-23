package Model;

import Service.BookingSystem;

import java.util.Scanner;

public abstract class Client {
    public void checkFlights(BookingSystem bookingSystem){
    bookingSystem.checkFlights();
    }

    public static int intInput(){
        Scanner intScanner = new Scanner(System.in);
        int output = intScanner.nextInt();
        return output;
    }

    public static String stringInput(){
        Scanner intScanner = new Scanner(System.in);
        String output = intScanner.nextLine();
        return output;
    }

    public static void enterToContinue(){
        Scanner enterScannerr = new Scanner(System.in);
        System.out.println("Press 'Enter' to continue.");
        String enter = enterScannerr.nextLine();
    }
}
