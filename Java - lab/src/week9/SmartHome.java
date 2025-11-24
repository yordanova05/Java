package week9;
import java.util.ArrayList;
import java.util.List;

public class SmartHome {
    private String name;
    private List<Device> devices;

    public SmartHome(String name){
        this.name = name;
        List<Device> devices = new ArrayList<>();
    }

    public Device addDevice(String id, String type){
        Device device = new Device(id, type);
        devices.add(device);
        SmartHome.Logger logger = new SmartHome.Logger();
        logger.log("Device added to list!");
        return device;
    }

    public void runScenario(){
        class ScenarioStep{
            private Device device;
            private boolean turnOn;

            public ScenarioStep(Device device, boolean turnOn){
                this.device = device;
                this.turnOn = turnOn;
            }

            public void execute(){
                if(turnOn){
                    device.turnOn();
                }
                else{
                    device.turnOff();
                }
                Logger.log("Executing scenario step for device" + device.id);
            }
        }
        //creating devices!!!
        SmartHome smartHome = new SmartHome("tv-A5");
        SmartHome.Device device1 = smartHome.new Device("123123","television");
        SmartHome.Device device2 = smartHome.new Device("34444", "oven");

        ScenarioStep scenarioStep1 = new ScenarioStep(device1,device1.isOn);
        ScenarioStep scenarioStep2 = new ScenarioStep(device2, device2.isOn);

        scenarioStep1.execute();
        scenarioStep2.execute();
    }

    public void notifyOnAllDevices(StatusListener listener){
        for(Device d: devices){
            listener.onStatusChange(d.id,d.isOn);
        }
    }

    public class Device{
        private String id;
        private String type;
        private boolean isOn;

        public Device(String id,String type){
            this.id = id;
            this.type = type;
            this.isOn = false;
        }

        public void turnOn(){
            isOn = true;
            SmartHome.Logger logger = new SmartHome.Logger();
            logger.log("Device turned on!");
        }
        public void turnOff(){
            isOn = false;
            SmartHome.Logger logger = new SmartHome.Logger();
            logger.log("Device turned off!");
        }
        public void printStatus(){
            System.out.printf("Device[id= %s, type= %s, isOn= %s]", id,type,isOn);
        }
    }

    public static class Logger{
        public Logger(){
        }
        public static void log(String message){
            System.out.println("[SmartHome LOG] "+message);
        }
    }

}
