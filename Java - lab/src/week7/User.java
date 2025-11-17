package week7;
import java.io.*;
import java.util.regex.*;
import java.util.Scanner;

public class User implements Validator{
    public String nickName;
    public String password;

    public User(){
    }
    public User(String nickName, String password) throws NotUserDefinedException{
        if (checking(nickName)){
            this.nickName = nickName;
            this.password = password;
        }
        else{
            throw new NotUserDefinedException("User email don't exists!");
        }
    }
    public String getNickName(String nickName){
        return nickName;
    }
    public void setNickName(String nickName){
        this.nickName = nickName;
    }
    public String getPassword(String password){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    @Override
    public boolean checking(String nickName){
        Matcher matcher = VALID_MAIL.matcher(nickName);
        return matcher.matches();
    }

    public static boolean nickNamesFile(File file, String nickName, String password) {
        try (BufferedReader bufferReader = new BufferedReader(new FileReader(file))) {
            String line = bufferReader.readLine();
            String[] data = line.split("#");

            for (String datum : data) {
                if (datum.equals(nickName + "*" + password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Exception while reading the file!");
        } catch (NullPointerException e) {
            System.out.println("The file is empty!");
        }
        return false;
    }
}
