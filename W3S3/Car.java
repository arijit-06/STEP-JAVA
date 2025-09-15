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
        System.out.println("Brand: " + brand + ", Model: " + model +
                ", Year: " + year + ", Color: " + color +
                ", Running: " + isRunning);
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
        System.out.println("Car 1 age: " + car1.getAge() + " years");

        car2.displayInfo();
        car2.startEngine();
        car2.stopEngine();
        System.out.println("Car 2 age: " + car2.getAge() + " years");

        car3.displayInfo();
        car3.startEngine();
        System.out.println("Car 3 age: " + car3.getAge() + " years");
    }
}