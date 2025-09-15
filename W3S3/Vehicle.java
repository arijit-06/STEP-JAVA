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
        System.out.println("Make: " + make + ", Model: " + model + 
                          ", Year: " + year + ", Fuel: " + fuelLevel + "L");
    }

    public static void main(String[] args) {
        Vehicle car = new Vehicle("Toyota", "Prius", 2021, 45.0);
        Vehicle truck = new Vehicle("Ford", "F-150", 2020, 80.0);
        Vehicle motorcycle = new Vehicle("Harley", "Sportster", 2019, 12.0);

        Vehicle[] vehicles = {car, truck, motorcycle};

        for (Vehicle v : vehicles) {
            v.displayVehicleInfo();
            v.startVehicle();
            v.refuel(10);
            v.stopVehicle();
            System.out.println();
        }
    }
}