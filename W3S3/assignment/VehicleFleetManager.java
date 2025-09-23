class Vehicle {
    protected String vehicleId;
    protected String brand;
    protected String model;
    protected int year;
    protected double mileage;
    protected String fuelType;
    protected String currentStatus;
    protected double purchasePrice;
    
    private static int totalVehicles = 0;
    private static double fleetValue = 0;
    private static String companyName = "Fleet Management Corp";
    private static double totalFuelConsumption = 0;
    
    public Vehicle(String brand, String model, int year, String fuelType, double purchasePrice) {
        this.vehicleId = generateVehicleId();
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.fuelType = fuelType;
        this.purchasePrice = purchasePrice;
        this.mileage = 0;
        this.currentStatus = "Available";
        totalVehicles++;
        fleetValue += purchasePrice;
    }
    
    private static String generateVehicleId() {
        return "VH" + String.format("%03d", totalVehicles + 1);
    }
    
    public void assignDriver(Driver driver) {
        if (currentStatus.equals("Available")) {
            currentStatus = "Assigned";
            driver.assignVehicle(this);
            System.out.println("Vehicle " + vehicleId + " assigned to " + driver.getDriverName());
        } else {
            System.out.println("Vehicle not available for assignment");
        }
    }
    
    public void scheduleMaintenance(String maintenanceType, double cost) {
        currentStatus = "Under Maintenance";
        System.out.println("Maintenance scheduled for " + vehicleId + ": " + maintenanceType + " ($" + cost + ")");
    }
    
    public double calculateRunningCost() {
        double fuelCost = mileage * 0.15; // $0.15 per mile for fuel
        double maintenanceCost = mileage * 0.05; // $0.05 per mile for maintenance
        return fuelCost + maintenanceCost;
    }
    
    public void updateMileage(double miles) {
        this.mileage += miles;
        double fuelUsed = miles / getFuelEfficiency();
        totalFuelConsumption += fuelUsed;
        System.out.println("Updated mileage for " + vehicleId + ": +" + miles + " miles (Total: " + mileage + ")");
    }
    
    protected double getFuelEfficiency() {
        return 25.0; // Default 25 MPG
    }
    
    public boolean checkServiceDue() {
        return mileage > 5000; // Service due every 5000 miles
    }
    
    public void displayVehicleInfo() {
        System.out.println(vehicleId + ": " + year + " " + brand + " " + model + 
                          " (" + fuelType + ") - " + currentStatus + 
                          " | Mileage: " + mileage + " | Value: $" + purchasePrice);
    }
    
    public static double getFleetUtilization(Vehicle[] vehicles) {
        int assigned = 0;
        for (Vehicle v : vehicles) {
            if (v != null && v.currentStatus.equals("Assigned")) {
                assigned++;
            }
        }
        return totalVehicles > 0 ? (double) assigned / totalVehicles * 100 : 0;
    }
    
    public static double calculateTotalMaintenanceCost(Vehicle[] vehicles) {
        double total = 0;
        for (Vehicle v : vehicles) {
            if (v != null) {
                total += v.mileage * 0.05; // Maintenance cost calculation
            }
        }
        return total;
    }
    
    public static Vehicle[] getVehiclesByType(Vehicle[] vehicles, String type) {
        Vehicle[] result = new Vehicle[vehicles.length];
        int count = 0;
        for (Vehicle v : vehicles) {
            if (v != null && v.getClass().getSimpleName().equals(type)) {
                result[count++] = v;
            }
        }
        return result;
    }
    
    public String getVehicleId() { return vehicleId; }
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public String getCurrentStatus() { return currentStatus; }
    public void setCurrentStatus(String status) { this.currentStatus = status; }
    public double getMileage() { return mileage; }
    public static int getTotalVehicles() { return totalVehicles; }
    public static double getFleetValue() { return fleetValue; }
    public static double getTotalFuelConsumption() { return totalFuelConsumption; }
}

class Car extends Vehicle {
    private int seatingCapacity;
    private boolean hasAirConditioning;
    
    public Car(String brand, String model, int year, String fuelType, double purchasePrice, int seatingCapacity) {
        super(brand, model, year, fuelType, purchasePrice);
        this.seatingCapacity = seatingCapacity;
        this.hasAirConditioning = true;
    }
    
    @Override
    protected double getFuelEfficiency() {
        return 30.0; // Cars are more fuel efficient
    }
    
    @Override
    public void displayVehicleInfo() {
        super.displayVehicleInfo();
        System.out.println("  Car Details: " + seatingCapacity + " seats, AC: " + hasAirConditioning);
    }
}

class Bus extends Vehicle {
    private int seatingCapacity;
    private String routeAssigned;
    
    public Bus(String brand, String model, int year, String fuelType, double purchasePrice, int seatingCapacity) {
        super(brand, model, year, fuelType, purchasePrice);
        this.seatingCapacity = seatingCapacity;
    }
    
    @Override
    protected double getFuelEfficiency() {
        return 8.0; // Buses are less fuel efficient
    }
    
    public void assignRoute(String route) {
        this.routeAssigned = route;
        System.out.println("Bus " + vehicleId + " assigned to route: " + route);
    }
    
    @Override
    public void displayVehicleInfo() {
        super.displayVehicleInfo();
        System.out.println("  Bus Details: " + seatingCapacity + " seats, Route: " + 
                          (routeAssigned != null ? routeAssigned : "Not assigned"));
    }
}

class Truck extends Vehicle {
    private double loadCapacity;
    private boolean hasTrailer;
    
    public Truck(String brand, String model, int year, String fuelType, double purchasePrice, double loadCapacity) {
        super(brand, model, year, fuelType, purchasePrice);
        this.loadCapacity = loadCapacity;
        this.hasTrailer = false;
    }
    
    @Override
    protected double getFuelEfficiency() {
        return 12.0; // Trucks have moderate fuel efficiency
    }
    
    public void attachTrailer() {
        this.hasTrailer = true;
        System.out.println("Trailer attached to truck " + vehicleId);
    }
    
    @Override
    public void displayVehicleInfo() {
        super.displayVehicleInfo();
        System.out.println("  Truck Details: " + loadCapacity + " tons capacity, Trailer: " + hasTrailer);
    }
}

class Driver {
    private String driverId;
    private String driverName;
    private String licenseType;
    private Vehicle assignedVehicle;
    private int totalTrips;
    private static int totalDrivers = 0;
    
    public Driver(String driverName, String licenseType) {
        this.driverId = generateDriverId();
        this.driverName = driverName;
        this.licenseType = licenseType;
        this.totalTrips = 0;
        totalDrivers++;
    }
    
    private static String generateDriverId() {
        return "DR" + String.format("%03d", totalDrivers + 1);
    }
    
    public void assignVehicle(Vehicle vehicle) {
        this.assignedVehicle = vehicle;
    }
    
    public void completeTrip(double miles) {
        if (assignedVehicle != null) {
            assignedVehicle.updateMileage(miles);
            totalTrips++;
            System.out.println("Trip completed by " + driverName + ": " + miles + " miles");
        } else {
            System.out.println("No vehicle assigned to driver");
        }
    }
    
    public void displayDriverInfo() {
        System.out.println("Driver: " + driverName + " (" + driverId + ") - License: " + licenseType);
        System.out.println("Assigned Vehicle: " + (assignedVehicle != null ? assignedVehicle.getVehicleId() : "None"));
        System.out.println("Total Trips: " + totalTrips);
    }
    
    public String getDriverName() { return driverName; }
    public String getLicenseType() { return licenseType; }
    public Vehicle getAssignedVehicle() { return assignedVehicle; }
    public static int getTotalDrivers() { return totalDrivers; }
}

public class VehicleFleetManager {
    public static void main(String[] args) {
        // Create fleet of vehicles
        Vehicle[] vehicles = {
            new Car("Toyota", "Camry", 2022, "Gasoline", 25000, 5),
            new Car("Honda", "Civic", 2021, "Gasoline", 22000, 5),
            new Car("Tesla", "Model 3", 2023, "Electric", 35000, 5),
            new Bus("Mercedes", "Sprinter", 2020, "Diesel", 80000, 25),
            new Bus("Volvo", "9700", 2019, "Diesel", 120000, 45),
            new Truck("Ford", "F-150", 2021, "Gasoline", 35000, 2.5),
            new Truck("Freightliner", "Cascadia", 2020, "Diesel", 150000, 40.0),
            new Car("BMW", "X5", 2022, "Gasoline", 55000, 7)
        };
        
        // Create drivers
        Driver[] drivers = {
            new Driver("John Smith", "Class A"),
            new Driver("Jane Doe", "Class B"),
            new Driver("Bob Johnson", "Class C"),
            new Driver("Alice Brown", "Class A"),
            new Driver("Charlie Wilson", "Class B"),
            new Driver("Diana Davis", "Class C")
        };
        
        System.out.println("=== Vehicle Fleet Management System ===");
        System.out.println("Total Vehicles: " + Vehicle.getTotalVehicles());
        System.out.println("Total Drivers: " + Driver.getTotalDrivers());
        System.out.println("Fleet Value: $" + Vehicle.getFleetValue());
        
        System.out.println("\n=== Fleet Inventory ===");
        for (Vehicle vehicle : vehicles) {
            vehicle.displayVehicleInfo();
        }
        
        System.out.println("\n=== Driver Information ===");
        for (Driver driver : drivers) {
            driver.displayDriverInfo();
        }
        
        System.out.println("\n=== Vehicle Assignment ===");
        vehicles[0].assignDriver(drivers[0]); // Car to John
        vehicles[1].assignDriver(drivers[1]); // Car to Jane
        vehicles[3].assignDriver(drivers[2]); // Bus to Bob
        vehicles[5].assignDriver(drivers[3]); // Truck to Alice
        vehicles[6].assignDriver(drivers[4]); // Truck to Charlie
        
        // Special assignments
        if (vehicles[3] instanceof Bus) {
            ((Bus) vehicles[3]).assignRoute("Downtown-Airport");
        }
        if (vehicles[6] instanceof Truck) {
            ((Truck) vehicles[6]).attachTrailer();
        }
        
        System.out.println("\n=== Trip Operations ===");
        drivers[0].completeTrip(150); // John's trip
        drivers[1].completeTrip(200); // Jane's trip
        drivers[2].completeTrip(300); // Bob's bus trip
        drivers[3].completeTrip(500); // Alice's truck trip
        drivers[4].completeTrip(800); // Charlie's long haul
        
        // Additional trips
        drivers[0].completeTrip(100);
        drivers[2].completeTrip(250);
        
        System.out.println("\n=== Maintenance Scheduling ===");
        vehicles[0].scheduleMaintenance("Oil Change", 50);
        vehicles[3].scheduleMaintenance("Brake Service", 200);
        vehicles[6].scheduleMaintenance("Engine Overhaul", 1500);
        
        System.out.println("\n=== Service Due Check ===");
        for (Vehicle vehicle : vehicles) {
            if (vehicle.checkServiceDue()) {
                System.out.println("Service due for " + vehicle.getVehicleId() + 
                                 " (" + vehicle.getMileage() + " miles)");
            }
        }
        
        System.out.println("\n=== Updated Fleet Status ===");
        for (Vehicle vehicle : vehicles) {
            vehicle.displayVehicleInfo();
        }
        
        System.out.println("\n=== Fleet Analytics ===");
        System.out.println("Fleet Utilization: " + Vehicle.getFleetUtilization(vehicles) + "%");
        System.out.println("Total Maintenance Cost: $" + Vehicle.calculateTotalMaintenanceCost(vehicles));
        System.out.println("Total Fuel Consumption: " + Vehicle.getTotalFuelConsumption() + " gallons");
        
        System.out.println("\n=== Vehicle Type Analysis ===");
        Vehicle[] cars = Vehicle.getVehiclesByType(vehicles, "Car");
        Vehicle[] buses = Vehicle.getVehiclesByType(vehicles, "Bus");
        Vehicle[] trucks = Vehicle.getVehiclesByType(vehicles, "Truck");
        
        int carCount = 0, busCount = 0, truckCount = 0;
        double carMiles = 0, busMiles = 0, truckMiles = 0;
        
        for (Vehicle v : cars) {
            if (v != null) {
                carCount++;
                carMiles += v.getMileage();
            }
        }
        for (Vehicle v : buses) {
            if (v != null) {
                busCount++;
                busMiles += v.getMileage();
            }
        }
        for (Vehicle v : trucks) {
            if (v != null) {
                truckCount++;
                truckMiles += v.getMileage();
            }
        }
        
        System.out.println("Cars: " + carCount + " vehicles, " + carMiles + " total miles");
        System.out.println("Buses: " + busCount + " vehicles, " + busMiles + " total miles");
        System.out.println("Trucks: " + truckCount + " vehicles, " + truckMiles + " total miles");
        
        System.out.println("\n=== Driver Performance ===");
        for (Driver driver : drivers) {
            driver.displayDriverInfo();
            if (driver.getAssignedVehicle() != null) {
                System.out.println("  Running Cost: $" + driver.getAssignedVehicle().calculateRunningCost());
            }
            System.out.println();
        }
        
        System.out.println("=== Cost Analysis ===");
        double totalRunningCost = 0;
        for (Vehicle vehicle : vehicles) {
            totalRunningCost += vehicle.calculateRunningCost();
        }
        
        System.out.println("Total Fleet Running Cost: $" + totalRunningCost);
        System.out.println("Average Cost per Vehicle: $" + (totalRunningCost / vehicles.length));
        System.out.println("Cost per Mile (Fleet Average): $" + (totalRunningCost / (Vehicle.getTotalVehicles() * 100))); // Simplified
        
        System.out.println("\n=== Fleet Management Features Demonstrated ===");
        System.out.println("✓ Multiple vehicle types with inheritance");
        System.out.println("✓ Driver assignment and trip management");
        System.out.println("✓ Maintenance scheduling and tracking");
        System.out.println("✓ Fuel consumption monitoring");
        System.out.println("✓ Fleet utilization and cost analysis");
        System.out.println("✓ Vehicle-specific operations (routes, trailers)");
    }
}