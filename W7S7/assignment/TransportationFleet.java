// ASSIGNMENT 3: Transportation Fleet Management - Dynamic Method Dispatch
abstract class Vehicle {
    protected String vehicleId;
    protected String currentLocation;
    protected boolean isAvailable;
    
    public Vehicle(String vehicleId, String currentLocation) {
        this.vehicleId = vehicleId;
        this.currentLocation = currentLocation;
        this.isAvailable = true;
    }
    
    public abstract void dispatch(String destination);
    public abstract void calculateFare(double distance);
    
    public void updateLocation(String location) {
        currentLocation = location;
        System.out.println("📍 " + vehicleId + " location updated to: " + location);
    }
}

class Bus extends Vehicle {
    private String route;
    private int passengerCapacity;
    private int currentPassengers;
    
    public Bus(String vehicleId, String route, int capacity) {
        super(vehicleId, "Bus Terminal");
        this.route = route;
        this.passengerCapacity = capacity;
        this.currentPassengers = 0;
    }
    
    @Override
    public void dispatch(String destination) {
        System.out.println("🚌 Bus " + vehicleId + " dispatched on route " + route + " to " + destination);
        System.out.println("   Capacity: " + currentPassengers + "/" + passengerCapacity + " passengers");
        isAvailable = false;
    }
    
    @Override
    public void calculateFare(double distance) {
        double fare = 2.50; // Fixed fare for bus
        System.out.println("🎫 Bus fare: $" + fare + " (Fixed rate regardless of distance)");
    }
    
    public void boardPassengers(int count) {
        if (currentPassengers + count <= passengerCapacity) {
            currentPassengers += count;
            System.out.println("👥 " + count + " passengers boarded. Total: " + currentPassengers);
        } else {
            System.out.println("❌ Cannot board " + count + " passengers. Capacity exceeded!");
        }
    }
}

class Taxi extends Vehicle {
    private String driverName;
    private double ratePerMile;
    
    public Taxi(String vehicleId, String driverName) {
        super(vehicleId, "Downtown");
        this.driverName = driverName;
        this.ratePerMile = 2.75;
    }
    
    @Override
    public void dispatch(String destination) {
        System.out.println("🚕 Taxi " + vehicleId + " (Driver: " + driverName + ") dispatched to " + destination);
        System.out.println("   Providing door-to-door service from " + currentLocation);
        isAvailable = false;
    }
    
    @Override
    public void calculateFare(double distance) {
        double baseFare = 3.50;
        double distanceFare = distance * ratePerMile;
        double totalFare = baseFare + distanceFare;
        System.out.println("🎫 Taxi fare: $" + String.format("%.2f", totalFare) + 
                         " (Base: $" + baseFare + " + Distance: $" + String.format("%.2f", distanceFare) + ")");
    }
}

class Train extends Vehicle {
    private String trainLine;
    private int carCount;
    private String schedule;
    
    public Train(String vehicleId, String trainLine, int carCount, String schedule) {
        super(vehicleId, "Central Station");
        this.trainLine = trainLine;
        this.carCount = carCount;
        this.schedule = schedule;
    }
    
    @Override
    public void dispatch(String destination) {
        System.out.println("🚆 Train " + vehicleId + " on " + trainLine + " line dispatched to " + destination);
        System.out.println("   " + carCount + " cars, Schedule: " + schedule);
        isAvailable = false;
    }
    
    @Override
    public void calculateFare(double distance) {
        double farePerMile = 0.15;
        double fare = Math.max(1.50, distance * farePerMile); // Minimum $1.50
        System.out.println("🎫 Train fare: $" + String.format("%.2f", fare) + 
                         " (" + String.format("%.1f", distance) + " miles at $" + farePerMile + "/mile)");
    }
    
    public void announceSchedule() {
        System.out.println("📢 " + trainLine + " line schedule: " + schedule);
    }
}

class Bike extends Vehicle {
    private boolean isElectric;
    private int batteryLevel;
    
    public Bike(String vehicleId, boolean isElectric) {
        super(vehicleId, "Bike Station A");
        this.isElectric = isElectric;
        this.batteryLevel = isElectric ? 100 : 0;
    }
    
    @Override
    public void dispatch(String destination) {
        String bikeType = isElectric ? "E-Bike" : "Regular Bike";
        System.out.println("🚲 " + bikeType + " " + vehicleId + " dispatched for eco-friendly trip to " + destination);
        if (isElectric) {
            System.out.println("   Battery level: " + batteryLevel + "%");
        }
        isAvailable = false;
    }
    
    @Override
    public void calculateFare(double distance) {
        double baseFare = 2.00;
        double farePerMile = isElectric ? 0.25 : 0.15;
        double fare = baseFare + (distance * farePerMile);
        String bikeType = isElectric ? "E-Bike" : "Regular Bike";
        System.out.println("🎫 " + bikeType + " fare: $" + String.format("%.2f", fare) + 
                         " (Eco-friendly option!)");
    }
}

public class TransportationFleet {
    public static void dispatchVehicles(Vehicle[] fleet, String[] destinations, double[] distances) {
        System.out.println("=== City Transportation Dispatch System ===\n");
        
        for (int i = 0; i < fleet.length && i < destinations.length; i++) {
            Vehicle vehicle = fleet[i];
            String destination = destinations[i];
            double distance = distances[i];
            
            System.out.println("--- Dispatch Request " + (i + 1) + " ---");
            vehicle.dispatch(destination);
            vehicle.calculateFare(distance);
            vehicle.updateLocation(destination);
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        Vehicle[] cityFleet = {
            new Bus("BUS-001", "Route 42", 50),
            new Taxi("TAXI-205", "John Smith"),
            new Train("TRAIN-A1", "Blue Line", 8, "Every 15 minutes"),
            new Bike("BIKE-E101", true),
            new Bus("BUS-002", "Route 15", 40),
            new Bike("BIKE-R205", false)
        };
        
        String[] destinations = {
            "University Campus",
            "Airport Terminal",
            "Business District",
            "City Park",
            "Shopping Mall",
            "Beach Boardwalk"
        };
        
        double[] distances = {5.2, 12.8, 8.5, 2.1, 6.7, 4.3};
        
        dispatchVehicles(cityFleet, destinations, distances);
        
        // Demonstrate specific vehicle features
        System.out.println("=== Special Vehicle Features ===");
        ((Bus)cityFleet[0]).boardPassengers(25);
        ((Train)cityFleet[2]).announceSchedule();
    }
}