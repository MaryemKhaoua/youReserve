public class Room {
    private int nbrRoom;
    private String typeRoom;
    private boolean disponibility;

    public Room(int nbrRoom, String getTypeRoom) {
        this.nbrRoom = nbrRoom;
        this.typeRoom = typeRoom;
        this.disponibility = true;
    }
    public int getNbrRoom() {
        return nbrRoom;
    }

    public String getTypeRoom() {
        return typeRoom;
    }

    public boolean isAvailable() {
        return disponibility;
    }


}
