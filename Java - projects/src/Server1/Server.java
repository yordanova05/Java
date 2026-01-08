package Server1;
import java.io.IOException;
import java.io.PrintStream;
import java.net.*;
import java.util.*;

public class Server {
    private ServerSocket server;

    private static final String USERS_FILE = "users.bin";
    private final Object usersLock = new Object();

    public void start(){
        try(ServerSocket server = new ServerSocket(8080)){
            System.out.println("Server started!");

            while(true){
                Socket client = server.accept();
                new Thread(() -> handleClient(client)).start();
            }
        }
        catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    private void handleClient(Socket client) {
        try (Scanner sc = new Scanner(client.getInputStream());
             PrintStream out = new PrintStream(client.getOutputStream())) {

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
