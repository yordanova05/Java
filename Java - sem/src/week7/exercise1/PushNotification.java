package week7.exercise1;

public class PushNotification implements Message{
    public PushNotification(){
    }
    @Override
    public void send(){
        System.out.println("Notification send!");
    }
}
