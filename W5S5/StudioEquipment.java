// Base class
class StudioEquipment {
    protected String equipmentName;
    protected String brand;
    protected double price;
    protected String condition;
    
    // Default constructor
    public StudioEquipment() {
        this("Unknown Equipment", "Generic", 0.0, "New");
    }
    
    // Constructor with name only
    public StudioEquipment(String equipmentName) {
        this(equipmentName, "Generic", 100.0, "New");
    }
    
    // Constructor with name and brand
    public StudioEquipment(String equipmentName, String brand) {
        this(equipmentName, brand, 200.0, "New");
    }
    
    // Full constructor
    public StudioEquipment(String equipmentName, String brand, double price, String condition) {
        this.equipmentName = (equipmentName != null) ? equipmentName : "Unknown Equipment";
        this.brand = (brand != null) ? brand : "Generic";
        this.price = (price >= 0) ? price : 0.0;
        this.condition = (condition != null) ? condition : "New";
    }
    
    public void testEquipment() {
        System.out.println("Testing " + equipmentName + " by " + brand);
        System.out.println("Status: " + condition + ", Value: $" + price);
    }
    
    public void performMaintenance() {
        System.out.println("Performing maintenance on " + equipmentName);
        if (condition.equals("Poor")) {
            condition = "Fair";
        } else if (condition.equals("Fair")) {
            condition = "Good";
        }
    }
    
    public double calculateValue() {
        double multiplier = 1.0;
        switch (condition.toLowerCase()) {
            case "excellent": multiplier = 1.0; break;
            case "good": multiplier = 0.8; break;
            case "fair": multiplier = 0.6; break;
            case "poor": multiplier = 0.4; break;
            default: multiplier = 1.0;
        }
        return price * multiplier;
    }
    
    public String getEquipmentName() { return equipmentName; }
    public String getBrand() { return brand; }
    public double getPrice() { return price; }
    public String getCondition() { return condition; }
}

// Derived classes
class Microphone extends StudioEquipment {
    private String micType;
    private boolean needsPhantomPower;
    
    public Microphone() {
        super();
        this.micType = "Dynamic";
        this.needsPhantomPower = false;
    }
    
    public Microphone(String brand) {
        super("Microphone", brand);
        this.micType = "Condenser";
        this.needsPhantomPower = true;
    }
    
    public Microphone(String brand, String micType, boolean needsPhantomPower, double price) {
        super("Microphone", brand, price, "New");
        this.micType = micType;
        this.needsPhantomPower = needsPhantomPower;
    }
    
    @Override
    public void testEquipment() {
        super.testEquipment();
        System.out.println("Mic Type: " + micType + ", Phantom Power: " + needsPhantomPower);
    }
}

class Mixer extends StudioEquipment {
    private int channels;
    private boolean hasUSB;
    
    public Mixer() {
        super();
        this.channels = 4;
        this.hasUSB = false;
    }
    
    public Mixer(String brand, int channels) {
        super("Mixer", brand);
        this.channels = channels;
        this.hasUSB = channels > 8;
    }
    
    public Mixer(String brand, int channels, boolean hasUSB, double price) {
        super("Mixer", brand, price, "New");
        this.channels = channels;
        this.hasUSB = hasUSB;
    }
    
    @Override
    public void testEquipment() {
        super.testEquipment();
        System.out.println("Channels: " + channels + ", USB: " + hasUSB);
    }
}

class Speaker extends StudioEquipment {
    private int wattage;
    private String speakerType;
    
    public Speaker() {
        super();
        this.wattage = 50;
        this.speakerType = "Monitor";
    }
    
    public Speaker(String brand, int wattage) {
        super("Speaker", brand);
        this.wattage = wattage;
        this.speakerType = (wattage > 100) ? "Studio" : "Monitor";
    }
    
    public Speaker(String brand, int wattage, String speakerType, double price) {
        super("Speaker", brand, price, "New");
        this.wattage = wattage;
        this.speakerType = speakerType;
    }
    
    @Override
    public void testEquipment() {
        super.testEquipment();
        System.out.println("Wattage: " + wattage + "W, Type: " + speakerType);
    }
}

class Synthesizer extends StudioEquipment {
    private int keys;
    private boolean hasMIDI;
    
    public Synthesizer() {
        super();
        this.keys = 61;
        this.hasMIDI = true;
    }
    
    public Synthesizer(String brand, int keys) {
        super("Synthesizer", brand);
        this.keys = keys;
        this.hasMIDI = true;
    }
    
    public Synthesizer(String brand, int keys, boolean hasMIDI, double price) {
        super("Synthesizer", brand, price, "New");
        this.keys = keys;
        this.hasMIDI = hasMIDI;
    }
    
    @Override
    public void testEquipment() {
        super.testEquipment();
        System.out.println("Keys: " + keys + ", MIDI: " + hasMIDI);
    }
}

public class StudioEquipmentDemo {
    public static void main(String[] args) {
        System.out.println("=== Studio Equipment Constructor Chaining Demo ===");
        
        Microphone mic1 = new Microphone();
        mic1.testEquipment();
        System.out.println("Value: $" + mic1.calculateValue());
        System.out.println();
        
        Microphone mic2 = new Microphone("Shure");
        mic2.testEquipment();
        System.out.println();
        
        Mixer mixer1 = new Mixer("Yamaha", 12);
        mixer1.testEquipment();
        mixer1.performMaintenance();
        System.out.println();
        
        Speaker speaker1 = new Speaker("KRK", 150, "Studio", 300.0);
        speaker1.testEquipment();
        System.out.println();
        
        Synthesizer synth1 = new Synthesizer("Roland", 88, true, 1200.0);
        synth1.testEquipment();
        System.out.println("Value: $" + synth1.calculateValue());
    }
}