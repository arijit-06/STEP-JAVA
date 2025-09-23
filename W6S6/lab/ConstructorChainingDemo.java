// File: ConstructorChainingDemo.java
// LAB 2: Phone and SmartPhone Constructors

public class ConstructorChainingDemo {
    
    public static class Phone {
        protected String brand;
        protected String model;
        protected double price;
        
        public Phone() {
            this("Unknown", "Basic", 100.0);
            System.out.println("Phone default constructor");
        }
        
        public Phone(String brand, String model, double price) {
            this.brand = brand;
            this.model = model;
            this.price = price;
            System.out.println("Phone parameterized constructor: " + brand + " " + model);
        }
        
        public void makeCall() {
            System.out.println("Making call on " + brand + " " + model);
        }
        
        public void displayInfo() {
            System.out.println(brand + " " + model + " - $" + price);
        }
    }
    
    public static class SmartPhone extends Phone {
        private String operatingSystem;
        private int storageGB;
        
        public SmartPhone() {
            super();
            this.operatingSystem = "Android";
            this.storageGB = 64;
            System.out.println("SmartPhone default constructor");
        }
        
        public SmartPhone(String brand, String model, double price, String os, int storage) {
            super(brand, model, price);
            this.operatingSystem = os;
            this.storageGB = storage;
            System.out.println("SmartPhone parameterized constructor: " + os + " with " + storage + "GB");
        }
        
        @Override
        public void makeCall() {
            super.makeCall();
            System.out.println("Using touchscreen interface");
        }
        
        public void installApp() {
            System.out.println("Installing app on " + operatingSystem);
        }
        
        @Override
        public void displayInfo() {
            super.displayInfo();
            System.out.println("OS: " + operatingSystem + ", Storage: " + storageGB + "GB");
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Constructor Chaining Demo ===");
        
        System.out.println("\n1. Default constructors:");
        SmartPhone phone1 = new SmartPhone();
        
        System.out.println("\n2. Parameterized constructors:");
        SmartPhone phone2 = new SmartPhone("iPhone", "14", 999.0, "iOS", 128);
        
        System.out.println("\n=== Testing Methods ===");
        phone1.displayInfo();
        phone1.makeCall();
        phone1.installApp();
        
        System.out.println();
        phone2.displayInfo();
        phone2.makeCall();
        phone2.installApp();
    }
}