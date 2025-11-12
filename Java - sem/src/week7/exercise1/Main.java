package week7.exercise1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter type of message notification: ");
        String type = input.nextLine();
        MessageFactory message = new MessageFactory();
        message.createMessage(type);
    }
}
