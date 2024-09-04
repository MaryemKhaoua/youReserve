public class Room {
    private int nbrRoom;
    private String typeRoom;
    private boolean availability;
    private Hotel hotel;

    public Room(int nbrRoom) {
        this.nbrRoom = nbrRoom;
        this.availability = true;
    }

    public int getNbrRoom() {
        return nbrRoom;
    }

    public boolean isAvailable() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }


}
