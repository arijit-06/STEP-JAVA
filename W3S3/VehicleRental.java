public class VehicleRental {
    private String vehicleId;
    private String brand;
    private String model;
    private double rentPerDay;
    private boolean isAvailable;
    private static int totalVehicles = 0;
    private static double totalRevenue = 0;
    private static String companyName = "RentACar";
    private static int rentalDays = 0;
    private static int vehicleCounter = 0;

    public VehicleRental(String brand, String model, double rentPerDay) {
        this.vehicleId = generateVehicleId();
        this.brand = brand;
        this.model = model;
        this.rentPerDay = rentPerDay;
        this.isAvailable = true;
        totalVehicles++;
    }

    public double rentVehicle(int days) {
        if (isAvailable) {
            isAvailable = false;
            double rent = calculateRent(days);
            rentalDays += days;
            System.out.println("Vehicle rented for " + days + " days. Total: $" + rent);
            return rent;
        } else {
            System.out.println("Vehicle not available");
            return 0;
        }
    }

    public void returnVehicle() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println("Vehicle returned: " + brand + " " + model);
        }
    }

    public double calculateRent(int days) {
        double rent = rentPerDay * days;
        totalRevenue += rent;
        return rent;
    }

    public void displayVehicleInfo() {
        System.out.println("ID: " + vehicleId + ", Brand: " + brand + ", Model: " + model + 
                          ", Rent/Day: $" + rentPerDay + ", Available: " + isAvailable);
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
        System.out.println("=== " + companyName + " STATS ===");
        System.out.println("Total Vehicles: " + totalVehicles);
        System.out.println("Total Revenue: $" + totalRevenue);
        System.out.println("Total Rental Days: " + rentalDays);
        System.out.println("Average Rent/Day: $" + getAverageRentPerDay());
    }

    private static String generateVehicleId() {
        vehicleCounter++;
        return "V" + String.format("%03d", vehicleCounter);
    }

    public static void main(String[] args) {
        setCompanyName("Premium Car Rentals");

        VehicleRental[] vehicles = {
            new VehicleRental("Toyota", "Camry", 50),
            new VehicleRental("Honda", "Civic", 45),
            new VehicleRental("BMW", "X5", 100)
        };

        for (VehicleRental v : vehicles) {
            v.displayVehicleInfo();
        }

        vehicles[0].rentVehicle(3);
        vehicles[1].rentVehicle(5);
        vehicles[2].rentVehicle(2);

        displayCompanyStats();

        vehicles[0].returnVehicle();
        vehicles[1].returnVehicle();

        System.out.println("Total Revenue (static): $" + getTotalRevenue());
    }
}