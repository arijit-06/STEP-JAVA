// File: BasicInheritanceDemo.java
// LAB 1: Fruit and Apple Classes

public class BasicInheritanceDemo {
    
    public static class Fruit {
        protected String color;
        protected String taste;
        protected double weight;
        
        public Fruit(String color, String taste, double weight) {
            this.color = color;
            this.taste = taste;
            this.weight = weight;
        }
        
        public void displayInfo() {
            System.out.println("Fruit - Color: " + color + ", Taste: " + taste + ", Weight: " + weight + "g");
        }
        
        public void eat() {
            System.out.println("Eating the fruit");
        }
    }
    
    public static class Apple extends Fruit {
        private String variety;
        
        public Apple(String color, String variety, double weight) {
            super(color, "Sweet", weight);
            this.variety = variety;
        }
        
        @Override
        public void displayInfo() {
            System.out.println("Apple - Variety: " + variety + ", Color: " + color + 
                             ", Taste: " + taste + ", Weight: " + weight + "g");
        }
        
        @Override
        public void eat() {
            System.out.println("Crunching the " + variety + " apple");
        }
        
        public void makeJuice() {
            System.out.println("Making juice from " + variety + " apple");
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Basic Inheritance Demo ===");
        
        Fruit fruit = new Fruit("Yellow", "Sweet", 150);
        Apple apple = new Apple("Red", "Gala", 180);
        
        fruit.displayInfo();
        fruit.eat();
        
        System.out.println();
        apple.displayInfo();
        apple.eat();
        apple.makeJuice();
        
        System.out.println("\n=== Polymorphism ===");
        Fruit polymorphicApple = new Apple("Green", "Granny Smith", 200);
        polymorphicApple.displayInfo();
        polymorphicApple.eat();
    }
}