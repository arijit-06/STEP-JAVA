// File: ShapeFactory.java
// LAB 4: Static Factory Pattern

public class ShapeFactory {
    
    public static abstract class Shape {
        protected String color;
        
        public Shape(String color) {
            this.color = color;
        }
        
        public abstract double getArea();
        public abstract void display();
    }
    
    public static class Circle extends Shape {
        private double radius;
        
        public Circle(String color, double radius) {
            super(color);
            this.radius = radius;
        }
        
        @Override
        public double getArea() {
            return Math.PI * radius * radius;
        }
        
        @Override
        public void display() {
            System.out.println(color + " Circle - Radius: " + radius + ", Area: " + getArea());
        }
    }
    
    public static class Rectangle extends Shape {
        private double width, height;
        
        public Rectangle(String color, double width, double height) {
            super(color);
            this.width = width;
            this.height = height;
        }
        
        @Override
        public double getArea() {
            return width * height;
        }
        
        @Override
        public void display() {
            System.out.println(color + " Rectangle - " + width + "x" + height + ", Area: " + getArea());
        }
    }
    
    // Static factory methods
    public static Shape createCircle(String color, double radius) {
        return new Circle(color, radius);
    }
    
    public static Shape createRectangle(String color, double width, double height) {
        return new Rectangle(color, width, height);
    }
    
    public static Shape createSquare(String color, double side) {
        return new Rectangle(color, side, side);
    }
    
    public static void main(String[] args) {
        System.out.println("=== Shape Factory Demo ===");
        
        Shape circle = ShapeFactory.createCircle("Red", 5.0);
        Shape rectangle = ShapeFactory.createRectangle("Blue", 4.0, 6.0);
        Shape square = ShapeFactory.createSquare("Green", 3.0);
        
        circle.display();
        rectangle.display();
        square.display();
    }
}