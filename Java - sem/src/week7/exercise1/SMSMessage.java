package week7.exercise1;

public class SMSMessage implements Message{
    public SMSMessage(){

    }
    @Override
    public void send(){
        System.out.println("SMSMessage send!");
    }
}
