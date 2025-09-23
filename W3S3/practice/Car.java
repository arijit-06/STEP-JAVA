public class Car {
    private String brand;
    private String model;
    private int year;
    private String color;
    private boolean isRunning;
    
    public Car(String brand, String model, int year, String color) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.isRunning = false;
    }
    
    public void startEngine() {
        isRunning = true;
        System.out.println(brand + " " + model + " engine started!");
    }
    
    public void stopEngine() {
        isRunning = false;
        System.out.println(brand + " " + model + " engine stopped!");
    }
    
    public void displayInfo() {
        System.out.println("Car: " + brand + " " + model + " (" + year + ") - " + color);
        System.out.println("Status: " + (isRunning ? "Running" : "Stopped"));
    }
    
    public int getAge() {
        return 2024 - year;
    }
    
    public static void main(String[] args) {
        Car car1 = new Car("Toyota", "Camry", 2020, "Blue");
        Car car2 = new Car("Honda", "Civic", 2018, "Red");
        Car car3 = new Car("BMW", "X5", 2022, "Black");
        
        car1.displayInfo();
        car1.startEngine();
        System.out.println("Age: " + car1.getAge() + " years\n");
        
        car2.displayInfo();
        car2.startEngine();
        car2.stopEngine();
        System.out.println("Age: " + car2.getAge() + " years\n");
        
        car3.displayInfo();
        System.out.println("Age: " + car3.getAge() + " years");
        
        // Each object maintains its own state - similar to real cars
        System.out.println("\n// Real-world analogy: Each car object is like a physical car");
        System.out.println("// - Has unique properties (brand, model, color)");
        System.out.println("// - Can perform actions (start/stop engine)");
        System.out.println("// - Maintains independent state (running/stopped)");
    }
}