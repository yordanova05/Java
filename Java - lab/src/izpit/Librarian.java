package izpit;

import java.util.Scanner;

public class Librarian {
    private Library library;
    private String name;
    private String id;

    public Librarian(){}
    public Librarian(Library library, String name, String id){
        this.library = library;
        this.name= name;
        this.id = id;
    }

    public String getName(){
        return name;
    }
    public String getId(){
        return id;
    }

    private void addBook(){
        Scanner input = new Scanner(System.in);
        System.out.println("Title: ");
        String title = input.nextLine();
        System.out.println("Autor: ");
        String autor = input.nextLine();
        System.out.println("Released year: ");
        int year = Integer.parseInt(input.nextLine());
        System.out.println("Available count: ");
        int available = Integer.parseInt(input.nextLine());

        Book book = new Book(title,autor,year,available);
        library.addBook(book);
    }
    public void removeBook(Book book){
        if ()
    }
}
