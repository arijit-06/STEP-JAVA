public class GameController {
    private String controllerBrand;
    private String connectionType;
    private boolean hasVibration;
    private int batteryLevel;
    private double sensitivity;
    
    public GameController() {
        this.controllerBrand = "GenericPad";
        this.connectionType = "USB";
        this.hasVibration = true;
        this.batteryLevel = 100;
        this.sensitivity = 1.0;
    }
    
    public GameController(String controllerBrand, String connectionType, boolean hasVibration, int batteryLevel, double sensitivity) {
        this.controllerBrand = controllerBrand;
        this.connectionType = connectionType;
        this.hasVibration = hasVibration;
        this.batteryLevel = (batteryLevel >= 0 && batteryLevel <= 100) ? batteryLevel : 100;
        this.sensitivity = (sensitivity >= 0.1 && sensitivity <= 3.0) ? sensitivity : 1.0;
    }
    
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
        System.out.println("Brand: " + controllerBrand + ", Connection: " + connectionType + 
                          ", Vibration: " + hasVibration + ", Battery: " + batteryLevel + 
                          "%, Sensitivity: " + sensitivity);
    }
    
    public void testVibration() {
        if (hasVibration) {
            System.out.println("*BUZZ* Vibration test successful!");
        } else {
            System.out.println("Vibration disabled on this controller.");
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== GAMING CONTROLLER SETUP ===");
        
        GameController controller1 = new GameController();
        GameController controller2 = new GameController("Xbox", "Wireless", true, 85, 2.5);
        GameController controller3 = new GameController("PlayStation", "Bluetooth");
        
        controller1.displayConfiguration();
        controller1.testVibration();
        
        controller2.calibrateController();
        controller2.displayConfiguration();
        
        controller3.testVibration();
        controller3.displayConfiguration();
    }
}