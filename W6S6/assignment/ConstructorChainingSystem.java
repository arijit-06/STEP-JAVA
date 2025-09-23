// File: ConstructorChainingSystem.java
// ASSIGNMENT 1: Light and LED Multiple Constructors

public class ConstructorChainingSystem {
    
    public static class Light {
        protected String type;
        protected int wattage;
        protected String color;
        protected boolean isOn;
        
        public Light() {
            this("Incandescent", 60, "Warm White");
            System.out.println("Light default constructor called");
        }
        
        public Light(String type) {
            this(type, 60, "Warm White");
            System.out.println("Light constructor with type called");
        }
        
        public Light(String type, int wattage) {
            this(type, wattage, "Warm White");
            System.out.println("Light constructor with type and wattage called");
        }
        
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
        
        public void displayInfo() {
            System.out.println(type + " - " + wattage + "W - " + color + " - " + (isOn ? "ON" : "OFF"));
        }
    }
    
    public static class LED extends Light {
        private int lifespan;
        private boolean isDimmable;
        private int brightness;
        
        public LED() {
            super("LED", 10, "Cool White");
            this.lifespan = 25000;
            this.isDimmable = true;
            this.brightness = 100;
            System.out.println("LED default constructor called");
        }
        
        public LED(int lifespan) {
            this();
            this.lifespan = lifespan;
            System.out.println("LED constructor with lifespan called");
        }
        
        public LED(String type, int lifespan) {
            super(type, 8, "Cool White");
            this.lifespan = lifespan;
            this.isDimmable = true;
            this.brightness = 100;
            System.out.println("LED constructor with type and lifespan called");
        }
        
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
                System.out.println("LED brightness adjusted to " + brightness + "%");
            } else {
                System.out.println("Cannot adjust brightness");
            }
        }
        
        @Override
        public void displayInfo() {
            super.displayInfo();
            System.out.println("Lifespan: " + lifespan + " hours, Dimmable: " + isDimmable + 
                             ", Brightness: " + brightness + "%");
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Constructor Chaining Demo ===");
        
        System.out.println("\n1. Light constructors with this():");
        Light light1 = new Light();
        Light light2 = new Light("Fluorescent");
        Light light3 = new Light("Halogen", 100);
        
        System.out.println("\n2. LED constructors with super() and this():");
        LED led1 = new LED();
        LED led2 = new LED(50000);
        LED led3 = new LED("Smart LED", 30000);
        LED led4 = new LED("RGB LED", 12, "Multi-color", 40000, true);
        
        System.out.println("\n=== Testing Functionality ===");
        led4.displayInfo();
        led4.turnOn();
        led4.setBrightness(75);
        led4.turnOff();
    }
}