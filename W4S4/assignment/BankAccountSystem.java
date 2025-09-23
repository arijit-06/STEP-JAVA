// File: BankAccountSystem.java
// HW PROBLEM 1: Light and LED Multiple Constructors
// Topic: Constructor Chaining with this() and super()

public class BankAccountSystem {
    
    // Light class with multiple constructors using this()
    public static class Light {
        private String type;
        private int wattage;
        private String color;
        private boolean isOn;
        
        // Default constructor
        public Light() {
            this("Incandescent", 60, "Warm White");
            System.out.println("Light default constructor called");
        }
        
        // Constructor with type only
        public Light(String type) {
            this(type, 60, "Warm White");
            System.out.println("Light constructor with type called");
        }
        
        // Constructor with type and wattage
        public Light(String type, int wattage) {
            this(type, wattage, "Warm White");
            System.out.println("Light constructor with type and wattage called");
        }
        
        // Full constructor
        public Light(String type, int wattage, String color) {
            this.type = type;
            this.wattage = wattage;
            this.color = color;
            this.isOn = false;
            System.out.println("Light full constructor called");
        }
        
        public void turnOn() {
            isOn = true;
            System.out.println(type + " light turned on");
        }
        
        public void turnOff() {
            isOn = false;
            System.out.println(type + " light turned off");
        }
        
        public String getLightInfo() {
            return String.format("Type: %s, Wattage: %dW, Color: %s, Status: %s",
                               type, wattage, color, isOn ? "ON" : "OFF");
        }
    }
    
    // LED class with constructors using both this() and super()
    public static class LED extends Light {
        private int lifespan;
        private boolean isDimmable;
        private int brightness;
        
        // Default constructor using super()
        public LED() {
            super("LED", 10, "Cool White");
            this.lifespan = 25000;
            this.isDimmable = true;
            this.brightness = 100;
            System.out.println("LED default constructor called");
        }
        
        // Constructor with lifespan using this()
        public LED(int lifespan) {
            this();
            this.lifespan = lifespan;
            System.out.println("LED constructor with lifespan called");
        }
        
        // Constructor with type and lifespan using super() and this()
        public LED(String type, int lifespan) {
            super(type, 8, "Cool White");
            this.lifespan = lifespan;
            this.isDimmable = true;
            this.brightness = 100;
            System.out.println("LED constructor with type and lifespan called");
        }
        
        // Full constructor using super()
        public LED(String type, int wattage, String color, int lifespan, boolean isDimmable) {
            super(type, wattage, color);
            this.lifespan = lifespan;
            this.isDimmable = isDimmable;
            this.brightness = 100;
            System.out.println("LED full constructor called");
        }
        
        @Override
        public void turnOn() {
            super.turnOn();
            System.out.println("LED brightness set to " + brightness + "%");
        }
        
        public void setBrightness(int brightness) {
            if (isDimmable && brightness >= 0 && brightness <= 100) {
                this.brightness = brightness;
                System.out.println("LED brightness set to " + brightness + "%");
            } else {
                System.out.println("Cannot adjust brightness");
            }
        }
        
        @Override
        public String getLightInfo() {
            return super.getLightInfo() + String.format(", Lifespan: %d hours, Dimmable: %s, Brightness: %d%%",
                                                       lifespan, isDimmable ? "Yes" : "No", brightness);
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Testing Constructor Chaining ===");
        
        System.out.println("\n1. Light constructors with this():");
        Light light1 = new Light();
        System.out.println(light1.getLightInfo());
        
        System.out.println("\n2. Light constructor with type:");
        Light light2 = new Light("Fluorescent");
        System.out.println(light2.getLightInfo());
        
        System.out.println("\n3. Light constructor with type and wattage:");
        Light light3 = new Light("Halogen", 100);
        System.out.println(light3.getLightInfo());
        
        System.out.println("\n4. LED constructors with super() and this():");
        LED led1 = new LED();
        System.out.println(led1.getLightInfo());
        
        System.out.println("\n5. LED constructor with lifespan:");
        LED led2 = new LED(50000);
        System.out.println(led2.getLightInfo());
        
        System.out.println("\n6. LED constructor with type and lifespan:");
        LED led3 = new LED("Smart LED", 30000);
        System.out.println(led3.getLightInfo());
        
        System.out.println("\n7. LED full constructor:");
        LED led4 = new LED("RGB LED", 12, "Multi-color", 40000, true);
        System.out.println(led4.getLightInfo());
        
        System.out.println("\n=== Testing Functionality ===");
        led4.turnOn();
        led4.setBrightness(75);
        led4.turnOff();
    }
}