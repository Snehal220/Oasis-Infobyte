import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class OnlineReservationSystem {
    private Map<String, String> users = new HashMap<>(); // Simulating user data storage

    public OnlineReservationSystem() {
        // Initialize some users (loginID, password)
        users.put("user1", "password1");
        users.put("user2", "password2");
    }

    public boolean authenticateUser(String loginID, String password) {
        // Check if the provided login credentials are valid
        return users.containsKey(loginID) && users.get(loginID).equals(password);
    }

    public void reserveTicket(String loginID) {
        Scanner scanner = new Scanner(System.in);

        // Collecting reservation details
        System.out.println("Enter Details for Reservation:");
        System.out.print("Train Number: ");
        int trainNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Class Type: ");
        String classType = scanner.nextLine();
        System.out.print("Date of Journey: ");
        String dateOfJourney = scanner.nextLine();
        System.out.print("From (Place of Origin): ");
        String origin = scanner.nextLine();
        System.out.print("To (Destination): ");
        String destination = scanner.nextLine();

        // Displaying reservation details
        System.out.println("\nReservation Details:");
        System.out.println("Train Number: " + trainNumber);
        System.out.println("Class Type: " + classType);
        System.out.println("Date of Journey: " + dateOfJourney);
        System.out.println("From: " + origin);
        System.out.println("To: " + destination);

        // Here you can add logic to save the reservation details to a database or perform further actions.
        System.out.println("Reservation for user " + loginID + " completed successfully.");

        scanner.close();
    }

    public void cancelTicket(String PNR) {
        // Logic to handle ticket cancellation
        // You can add code to retrieve ticket details and cancel the ticket here
        System.out.println("Ticket with PNR: " + PNR + " canceled successfully.");
    }
}

public class Main2 {
    public static void main(String[] args) {
        OnlineReservationSystem reservationSystem = new OnlineReservationSystem();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Online Reservation System");

        // Login
        System.out.print("Enter Login ID: ");
        String loginID = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        if (reservationSystem.authenticateUser(loginID, password)) {
            System.out.println("Login Successful. Choose an option:");
            System.out.println("1. Reserve Ticket");
            System.out.println("2. Cancel Ticket");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    reservationSystem.reserveTicket(loginID);
                    break;
                case 2:
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter PNR to cancel ticket: ");
                    String PNR = scanner.nextLine();
                    reservationSystem.cancelTicket(PNR);
                    break;
                default:
                    System.out.println("Invalid option");
            }
        } else {
            System.out.println("Invalid Login. Access Denied.");
        }

        scanner.close();
    }
}