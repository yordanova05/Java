package week7.exercise2;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileLogger implements Logger{
    public FileLogger(){
    }

    @Override
    public void log(String message){
        try{
            File myFile = new File("log.txt");
            if(myFile.createNewFile()){
                System.out.println("File created! - "+myFile.getName());
                FileWriter myFileWrite = new FileWriter("log.txt");
                myFileWrite.write("logger[1]");
                myFileWrite.close();
            }
            else{
                System.out.println("File exists!");
            }
            Scanner myReader = new Scanner(myFile);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    System.out.println(data);
                }
        } catch(IOException e){
            System.out.println("An error occurred.");
        }
    }
}
