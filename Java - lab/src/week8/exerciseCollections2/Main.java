package week8.exerciseCollections2;
import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        Set<Book> booksHashSet = null;
        while(n>0){
            try {
                System.out.println("Title: ");
                String title = input.nextLine();
                System.out.println("Author: ");
                String author = input.nextLine();
                System.out.println("Released year: ");
                int year = Integer.parseInt(input.nextLine());
                n--;

                Book book = new Book(title,author,year);
                booksHashSet = new HashSet<Book>();
                booksHashSet.add(book);
            }catch(NumberFormatException e){
                System.out.println("Format incorrect!");
            }catch(Exception e){
                e.getMessage();
            }
        }
        Map<String,Book> booksHashMap = new HashMap<String,Book>();
        for(Book book: booksHashSet){
            booksHashMap.put(book.getTitle(),book);
        }
        System.out.println("Enter title: ");
        String titleResult = input.nextLine();

        if(booksHashMap.containsKey(titleResult)) {
            System.out.println("Book found: " + booksHashMap.get(titleResult).toString());
        }
        else{
            System.out.println("Book not found!");
        }
    }
}
