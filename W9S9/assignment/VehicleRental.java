/*
Problem 1: Object Modeling & toString()
Problem: "Vehicle Rental System"
*/

class Vehicle {
    private String registrationNo;
    private String type;
    private double ratePerDay;
    
    // TODO: Create constructor initializing all fields
    public Vehicle(String registrationNo, String type, double ratePerDay) {
        this.registrationNo = registrationNo;
        this.type = type;
        this.ratePerDay = ratePerDay;
    }
    
    // TODO: Override toString() to print: "Vehicle: [registrationNo], Type: [type], Rate: $[ratePerDay]/day"
    @Override
    public String toString() {
        return "Vehicle: " + registrationNo + ", Type: " + type + ", Rate: $" + ratePerDay + "/day";
    }
    
    // TODO: Create getters for all fields
    public String getRegistrationNo() {
        return registrationNo;
    }
    
    public String getType() {
        return type;
    }
    
    public double getRatePerDay() {
        return ratePerDay;
    }
}

public class VehicleRental {
    public static void main(String[] args) {
        // 1. Create Vehicle("MH12AB1234", "Sedan", 1500)
        Vehicle vehicle1 = new Vehicle("MH12AB1234", "Sedan", 1500);
        
        // 2. Print the Vehicle object and observe output
        System.out.println(vehicle1);
        
        // 3. Create another vehicle and compare
        Vehicle vehicle2 = new Vehicle("KA05CD5678", "SUV", 2000);
        System.out.println(vehicle2);
        
        System.out.println("\n=== Vehicle Details ===");
        System.out.println("Vehicle 1 Registration: " + vehicle1.getRegistrationNo());
        System.out.println("Vehicle 1 Type: " + vehicle1.getType());
        System.out.println("Vehicle 1 Rate: $" + vehicle1.getRatePerDay());
        
        System.out.println("\nVehicle 2 Registration: " + vehicle2.getRegistrationNo());
        System.out.println("Vehicle 2 Type: " + vehicle2.getType());
        System.out.println("Vehicle 2 Rate: $" + vehicle2.getRatePerDay());
    }
}