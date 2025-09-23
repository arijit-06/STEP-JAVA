// File: VirtualPetSimulator.java
// PRACTICE PROBLEM 1: Single Inheritance with extends and super
// Topic: Understanding basic inheritance, constructor chaining, and super keyword usage

public class VirtualPetSimulator {
    
    // Base class Vehicle
    public static class Vehicle {
        protected String brand;
        protected String model;
        protected int year;
        protected String engineType;
        private String registrationNumber;
        private boolean isRunning;
        
        public Vehicle() {
            this.brand = "Unknown";
            this.model = "Generic";
            this.year = 2020;
            this.engineType = "Standard";
            this.registrationNumber = "REG" + (int)(Math.random() * 10000);
            this.isRunning = false;
            System.out.println("Vehicle default constructor called");
        }
        
        public Vehicle(String brand, String model, int year, String engineType) {
            this.brand = brand;
            this.model = model;
            this.year = year;
            this.engineType = engineType;
            this.registrationNumber = "REG" + (int)(Math.random() * 10000);
            this.isRunning = false;
            System.out.println("Vehicle parameterized constructor called");
        }
        
        public void start() {
            isRunning = true;
            System.out.println("Vehicle started");
        }
        
        public void stop() {
            isRunning = false;
            System.out.println("Vehicle stopped");
        }
        
        public String getVehicleInfo() {
            return String.format("Brand: %s, Model: %s, Year: %d, Engine: %s, Reg: %s", 
                               brand, model, year, engineType, registrationNumber);
        }
        
        public void displaySpecs() {
            System.out.println("=== Vehicle Specifications ===");
            System.out.println(getVehicleInfo());
            System.out.println("Status: " + (isRunning ? "Running" : "Stopped"));
        }
        
        public String getRegistrationNumber() { return registrationNumber; }
        public void setRegistrationNumber(String reg) { this.registrationNumber = reg; }
        public boolean isRunning() { return isRunning; }
    }
    
    // Child class Car extending Vehicle
    public static class Car extends Vehicle {
        private int numberOfDoors;
        private String fuelType;
        private String transmissionType;
        
        public Car() {
            super();
            this.numberOfDoors = 4;
            this.fuelType = "Gasoline";
            this.transmissionType = "Manual";
            System.out.println("Car default constructor called");
        }
        
        public Car(String brand, String model, int year, String engineType, 
                   int doors, String fuel, String transmission) {
            super(brand, model, year, engineType);
            this.numberOfDoors = doors;
            this.fuelType = fuel;
            this.transmissionType = transmission;
            System.out.println("Car parameterized constructor called");
        }
        
        @Override
        public void start() {
            System.out.println("Car starting sequence initiated...");
            super.start();
            System.out.println("Car engine running smoothly");
        }
        
        @Override
        public void displaySpecs() {
            System.out.println("=== Car Specifications ===");
            System.out.println(getVehicleInfo());
            System.out.println("Doors: " + numberOfDoors + ", Fuel: " + fuelType + 
                             ", Transmission: " + transmissionType);
            System.out.println("Status: " + (isRunning() ? "Running" : "Stopped"));
        }
        
        public void openTrunk() {
            System.out.println("Trunk opened");
        }
        
        public void playRadio() {
            System.out.println("Radio playing music");
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Testing Constructor Chaining ===");
        
        // Test default constructor chaining
        System.out.println("\n1. Creating Car with default constructor:");
        Car defaultCar = new Car();
        
        // Test parameterized constructor chaining
        System.out.println("\n2. Creating Car with parameterized constructor:");
        Car customCar = new Car("Toyota", "Camry", 2023, "Hybrid", 4, "Hybrid", "Automatic");
        
        System.out.println("\n=== Testing Inheritance ===");
        
        // Test inherited fields access
        System.out.println("\n3. Accessing inherited fields:");
        System.out.println("Default car brand: " + defaultCar.brand);
        System.out.println("Custom car model: " + customCar.model);
        
        // Test inherited methods
        System.out.println("\n4. Testing inherited methods:");
        defaultCar.start();
        defaultCar.stop();
        
        // Test overridden methods
        System.out.println("\n5. Testing overridden methods:");
        customCar.start();
        customCar.displaySpecs();
        
        // Test car-specific methods
        System.out.println("\n6. Testing car-specific methods:");
        customCar.openTrunk();
        customCar.playRadio();
        
        // Test polymorphism
        System.out.println("\n7. Testing polymorphism:");
        Vehicle vehicle = new Car("Honda", "Civic", 2022, "Gasoline", 2, "Gasoline", "Manual");
        vehicle.start(); // Calls overridden Car.start()
        vehicle.displaySpecs(); // Calls overridden Car.displaySpecs()
    }
}