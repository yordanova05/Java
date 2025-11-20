package week7.exercise5;
import java.io.IOException;

public interface Reservable {
    void updateAvailabilityFromFile() throws IOException, InvalidRoomDataException;
}
