import java.util.Date;

public class Reservation {
    private int id;
    private Client client;
    private Room room;
    private Date startDate;
    private Date endDate;

    public Reservation(int id, Client client, Room room, Date startDate, Date endDate) {
        this.id = id;
        this.client = client;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;

    }

    public int getId() {
        return this.id;
    }

    public void cancelReservation() {
        this.room.setAvailability(true);
    }

    public void modifyReservation(Client client, Room room, Date startDate, Date endDate) {
        this.client = client;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void displayReservationDetails() {
        System.out.println("Reservation id: " + this.id);
        System.out.println("Client name: " + this.client.getName());
        System.out.println("Room number: " + this.room.getNbrRoom());
        System.out.println("Start date: " + this.startDate);
        System.out.println("End date: " + this.endDate);
    }
}