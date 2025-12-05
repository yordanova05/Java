package week10.server;

public class ScholarshipServer {

    public void start() {
        DocumentQueue queue = new DocumentQueue();

        Thread secretary1 = new Thread(new SecretaryHandler(queue));
        Thread secretary2 = new Thread(new SecretaryHandler(queue));

        secretary1.start();
        secretary2.start();

        Thread student1 = new Thread(new StudentHandler(queue, "Ivan"));
        Thread student2 = new Thread(new StudentHandler(queue, "Maria"));

        student1.start();
        student2.start();
    }
}
