package week6;
import java.io.IOException;
import java.util.*;
//import java.util.ArrayList;
//import java.util.Scanner;
import java.util.regex.*;

public class exercisesString {
    protected static int GlasniBukvi(String str){
        int count = 0;
        for(char a:str.toCharArray()){
            char lower = Character.toLowerCase(a);
            switch(lower){
                case 'a':count++;break;
                case 'e':count++;break;
                case 'i':count++;break;
                case 'o':count++;break;
                case 'u':count++;break;
            }
        }
        return count;
    }

    protected static boolean isPalindrom(String str){
        String reverseStr = new StringBuilder(str).reverse().toString();
        return str.equals(reverseStr);
    }

    protected static void LowerCase(String str){
        Pattern pattern = Pattern.compile("-");
        Matcher matcher = pattern.matcher(str);
        System.out.println("Repalced - with _ and all leters to lower cas: " + str.toLowerCase());
    }

    protected static boolean isNumberValid(String str){
        return (str.length() == 10 && (str.startsWith("08")));
    }

    protected static String NumbersToStars(String str){
        return str.replaceAll("\\d","*");
    }

    protected static boolean isPasswordValid(String str){
        return ( str.length() >= 8 && str.matches(".*\\d*") && str.matches(".*\\w*"));
    }

    protected static void reader(){
        try {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter number of rows: ");
            int n = Integer.parseInt((input.nextLine()));
            while (n != 0) {
                try {
                    String line = input.nextLine();
                    String name = line.substring(line.indexOf('@') + 1, line.indexOf('|'));
                    String age = line.substring(line.indexOf('#') + 1, line.indexOf('*'));
                    System.out.printf("{%s} is {%s} years old!\n", name, age);
                    n--;

                } catch (StringIndexOutOfBoundsException e) {
                    System.out.println("Index out of range!");
                }
            }
        }
        catch(NumberFormatException e){
            System.out.println("Enter valid number!");
        }
        catch(StringIndexOutOfBoundsException e){
            System.out.println("Index out of range!");
        }
        catch(Exception e){
            System.out.println("Error:" + e.getMessage());
        }
    }

    protected static void validName(){
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        List<String> names = new ArrayList<>(List.of(str.split(",")));
        for(String name: names){
            if (name.length() >= 3 && name.length() <=16 && name.matches(".*\\w*")){
                System.out.println(name);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Glasni bukvi v niza broi: " + GlasniBukvi("Amuse bush enchalte"));
        System.out.println("Is palindrom: " + isPalindrom("lebel"));
        LowerCase("May-To-Gate");
        System.out.println("Number starts with 08--------: " + isNumberValid("0872347818"));
        System.out.println("Password without numbers: " + NumbersToStars("AS7asd(9231)i324"));
        System.out.println("Is password valid: " + isPasswordValid("AS7asd(R"));
        reader();
        validName();
    }
}
