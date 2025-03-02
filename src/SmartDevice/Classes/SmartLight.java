package SmartDevice.Classes;

import SmartDevice.Abstract.SmartDevice;
import SmartDevice.Interfaces.RemoteControllable;

public class SmartLight extends SmartDevice implements RemoteControllable {

    private boolean ukljuceno = false; //default stanje
    private int svjetlina;
    private String imeSobe;

    public SmartLight() {
    }

    public SmartLight(boolean ukljuceno, int svjetlina, String version, String ime) {
        this.imeSobe = ime;
        this.ukljuceno = ukljuceno;
        postaviSvjetlinu(svjetlina);
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
    }

    private void postaviSvjetlinu(int svjetlina) {
        //svjetlina ce biti u postocima
        if (svjetlina >= 0 && svjetlina <= 100) {
            this.svjetlina = svjetlina;

        } else {
            System.out.println("\nZa svjetlo "+ getImeSobe() +", svjetlina mora biti od 0 do 100%!");
        }
    }

    @Override
    public void performAction() {
        onOff();
        postaviSvjetlinu(60);
    }

    @Override
    public void displayStatus() {
        System.out.println("\n*** Status report za " + getImeSobe() + " ***");
        System.out.println("Svjetlina: " + svjetlina + "%");
        System.out.println("Uređaj je:" + ((ukljuceno) ? " uključen." : " isključen."));
        System.out.println("Inačica firmwarea: " + getVersion());
    }

    @Override
    public void remoteControl(String command) {
        // SVJETLINA, POWER, FIRMWARE
        switch (command) {
            case "SVJETLINA":
                postaviSvjetlinu(100); //ova komanda postavlja svjetlinu na 100%
                break;
            case "POWER":
                onOff();
                break;
            case "FIRMWARE":
                updateFirmware("1.25");
                break;
        }


    }


}
