// LAB 6: Smart Campus IoT System - Safe Downcasting with instanceof
class SmartDevice {
    protected String deviceId;
    protected String location;
    protected boolean isOnline;
    
    public SmartDevice(String deviceId, String location) {
        this.deviceId = deviceId;
        this.location = location;
        this.isOnline = true;
    }
    
    public void connect() {
        System.out.println("🔗 Device " + deviceId + " connected at " + location);
    }
    
    public void disconnect() {
        isOnline = false;
        System.out.println("❌ Device " + deviceId + " disconnected");
    }
}

class SmartClassroom extends SmartDevice {
    private int lightLevel;
    private int temperature;
    private boolean projectorOn;
    
    public SmartClassroom(String deviceId, String location) {
        super(deviceId, location);
        this.lightLevel = 70;
        this.temperature = 72;
        this.projectorOn = false;
    }
    
    public void controlLighting(int level) {
        lightLevel = level;
        System.out.println("💡 Classroom " + deviceId + " lighting set to " + level + "%");
    }
    
    public void controlAC(int temp) {
        temperature = temp;
        System.out.println("❄️ AC temperature set to " + temp + "°F");
    }
    
    public void controlProjector(boolean on) {
        projectorOn = on;
        System.out.println("📽️ Projector " + (on ? "ON" : "OFF"));
    }
}

class SmartLab extends SmartDevice {
    private String[] equipment;
    private boolean safetySystemActive;
    
    public SmartLab(String deviceId, String location, String[] equipment) {
        super(deviceId, location);
        this.equipment = equipment;
        this.safetySystemActive = true;
    }
    
    public void manageEquipment() {
        System.out.print("🔬 Lab " + deviceId + " equipment status: ");
        for (String item : equipment) {
            System.out.print(item + " ✅ ");
        }
        System.out.println();
    }
    
    public void activateSafety() {
        safetySystemActive = true;
        System.out.println("🚨 Safety systems activated for lab " + deviceId);
    }
}

class SmartLibrary extends SmartDevice {
    private int occupancy;
    private int maxCapacity;
    private int availableBooks;
    
    public SmartLibrary(String deviceId, String location, int maxCapacity) {
        super(deviceId, location);
        this.maxCapacity = maxCapacity;
        this.occupancy = 0;
        this.availableBooks = 10000;
    }
    
    public void trackOccupancy(int current) {
        occupancy = current;
        double percentage = (occupancy * 100.0) / maxCapacity;
        System.out.println("👥 Library " + deviceId + " occupancy: " + occupancy + "/" + maxCapacity + 
                         " (" + String.format("%.1f", percentage) + "%)");
    }
    
    public void updateBookAvailability(int books) {
        availableBooks = books;
        System.out.println("📚 Available books: " + books);
    }
}

public class SmartCampusIoT {
    public static void processDevices(SmartDevice[] devices) {
        System.out.println("=== Smart Campus Device Management ===");
        
        for (SmartDevice device : devices) {
            device.connect();
            
            // Safe downcasting with instanceof
            if (device instanceof SmartClassroom) {
                SmartClassroom classroom = (SmartClassroom) device;
                classroom.controlLighting(80);
                classroom.controlAC(70);
                classroom.controlProjector(true);
            } else if (device instanceof SmartLab) {
                SmartLab lab = (SmartLab) device;
                lab.manageEquipment();
                lab.activateSafety();
            } else if (device instanceof SmartLibrary) {
                SmartLibrary library = (SmartLibrary) device;
                library.trackOccupancy(45);
                library.updateBookAvailability(9876);
            } else {
                System.out.println("⚠️ Unknown device type for " + device.deviceId);
            }
            
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        SmartDevice[] campusDevices = {
            new SmartClassroom("CR-101", "Engineering Building"),
            new SmartLab("LAB-205", "Chemistry Department", new String[]{"Microscope", "Centrifuge", "Spectrometer"}),
            new SmartLibrary("LIB-MAIN", "Central Library", 200),
            new SmartClassroom("CR-302", "Business School")
        };
        
        processDevices(campusDevices);
        
        System.out.println("=== System Status Check ===");
        for (SmartDevice device : campusDevices) {
            System.out.println("Device " + device.deviceId + " at " + device.location + 
                             " - Status: " + (device.isOnline ? "Online" : "Offline"));
        }
    }
}