package week7.exercise2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        Logger logger = new ConsoleLogger();
        Application application = new Application(logger);
        application.logInfo();

        Logger logger2 = new FileLogger();
        Application application2 = new Application(logger2);
        application2.logInfo();
    }
}
