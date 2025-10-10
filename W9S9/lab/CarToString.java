/*
LAB PROBLEM 2: toString() and getClass() Usage
Topic: Object Class Methods – toString(), getClass()
*/

class Car {
    private String brand;
    private String model;
    private double price;
    
    public Car(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }
    
    @Override
    public String toString() {
        return "Car{brand='" + brand + "', model='" + model + "', price=$" + price + "}";
    }
}

public class CarToString {
    public static void main(String[] args) {
        Car car1 = new Car("Toyota", "Camry", 25000.0);
        Car car2 = new Car("Honda", "Civic", 22000.0);
        
        System.out.println("=== Car toString() and getClass() Demo ===");
        
        System.out.println("\n--- Object Details (toString()) ---");
        System.out.println("Car 1: " + car1);
        System.out.println("Car 2: " + car2);
        
        System.out.println("\n--- Class Information (getClass()) ---");
        System.out.println("Car 1 class: " + car1.getClass().getName());
        System.out.println("Car 2 class: " + car2.getClass().getName());
        
        System.out.println("\n--- Additional Class Info ---");
        System.out.println("Simple class name: " + car1.getClass().getSimpleName());
        System.out.println("Package name: " + car1.getClass().getPackage());
    }
}