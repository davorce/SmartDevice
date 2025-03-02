package SmartDevice;

import SmartDevice.Classes.SmartLight;
import SmartDevice.Classes.SmartSpeaker;
import SmartDevice.Classes.SmartThermostat;

import javax.sound.midi.Soundbank;

public class SmartDeviceMain {
    public static void main(String[] args) {
        //razliciti nacini kreiranja svjetla
        SmartLight light1 = new SmartLight();
        light1.performAction();
        light1.updateFirmware("123");
        light1.setImeSobe("Spavaca soba");
        light1.displayStatus();

        SmartLight light2 = new SmartLight(false, 150, "5", "Dnevna soba");
        light2.displayStatus();
        //light2 je u problemu pa ga idemo preko remote controlla ispravno postaviti
        System.out.println("\nNakon remote controlla: ");
        light2.remoteControl("POWER");
        light2.remoteControl("SVJETLINA");
        light2.remoteControl("FIRMWARE");
        light2.displayStatus();

        SmartThermostat term1 = new SmartThermostat(true, 45, "kupaona", "1.11");
        term1.displayStatus();
        System.out.println("\nNakon remote controlla: ");
        term1.remoteControl("POWER");
        term1.remoteControl("TEMPERATURA");
        term1.displayStatus();
        term1.trenutnaTemperatura();

        SmartSpeaker speak1 = new SmartSpeaker(true, 29, "1.21.3", "spavaca soba");
        speak1.displayStatus();
        speak1.remoteControl("PLAY");
        speak1.displayStatus();

        speak1.remoteControl("PLAY");
        speak1.performAction();
        speak1.updateFirmware("3.2.1");
        speak1.displayStatus();


    }
}
