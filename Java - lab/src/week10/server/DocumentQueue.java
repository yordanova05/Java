package week10.server;
import week10.model.Document;
import java.util.*;

public class DocumentQueue{
    private final Queue<Document> queue = new LinkedList<>();

    public synchronized void add(Document doc) {
        queue.add(doc);
        notifyAll();
    }

    public synchronized Document take() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        return queue.remove();
    }
}
