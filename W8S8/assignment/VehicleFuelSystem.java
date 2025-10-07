/*
Topic 3: Abstract Class + Interface Together
Problem Statement:
Create an abstract class Vehicle with abstract method start() and a concrete method
stop().
Create an interface Fuel with method refuel().
Create class Car that extends Vehicle and implements Fuel. Test all methods.
Hints:
● Use abstract class for Vehicle.
● Implement refuel() from Fuel interface in Car.
● Show method calls of start(), stop(), and refuel().
*/

abstract class AbstractVehicle {
    protected String brand;
    protected String model;
    protected int year;
    protected boolean engineRunning;
    protected double fuelLevel;
    
    public AbstractVehicle(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.engineRunning = false;
        this.fuelLevel = 50.0;
    }
    
    public abstract void start();
    
    public void stop() {
        if (engineRunning) {
            System.out.println("Stopping " + brand + " " + model);
            engineRunning = false;
        } else {
            System.out.println("Vehicle is already stopped");
        }
    }
    
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public boolean isEngineRunning() { return engineRunning; }
    public double getFuelLevel() { return fuelLevel; }
}

interface Fuel {
    void refuel();
    
    default void fuelInfo() {
        System.out.println("This vehicle requires regular refueling");
    }
}

class Car extends AbstractVehicle implements Fuel {
    private String fuelType;
    
    public Car(String brand, String model, int year) {
        super(brand, model, year);
        this.fuelType = "Petrol";
    }
    
    @Override
    public void start() {
        if (!engineRunning) {
            System.out.println("Starting " + brand + " " + model + " with ignition");
            engineRunning = true;
        } else {
            System.out.println("Car engine is already running");
        }
    }
    
    @Override
    public void refuel() {
        System.out.println("Refueling " + brand + " " + model + " with " + fuelType);
        fuelLevel = 100.0;
        System.out.println("Tank is now full");
    }
}

public class VehicleFuelSystem {
    public static void main(String[] args) {
        System.out.println("=== Abstract Class + Interface Together Demo ===");
        
        Car car1 = new Car("Toyota", "Camry", 2022);
        Car car2 = new Car("Honda", "Civic", 2023);
        
        System.out.println("\n=== Car 1 Demo ===");
        car1.start();
        car1.stop();
        car1.refuel();
        car1.fuelInfo();
        
        System.out.println("\n=== Car 2 Demo ===");
        car2.start();
        car2.refuel();
        car2.stop();
        
        System.out.println("\n=== Polymorphic Behavior Demo ===");
        AbstractVehicle[] vehicles = {car1, car2};
        Fuel[] fuelableVehicles = {car1, car2};
        
        System.out.println("\nUsing Vehicle references:");
        for (AbstractVehicle vehicle : vehicles) {
            System.out.println(vehicle.getBrand() + " " + vehicle.getModel() + 
                " - Status: " + (vehicle.isEngineRunning() ? "Running" : "Stopped"));
        }
        
        System.out.println("\nRefueling all vehicles:");
        for (Fuel fuelable : fuelableVehicles) {
            fuelable.refuel();
        }
        
        System.out.println("\n=== Key Learning Points ===");
        System.out.println("1. Abstract Vehicle class provides common vehicle structure");
        System.out.println("2. Fuel interface defines refueling contract");
        System.out.println("3. Car implements both abstract methods and interface methods");
        System.out.println("4. Concrete stop() method is inherited by all vehicles");
        System.out.println("5. Multiple inheritance achieved through interface implementation");
    }
}