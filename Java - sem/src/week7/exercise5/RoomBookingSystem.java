package week7.exercise5;
import java.util.List;

public class RoomBookingSystem{
    public static SingleRoom[] singleRooms;
    public static SuiteRoom[] suiteRooms;

    public static void processRoomReservations() {
        RoomLoader loader = new RoomLoader();

        try {
            loader.updateAvailabilityFromFile();
            List<Room> rooms = loader.getRooms();

            int singleCount = 0;
            int suiteCount = 0;

            for (Room r : rooms) {
                if (r instanceof SingleRoom) {
                    singleCount++;
                } else if (r instanceof SuiteRoom) {
                    suiteCount++;
                }
            }

            singleRooms = new SingleRoom[singleCount];
            suiteRooms = new SuiteRoom[suiteCount];

            int si = 0;
            int su = 0;

            for (Room r : rooms) {
                if (r instanceof SingleRoom) {
                    singleRooms[si++] = (SingleRoom) r;
                    System.out.println("Loaded single room: " + r);
                } else if (r instanceof SuiteRoom) {
                    suiteRooms[su++] = (SuiteRoom) r;
                    System.out.println("Loaded suite room: " + r);
                }
            }

        } catch (Exception e) {
            System.out.println("Error loading rooms: " + e.getMessage());
        }
    }
}
