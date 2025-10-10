/*
Practice Problem 1: Object Modeling & toString()
Problem: "Vehicle Rental System"
*/

class Vehicle {
    private String registrationNo;
    private String type;
    private double ratePerDay;
    
    public Vehicle(String registrationNo, String type, double ratePerDay) {
        this.registrationNo = registrationNo;
        this.type = type;
        this.ratePerDay = ratePerDay;
    }
    
    @Override
    public String toString() {
        return "Vehicle: " + registrationNo + ", Type: " + type + ", Rate: $" + ratePerDay + "/day";
    }
    
    public String getRegistrationNo() { return registrationNo; }
    public String getType() { return type; }
    public double getRatePerDay() { return ratePerDay; }
}

public class VehicleRental {
    public static void main(String[] args) {
        System.out.println("=== Vehicle Rental System ===");
        
        Vehicle vehicle1 = new Vehicle("MH12AB1234", "Sedan", 1500);
        System.out.println("Vehicle 1: " + vehicle1);
        
        Vehicle vehicle2 = new Vehicle("KA05CD5678", "SUV", 2500);
        System.out.println("Vehicle 2: " + vehicle2);
        
        System.out.println("\n--- Vehicle Details ---");
        System.out.println("Registration: " + vehicle1.getRegistrationNo());
        System.out.println("Type: " + vehicle1.getType());
        System.out.println("Rate: $" + vehicle1.getRatePerDay() + "/day");
    }
}