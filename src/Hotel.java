import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hotel {
    private String hotelName;
    private List<Room> rooms;
    private Map<Integer, Reservation> reservations;

    public Hotel(String hotelName) {
        this.hotelName = hotelName;
        this.rooms = new ArrayList<>();
        this.reservations = new HashMap<>();
    }

    public void addRoom(Room room) {
        this.rooms.add(room);
    }

    public List<Room> getRooms() {
        return this.rooms;
    }

    public void addReservation(Reservation reservation) {
        this.reservations.put(reservation.getId(), reservation);
    }

    public Reservation getReservation(int id) {
        return this.reservations.get(id);
    }

    public void cancelReservation(int id) {
        Reservation reservation = this.reservations.get(id);
        if (reservation != null) {
            reservation.cancelReservation();
            this.reservations.remove(id);
        }
    }

    public void displayReservations() {
        for (Reservation reservation : this.reservations.values()) {
            reservation.displayReservationDetails();
        }
    }
    public Map<Integer, Reservation> getReservations() {
        return this.reservations;
    }
}