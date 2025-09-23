// File: AnimalKingdomHierarchy.java
// PRACTICE PROBLEM 2: Multilevel Inheritance Chain

public class AnimalKingdomHierarchy {
    
    public static class Animal {
        protected String species;
        protected String habitat;
        protected int lifespan;
        
        public Animal(String species, String habitat, int lifespan) {
            this.species = species;
            this.habitat = habitat;
            this.lifespan = lifespan;
            System.out.println("Animal constructor: " + species);
        }
        
        public void eat() {
            System.out.println(species + " is eating");
        }
        
        public void sleep() {
            System.out.println(species + " is sleeping");
        }
        
        public void move() {
            System.out.println(species + " is moving");
        }
    }
    
    public static class Mammal extends Animal {
        protected boolean hasWarmBlood;
        protected String furColor;
        
        public Mammal(String species, String habitat, int lifespan, String furColor) {
            super(species, habitat, lifespan);
            this.hasWarmBlood = true;
            this.furColor = furColor;
            System.out.println("Mammal constructor: " + furColor + " fur");
        }
        
        @Override
        public void move() {
            super.move();
            System.out.println("Mammal is walking on four legs");
        }
        
        public void nurse() {
            System.out.println("Mammal is nursing offspring");
        }
    }
    
    public static class Dog extends Mammal {
        private String breed;
        private boolean isDomesticated;
        
        public Dog(String breed, String furColor) {
            super("Canis lupus", "Domestic", 12, furColor);
            this.breed = breed;
            this.isDomesticated = true;
            System.out.println("Dog constructor: " + breed);
        }
        
        @Override
        public void eat() {
            super.eat();
            System.out.println("Dog is wagging tail while eating");
        }
        
        @Override
        public void move() {
            System.out.println("Dog is running and playing");
        }
        
        public void bark() {
            System.out.println("Woof! Woof!");
        }
        
        public void fetch() {
            System.out.println("Dog is fetching the ball");
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Multilevel Inheritance Demo ===");
        
        Dog myDog = new Dog("Golden Retriever", "Golden");
        
        System.out.println("\n=== Testing Inherited Methods ===");
        myDog.eat();
        myDog.sleep();
        myDog.move();
        myDog.nurse();
        
        System.out.println("\n=== Testing Dog-specific Methods ===");
        myDog.bark();
        myDog.fetch();
        
        System.out.println("\n=== Polymorphism Test ===");
        Animal animal = new Dog("Labrador", "Black");
        animal.eat();
        animal.move();
    }
}