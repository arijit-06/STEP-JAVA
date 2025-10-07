/*
Problem 1: Vehicle with Abstract Class
Problem Statement:
Create an abstract class Vehicle with an abstract method start(). Subclasses Car
and Bike will extend Vehicle and provide their own implementations for start().
Demonstrate abstraction by using Vehicle references to call the methods.
*/

// File: Vehicle.java
abstract class AbstractVehicle {
    // TODO: Create abstract method start()
    public abstract void start();
    
    // TODO: Create non-abstract method fuelType() -> print "Uses fuel"
    public void fuelType() {
        System.out.println("Uses fuel");
    }
}

// File: Car.java
class Car extends AbstractVehicle {
    // TODO: Implement start() -> "Car starts with key"
    @Override
    public void start() {
        System.out.println("Car starts with key");
    }
}

// File: Bike.java
class Bike extends AbstractVehicle {
    // TODO: Implement start() -> "Bike starts with kick"
    @Override
    public void start() {
        System.out.println("Bike starts with kick");
    }
}

// File: VehicleTest.java
public class Vehicle {
    public static void main(String[] args) {
        // TODO: Create Vehicle reference pointing to Car
        AbstractVehicle car = new Car();
        // TODO: Call start() and fuelType()
        car.start();
        car.fuelType();
        
        System.out.println(); // Separator
        
        // TODO: Create Vehicle reference pointing to Bike
        AbstractVehicle bike = new Bike();
        // TODO: Call start() and fuelType()
        bike.start();
        bike.fuelType();
        
        System.out.println("\n=== Demonstrating Abstraction ===");
        System.out.println("Both Car and Bike objects are referenced through Vehicle abstract class");
        System.out.println("Each provides its own implementation of the abstract start() method");
        System.out.println("Both inherit the concrete fuelType() method from Vehicle");
    }
}