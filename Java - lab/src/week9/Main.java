package week9;

public class Main {
    public static void main(String[] args){
        SmartHome home = new SmartHome("My Smart Home");

        SmartHome.Device lamp = home.new Device("111","lava-lamp");
        SmartHome.Device climatic = home.new Device("222","climatic-MITSUBISHI");
        SmartHome.Device camera = home.new Device("333","camera-PRO");

        home.runScenario();

        home.notifyOnAllDevices(new StatusListener(){
            @Override
            public void onStatusChange(String deviceId, boolean isOn){
                System.out.println("Device" + deviceId + "is now" + (isOn ? "ON" : "OFF"));
            }
        });

    }
}
