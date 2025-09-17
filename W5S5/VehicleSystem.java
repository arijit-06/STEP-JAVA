// Base Vehicle class
class Vehicle {
    protected String make;
    protected String model;
    protected int year;
    protected double weight;
    
    public Vehicle(String make, String model, int year, double weight) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.weight = weight;
    }
    
    public void startEngine() {
        System.out.println(make + " " + model + " engine started");
    }
    
    public String getMake() { return make; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public double getWeight() { return weight; }
    
    @Override
    public String toString() {
        return year + " " + make + " " + model;
    }
}

// Derived classes
class Car extends Vehicle {
    private int doors;
    private String fuelType;
    
    public Car(String make, String model, int year, double weight, int doors, String fuelType) {
        super(make, model, year, weight);
        this.doors = doors;
        this.fuelType = fuelType;
    }
    
    public int getDoors() { return doors; }
    public String getFuelType() { return fuelType; }
    
    @Override
    public void startEngine() {
        System.out.println("Car " + make + " " + model + " engine started with " + fuelType);
    }
}

class Motorcycle extends Vehicle {
    private boolean hasSidecar;
    private int engineCC;
    
    public Motorcycle(String make, String model, int year, double weight, boolean hasSidecar, int engineCC) {
        super(make, model, year, weight);
        this.hasSidecar = hasSidecar;
        this.engineCC = engineCC;
    }
    
    public boolean hasSidecar() { return hasSidecar; }
    public int getEngineCC() { return engineCC; }
    
    @Override
    public void startEngine() {
        System.out.println("Motorcycle " + make + " " + model + " (" + engineCC + "cc) engine started");
    }
}

class Truck extends Vehicle {
    private double cargoCapacity;
    private int axles;
    
    public Truck(String make, String model, int year, double weight, double cargoCapacity, int axles) {
        super(make, model, year, weight);
        this.cargoCapacity = cargoCapacity;
        this.axles = axles;
    }
    
    public double getCargoCapacity() { return cargoCapacity; }
    public int getAxles() { return axles; }
    
    @Override
    public void startEngine() {
        System.out.println("Truck " + make + " " + model + " (capacity: " + cargoCapacity + " tons) engine started");
    }
}

class Bicycle extends Vehicle {
    private int gears;
    private String bikeType;
    
    public Bicycle(String make, String model, int year, double weight, int gears, String bikeType) {
        super(make, model, year, weight);
        this.gears = gears;
        this.bikeType = bikeType;
    }
    
    public int getGears() { return gears; }
    public String getBikeType() { return bikeType; }
    
    @Override
    public void startEngine() {
        System.out.println("Bicycle " + make + " " + model + " - no engine, pedal power!");
    }
}

// VehicleManager class demonstrating instanceof usage
class VehicleManager {
    
    // Method using instanceof for different processing based on type
    public static void processVehicle(Vehicle vehicle) {
        System.out.println("\n=== Processing Vehicle ===");
        System.out.println("Vehicle: " + vehicle);
        
        if (vehicle instanceof Car) {
            Car car = (Car) vehicle; // Safe casting after instanceof check
            System.out.println("Processing car with " + car.getDoors() + " doors");
            System.out.println("Fuel type: " + car.getFuelType());
            System.out.println("Recommended service: Oil change and tire rotation");
            
        } else if (vehicle instanceof Motorcycle) {
            Motorcycle motorcycle = (Motorcycle) vehicle; // Safe casting
            System.out.println("Processing motorcycle with " + motorcycle.getEngineCC() + "cc engine");
            System.out.println("Has sidecar: " + motorcycle.hasSidecar());
            System.out.println("Recommended service: Chain lubrication and brake check");
            
        } else if (vehicle instanceof Truck) {
            Truck truck = (Truck) vehicle; // Safe casting
            System.out.println("Processing truck with " + truck.getCargoCapacity() + " ton capacity");
            System.out.println("Number of axles: " + truck.getAxles());
            System.out.println("Recommended service: Heavy-duty maintenance and cargo inspection");
            
        } else if (vehicle instanceof Bicycle) {
            Bicycle bicycle = (Bicycle) vehicle; // Safe casting
            System.out.println("Processing bicycle with " + bicycle.getGears() + " gears");
            System.out.println("Bike type: " + bicycle.getBikeType());
            System.out.println("Recommended service: Chain cleaning and tire pressure check");
            
        } else {
            System.out.println("Unknown vehicle type - basic processing only");
        }
    }
    
    // Method using instanceof for toll calculation
    public static double calculateToll(Vehicle vehicle) {
        double baseToll = 2.0;
        
        if (vehicle instanceof Bicycle) {
            return 0.0; // Bicycles are free
        } else if (vehicle instanceof Motorcycle) {
            return baseToll * 0.5; // 50% discount for motorcycles
        } else if (vehicle instanceof Car) {
            return baseToll; // Standard rate for cars
        } else if (vehicle instanceof Truck) {
            Truck truck = (Truck) vehicle;
            return baseToll * (1 + truck.getAxles()); // More axles = higher toll
        }
        
        return baseToll; // Default rate
    }
    
    // Method using instanceof for maintenance scheduling
    public static String performMaintenance(Vehicle vehicle) {
        String maintenanceType = "Basic maintenance";
        
        if (vehicle instanceof Car) {
            Car car = (Car) vehicle;
            if (car.getFuelType().equals("Electric")) {
                maintenanceType = "Electric vehicle service - battery check, software update";
            } else {
                maintenanceType = "Standard car service - oil, filters, brakes";
            }
        } else if (vehicle instanceof Motorcycle) {
            Motorcycle motorcycle = (Motorcycle) vehicle;
            if (motorcycle.getEngineCC() > 600) {
                maintenanceType = "High-performance motorcycle service";
            } else {
                maintenanceType = "Standard motorcycle service";
            }
        } else if (vehicle instanceof Truck) {
            maintenanceType = "Commercial vehicle inspection and service";
        } else if (vehicle instanceof Bicycle) {
            maintenanceType = "Bicycle tune-up and safety check";
        }
        
        return maintenanceType;
    }
    
    // Method to count vehicles by type using instanceof
    public static void analyzeVehicleFleet(Vehicle[] vehicles) {
        int carCount = 0, motorcycleCount = 0, truckCount = 0, bicycleCount = 0;
        double totalTolls = 0;
        
        System.out.println("\n=== Fleet Analysis ===");
        
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Car) {
                carCount++;
            } else if (vehicle instanceof Motorcycle) {
                motorcycleCount++;
            } else if (vehicle instanceof Truck) {
                truckCount++;
            } else if (vehicle instanceof Bicycle) {
                bicycleCount++;
            }
            
            totalTolls += calculateToll(vehicle);
        }
        
        System.out.println("Fleet composition:");
        System.out.println("  Cars: " + carCount);
        System.out.println("  Motorcycles: " + motorcycleCount);
        System.out.println("  Trucks: " + truckCount);
        System.out.println("  Bicycles: " + bicycleCount);
        System.out.println("  Total vehicles: " + vehicles.length);
        System.out.println("  Total toll revenue: $" + String.format("%.2f", totalTolls));
    }
    
    // Method demonstrating instanceof with inheritance hierarchy
    public static void checkVehicleHierarchy(Object obj) {
        System.out.println("\n=== Type Checking for: " + obj.getClass().getSimpleName() + " ===");
        
        // Check from most specific to most general
        if (obj instanceof Car) {
            System.out.println("✓ This is a Car");
        }
        if (obj instanceof Motorcycle) {
            System.out.println("✓ This is a Motorcycle");
        }
        if (obj instanceof Truck) {
            System.out.println("✓ This is a Truck");
        }
        if (obj instanceof Bicycle) {
            System.out.println("✓ This is a Bicycle");
        }
        if (obj instanceof Vehicle) {
            System.out.println("✓ This is a Vehicle");
        }
        if (obj instanceof Object) {
            System.out.println("✓ This is an Object");
        }
        
        // Demonstrate what happens with non-Vehicle objects
        if (!(obj instanceof Vehicle)) {
            System.out.println("✗ This is NOT a Vehicle");
        }
    }
}

public class VehicleSystem {
    public static void main(String[] args) {
        System.out.println("=== Vehicle instanceof Demo ===");
        
        // Create different types of vehicles
        Vehicle[] vehicles = {
            new Car("Toyota", "Camry", 2022, 1500, 4, "Gasoline"),
            new Car("Tesla", "Model 3", 2023, 1600, 4, "Electric"),
            new Motorcycle("Harley-Davidson", "Street 750", 2021, 250, false, 750),
            new Motorcycle("Honda", "Gold Wing", 2022, 380, true, 1833),
            new Truck("Ford", "F-150", 2023, 2500, 1.5, 2),
            new Truck("Peterbilt", "579", 2022, 8000, 40, 5),
            new Bicycle("Trek", "Mountain Bike", 2023, 15, 21, "Mountain"),
            new Bicycle("Schwinn", "Road Bike", 2022, 12, 16, "Road")
        };
        
        // Process each vehicle using instanceof
        for (Vehicle vehicle : vehicles) {
            VehicleManager.processVehicle(vehicle);
            System.out.println("Toll: $" + String.format("%.2f", VehicleManager.calculateToll(vehicle)));
            System.out.println("Maintenance: " + VehicleManager.performMaintenance(vehicle));
        }
        
        // Analyze the entire fleet
        VehicleManager.analyzeVehicleFleet(vehicles);
        
        // Demonstrate type hierarchy checking
        VehicleManager.checkVehicleHierarchy(vehicles[0]); // Car
        VehicleManager.checkVehicleHierarchy(vehicles[2]); // Motorcycle
        VehicleManager.checkVehicleHierarchy("Not a vehicle"); // String object
        
        // Demonstrate safe casting with instanceof
        System.out.println("\n=== Safe Casting Demo ===");
        Vehicle mysteryVehicle = vehicles[1]; // Tesla Model 3 (Car)
        
        if (mysteryVehicle instanceof Car) {
            Car car = (Car) mysteryVehicle;
            System.out.println("Successfully cast to Car: " + car.getFuelType() + " powered");
        }
        
        // This would be false, so no casting occurs
        if (mysteryVehicle instanceof Motorcycle) {
            Motorcycle motorcycle = (Motorcycle) mysteryVehicle;
            System.out.println("This won't execute - not a motorcycle");
        } else {
            System.out.println("Mystery vehicle is not a motorcycle - safe from ClassCastException");
        }
    }
}