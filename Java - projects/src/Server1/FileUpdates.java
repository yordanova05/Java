package Server1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUpdates {
    private final String FILENAME = "users.bin";

     synchronized List<User> load(){
        try(ObjectInputStream in = new ObjectInputStream( new FileInputStream(FILENAME))){
            return (List<User>)in.readObject();
        }
        catch(Exception e){
            return new ArrayList<>();
        }
    }
    synchronized void saveUsers(List<User> users){
        try(ObjectOutputStream out = new ObjectOutputStream( new FileOutputStream(FILENAME))){
            out.writeObject(users);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
