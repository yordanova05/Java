package Server3;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientHandler implements Runnable {
    Socket socket;
    public ClientHandler(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run(){
        try(BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true)){

            BarSystem bar = new BarSystem();

            String line;
            while((line = in.readLine())!= null){
                String[] parts = line.split(" ");
                int choice = Integer.parseInt(parts[0]);

                switch(choice){
                    case(1):
                        bar.showDrinks(out);
                        break;
                    case(2):
                        out.println("Enter product ID:");
                        int id = Integer.parseInt(in.readLine());
                        out.println("Enter product quantity:");
                        int quantity = Integer.parseInt(in.readLine());
                        bar.makeOrder(id, quantity, out);
                        break;
                    case(3):
                        bar.showOrders(out);
                        break;
                    case(4):
                        bar.restock(out);
                        break;
                    default:
                        out.println("Incorrect choice!");
                }
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
