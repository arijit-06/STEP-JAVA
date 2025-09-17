public class Vehicle {
    protected String brand;
    protected String model;
    protected int year;
    protected String engineType;
    private String registrationNumber;
    private boolean isRunning;

    public Vehicle() {
        this.brand = "Unknown";
        this.model = "Unknown";
        this.year = 2020;
        this.engineType = "Petrol";
        this.registrationNumber = "REG" + (int)(Math.random() * 1000);
        this.isRunning = false;
        System.out.println("Vehicle default constructor called");
    }

    public Vehicle(String brand, String model, int year, String engineType) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.engineType = engineType;
        this.registrationNumber = "REG" + (int)(Math.random() * 1000);
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
        return "Brand: " + brand + ", Model: " + model + ", Year: " + year + ", Engine: " + engineType;
    }

    public void displaySpecs() {
        System.out.println("Vehicle Specifications:");
        System.out.println(getVehicleInfo());
    }

    public String getRegistrationNumber() { return registrationNumber; }
    public void setRegistrationNumber(String registrationNumber) { this.registrationNumber = registrationNumber; }
    public boolean isRunning() { return isRunning; }
}

class Car extends Vehicle {
    private int numberOfDoors;
    private String fuelType;
    private String transmissionType;

    public Car() {
        super();
        this.numberOfDoors = 4;
        this.fuelType = "Petrol";
        this.transmissionType = "Manual";
        System.out.println("Car default constructor called");
    }

    public Car(String brand, String model, int year, String engineType, int numberOfDoors, String fuelType, String transmissionType) {
        super(brand, model, year, engineType);
        this.numberOfDoors = numberOfDoors;
        this.fuelType = fuelType;
        this.transmissionType = transmissionType;
        System.out.println("Car parameterized constructor called");
    }

    @Override
    public void start() {
        super.start();
        System.out.println("Car engine ignition sequence completed");
    }

    @Override
    public void displaySpecs() {
        super.displaySpecs();
        System.out.println("Car Specifications:");
        System.out.println("Doors: " + numberOfDoors + ", Fuel: " + fuelType + ", Transmission: " + transmissionType);
    }

    public void openTrunk() {
        System.out.println("Trunk opened");
    }

    public void playRadio() {
        System.out.println("Radio playing music");
    }

    public static void main(String[] args) {
        System.out.println("=== Testing Default Constructor ===");
        Car car1 = new Car();
        
        System.out.println("\n=== Testing Parameterized Constructor ===");
        Car car2 = new Car("Toyota", "Camry", 2023, "Hybrid", 4, "Hybrid", "Automatic");
        
        System.out.println("\n=== Testing Inherited Methods ===");
        car2.start();
        car2.displaySpecs();
        car2.openTrunk();
        car2.playRadio();
        car2.stop();
        
        System.out.println("\n=== Testing Protected Field Access ===");
        System.out.println("Car brand: " + car2.brand);
        System.out.println("Car model: " + car2.model);
    }
}