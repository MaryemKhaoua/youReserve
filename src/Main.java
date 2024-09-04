import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    private static Hotel hotel = new Hotel("Myyyym");

    public static void main(String[] args) {

        hotel.addRoom(new Room(101));
        hotel.addRoom(new Room(102));
        hotel.addRoom(new Room(103));
        hotel.addRoom(new Room(104));

        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        while (true) {
            System.out.println("\n===============================================");
            System.out.println("       Welcome to Myyyym Hotel :)");
            System.out.println("===============================================");
            System.out.println("1. Add Reservation");
            System.out.println("2. View Reservations");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. Exit");
            System.out.println("===============================================");
            System.out.print("Please choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addReservation(scanner, dateFormat);
                    break;
                case 2:
                    viewReservations();
                    break;
                case 3:
                    cancelReservation(scanner);
                    break;
                case 4:
                    System.out.println("Thank You");
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addReservation(Scanner scanner, SimpleDateFormat dateFormat) {
        try {
            System.out.print("Enter client name: ");
            String clientName = scanner.nextLine();
            System.out.print("Enter client CIN: ");
            String clientCin = scanner.nextLine();
            Client client = new Client(clientName, clientCin);

            System.out.println("\nAvailable Rooms:");
            displayAvailableRooms();

            System.out.print("Enter room number to book: ");
            int roomNumber = scanner.nextInt();
            scanner.nextLine();
            Room room = getRoomByNumber(roomNumber);

            if (room == null || !room.isAvailable()) {
                System.out.println("Room is not available.");
                return;
            }

            System.out.print("Enter start date (yyyy-MM-dd): ");
            Date startDate = dateFormat.parse(scanner.nextLine());
            System.out.print("Enter end date (yyyy-MM-dd): ");
            Date endDate = dateFormat.parse(scanner.nextLine());

            int reservationId = hotel.getReservations().size() + 1;
            Reservation reservation = new Reservation(reservationId, client, room, startDate, endDate);
            hotel.addReservation(reservation);
            room.setAvailability(false);

            System.out.println("Reservation added successfully!");
        } catch (ParseException e) {
            System.out.println("Error parsing date. Please use the format yyyy-MM-dd.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void viewReservations() {
        System.out.println("Current Reservations:");
        hotel.displayReservations();
    }

    private static void cancelReservation(Scanner scanner) {
        System.out.print("Enter reservation ID to cancel: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        hotel.cancelReservation(id);
        System.out.println("Reservation canceled successfully!");
    }
    private static void displayAvailableRooms() {
        for (Room room : hotel.getRooms()) {
            if (room.isAvailable()) {
                System.out.println("Room Number: " + room.getNbrRoom());
            }
        }
    }
    private static Room getRoomByNumber(int roomNumber) {
        for (Room room : hotel.getRooms()) {
            if (room.getNbrRoom() == roomNumber) {
                return room;
            }
        }
        return null;
    }
}