package Server2;

import java.net.*;
import java.util.*;

public class Server {
    public static void main(String[] args){

        List<Place> places = new ArrayList<>();

        places.add(new Place(12, 4));
        places.add(new Place(3, 1));
        places.add(new Place(42, 12));

        try( ServerSocket server = new ServerSocket(1643)){
            while(true){
                Socket clientSocket = server.accept();
                System.out.println("New client has join");

                Thread handler = new Thread(new ClientHandler(clientSocket, places));
                handler.start();
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}
