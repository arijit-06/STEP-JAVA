public class SmartDevice {
    private String deviceId;
    private String deviceName;
    private String location;
    private boolean isConnected;
    private int batteryLevel;
    
    // Constructor demonstrating 'this' to resolve parameter shadowing
    public SmartDevice(String deviceId, String deviceName, String location, boolean isConnected, int batteryLevel) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.location = location;
        this.isConnected = isConnected;
        this.batteryLevel = batteryLevel;
    }
    
    // Constructor chaining using 'this'
    public SmartDevice(String deviceId, String deviceName) {
        this(deviceId, deviceName, "Unknown", false, 100);
    }
    
    // Default constructor using 'this'
    public SmartDevice() {
        this("DEV001", "Smart Device", "Home", false, 50);
    }
    
    // Method chaining using 'this' - fluent interface pattern
    public SmartDevice setName(String deviceName) {
        this.deviceName = deviceName;
        return this; // Return 'this' for method chaining
    }
    
    public SmartDevice setLocation(String location) {
        this.location = location;
        return this; // Return 'this' for method chaining
    }
    
    public SmartDevice connect() {
        this.isConnected = true;
        System.out.println(this.deviceName + " connected at " + this.location);
        return this; // Return 'this' for method chaining
    }
    
    public SmartDevice disconnect() {
        this.isConnected = false;
        System.out.println(this.deviceName + " disconnected");
        return this; // Return 'this' for method chaining
    }
    
    public SmartDevice setBatteryLevel(int batteryLevel) {
        this.batteryLevel = (batteryLevel >= 0 && batteryLevel <= 100) ? batteryLevel : this.batteryLevel;
        return this; // Return 'this' for method chaining
    }
    
    // Method using 'this' for method calls
    public void performDiagnostics() {
        System.out.println("=== Device Diagnostics ===");
        this.displayStatus(); // Using 'this' to call method
        this.checkBattery(); // Using 'this' to call method
        this.testConnection(); // Using 'this' to call method
    }
    
    private void displayStatus() {
        System.out.println("Device: " + this.deviceName + " (ID: " + this.deviceId + ")");
        System.out.println("Location: " + this.location);
        System.out.println("Connected: " + this.isConnected);
    }
    
    private void checkBattery() {
        System.out.println("Battery Level: " + this.batteryLevel + "%");
        if (this.batteryLevel < 20) {
            System.out.println("Warning: Low battery!");
        }
    }
    
    private void testConnection() {
        if (this.isConnected) {
            System.out.println("Connection test: PASSED");
        } else {
            System.out.println("Connection test: FAILED - Device not connected");
        }
    }
    
    // Method that compares with another object using 'this'
    public boolean isSameDevice(SmartDevice other) {
        return this.deviceId.equals(other.deviceId);
    }
    
    // Method that uses 'this' reference for comparison
    public SmartDevice getBetterDevice(SmartDevice other) {
        if (this.batteryLevel > other.batteryLevel && this.isConnected) {
            return this;
        }
        return other;
    }
    
    // Getters using 'this' for clarity
    public String getDeviceId() { return this.deviceId; }
    public String getDeviceName() { return this.deviceName; }
    public String getLocation() { return this.location; }
    public boolean isConnected() { return this.isConnected; }
    public int getBatteryLevel() { return this.batteryLevel; }
    
    @Override
    public String toString() {
        return this.deviceName + " at " + this.location + 
               " (Battery: " + this.batteryLevel + "%, Connected: " + this.isConnected + ")";
    }
    
    public static void main(String[] args) {
        System.out.println("=== Smart Device 'this' Keyword Demo ===");
        
        // Demonstrate constructor chaining with 'this'
        SmartDevice device1 = new SmartDevice();
        System.out.println("Device 1: " + device1);
        System.out.println();
        
        SmartDevice device2 = new SmartDevice("DEV002", "Smart Thermostat");
        System.out.println("Device 2: " + device2);
        System.out.println();
        
        // Demonstrate method chaining with 'this'
        SmartDevice device3 = new SmartDevice("DEV003", "Smart Light")
            .setLocation("Living Room")
            .setBatteryLevel(85)
            .connect();
        
        System.out.println("Device 3 after chaining: " + device3);
        System.out.println();
        
        // Demonstrate 'this' in method calls
        device3.performDiagnostics();
        System.out.println();
        
        // Demonstrate 'this' in object comparison
        SmartDevice device4 = new SmartDevice("DEV003", "Another Light");
        System.out.println("Device 3 and 4 same device: " + device3.isSameDevice(device4));
        
        SmartDevice device5 = new SmartDevice("DEV005", "Smart Speaker")
            .setLocation("Kitchen")
            .setBatteryLevel(30)
            .connect();
        
        SmartDevice betterDevice = device3.getBetterDevice(device5);
        System.out.println("Better device: " + betterDevice.getDeviceName());
        
        // More method chaining examples
        System.out.println("\n=== Advanced Method Chaining ===");
        new SmartDevice("DEV006", "Smart Camera")
            .setLocation("Front Door")
            .setBatteryLevel(95)
            .connect()
            .performDiagnostics();
    }
}