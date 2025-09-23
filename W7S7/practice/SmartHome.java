class SmartDevice {
    protected String name;
    protected boolean isOn;
    
    public SmartDevice(String name) {
        this.name = name;
        this.isOn = false;
    }
    
    public void turnOn() {
        isOn = true;
        System.out.println(name + " is now ON");
    }
    
    public void turnOff() {
        isOn = false;
        System.out.println(name + " is now OFF");
    }
}

class SmartLight extends SmartDevice {
    private int brightness;
    
    public SmartLight(String name) {
        super(name);
        this.brightness = 50;
    }
    
    public void setBrightness(int level) {
        brightness = level;
        System.out.println(name + " brightness set to " + level + "%");
    }
    
    public void changeColor(String color) {
        System.out.println(name + " color changed to " + color);
    }
}

class SmartThermostat extends SmartDevice {
    private int temperature;
    
    public SmartThermostat(String name) {
        super(name);
        this.temperature = 72;
    }
    
    public void setTemperature(int temp) {
        temperature = temp;
        System.out.println(name + " temperature set to " + temp + "°F");
    }
    
    public void setMode(String mode) {
        System.out.println(name + " mode set to " + mode);
    }
}

class SmartSpeaker extends SmartDevice {
    private int volume;
    
    public SmartSpeaker(String name) {
        super(name);
        this.volume = 30;
    }
    
    public void setVolume(int level) {
        volume = level;
        System.out.println(name + " volume set to " + level);
    }
    
    public void playMusic(String song) {
        System.out.println(name + " playing: " + song);
    }
}

public class SmartHome {
    public static void main(String[] args) {
        SmartDevice[] devices = {
            new SmartLight("Living Room Light"),
            new SmartThermostat("Main Thermostat"),
            new SmartSpeaker("Kitchen Speaker")
        };
        
        for (SmartDevice device : devices) {
            device.turnOn();
            
            if (device instanceof SmartLight) {
                SmartLight light = (SmartLight) device;
                light.setBrightness(80);
                light.changeColor("blue");
            } else if (device instanceof SmartThermostat) {
                SmartThermostat thermostat = (SmartThermostat) device;
                thermostat.setTemperature(68);
                thermostat.setMode("cooling");
            } else if (device instanceof SmartSpeaker) {
                SmartSpeaker speaker = (SmartSpeaker) device;
                speaker.setVolume(50);
                speaker.playMusic("Jazz Playlist");
            }
            
            System.out.println();
        }
    }
}