package week6;
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
        List<String> strings = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        while(true){
            String str = input.nextLine();
            if (str.isEmpty()){
                break;
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
    }
}
