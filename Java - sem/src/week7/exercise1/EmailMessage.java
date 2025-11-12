package week7.exercise1;

public class EmailMessage implements Message{
    public EmailMessage() {
    }
    @Override
    public void send(){
        System.out.println("Email send!");
    }
}
