// File: SpaceStationCrew.java
// PRACTICE PROBLEM 2: Multilevel Inheritance Chain
// Topic: Building deep inheritance hierarchies with proper constructor chaining

public class SpaceStationCrew {
    
    // Base class Animal
    public static class Animal {
        protected String species;
        protected String habitat;
        protected int lifespan;
        protected boolean isWildlife;
        
        public Animal(String species, String habitat, int lifespan, boolean isWildlife) {
            this.species = species;
            this.habitat = habitat;
            this.lifespan = lifespan;
            this.isWildlife = isWildlife;
            System.out.println("Animal constructor: Creating " + species);
        }
        
        public void eat() {
            System.out.println("Animal is eating");
        }
        
        public void sleep() {
            System.out.println("Animal is sleeping");
        }
        
        public void move() {
            System.out.println("Animal is moving");
        }
        
        public String getAnimalInfo() {
            return String.format("Species: %s, Habitat: %s, Lifespan: %d years, Wildlife: %s",
                               species, habitat, lifespan, isWildlife ? "Yes" : "No");
        }
    }
    
    // Intermediate class Mammal extends Animal
    public static class Mammal extends Animal {
        protected String furColor;
        protected boolean hasWarmBlood;
        protected int gestationPeriod;
        
        public Mammal(String species, String habitat, int lifespan, boolean isWildlife,
                     String furColor, int gestationPeriod) {
            super(species, habitat, lifespan, isWildlife);
            this.furColor = furColor;
            this.hasWarmBlood = true; // Always true for mammals
            this.gestationPeriod = gestationPeriod;
            System.out.println("Mammal constructor: Adding mammal traits");
        }
        
        @Override
        public void move() {
            super.move();
            System.out.println("Mammal is walking/running");
        }
        
        public void nurse() {
            System.out.println("Mammal is nursing offspring");
        }
        
        public void regulateTemperature() {
            System.out.println("Maintaining body temperature");
        }
    }
    
    // Specific class Dog extends Mammal
    public static class Dog extends Mammal {
        private String breed;
        private boolean isDomesticated;
        private int loyaltyLevel;
        private String favoriteActivity;
        
        // Basic constructor with minimal parameters
        public Dog(String breed) {
            super("Canis lupus", "Domestic", 12, false, "Brown", 63);
            this.breed = breed;
            this.isDomesticated = true;
            this.loyaltyLevel = 8;
            this.favoriteActivity = "Playing fetch";
            System.out.println("Dog constructor: Creating " + breed + " dog");
        }
        
        // Detailed constructor with all parameters
        public Dog(String species, String habitat, int lifespan, boolean isWildlife,
                  String furColor, int gestationPeriod, String breed, 
                  boolean isDomesticated, int loyaltyLevel, String favoriteActivity) {
            super(species, habitat, lifespan, isWildlife, furColor, gestationPeriod);
            this.breed = breed;
            this.isDomesticated = isDomesticated;
            this.loyaltyLevel = loyaltyLevel;
            this.favoriteActivity = favoriteActivity;
            System.out.println("Dog constructor: Creating " + breed + " dog");
        }
        
        // Copy constructor
        public Dog(Dog other) {
            this(other.species, other.habitat, other.lifespan, other.isWildlife,
                 other.furColor, other.gestationPeriod, other.breed,
                 other.isDomesticated, other.loyaltyLevel, other.favoriteActivity);
        }
        
        @Override
        public void eat() {
            super.eat();
            System.out.println("wagging tail while eating");
        }
        
        @Override
        public void move() {
            System.out.println("Dog is running and playing");
        }
        
        @Override
        public void sleep() {
            System.out.println("Dog is sleeping in doghouse");
        }
        
        public void bark() {
            System.out.println("Woof! Woof!");
        }
        
        public void fetch() {
            System.out.println("Dog is fetching the ball");
        }
        
        public void showLoyalty() {
            System.out.println("Loyalty level: " + loyaltyLevel + "/10 - Very loyal companion!");
        }
        
        public void demonstrateInheritance() {
            System.out.println("\n=== Demonstrating Inheritance Chain ===");
            System.out.println("Animal level:");
            super.eat(); // Calls Animal.eat() through Mammal
            
            System.out.println("\nMammal level:");
            nurse();
            regulateTemperature();
            
            System.out.println("\nDog level:");
            bark();
            fetch();
            showLoyalty();
        }
        
        public String getDogInfo() {
            return getAnimalInfo() + String.format(", Breed: %s, Domesticated: %s, Loyalty: %d/10",
                                                 breed, isDomesticated ? "Yes" : "No", loyaltyLevel);
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Testing Multilevel Constructor Chaining ===");
        
        // Test basic constructor
        System.out.println("\n1. Creating basic Golden Retriever:");
        Dog basicDog = new Dog("Golden Retriever");
        
        // Test detailed constructor
        System.out.println("\n2. Creating detailed German Shepherd:");
        Dog detailedDog = new Dog("Canis lupus", "Domestic", 13, false, "Black and Tan", 
                                 63, "German Shepherd", true, 10, "Guarding");
        
        // Test copy constructor
        System.out.println("\n3. Creating copy of German Shepherd:");
        Dog copyDog = new Dog(detailedDog);
        
        System.out.println("\n=== Testing Method Overriding Across Levels ===");
        
        // Test method calls at different levels
        System.out.println("\n4. Testing eat() method:");
        basicDog.eat(); // Shows overriding chain
        
        System.out.println("\n5. Testing move() method:");
        basicDog.move(); // Dog's implementation
        
        System.out.println("\n6. Testing sleep() method:");
        basicDog.sleep(); // Dog's implementation
        
        System.out.println("\n=== Testing Access to Inherited Members ===");
        
        // Access fields from all levels
        System.out.println("\n7. Accessing inherited fields:");
        System.out.println("Species (Animal): " + basicDog.species);
        System.out.println("Fur Color (Mammal): " + basicDog.furColor);
        System.out.println("Dog Info: " + basicDog.getDogInfo());
        
        System.out.println("\n=== Demonstrating IS-A Relationships ===");
        
        // Test instanceof with all levels
        System.out.println("\n8. Testing instanceof relationships:");
        System.out.println("basicDog instanceof Dog: " + (basicDog instanceof Dog));
        System.out.println("basicDog instanceof Mammal: " + (basicDog instanceof Mammal));
        System.out.println("basicDog instanceof Animal: " + (basicDog instanceof Animal));
        
        System.out.println("\n=== Complete Inheritance Demonstration ===");
        detailedDog.demonstrateInheritance();
        
        System.out.println("\n=== Polymorphic Behavior ===");
        
        // Test polymorphism at different levels
        Animal animalRef = new Dog("Labrador");
        Mammal mammalRef = new Dog("Poodle");
        
        System.out.println("\n9. Polymorphic method calls:");
        animalRef.move(); // Calls Dog's move() method
        mammalRef.nurse(); // Calls Mammal's nurse() method
    }
}