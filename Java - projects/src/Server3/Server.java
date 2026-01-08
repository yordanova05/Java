package Server3;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Server {
    public static void main(String[] args){
        try(ServerSocket server = new ServerSocket(5678)){
            while(true){
                Socket socket = server.accept();
                System.out.println("New client has join");

                Thread client = new Thread(new ClientHandler(socket));
                client.start();
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
