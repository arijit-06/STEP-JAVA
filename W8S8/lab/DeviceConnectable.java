/*
LAB PROBLEM 6: Abstract Device and Connectable Interface
Topic: Abstract Class and Interface in Electronics
Problem Statement:
Create an abstract class Device with fields brand and model. Add an abstract method
powerOn().
Create an interface Connectable with method connect().
Create a class Smartphone that extends Device and implements Connectable.
Hints:
● Abstract class handles general device structure.
● Interface enforces connectivity feature.
*/

abstract class AbstractDevice {
    protected String brand;
    protected String model;
    protected boolean isPoweredOn;
    
    public AbstractDevice(String brand, String model) {
        this.brand = brand;
        this.model = model;
        this.isPoweredOn = false;
    }
    
    public abstract void powerOn();
    
    public void powerOff() {
        if (isPoweredOn) {
            System.out.println("Powering off " + brand + " " + model);
            isPoweredOn = false;
        } else {
            System.out.println("Device is already powered off");
        }
    }
    
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public boolean isPoweredOn() { return isPoweredOn; }
}

interface Connectable {
    void connect();
    
    default void connectionInfo() {
        System.out.println("This device supports network connectivity");
    }
}

class Smartphone extends AbstractDevice implements Connectable {
    private String phoneNumber;
    private boolean isConnected;
    
    public Smartphone(String brand, String model) {
        super(brand, model);
        this.phoneNumber = "Not Assigned";
        this.isConnected = false;
    }
    
    @Override
    public void powerOn() {
        if (!isPoweredOn) {
            System.out.println("Powering on " + brand + " " + model + " smartphone");
            isPoweredOn = true;
        } else {
            System.out.println("Smartphone is already powered on");
        }
    }
    
    @Override
    public void connect() {
        if (!isPoweredOn) {
            System.out.println("Cannot connect - device is powered off");
            return;
        }
        
        System.out.println("Connecting " + brand + " " + model + " to network");
        isConnected = true;
        System.out.println("Smartphone connected successfully");
    }
    
    public void makeCall(String number) {
        if (!isPoweredOn || !isConnected) {
            System.out.println("Cannot make call - device not ready");
            return;
        }
        System.out.println("Making call to " + number);
    }
}

public class DeviceConnectable {
    public static void main(String[] args) {
        System.out.println("=== Abstract Device and Connectable Interface Demo ===");
        
        Smartphone phone1 = new Smartphone("Samsung", "Galaxy S23");
        Smartphone phone2 = new Smartphone("Apple", "iPhone 14");
        
        System.out.println("\n=== Smartphone 1 Demo ===");
        phone1.powerOn();
        phone1.connect();
        phone1.connectionInfo();
        phone1.makeCall("+1-555-0123");
        
        System.out.println("\n=== Smartphone 2 Demo ===");
        phone2.powerOn();
        phone2.connect();
        phone2.makeCall("+1-555-0456");
        
        System.out.println("\n=== Polymorphic Behavior Demo ===");
        AbstractDevice[] devices = {phone1, phone2};
        Connectable[] connectables = {phone1, phone2};
        
        System.out.println("\nUsing Device references:");
        for (AbstractDevice device : devices) {
            System.out.println(device.getBrand() + " " + device.getModel() + 
                " - Status: " + (device.isPoweredOn() ? "ON" : "OFF"));
        }
        
        System.out.println("\nUsing Connectable references:");
        for (Connectable connectable : connectables) {
            connectable.connectionInfo();
        }
        
        System.out.println("\n=== Key Learning Points ===");
        System.out.println("1. Abstract Device class provides common device structure");
        System.out.println("2. Connectable interface defines connectivity contract");
        System.out.println("3. Smartphone implements both abstract methods and interface methods");
        System.out.println("4. Polymorphism enables uniform device management");
    }
}