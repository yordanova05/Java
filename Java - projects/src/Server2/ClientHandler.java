package Server2;
import java.io.*;
import java.net.Socket;
import java.util.List;

public class ClientHandler implements Runnable{
    private Socket socket;
    private List<Place> places;

    public ClientHandler(Socket socket, List<Place> places){
        this.socket = socket;
        this.places = places;
    }

    @Override
    public void run(){
        try(BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter( socket.getOutputStream(), true)){

            out.println("Server connected!");
            out.println("1 - Show spots/ 2 - borrow (ID and your name)/ 3 - release (ID)");

            String line;

            while( (line = in.readLine()) != null ){
                String[] parts = line.split(" ");

                int choice = Integer.parseInt(parts[0]);

                switch(choice){
                    case (1):
                        showAll(out);
                        break;
                    case(2):
                        int ID = Integer.parseInt(parts[1]);
                        String name = parts[2];
                        borrowSpot(ID, name, out);
                        break;
                    case (3):
                        int ID2 = Integer.parseInt(parts[1]);
                        releaseSpot(ID2, out);
                        break;
                    default:
                        out.println("Wrong entered dates!");
                }
            }
        }
        catch(IOException e) {
           System.out.println("Invalid dataformat!");
        }
    }

    public void showAll(PrintWriter out){
        for( Place p: places){
            out.println(p);
        }
    }

    public void borrowSpot(int ID, String name, PrintWriter out){
        synchronized(places) {
            for (Place p : places) {
                if ( p.getId() == ID) {
                    if (p.getFree()) {
                        p.takeFree(name);
                        out.println("Successfully borrowed place " + p.getNumber() + " ID: " + p.getId());
                    }
                    else {
                        out.println("This spot is already borrowed from: " + p.getName());
                    }
                    return;
                } else {
                    out.println("This spot does not exist!");
                }
            }
        }
    }
    public void releaseSpot(int ID, PrintWriter out){
        synchronized(places){
            for(Place p: places){
                if(p.getId() == ID){
                    if(!p.getFree()){
                        p.reFree();
                        out.println("Successfully released this place " + p.getNumber() + " ID: " + p.getId());
                    }
                    else {
                        out.println("This spot is already released!");
                    }
                    return;
                }
                else{
                    out.println("This spot does not exist!");
                }
            }
        }
    }

}
