public class GameController {
    private String controllerType;
    private int buttonCount;
    private boolean hasVibration;
    private int batteryLevel;
    private String customSettings;
    
    // Default constructor
    public GameController() {
        this("Standard");
    }
    
    // Constructor with controller type
    public GameController(String controllerType) {
        this(controllerType, getDefaultButtonCount(controllerType), 
             getDefaultVibration(controllerType), 100, "Default Settings");
    }
    
    // Constructor with type and custom settings
    public GameController(String controllerType, int buttonCount, 
                         boolean hasVibration, int batteryLevel, String customSettings) {
        this.controllerType = (controllerType != null) ? controllerType : "Standard";
        this.buttonCount = (buttonCount > 0) ? buttonCount : 8;
        this.hasVibration = hasVibration;
        this.batteryLevel = (batteryLevel >= 0 && batteryLevel <= 100) ? batteryLevel : 100;
        this.customSettings = (customSettings != null) ? customSettings : "Default Settings";
    }
    
    private static int getDefaultButtonCount(String type) {
        switch (type.toLowerCase()) {
            case "pro": return 12;
            case "elite": return 16;
            case "basic": return 6;
            default: return 8;
        }
    }
    
    private static boolean getDefaultVibration(String type) {
        return !type.equalsIgnoreCase("basic");
    }
    
    public void configure() {
        System.out.println("Configuring " + controllerType + " controller...");
        System.out.println("Buttons: " + buttonCount + ", Vibration: " + hasVibration);
        System.out.println("Settings: " + customSettings);
    }
    
    public boolean testController() {
        System.out.println("Testing controller...");
        if (batteryLevel < 10) {
            System.out.println("Warning: Low battery!");
            return false;
        }
        System.out.println("Controller test passed!");
        return true;
    }
    
    public String getBatteryStatus() {
        if (batteryLevel > 75) return "High (" + batteryLevel + "%)";
        if (batteryLevel > 25) return "Medium (" + batteryLevel + "%)";
        return "Low (" + batteryLevel + "%)";
    }
    
    public void updateSettings(String newSettings) {
        this.customSettings = newSettings;
        System.out.println("Settings updated to: " + newSettings);
    }
    
    // Getters
    public String getControllerType() { return controllerType; }
    public int getButtonCount() { return buttonCount; }
    public boolean hasVibration() { return hasVibration; }
    public int getBatteryLevel() { return batteryLevel; }
    public String getCustomSettings() { return customSettings; }
    
    public static void main(String[] args) {
        System.out.println("=== Game Controller Demo ===");
        
        GameController controller1 = new GameController();
        controller1.configure();
        controller1.testController();
        System.out.println("Battery: " + controller1.getBatteryStatus());
        System.out.println();
        
        GameController controller2 = new GameController("Pro");
        controller2.configure();
        controller2.testController();
        System.out.println("Battery: " + controller2.getBatteryStatus());
        System.out.println();
        
        GameController controller3 = new GameController("Elite", 20, true, 50, "Custom Gaming Profile");
        controller3.configure();
        controller3.testController();
        controller3.updateSettings("Tournament Mode");
        System.out.println("Battery: " + controller3.getBatteryStatus());
    }
}