/*
Problem 4: Multiple Interfaces with Devices
Problem Statement:
Create two interfaces: Camera with method takePhoto() and MusicPlayer with
method playMusic(). A class SmartPhone should implement both. Demonstrate
multiple interface implementations.
Understanding: Multiple inheritance via interfaces.
*/

// File: Camera.java
interface Camera {
    // TODO: Declare method takePhoto()
    void takePhoto();
    
    // Additional camera methods
    default void switchCameraMode() {
        System.out.println("Switching camera mode...");
    }
}

// File: MusicPlayer.java
interface MusicPlayer {
    // TODO: Declare method playMusic()
    void playMusic();
    
    // Additional music player methods
    default void adjustVolume(int level) {
        System.out.println("Volume adjusted to: " + level);
    }
}

// File: SmartPhone.java
class SmartPhone implements Camera, MusicPlayer {
    private String brand;
    private String model;
    private boolean cameraActive;
    private boolean musicPlaying;
    
    public SmartPhone(String brand, String model) {
        this.brand = brand;
        this.model = model;
        this.cameraActive = false;
        this.musicPlaying = false;
        System.out.println("SmartPhone created: " + brand + " " + model);
    }
    
    // TODO: Implement takePhoto() -> "Taking photo with smartphone"
    @Override
    public void takePhoto() {
        System.out.println("📸 Camera activated on " + brand + " " + model);
        System.out.println("Taking photo with smartphone camera...");
        System.out.println("Photo captured successfully!");
        cameraActive = true;
    }
    
    // TODO: Implement playMusic() -> "Playing music on smartphone"
    @Override
    public void playMusic() {
        System.out.println("🎵 Music player activated on " + brand + " " + model);
        System.out.println("Playing music on smartphone...");
        System.out.println("♪ Now playing: 'Your Favorite Song' ♪");
        musicPlaying = true;
    }
    
    // Additional smartphone methods
    public void showDeviceStatus() {
        System.out.println("\n--- Device Status ---");
        System.out.println("Device: " + brand + " " + model);
        System.out.println("Camera Active: " + cameraActive);
        System.out.println("Music Playing: " + musicPlaying);
    }
    
    public void stopAllActivities() {
        if (cameraActive) {
            System.out.println("Camera deactivated");
            cameraActive = false;
        }
        if (musicPlaying) {
            System.out.println("Music stopped");
            musicPlaying = false;
        }
    }
}

// File: DeviceTest.java
public class MultipleInterfaces {
    public static void main(String[] args) {
        System.out.println("=== Multiple Interface Implementation Demo ===");
        
        // TODO: Create SmartPhone object
        SmartPhone phone = new SmartPhone("iPhone", "14 Pro");
        
        System.out.println("\n--- Testing Camera Interface ---");
        // TODO: Call takePhoto()
        phone.takePhoto();
        phone.switchCameraMode(); // Using default method from Camera interface
        
        System.out.println("\n--- Testing MusicPlayer Interface ---");
        // TODO: Call playMusic()
        phone.playMusic();
        phone.adjustVolume(75); // Using default method from MusicPlayer interface
        
        phone.showDeviceStatus();
        
        System.out.println("\n--- Demonstrating Interface References ---");
        // Using Camera interface reference
        Camera camera = new SmartPhone("Samsung", "Galaxy S23");
        camera.takePhoto();
        
        // Using MusicPlayer interface reference
        MusicPlayer player = new SmartPhone("Google", "Pixel 7");
        player.playMusic();
        
        System.out.println("\n=== Multiple Inheritance Benefits ===");
        System.out.println("- SmartPhone implements both Camera and MusicPlayer interfaces");
        System.out.println("- Single class can have multiple behaviors");
        System.out.println("- Can be referenced by any of its implemented interfaces");
        System.out.println("- Achieves multiple inheritance through interfaces");
        
        phone.stopAllActivities();
    }
}