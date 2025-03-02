package SmartDevice.Classes;

import SmartDevice.Abstract.SmartDevice;
import SmartDevice.Interfaces.RemoteControllable;

public class SmartSpeaker extends SmartDevice implements RemoteControllable {

    private boolean ukljuceno = false; //default stanje
    private int glasnoca;
    private String imeSobe;
    private boolean glazba = false;

    public SmartSpeaker(boolean ukljuceno, int glasnoca, String version, String ime) {
        this.imeSobe = ime;
        this.ukljuceno = ukljuceno;
        postaviGlasnocu(glasnoca);
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

    private void onOffGlazba() {
        glazba = !glazba;
    }

    private void postaviGlasnocu(int glasnoca) {
        //glasnoca ce biti u postocima
        if (glasnoca >= 0 && glasnoca <= 100) {
            this.glasnoca = glasnoca;

        } else {
            System.out.println("\nGlasnoca u sobi " + getImeSobe() + ", mora biti od 0 do 100%!");
        }
    }

    @Override
    public void performAction() {
        onOff();
        postaviGlasnocu(60);
    }

    @Override
    public void displayStatus() {
        System.out.println("\n*** Status report za " + getImeSobe() + " ***");
        System.out.println("Glasnoca: " + glasnoca + "%");
        System.out.println("Uređaj je:" + ((ukljuceno) ? " uključen." : " isključen."));
        System.out.println("Glazba" + ((glazba) ? " svira." : " je pauzirana."));
        System.out.println("Inačica firmwarea: " + getVersion());
    }

    @Override
    public void remoteControl(String command) {
        // GLASNOCA, POWER, FIRMWARE
        switch (command) {
            case "GLASNOCA":
                postaviGlasnocu(10); //ova komanda postavlja glasnocu na 10%
                break;
            case "POWER":
                onOff();
                break;
            case "PLAY":
                onOffGlazba();
                break;
            case "FIRMWARE":
                updateFirmware("3.7.8");
                break;
        }


    }


}