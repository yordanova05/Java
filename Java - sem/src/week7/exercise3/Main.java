package week7.exercise3;

public class Main {
    public static void main(String[] args) {
        PaymentMethod payment = new PayPal();
        PaymentMethod payment2 = new CreditCard();

        payment.processPayment();
        payment2.processPayment();
    }
}
