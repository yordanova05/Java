package week7;
import java.util.Scanner;
import java.io.*;

public class Main {
    public static void addUser(File f, User user) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(f));
        writer.write(user.nickName + "*");
        writer.write(user.password + "#");
        writer.flush();
    }
    public static void main(String[] args) throws IOException, NotUserDefinedException {
        Scanner input = new Scanner(System.in);

        System.out.println("Nickname: ");
        String nickname = input.nextLine();

        System.out.println("Password: ");
        String password = input.nextLine();

        File myFile = new File("users.txt");
        if (myFile.createNewFile()){
            System.out.println("File created!");
        }
        else{
            System.out.println("File exists!");
        }
        User user = new User(nickname, password);
        if (user != null) {
            addUser(myFile, user);
        }
        System.out.println("Enter username for searching:");
        String searchedUsername = input.nextLine();
        System.out.println("Enter password for searching.");
        String searchedPassword = input.nextLine();

        boolean matches = User.nickNamesFile(myFile, searchedUsername, searchedPassword);
        if(matches){
            System.out.println("exists.");
        } else {
            System.out.println("doesn’t exist.");
        }
    }
}
