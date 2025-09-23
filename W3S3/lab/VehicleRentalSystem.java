class Vehicle {
    private String vehicleId;
    private String brand;
    private String model;
    private double rentPerDay;
    private boolean isAvailable;
    
    private static int totalVehicles = 0;
    private static double totalRevenue = 0;
    private static String companyName;
    private static int rentalDays = 0;
    
    public Vehicle(String brand, String model, double rentPerDay) {
        this.vehicleId = generateVehicleId();
        this.brand = brand;
        this.model = model;
        this.rentPerDay = rentPerDay;
        this.isAvailable = true;
        totalVehicles++;
    }
    
    private static String generateVehicleId() {
        return "V" + String.format("%03d", totalVehicles + 1);
    }
    
    public static void setCompanyName(String name) {
        companyName = name;
    }
    
    public static double getTotalRevenue() {
        return totalRevenue;
    }
    
    public static double getAverageRentPerDay() {
        return rentalDays > 0 ? totalRevenue / rentalDays : 0;
    }
    
    public static void displayCompanyStats() {
        System.out.println("=== " + companyName + " Statistics ===");
        System.out.println("Total Vehicles: " + totalVehicles);
        System.out.println("Total Revenue: $" + totalRevenue);
        System.out.println("Total Rental Days: " + rentalDays);
        System.out.println("Average Revenue per Day: $" + getAverageRentPerDay());
    }
    
    public double rentVehicle(int days) {
        if (isAvailable && days > 0) {
            isAvailable = false;
            double amount = calculateRent(days);
            System.out.println("Rented " + brand + " " + model + " for " + days + " days - $" + amount);
            return amount;
        } else if (!isAvailable) {
            System.out.println("Vehicle not available: " + brand + " " + model);
            return 0;
        } else {
            System.out.println("Invalid rental days");
            return 0;
        }
    }
    
    public void returnVehicle() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println("Returned: " + brand + " " + model);
        } else {
            System.out.println("Vehicle was not rented: " + brand + " " + model);
        }
    }
    
    public double calculateRent(int days) {
        double amount = rentPerDay * days;
        totalRevenue += amount;
        rentalDays += days;
        return amount;
    }
    
    public void displayVehicleInfo() {
        System.out.println(vehicleId + ": " + brand + " " + model + " - $" + rentPerDay + "/day - " + 
                          (isAvailable ? "Available" : "Rented"));
    }
    
    public String getVehicleId() { return vehicleId; }
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public boolean isAvailable() { return isAvailable; }
    public double getRentPerDay() { return rentPerDay; }
    public static int getTotalVehicles() { return totalVehicles; }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
        Vehicle.setCompanyName("Premium Car Rentals");
        
        Vehicle[] vehicles = {
            new Vehicle("Toyota", "Camry", 50.0),
            new Vehicle("Honda", "Civic", 45.0),
            new Vehicle("BMW", "X5", 120.0),
            new Vehicle("Mercedes", "C-Class", 100.0),
            new Vehicle("Ford", "Mustang", 80.0)
        };
        
        System.out.println("=== Vehicle Rental System ===");
        Vehicle.displayCompanyStats();
        
        System.out.println("\n=== Available Vehicles ===");
        for (Vehicle v : vehicles) {
            v.displayVehicleInfo();
        }
        
        System.out.println("\n=== Rental Operations ===");
        vehicles[0].rentVehicle(3); // Toyota Camry for 3 days
        vehicles[1].rentVehicle(5); // Honda Civic for 5 days
        vehicles[2].rentVehicle(2); // BMW X5 for 2 days
        vehicles[0].rentVehicle(1); // Try to rent already rented Toyota (should fail)
        
        System.out.println("\n=== Updated Vehicle Status ===");
        for (Vehicle v : vehicles) {
            v.displayVehicleInfo();
        }
        
        System.out.println("\n=== Company Statistics After Rentals ===");
        Vehicle.displayCompanyStats();
        
        System.out.println("\n=== Return Operations ===");
        vehicles[0].returnVehicle(); // Return Toyota Camry
        vehicles[1].returnVehicle(); // Return Honda Civic
        
        System.out.println("\n=== Final Vehicle Status ===");
        for (Vehicle v : vehicles) {
            v.displayVehicleInfo();
        }
        
        System.out.println("\n=== Final Company Statistics ===");
        Vehicle.displayCompanyStats();
        
        System.out.println("\n=== Static vs Instance Members Demonstration ===");
        System.out.println("Static Members (Shared across all vehicles):");
        System.out.println("  - Company Name: " + "Premium Car Rentals");
        System.out.println("  - Total Vehicles: " + Vehicle.getTotalVehicles());
        System.out.println("  - Total Revenue: $" + Vehicle.getTotalRevenue());
        
        System.out.println("\nInstance Members (Unique to each vehicle):");
        for (Vehicle v : vehicles) {
            System.out.println("  - " + v.getVehicleId() + ": " + v.getBrand() + " " + v.getModel() + 
                             " ($" + v.getRentPerDay() + "/day, " + 
                             (v.isAvailable() ? "Available" : "Rented") + ")");
        }
        
        System.out.println("\n=== Benefits Demonstrated ===");
        System.out.println("✓ Static variables track company-wide data");
        System.out.println("✓ Instance variables maintain individual vehicle states");
        System.out.println("✓ Static methods provide company-level operations");
        System.out.println("✓ Instance methods handle vehicle-specific operations");
    }
}