package week7.exercise4;
import java.io.Serializable;

public class Book implements Serializable {
    private String bookName;
    private String author;

    public Book(String bookName, String author) {
        this.bookName = bookName;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + bookName + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
