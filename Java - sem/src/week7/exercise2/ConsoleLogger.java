package week7.exercise2;

public class ConsoleLogger implements Logger {
    public ConsoleLogger() {}
    @Override
    public void log(String message){
        System.out.println(message);
    }
}
