/*
LAB PROBLEM 2: Abstract Shape and Drawable Interface
Topic: Abstract Class and Interface in Geometry
Problem Statement:
Create an abstract class Shape with fields area and perimeter. Add abstract methods
calculateArea() and calculatePerimeter().
Create an interface Drawable with method draw().
Create a class Circle extending Shape and implementing Drawable.
Hints:
● Abstract methods must be overridden in child class.
● Use interface to add extra behavior.
*/

abstract class AbstractShape {
    protected double area;
    protected double perimeter;
    protected String shapeName;
    protected String color;
    
    public Shape(String shapeName) {
        this.shapeName = shapeName;
        this.color = "Default";
        this.area = 0.0;
        this.perimeter = 0.0;
    }
    
    public Shape(String shapeName, String color) {
        this.shapeName = shapeName;
        this.color = color;
        this.area = 0.0;
        this.perimeter = 0.0;
    }
    
    public abstract void calculateArea();
    public abstract void calculatePerimeter();
    
    public void displayShapeInfo() {
        calculateArea();
        calculatePerimeter();
        System.out.println("\n=== Shape Information ===");
        System.out.println("Shape: " + shapeName);
        System.out.println("Color: " + color);
        System.out.printf("Area: %.2f square units%n", area);
        System.out.printf("Perimeter: %.2f units%n", perimeter);
    }
    
    public double getArea() {
        calculateArea();
        return area;
    }
    
    public double getPerimeter() {
        calculatePerimeter();
        return perimeter;
    }
    
    public String getShapeName() {
        return shapeName;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
}

interface Drawable {
    void draw();
    
    default void showDrawingInfo() {
        System.out.println("This shape can be drawn on a canvas");
    }
    
    static void drawingInstructions() {
        System.out.println("Use appropriate drawing tools for geometric shapes");
    }
}

class Circle extends AbstractShape implements Drawable {
    private double radius;
    
    public Circle(double radius) {
        super("Circle");
        this.radius = radius;
        validateRadius();
    }
    
    public Circle(double radius, String color) {
        super("Circle", color);
        this.radius = radius;
        validateRadius();
    }
    
    private void validateRadius() {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be positive");
        }
    }
    
    @Override
    public void calculateArea() {
        area = Math.PI * radius * radius;
    }
    
    @Override
    public void calculatePerimeter() {
        perimeter = 2 * Math.PI * radius;
    }
    
    @Override
    public void draw() {
        System.out.println("\n🎨 Drawing a " + color + " circle...");
        System.out.println("   ⭕");
        System.out.println("Drawing circle with radius " + radius + " units");
        System.out.println("Circle drawn successfully!");
    }
    
    @Override
    public void displayShapeInfo() {
        super.displayShapeInfo();
        System.out.printf("Radius: %.2f units%n", radius);
        System.out.printf("Diameter: %.2f units%n", 2 * radius);
    }
    
    public double getRadius() {
        return radius;
    }
    
    public void setRadius(double radius) {
        this.radius = radius;
        validateRadius();
    }
    
    public double getDiameter() {
        return 2 * radius;
    }
}

class Rectangle extends AbstractShape implements Drawable {
    private double length;
    private double width;
    
    public Rectangle(double length, double width) {
        super("Rectangle");
        this.length = length;
        this.width = width;
        validateDimensions();
    }
    
    public Rectangle(double length, double width, String color) {
        super("Rectangle", color);
        this.length = length;
        this.width = width;
        validateDimensions();
    }
    
    private void validateDimensions() {
        if (length <= 0 || width <= 0) {
            throw new IllegalArgumentException("Length and width must be positive");
        }
    }
    
    @Override
    public void calculateArea() {
        area = length * width;
    }
    
    @Override
    public void calculatePerimeter() {
        perimeter = 2 * (length + width);
    }
    
    @Override
    public void draw() {
        System.out.println("\n🎨 Drawing a " + color + " rectangle...");
        System.out.println("   ▭");
        System.out.println("Drawing rectangle with dimensions " + length + " x " + width);
        System.out.println("Rectangle drawn successfully!");
    }
    
    @Override
    public void displayShapeInfo() {
        super.displayShapeInfo();
        System.out.printf("Length: %.2f units%n", length);
        System.out.printf("Width: %.2f units%n", width);
        System.out.println("Type: " + (isSquare() ? "Square" : "Rectangle"));
    }
    
    public boolean isSquare() {
        return Math.abs(length - width) < 0.001;
    }
    
    public double getLength() {
        return length;
    }
    
    public double getWidth() {
        return width;
    }
}

public class ShapeDrawable {
    public static void main(String[] args) {
        System.out.println("=== Abstract Shape and Drawable Interface Demo ===");
        
        Drawable.drawingInstructions();
        
        try {
            Circle circle = new Circle(5.0, "Red");
            Rectangle rectangle = new Rectangle(4.0, 6.0, "Blue");
            Rectangle square = new Rectangle(5.0, 5.0, "Green");
            
            circle.displayShapeInfo();
            circle.draw();
            circle.showDrawingInfo();
            
            rectangle.displayShapeInfo();
            rectangle.draw();
            rectangle.showDrawingInfo();
            
            square.displayShapeInfo();
            square.draw();
            
            System.out.println("\n=== Polymorphic Drawing Demo ===");
            AbstractShape[] shapes = {circle, rectangle, square};
            Drawable[] drawables = {circle, rectangle, square};
            
            System.out.println("\nUsing Shape references:");
            for (AbstractShape shape : shapes) {
                System.out.printf("%s - Area: %.2f, Perimeter: %.2f%n", 
                    shape.getShapeName(), shape.getArea(), shape.getPerimeter());
            }
            
            System.out.println("\nUsing Drawable references:");
            for (Drawable drawable : drawables) {
                drawable.draw();
            }
            
            System.out.println("\n=== Key Learning Points ===");
            System.out.println("1. Abstract class Shape provides common geometric structure");
            System.out.println("2. Abstract methods ensure all shapes implement area/perimeter calculation");
            System.out.println("3. Drawable interface adds drawing capability to shapes");
            System.out.println("4. Multiple inheritance achieved through interface implementation");
            System.out.println("5. Polymorphism allows uniform treatment of different shapes");
            
        } catch (IllegalArgumentException e) {
            System.err.println("Error creating shape: " + e.getMessage());
        }
    }
}