/*
Topic 1: Abstract Class with Abstract and Concrete Methods
Problem Statement:
Create an abstract class Shape with abstract methods area() and perimeter(). Provide a
concrete method displayInfo().
Create subclasses Circle and Rectangle that implement the abstract methods. Test the
implementation by creating objects and displaying results.
Hints:
● Use abstract keyword for Shape class.
● Implement area() and perimeter() in subclasses.
● Call displayInfo() from subclass objects.
*/

abstract class AbstractShape {
    protected String shapeName;
    protected String color;
    private static int shapeCount = 0;
    
    public AbstractShape(String shapeName) {
        this.shapeName = shapeName;
        this.color = "Default";
        shapeCount++;
    }
    
    public AbstractShape(String shapeName, String color) {
        this.shapeName = shapeName;
        this.color = color;
        shapeCount++;
    }
    
    public abstract double area();
    public abstract double perimeter();
    
    public void displayInfo() {
        System.out.println("\n=== Shape Information ===");
        System.out.println("Shape: " + shapeName);
        System.out.println("Color: " + color);
        System.out.printf("Area: %.2f square units%n", area());
        System.out.printf("Perimeter: %.2f units%n", perimeter());
        System.out.println("Shape Type: " + getClass().getSimpleName());
    }
    
    public String getShapeName() { return shapeName; }
    public String getColor() { return color; }
    public static int getShapeCount() { return shapeCount; }
}

class Circle extends AbstractShape {
    private double radius;
    
    public Circle(double radius) {
        super("Circle");
        this.radius = radius;
    }
    
    public Circle(double radius, String color) {
        super("Circle", color);
        this.radius = radius;
    }
    
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
    
    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.printf("Radius: %.2f units%n", radius);
    }
}

class Rectangle extends AbstractShape {
    private double length;
    private double width;
    
    public Rectangle(double length, double width) {
        super("Rectangle");
        this.length = length;
        this.width = width;
    }
    
    public Rectangle(double length, double width, String color) {
        super("Rectangle", color);
        this.length = length;
        this.width = width;
    }
    
    @Override
    public double area() {
        return length * width;
    }
    
    @Override
    public double perimeter() {
        return 2 * (length + width);
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.printf("Length: %.2f units%n", length);
        System.out.printf("Width: %.2f units%n", width);
    }
}

public class AbstractShape {
    public static void main(String[] args) {
        System.out.println("=== Abstract Class with Abstract and Concrete Methods Demo ===");
        
        AbstractShape circle = new Circle(5.0, "Red");
        AbstractShape rectangle = new Rectangle(4.0, 6.0, "Blue");
        AbstractShape square = new Rectangle(5.0, 5.0, "Green");
        
        circle.displayInfo();
        rectangle.displayInfo();
        square.displayInfo();
        
        System.out.println("\n=== Polymorphic Behavior Demo ===");
        AbstractShape[] shapes = {circle, rectangle, square};
        
        double totalArea = 0;
        for (AbstractShape shape : shapes) {
            System.out.printf("%s - Area: %.2f, Perimeter: %.2f%n", 
                shape.getShapeName(), shape.area(), shape.perimeter());
            totalArea += shape.area();
        }
        
        System.out.printf("\nTotal Area: %.2f square units%n", totalArea);
        System.out.println("Total shapes created: " + AbstractShape.getShapeCount());
        
        System.out.println("\n=== Key Learning Points ===");
        System.out.println("1. Abstract class Shape defines common structure");
        System.out.println("2. Abstract methods must be implemented by subclasses");
        System.out.println("3. Concrete method displayInfo() is inherited");
        System.out.println("4. Polymorphism allows uniform shape handling");
    }
}