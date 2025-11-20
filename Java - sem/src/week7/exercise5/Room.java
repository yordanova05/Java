package week7.exercise5;

public class Room {
    protected int roomNumber;
    protected String roomType;
    protected float pricePerNight;
    protected int availableNights;

    public Room(){

    }
    public Room(int roomNumber, String roomType, float pricePerNight, int availableNights) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.availableNights = availableNights;
    }

    public int getRoomNumber(){
        return roomNumber;
    }
    public void setRoomNumber(int roomNumber){
        this.roomNumber = roomNumber;
    }
    public String getRoomType(){
        return roomType;
    }
    public void setRoomType(String roomType){
        this.roomType = roomType;
    }
    public float getPricePerNight(){
        return pricePerNight;
    }
    public void setPricePerNight(float pricePerNight){
        this.pricePerNight = pricePerNight;
    }
    public int getAvailableNights(){
        return  availableNights;
    }
    public void setAvailableNights(int availableNights){
        this.availableNights = availableNights;
    }

    protected boolean reserveRoom(int numNights) throws NotAvailableNightsException {
        if (availableNights >= numNights) {
            availableNights = availableNights - numNights;
            return true;
        }
        throw new NotAvailableNightsException("No available nights!");
    }
}
