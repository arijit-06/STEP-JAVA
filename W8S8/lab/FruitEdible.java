/*
LAB PROBLEM 1: Abstract Fruit and Edible Interface
Topic: Abstract Class with Interface Implementation
Problem Statement:
Create an abstract class Fruit with protected fields color and taste. Add an abstract
method showDetails().
Create an interface Edible with method nutrientsInfo().
Create a class Apple that extends Fruit and implements Edible, adding a variety field.
Hints:
● Use abstract for parent class.
● Use interface for common behavior.
● Implement both abstract and interface methods.
*/

abstract class AbstractFruit {
    protected String color;
    protected String taste;
    protected double weight;
    protected String origin;
    
    public Fruit(String color, String taste) {
        this.color = color;
        this.taste = taste;
        this.weight = 0.0;
        this.origin = "Unknown";
    }
    
    public Fruit(String color, String taste, double weight, String origin) {
        this.color = color;
        this.taste = taste;
        this.weight = weight;
        this.origin = origin;
    }
    
    public abstract void showDetails();
    
    public void displayBasicInfo() {
        System.out.println("Basic Fruit Info - Color: " + color + ", Taste: " + taste);
    }
    
    public String getColor() { return color; }
    public String getTaste() { return taste; }
    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }
    public void setOrigin(String origin) { this.origin = origin; }
}

interface Edible {
    void nutrientsInfo();
    
    default void edibilityInfo() {
        System.out.println("This fruit is safe to eat and provides nutritional benefits");
    }
    
    static void generalNutritionAdvice() {
        System.out.println("Fruits are essential for a balanced diet. Eat 2-3 servings daily!");
    }
}

class Apple extends AbstractFruit implements Edible {
    private String variety;
    private boolean isOrganic;
    private String harvestSeason;
    
    public Apple(String color, String taste, String variety) {
        super(color, taste);
        this.variety = variety;
        this.isOrganic = false;
        this.harvestSeason = "Fall";
    }
    
    public Apple(String color, String taste, String variety, double weight, String origin, boolean isOrganic) {
        super(color, taste, weight, origin);
        this.variety = variety;
        this.isOrganic = isOrganic;
        this.harvestSeason = "Fall";
    }
    
    @Override
    public void showDetails() {
        System.out.println("\n=== Apple Details ===");
        System.out.println("Variety: " + variety);
        System.out.println("Color: " + color);
        System.out.println("Taste: " + taste);
        System.out.println("Weight: " + weight + " grams");
        System.out.println("Origin: " + origin);
        System.out.println("Organic: " + (isOrganic ? "Yes" : "No"));
        System.out.println("Harvest Season: " + harvestSeason);
    }
    
    @Override
    public void nutrientsInfo() {
        System.out.println("\n=== Apple Nutritional Information ===");
        System.out.println("Rich in Vitamin C and dietary fiber");
        System.out.println("Contains antioxidants and potassium");
        System.out.println("Low in calories (approximately 95 calories per medium apple)");
        System.out.println("Helps in digestion and heart health");
        if (isOrganic) {
            System.out.println("Organic apples have no pesticide residues");
        }
    }
    
    public void setOrganic(boolean organic) {
        this.isOrganic = organic;
    }
    
    public String getVariety() {
        return variety;
    }
    
    public void crunchSound() {
        System.out.println("*CRUNCH* - Enjoying a crispy " + variety + " apple!");
    }
}

class Orange extends AbstractFruit implements Edible {
    private boolean hasSeeds;
    private int segments;
    
    public Orange(String color, String taste, boolean hasSeeds) {
        super(color, taste);
        this.hasSeeds = hasSeeds;
        this.segments = 10;
    }
    
    @Override
    public void showDetails() {
        System.out.println("\n=== Orange Details ===");
        System.out.println("Color: " + color);
        System.out.println("Taste: " + taste);
        System.out.println("Has Seeds: " + (hasSeeds ? "Yes" : "No"));
        System.out.println("Segments: " + segments);
    }
    
    @Override
    public void nutrientsInfo() {
        System.out.println("\n=== Orange Nutritional Information ===");
        System.out.println("Excellent source of Vitamin C");
        System.out.println("Contains folate and potassium");
        System.out.println("Rich in citrus flavonoids");
    }
}

public class FruitEdible {
    public static void main(String[] args) {
        System.out.println("=== Abstract Fruit and Edible Interface Demo ===");
        
        Edible.generalNutritionAdvice();
        
        Apple apple1 = new Apple("Red", "Sweet", "Gala");
        apple1.setWeight(180.5);
        apple1.setOrigin("Washington State");
        apple1.setOrganic(true);
        
        Apple apple2 = new Apple("Green", "Tart", "Granny Smith", 165.0, "New Zealand", false);
        
        apple1.displayBasicInfo();
        apple1.showDetails();
        apple1.nutrientsInfo();
        apple1.edibilityInfo();
        apple1.crunchSound();
        
        apple2.showDetails();
        apple2.nutrientsInfo();
        
        Orange orange = new Orange("Orange", "Citrusy", true);
        orange.setWeight(200.0);
        orange.setOrigin("Florida");
        
        orange.showDetails();
        orange.nutrientsInfo();
        orange.edibilityInfo();
        
        AbstractFruit[] fruits = {apple1, apple2, orange};
        Edible[] edibles = {apple1, apple2, orange};
        
        System.out.println("\nUsing Fruit references:");
        for (AbstractFruit fruit : fruits) {
            fruit.showDetails();
        }
        
        System.out.println("\nUsing Edible references:");
        for (Edible edible : edibles) {
            edible.nutrientsInfo();
        }
        
        System.out.println("\n=== Key Learning Points ===");
        System.out.println("1. Abstract class Fruit provides common structure and behavior");
        System.out.println("2. Interface Edible defines contract for nutritional information");
        System.out.println("3. Apple implements both abstract method and interface methods");
        System.out.println("4. Polymorphism allows treating objects through different references");
        System.out.println("5. Default and static methods in interfaces provide additional functionality");
    }
}