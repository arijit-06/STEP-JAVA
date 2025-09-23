import java.util.Scanner;

class GameController {
    private String controllerBrand;
    private String connectionType;
    private boolean hasVibration;
    private int batteryLevel;
    private double sensitivity;
    
    // Default constructor
    public GameController() {
        this.controllerBrand = "GenericPad";
        this.connectionType = "USB";
        this.hasVibration = true;
        this.batteryLevel = 100;
        this.sensitivity = 1.0;
    }
    
    // Parameterized constructor
    public GameController(String controllerBrand, String connectionType, 
                         boolean hasVibration, int batteryLevel, double sensitivity) {
        this.controllerBrand = controllerBrand;
        this.connectionType = connectionType;
        this.hasVibration = hasVibration;
        this.batteryLevel = Math.max(0, Math.min(100, batteryLevel));
        this.sensitivity = Math.max(0.1, Math.min(3.0, sensitivity));
    }
    
    // Two-parameter convenience constructor
    public GameController(String brand, String connectionType) {
        this.controllerBrand = brand;
        this.connectionType = connectionType;
        this.hasVibration = true;
        this.batteryLevel = 100;
        this.sensitivity = 1.0;
    }
    
    public void calibrateController() {
        System.out.println("Calibrating " + controllerBrand + " controller...");
    }
    
    public void displayConfiguration() {
        System.out.println("🎮 CONTROLLER CONFIG 🎮");
        System.out.println("Brand: " + controllerBrand);
        System.out.println("Connection: " + connectionType);
        System.out.println("Vibration: " + (hasVibration ? "Enabled" : "Disabled"));
        System.out.println("Battery: " + batteryLevel + "%");
        System.out.println("Sensitivity: " + sensitivity);
        System.out.println("-------------------");
    }
    
    public void testVibration() {
        if (hasVibration) {
            System.out.println("*BUZZ* Vibration test successful!");
        } else {
            System.out.println("Vibration disabled on this controller.");
        }
    }
}

public class GameControllerConfig {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== GAMING CONTROLLER SETUP ===\n");
        
        // Default controller
        GameController controller1 = new GameController();
        System.out.println("Default Controller:");
        controller1.displayConfiguration();
        controller1.calibrateController();
        controller1.testVibration();
        
        // Full parameterized controller
        GameController controller2 = new GameController("Xbox Elite", "Wireless", true, 85, 2.5);
        System.out.println("Custom Controller:");
        controller2.displayConfiguration();
        controller2.calibrateController();
        controller2.testVibration();
        
        // Convenience constructor
        GameController controller3 = new GameController("PlayStation", "Bluetooth");
        System.out.println("Convenience Constructor Controller:");
        controller3.displayConfiguration();
        controller3.calibrateController();
        controller3.testVibration();
        
        sc.close();
    }
}