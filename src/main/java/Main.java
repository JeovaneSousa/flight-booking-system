import Model.Client;
import Model.RegisteredClient;
import Model.UnregisteredClient;
import Service.BookingSystem;


public class Main {
    public static void main(String[] args) {
        String logo = "______             _    _               _____           _                 \n" +
                "| ___ \\           | |  (_)             /  ___|         | |                \n" +
                "| |_/ / ___   ___ | | ___ _ __   __ _  \\ `--. _   _ ___| |_ ___ _ __ ___  \n" +
                "| ___ \\/ _ \\ / _ \\| |/ / | '_ \\ / _` |  `--. \\ | | / __| __/ _ \\ '_ ` _ \\ \n" +
                "| |_/ / (_) | (_) |   <| | | | | (_| | /\\__/ / |_| \\__ \\ ||  __/ | | | | |\n" +
                "\\____/ \\___/ \\___/|_|\\_\\_|_| |_|\\__, | \\____/ \\__, |___/\\__\\___|_| |_| |_|\n" +
                "                                 __/ |         __/ |                      \n" +
                "                                |___/         |___/       ";


        String unloggedOptions =
                "I see you're not logged in. What would you like to do? Choose a number:\n" +
                "---------------------------------------------------\n" +
                "                      OPTIONS                      \n" +
                "---------------------------------------------------\n" +
                "|1 - Register a New User.\n" +
                "|2 - Log In.\n" +
                "|3 - Check Flights.\n" +
                "|4 - Quit Program.\n";

        String loggedOptions =
                "---------------------------------------------------\n" +
                "                 LOGGED USER OPTIONS               \n" +
                "---------------------------------------------------\n" +
                "|1 - Check Flights.\n" +
                "|2 - Book Flight.\n" +
                "|3 - Cancel Flight Reservation.\n" +
                "|4 - Show Booked Flights.\n" +
                "|5 - Log Out.\n" +
                "|6 - Quit Program.\n";

        UnregisteredClient unregisteredClient = new UnregisteredClient();
        RegisteredClient client = null;
        boolean logged = false;
        boolean systemOn = true;
        BookingSystem bookingSystem = new BookingSystem();
        System.out.println(logo);

        while (systemOn){

            while (!logged) {

                System.out.println(unloggedOptions);
                System.out.print("Choose an option:");
                int chosenOption = Client.intInput();

                switch (chosenOption) {
                    case 1: {
                        System.out.print("Type your account name: ");
                        String accountName = Client.stringInput();
                        System.out.print("Type your CPF: ");
                        String cpf = Client.stringInput();
                        System.out.print("Choose a login pin number sequence:");
                        int loginPin = Client.intInput();

                            if (bookingSystem.getClientList().containsKey(cpf)) {
                                System.out.println("The CPF number is already registered.");
                            }
                            else {
                                bookingSystem.registerClient(accountName, cpf, loginPin);
                            }
                            
                        Client.enterToContinue();
                        break;
                    }
                    case 2: {
                        System.out.print("CPF: ");
                        String loginCPF = Client.stringInput();
                        System.out.print("Pin Number: ");
                        int loginPin = Client.intInput();

                            if (bookingSystem.getClientList().containsKey(loginCPF) && (bookingSystem.getClientList().get(loginCPF).getLoginPin() == loginPin)){
                                client = bookingSystem.logIn(loginCPF);
                                logged = bookingSystem.logStatus(client);
                            }
                            else{
                                System.out.println("Login failed. CPF or Pin number not found in our Database.");
                            }

                        Client.enterToContinue();
                        break;
                    }
                    case 3: {
                        unregisteredClient.checkFlights(bookingSystem);
                        Client.enterToContinue();
                        break;
                    }
                    case 4: {
                        System.out.println("Bye bye! Cya!");
                        logged = true;
                        systemOn = false;
                        break;
                    }
                }
            }

            while(logged && client != null){

                System.out.println(loggedOptions);
                System.out.print("Choose an option:");
                int newChosenOption = Client.intInput();

                switch (newChosenOption){
                    case 1: {
                        client.checkFlights(bookingSystem);
                        Client.enterToContinue();
                        break;
                    }
                    case 2: {
                        client.checkFlights(bookingSystem);
                        System.out.print("\n\nWhich flight would you like to book? Type only the Flight code:");
                        int flightCode = Client.intInput();

                            if (bookingSystem.getFlightList().containsKey(flightCode)){
                                client.bookFlight(flightCode,bookingSystem);
                            }
                            else{
                                System.out.println("There's no Flight assigned to this code.");
                            }

                        Client.enterToContinue();
                        break;
                    }
                    case 3: {
                        client.showBookedFlights();
                        System.out.print("\n\nWhich flight would you like to cancel? Type only it's code:");
                        int reservationIndex = Client.intInput();

                            if ((reservationIndex > 0) && (reservationIndex <= client.getBookedFlights().size()))
                                client.cancelReservation(reservationIndex);
                            else
                                System.out.println("There's no reservation assigned to this code.");

                        Client.enterToContinue();
                        break;
                    }
                    case 4: {
                        client.showBookedFlights();
                        Client.enterToContinue();
                        break;
                    }
                    case 5: {
                        logged = bookingSystem.logOut();
                        Client.enterToContinue();
                        break;
                    }
                    case 6: {
                        System.out.println("Bye bye! Cya!");
                        logged = false;
                        systemOn = false;
                        break;
                    }
                }
            }
        }
        System.out.println("Booking System Transactions log:");
        System.out.println(bookingSystem.getFlightLog());
    }
}
