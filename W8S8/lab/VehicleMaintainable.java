/*
LAB PROBLEM 3: Abstract Vehicle and Maintainable Interface
Topic: Abstract Class and Interface in Transport System
Problem Statement:
Create an abstract class Vehicle with protected fields speed and fuelType. Add an abstract
method startEngine().
Create an interface Maintainable with method serviceInfo().
Create a class Car that extends Vehicle and implements Maintainable.
Hints:
● Use extends and implements together.
● Provide concrete implementations for abstract and interface methods.
*/

abstract class AbstractVehicle {
    protected int speed;
    protected String fuelType;
    protected String brand;
    protected String model;
    protected int year;
    protected boolean engineRunning;
    
    public Vehicle(int speed, String fuelType) {
        this.speed = speed;
        this.fuelType = fuelType;
        this.brand = "Generic";
        this.model = "Unknown";
        this.year = 2023;
        this.engineRunning = false;
    }
    
    public Vehicle(int speed, String fuelType, String brand, String model, int year) {
        this.speed = speed;
        this.fuelType = fuelType;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.engineRunning = false;
    }
    
    public abstract void startEngine();
    
    public void stopEngine() {
        if (engineRunning) {
            System.out.println(brand + " " + model + " engine stopped");
            engineRunning = false;
        } else {
            System.out.println("Engine is already stopped");
        }
    }
    
    public void displayVehicleInfo() {
        System.out.println("\n=== Vehicle Information ===");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Max Speed: " + speed + " km/h");
        System.out.println("Fuel Type: " + fuelType);
        System.out.println("Engine Status: " + (engineRunning ? "Running" : "Stopped"));
    }
    
    public void accelerate(int targetSpeed) {
        if (!engineRunning) {
            System.out.println("Cannot accelerate - engine is not running!");
            return;
        }
        
        if (targetSpeed > speed) {
            System.out.println("Cannot exceed maximum speed of " + speed + " km/h");
            targetSpeed = speed;
        }
        
        System.out.println("Accelerating to " + targetSpeed + " km/h...");
    }
    
    public int getSpeed() { return speed; }
    public String getFuelType() { return fuelType; }
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public boolean isEngineRunning() { return engineRunning; }
}

interface Maintainable {
    void serviceInfo();
    
    default void maintenanceReminder() {
        System.out.println("Regular maintenance is essential for vehicle longevity");
    }
    
    static void generalMaintenanceTips() {
        System.out.println("General Maintenance Tips:");
        System.out.println("- Check oil levels regularly");
        System.out.println("- Monitor tire pressure");
        System.out.println("- Replace air filters as needed");
        System.out.println("- Follow manufacturer's service schedule");
    }
}

class Car extends AbstractVehicle implements Maintainable {
    private int doors;
    private String transmission;
    private int mileage;
    private String lastServiceDate;
    
    public Car(int speed, String fuelType) {
        super(speed, fuelType);
        this.doors = 4;
        this.transmission = "Manual";
        this.mileage = 0;
        this.lastServiceDate = "Never";
    }
    
    public Car(int speed, String fuelType, String brand, String model, int year, int doors, String transmission) {
        super(speed, fuelType, brand, model, year);
        this.doors = doors;
        this.transmission = transmission;
        this.mileage = 0;
        this.lastServiceDate = "Never";
    }
    
    @Override
    public void startEngine() {
        if (!engineRunning) {
            System.out.println("\n🚗 Starting " + brand + " " + model + " engine...");
            System.out.println("Turning key in ignition...");
            System.out.println("Engine started successfully!");
            System.out.println("Fuel Type: " + fuelType);
            System.out.println("Ready to drive!");
            engineRunning = true;
        } else {
            System.out.println("Engine is already running");
        }
    }
    
    @Override
    public void serviceInfo() {
        System.out.println("\n=== Car Service Information ===");
        System.out.println("Vehicle: " + brand + " " + model + " (" + year + ")");
        System.out.println("Service Interval: Every 6 months or 10,000 km");
        System.out.println("Current Mileage: " + mileage + " km");
        System.out.println("Last Service: " + lastServiceDate);
        
        int nextServiceMileage = ((mileage / 10000) + 1) * 10000;
        System.out.println("Next Service Due: " + nextServiceMileage + " km");
        
        System.out.println("\nService Checklist:");
        System.out.println("- Engine oil change");
        System.out.println("- Filter replacements");
        System.out.println("- Brake inspection");
        System.out.println("- Tire rotation");
        System.out.println("- Battery check");
        
        if (mileage > 50000) {
            System.out.println("⚠️ High mileage vehicle - consider additional inspections");
        }
    }
    
    @Override
    public void displayVehicleInfo() {
        super.displayVehicleInfo();
        System.out.println("Doors: " + doors);
        System.out.println("Transmission: " + transmission);
        System.out.println("Mileage: " + mileage + " km");
    }
    
    public void drive(int distance) {
        if (!engineRunning) {
            System.out.println("Cannot drive - engine is not running!");
            return;
        }
        
        mileage += distance;
        System.out.println("Driving " + distance + " km...");
        System.out.println("Total mileage: " + mileage + " km");
        
        if (mileage % 10000 == 0) {
            System.out.println("🔧 Service reminder: You've reached " + mileage + " km!");
        }
    }
    
    public void setLastServiceDate(String date) {
        this.lastServiceDate = date;
        System.out.println("Service date updated: " + date);
    }
    
    public int getDoors() { return doors; }
    public String getTransmission() { return transmission; }
    public int getMileage() { return mileage; }
}

class Motorcycle extends AbstractVehicle implements Maintainable {
    private boolean hasSidecar;
    private int engineCapacity;
    
    public Motorcycle(int speed, String fuelType, int engineCapacity) {
        super(speed, fuelType);
        this.engineCapacity = engineCapacity;
        this.hasSidecar = false;
    }
    
    @Override
    public void startEngine() {
        if (!engineRunning) {
            System.out.println("\n🏍️ Starting " + brand + " motorcycle engine...");
            System.out.println("Kick starting " + engineCapacity + "cc engine...");
            System.out.println("Engine roaring to life!");
            engineRunning = true;
        } else {
            System.out.println("Engine is already running");
        }
    }
    
    @Override
    public void serviceInfo() {
        System.out.println("\n=== Motorcycle Service Information ===");
        System.out.println("Engine Capacity: " + engineCapacity + "cc");
        System.out.println("Service Interval: Every 3 months or 5,000 km");
        System.out.println("Special Requirements:");
        System.out.println("- Chain lubrication");
        System.out.println("- Spark plug inspection");
        System.out.println("- Carburetor cleaning");
    }
}

public class VehicleMaintainable {
    public static void main(String[] args) {
        System.out.println("=== Abstract Vehicle and Maintainable Interface Demo ===");
        
        Maintainable.generalMaintenanceTips();
        
        Car car1 = new Car(180, "Petrol", "Toyota", "Camry", 2022, 4, "Automatic");
        Car car2 = new Car(200, "Diesel", "BMW", "X5", 2023, 4, "Automatic");
        Motorcycle bike = new Motorcycle(150, "Petrol", 250);
        
        System.out.println("\n=== Car 1 Demo ===");
        car1.displayVehicleInfo();
        car1.startEngine();
        car1.accelerate(120);
        car1.drive(15000);
        car1.setLastServiceDate("2023-06-15");
        car1.serviceInfo();
        car1.maintenanceReminder();
        car1.stopEngine();
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("\n=== Car 2 Demo ===");
        car2.displayVehicleInfo();
        car2.startEngine();
        car2.drive(25000);
        car2.serviceInfo();
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("\n=== Motorcycle Demo ===");
        bike.startEngine();
        bike.serviceInfo();
        bike.maintenanceReminder();
        
        System.out.println("\n=== Polymorphic Behavior Demo ===");
        AbstractVehicle[] vehicles = {car1, car2, bike};
        Maintainable[] maintainables = {car1, car2, bike};
        
        System.out.println("\nUsing Vehicle references:");
        for (AbstractVehicle vehicle : vehicles) {
            System.out.println(vehicle.getBrand() + " " + vehicle.getModel() + 
                " - Speed: " + vehicle.getSpeed() + " km/h, Fuel: " + vehicle.getFuelType());
        }
        
        System.out.println("\nUsing Maintainable references:");
        for (Maintainable maintainable : maintainables) {
            maintainable.serviceInfo();
            System.out.println();
        }
        
        System.out.println("=== Key Learning Points ===");
        System.out.println("1. Abstract Vehicle class provides common vehicle structure");
        System.out.println("2. Maintainable interface defines maintenance contract");
        System.out.println("3. Car implements both abstract methods and interface methods");
        System.out.println("4. Multiple inheritance achieved through interface implementation");
        System.out.println("5. Polymorphism enables uniform handling of different vehicle types");
    }
}