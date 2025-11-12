package week7.exercise4;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Book> books = new ArrayList<>();
        books.add(new Book("Под игото", "Иван Вазов"));
        books.add(new Book("Хамлет", "Уилям Шекспир"));
        books.add(new Book("Престъпление и наказание", "Фьодор Достоевски"));

        // 2. Сериализация на списъка във файл
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("books.ser"))) {
            oos.writeObject(books);
            System.out.println("Списъкът с книги е сериализиран успешно!");
        } catch (IOException e) {
            System.out.println("IOException");
        }

        // 3. Десериализация от файла
        List<Book> restoredBooks = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("books.ser"))) {
            restoredBooks = (List<Book>) ois.readObject();
            System.out.println("\nВъзстановени книги от файла:");
            for (Book b : restoredBooks) {
                System.out.println(b);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
