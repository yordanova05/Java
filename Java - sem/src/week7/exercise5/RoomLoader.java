package week7.exercise5;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class RoomLoader implements Reservable{
    public List<Room> rooms = new ArrayList<Room>();
    public List<Room> getRooms(){
        return rooms;
    }
    public RoomLoader(){

    }
    public void updateAvailabilityFromFile() throws IOException, InvalidRoomDataException{

        try(BufferedReader reader = new BufferedReader(new FileReader("rooms.txt"))){
            String line;

            while((line = reader.readLine()) != null){
                String[] parts = line.split("\\*");

                if(parts.length != 5){
                    throw new InvalidRoomDataException("Room information invalid syntactic!");
                }
                try{
                    int type = Integer.parseInt(parts[0]);
                    int number = Integer.parseInt(parts[1]);
                    String category = (parts[2]);
                    int price = Integer.parseInt(parts[3]);
                    int nights = Integer.parseInt(parts[4]);

                    if( type != 1 && type != 2){
                        throw new InvalidRoomDataException("Invalid type room!");
                    }

                    Room room = new Room(number,category,price,nights);
                    rooms.add(room);
                }catch(NumberFormatException e){
                    System.out.println("Invalid values!");
                }
            }
        }
        catch(IOException e){
            System.out.println("Exception occurred while opening the file!");
        }
    }
}
