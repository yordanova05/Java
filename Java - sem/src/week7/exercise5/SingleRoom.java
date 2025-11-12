package week7.exercise5;

public class SingleRoom extends Room{
    private String bedType;
    public SingleRoom(int roomNumber, String roomType, float pricePerNight, int availableNights,String bedType) {
        super(roomNumber,roomType,pricePerNight,availableNights);
        this.bedType = bedType;
    }

    public String getBedType() {
        return bedType;
    }
    public void setBedType(String bedType) {
        this.bedType = bedType;
    }
}
