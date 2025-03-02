package SmartDevice.Abstract;

public abstract class SmartDevice {

    private String version;

    public abstract void performAction();

    public abstract void displayStatus();

    public void updateFirmware(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }
}
