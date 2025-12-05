package week10.server;

import week10.model.Document;

public class StudentHandler implements Runnable {

    private DocumentQueue queue;
    private String name;

    public StudentHandler(DocumentQueue queue, String name) {
        this.queue = queue;
        this.name = name;
    }

    @Override
    public void run() {
        // студент подава документи
        Document d1 = new Document(name, 5.60, 400, "IT", Document.Type.SUCCESS);
        Document d2 = new Document(name, 5.40, 250, "IT", Document.Type.SPECIAL);

        queue.add(d1);
        System.out.println("Студент " + name + " подаде SUCCESS заявка");

        queue.add(d2);
        System.out.println("Студент " + name + " подаде SPECIAL заявка");
    }
}
