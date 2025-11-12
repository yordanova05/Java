package week7.exercise3;

public class PayPal extends  PaymentMethod {
    public PayPal(){

    }
    @Override
    public void processPayment(){
        System.out.println("Payed with paypal!");
    }
}
