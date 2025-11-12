package week7.exercise5;

public class SuiteRoom extends Room{
    private int numberRooms;
    public SuiteRoom(int roomNumber, String roomType, float pricePerNight, int availableNights,int numberRooms) {
        super(roomNumber,roomType,pricePerNight,availableNights);
        this.numberRooms = numberRooms;
    }
    public int getNumberRooms() {
        return numberRooms;
    }
    public void setNumberRooms(int numberRooms) {
        this.numberRooms = numberRooms;
    }
}
