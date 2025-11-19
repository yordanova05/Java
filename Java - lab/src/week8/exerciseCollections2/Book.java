package week8.exerciseCollections2;
import java.util.Objects;

public class Book {
    public String title;
    public String author;
    public int year;

    public Book(){

    }
    public Book(String title, String author, int year){
        this.title = title;
        this.author = author;
        this.year = year;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getAuthor(){
        return author;
    }
    public void setAuthor(String  author){
        this.author = author;
    }
    public int getYear(){return year;}
    public void setAge(int year){
        this.year = year;
    }

    @Override
    public int hashCode(){
        return Objects.hash(title,author);
    }
    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (!(obj instanceof Book other)) return false;

        return Objects.equals(title, other.title) && Objects.equals(author, other.author);
    }
    @Override
    public String toString(){
        return "Title: " + title + " Author: " + author + " Year: " + year;
    }
}
