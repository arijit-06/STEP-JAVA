import java.util.Scanner;

class AudioMixer {
    private String mixerModel;
    private int numberOfChannels;
    private boolean hasBluetoothConnectivity;
    private double maxVolumeDecibels;
    private String[] connectedDevices;
    private int deviceCount;
    
    // No-argument constructor using this() chaining
    public AudioMixer() {
        this("StandardMix-8", 8, false);
    }
    
    // Two-parameter constructor using this() chaining
    public AudioMixer(String mixerModel, int numberOfChannels) {
        this(mixerModel, numberOfChannels, false);
    }
    
    // Three-parameter constructor using this() chaining
    public AudioMixer(String mixerModel, int numberOfChannels, boolean hasBluetoothConnectivity) {
        this(mixerModel, numberOfChannels, hasBluetoothConnectivity, 120.0);
    }
    
    // Main constructor - all parameters
    public AudioMixer(String mixerModel, int numberOfChannels, 
                     boolean hasBluetoothConnectivity, double maxVolumeDecibels) {
        this.mixerModel = mixerModel;
        this.numberOfChannels = numberOfChannels;
        this.hasBluetoothConnectivity = hasBluetoothConnectivity;
        this.maxVolumeDecibels = maxVolumeDecibels;
        this.connectedDevices = new String[numberOfChannels];
        this.deviceCount = 0;
        System.out.println("AudioMixer " + mixerModel + " initialized with " + numberOfChannels + " channels");
    }
    
    public void connectDevice(String deviceName) {
        if (deviceCount < connectedDevices.length) {
            connectedDevices[deviceCount] = deviceName;
            deviceCount++;
            System.out.println("Connected: " + deviceName);
        } else {
            System.out.println("All channels occupied!");
        }
    }
    
    public void displayMixerStatus() {
        System.out.println("\n=== " + mixerModel + " STATUS ===");
        System.out.println("Channels: " + numberOfChannels);
        System.out.println("Bluetooth: " + (hasBluetoothConnectivity ? "Enabled" : "Disabled"));
        System.out.println("Max Volume: " + maxVolumeDecibels + " dB");
        System.out.println("Connected Devices: " + deviceCount + "/" + numberOfChannels);
        for (int i = 0; i < deviceCount; i++) {
            System.out.println(" Channel " + (i + 1) + ": " + connectedDevices[i]);
        }
        System.out.println("-------------------");
    }
}

public class AudioMixerStudio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== MUSIC STUDIO SETUP ===\n");
        
        // No-argument constructor
        AudioMixer mixer1 = new AudioMixer();
        mixer1.connectDevice("Microphone 1");
        mixer1.connectDevice("Guitar");
        mixer1.displayMixerStatus();
        
        // Two-parameter constructor
        AudioMixer mixer2 = new AudioMixer("ProMix-16", 16);
        mixer2.connectDevice("Piano");
        mixer2.connectDevice("Drums");
        mixer2.connectDevice("Bass Guitar");
        mixer2.displayMixerStatus();
        
        // Three-parameter constructor
        AudioMixer mixer3 = new AudioMixer("StudioMaster", 24, true);
        mixer3.connectDevice("Vocal Mic");
        mixer3.connectDevice("Synthesizer");
        mixer3.displayMixerStatus();
        
        // Full constructor
        AudioMixer mixer4 = new AudioMixer("EliteMix-32", 32, true, 140.0);
        mixer4.connectDevice("Orchestra Mic");
        mixer4.connectDevice("Grand Piano");
        mixer4.connectDevice("String Section");
        mixer4.displayMixerStatus();
        
        sc.close();
    }
}