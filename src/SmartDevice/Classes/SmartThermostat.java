package SmartDevice.Classes;

import SmartDevice.Abstract.SmartDevice;
import SmartDevice.Interfaces.RemoteControllable;

public class SmartThermostat extends SmartDevice implements RemoteControllable {
    private boolean ukljuceno = false;
    private int temperatura;
    private String imeSobe;

    public SmartThermostat(boolean ukljuceno, int temperatura, String imeSobe, String version) {
        this.imeSobe = imeSobe;
        this.ukljuceno = ukljuceno;
        postaviTemperaturu(temperatura);
        super.updateFirmware(version);

    }

    public String getImeSobe() {
        return imeSobe;
    }

    public void setImeSobe(String ime) {
        this.imeSobe = ime;
    }

    private void onOff() {
        ukljuceno = !ukljuceno;
        String output = (ukljuceno) ? " uključen." : " isključen.";
    }

    private void postaviTemperaturu(int temperatura) {
        if (temperatura >= 15 && temperatura <= 35) {
            this.temperatura = temperatura;

        } else {
            System.out.println("\nZa termostat " + getImeSobe() + ", temperatura mora biti od 15 do 35 stupnjeva!");
        }
    }

    public void trenutnaTemperatura() {
        System.out.println("Trenutna temperatura je " + temperatura + " stupnjeva");
    }

    @Override
    public void performAction() {
        onOff();
        postaviTemperaturu(29);
    }

    @Override
    public void displayStatus() {
        System.out.println("\n*** Status report za " + getImeSobe() + " ***");
        System.out.println("Temperatura je postavljena na: " + temperatura + " stupnjeva.");
        System.out.println("Uređaj je:" + ((ukljuceno) ? " uključen." : " isključen."));
        System.out.println("Inačica firmwarea: " + getVersion());
    }


    @Override
    public void remoteControl(String command) {
        // TEMPERATURA, POWER, FIRMWARE
        switch (command) {
            case "TEMPERATURA":
                postaviTemperaturu(20); //ova komanda postavlja temperaturu na 20 stupnjeva
                break;
            case "POWER":
                onOff();
                break;
            case "FIRMWARE":
                updateFirmware("1.68");
                break;
        }
    }
}
