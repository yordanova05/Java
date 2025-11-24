package week9;

public interface StatusListener {
    void onStatusChange(String deviceId, boolean isOn);
}
