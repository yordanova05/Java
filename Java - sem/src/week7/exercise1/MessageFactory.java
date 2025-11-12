package week7.exercise1;

public class MessageFactory{
    public void createMessage(String type){
        if (type.equalsIgnoreCase("sms")){
            SMSMessage smsMessage = new SMSMessage();
            smsMessage.send();
        }
        else if( type.equalsIgnoreCase("email")){
            EmailMessage emailMessage = new EmailMessage();
            emailMessage.send();
        }
        else if(type.equalsIgnoreCase("message")){
            PushNotification pushNotification = new PushNotification();
            pushNotification.send();
        }
        else{
            System.out.println("This type of message doesn't exist!");
        }
    }
}
