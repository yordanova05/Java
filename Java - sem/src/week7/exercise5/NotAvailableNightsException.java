package week7.exercise5;

public class NotAvailableNightsException extends Exception {
    public NotAvailableNightsException(String message)
    {
        super(message);
    }
    public  NotAvailableNightsException()
    {
        super("Not available nights!");
    }
}
