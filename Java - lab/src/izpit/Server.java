package izpit;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    ExecutorService pool = Executors.newFixedThreadPool(5);
}
