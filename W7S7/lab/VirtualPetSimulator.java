// LAB 8: Virtual Pet Simulator - Complete Polymorphism Mastery
abstract class Pet {
    protected String name;
    protected int happiness;
    protected int hunger;
    protected int energy;
    
    public Pet(String name) {
        this.name = name;
        this.happiness = 50;
        this.hunger = 30;
        this.energy = 70;
    }
    
    // Common feeding method (inheritance)
    public void feed() {
        hunger = Math.max(0, hunger - 20);
        happiness += 10;
        System.out.println("🍽️ " + name + " is eating! Hunger: " + hunger + ", Happiness: " + happiness);
    }
    
    // Abstract methods for polymorphic behavior
    public abstract void play();
    public abstract void makeSound();
    
    // Method overloading for different care options
    public void care() {
        System.out.println("💝 Basic care for " + name);
        happiness += 5;
    }
    
    public void care(String activity) {
        System.out.println("💝 " + activity + " care for " + name);
        happiness += 10;
        energy -= 5;
    }
    
    public void care(String activity, int duration) {
        System.out.println("💝 " + activity + " for " + duration + " minutes with " + name);
        happiness += duration / 2;
        energy -= duration / 3;
    }
    
    public void displayStats() {
        System.out.println("📊 " + name + " - Happiness: " + happiness + ", Hunger: " + hunger + ", Energy: " + energy);
    }
}

class Dog extends Pet {
    private boolean needsWalk;
    
    public Dog(String name) {
        super(name);
        this.needsWalk = true;
    }
    
    @Override
    public void play() {
        energy -= 15;
        happiness += 20;
        System.out.println("🎾 " + name + " is playing fetch! So excited!");
    }
    
    @Override
    public void makeSound() {
        System.out.println("🐕 " + name + " says: Woof! Woof!");
    }
    
    public void walk() {
        needsWalk = false;
        energy -= 10;
        happiness += 15;
        System.out.println("🚶 Taking " + name + " for a walk in the park!");
    }
    
    public void barkAtStranger() {
        energy -= 5;
        System.out.println("🚨 " + name + " is barking at a stranger! Protective mode!");
    }
}

class Cat extends Pet {
    private boolean needsGrooming;
    private int mousesCaught;
    
    public Cat(String name) {
        super(name);
        this.needsGrooming = true;
        this.mousesCaught = 0;
    }
    
    @Override
    public void play() {
        energy -= 10;
        happiness += 15;
        System.out.println("🧶 " + name + " is playing with yarn! Pouncing around!");
    }
    
    @Override
    public void makeSound() {
        System.out.println("🐱 " + name + " says: Meow! Purr...");
    }
    
    public void groom() {
        needsGrooming = false;
        happiness += 10;
        System.out.println("✨ " + name + " is grooming and looking fabulous!");
    }
    
    public void huntMice() {
        mousesCaught++;
        energy -= 20;
        happiness += 25;
        System.out.println("🐭 " + name + " caught a mouse! Total caught: " + mousesCaught);
    }
    
    public void sleep() {
        energy = Math.min(100, energy + 30);
        System.out.println("😴 " + name + " is taking a long nap... Zzz...");
    }
}

class Bird extends Pet {
    private boolean canFly;
    private String[] learnedWords;
    private int wordCount;
    
    public Bird(String name) {
        super(name);
        this.canFly = true;
        this.learnedWords = new String[10];
        this.wordCount = 0;
    }
    
    @Override
    public void play() {
        energy -= 12;
        happiness += 18;
        System.out.println("🪶 " + name + " is playing with toys and swinging!");
    }
    
    @Override
    public void makeSound() {
        if (wordCount > 0) {
            System.out.println("🦜 " + name + " says: " + learnedWords[0] + "!");
        } else {
            System.out.println("🐦 " + name + " chirps: Tweet tweet!");
        }
    }
    
    public void fly() {
        if (canFly && energy > 20) {
            energy -= 15;
            happiness += 20;
            System.out.println("🕊️ " + name + " is flying around the room! Freedom!");
        } else {
            System.out.println("😴 " + name + " is too tired to fly right now");
        }
    }
    
    public void learnWord(String word) {
        if (wordCount < learnedWords.length) {
            learnedWords[wordCount] = word;
            wordCount++;
            happiness += 15;
            System.out.println("🎓 " + name + " learned a new word: " + word + "!");
        }
    }
    
    public void sing() {
        energy -= 8;
        happiness += 12;
        System.out.println("🎵 " + name + " is singing a beautiful song!");
    }
}

public class VirtualPetSimulator {
    public static void petCareRoutine(Pet[] pets) {
        System.out.println("=== Daily Pet Care Routine ===");
        
        for (Pet pet : pets) {
            System.out.println("\n--- Caring for " + pet.name + " ---");
            
            // Common feeding (inheritance)
            pet.feed();
            
            // Polymorphic play behavior (overriding)
            pet.play();
            pet.makeSound();
            
            // Method overloading examples
            pet.care();
            pet.care("Brushing");
            pet.care("Training", 15);
            
            // Safe downcasting for specific behaviors
            if (pet instanceof Dog) {
                Dog dog = (Dog) pet;
                dog.walk();
                dog.barkAtStranger();
            } else if (pet instanceof Cat) {
                Cat cat = (Cat) pet;
                cat.groom();
                cat.huntMice();
                cat.sleep();
            } else if (pet instanceof Bird) {
                Bird bird = (Bird) pet;
                bird.fly();
                bird.learnWord("Hello");
                bird.sing();
            }
            
            pet.displayStats();
        }
    }
    
    public static void main(String[] args) {
        Pet[] petCollection = {
            new Dog("Buddy"),
            new Cat("Whiskers"),
            new Bird("Tweety"),
            new Dog("Max")
        };
        
        petCareRoutine(petCollection);
        
        System.out.println("\n=== Pet Interaction Summary ===");
        for (Pet pet : petCollection) {
            System.out.print("🐾 " + pet.name + " (" + pet.getClass().getSimpleName() + ") - ");
            pet.makeSound();
        }
    }
}