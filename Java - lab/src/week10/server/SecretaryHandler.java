package week10.server;

import week10.model.Document;

public class SecretaryHandler implements Runnable {

    private DocumentQueue queue;

    public SecretaryHandler(DocumentQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Document doc = queue.take();
                process(doc);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void process(Document doc) {
        boolean approved = false;

        if (doc.getType() == Document.Type.SUCCESS) {
            approved = doc.getGrade() > 5.50 && doc.getIncome() < 500;
        } else {
            approved = doc.getGrade() > 5.30 && doc.getIncome() < 300;
        }

        if (approved)
            System.out.println("✔ Приета: " + doc);
        else
            System.out.println("❌ Отказана: " + doc);
    }
}
