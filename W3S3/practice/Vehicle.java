public class Vehicle {
    protected String make;
    protected String model;
    protected int year;
    protected double fuelLevel;
    
    public Vehicle(String make, String model, int year, double fuelLevel) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.fuelLevel = fuelLevel;
    }
    
    public void startVehicle() {
        System.out.println(make + " " + model + " started");
    }
    
    public void stopVehicle() {
        System.out.println(make + " " + model + " stopped");
    }
    
    public void refuel(double amount) {
        fuelLevel += amount;
        System.out.println("Refueled " + amount + " liters. Current fuel: " + fuelLevel);
    }
    
    public void displayVehicleInfo() {
        System.out.println(year + " " + make + " " + model + " - Fuel: " + fuelLevel + "L");
    }
    
    public static void main(String[] args) {
        Vehicle car = new Vehicle("Toyota", "Camry", 2020, 45.0);
        Vehicle truck = new Vehicle("Ford", "F-150", 2019, 80.0);
        Vehicle motorcycle = new Vehicle("Honda", "CBR", 2021, 15.0);
        
        Vehicle[] vehicles = {car, truck, motorcycle};
        
        System.out.println("=== Vehicle Fleet Management ===");
        for (Vehicle v : vehicles) {
            v.displayVehicleInfo();
            v.startVehicle();
            v.refuel(10);
            v.stopVehicle();
            System.out.println();
        }
        
        System.out.println("=== Reusability Benefits ===");
        System.out.println("// Same Vehicle class used for different vehicle types");
        System.out.println("// Common methods (start, stop, refuel) work for all");
        System.out.println("// Easy to add new vehicle types without changing existing code");
        
        System.out.println("\n=== Extensibility Benefits ===");
        System.out.println("// Can extend Vehicle class for specific types:");
        System.out.println("// - Car class with doors, airCondition");
        System.out.println("// - Truck class with loadCapacity, trailerAttached");
        System.out.println("// - Motorcycle class with helmetRequired, sidecar");
        
        System.out.println("\n=== Polymorphic Behavior ===");
        System.out.println("Array of Vehicle objects can hold different vehicle types");
        System.out.println("Same method calls work on all objects in the array");
    }
}