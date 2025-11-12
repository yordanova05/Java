package week7.exercise3;

public class CreditCard extends  PaymentMethod {
    public CreditCard() {

    }
    @Override
    public void processPayment(){
        System.out.println("Payed with credit card!");
    }
}
