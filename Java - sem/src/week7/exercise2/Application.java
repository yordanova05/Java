package week7.exercise2;

public class Application{
    private Logger logger;

    public Application(Logger logger){
        this.logger = logger;
    }
    public void logInfo() throws Exception {
        logger.log("Log Info.");
        if(logger instanceof ConsoleLogger){
            System.out.println("Logged by console.");
        }
        else if(logger instanceof FileLogger){
            System.out.println("Logged in file.");
        }
        else{
            throw new Exception("Something went wrong!");
        }
    }
}
