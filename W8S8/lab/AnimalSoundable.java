/*
LAB PROBLEM 5: Abstract Animal and Soundable Interface
Topic: Abstract Class and Interface in Zoology
Problem Statement:
Create an abstract class Animal with fields name and habitat. Add an abstract method
eat().
Create an interface Soundable with method makeSound().
Create a class Dog that extends Animal and implements Soundable.
Hints:
● Abstract method represents common but incomplete behavior.
● Interface enforces sound-making behavior across animals.
*/

abstract class AbstractAnimal {
    protected String name;
    protected String habitat;
    protected int age;
    
    public AbstractAnimal(String name, String habitat) {
        this.name = name;
        this.habitat = habitat;
        this.age = 1;
    }
    
    public abstract void eat();
    
    public void sleep() {
        System.out.println(name + " is sleeping peacefully in " + habitat);
    }
    
    public String getName() { return name; }
    public String getHabitat() { return habitat; }
}

interface Soundable {
    void makeSound();
    
    default void communicationInfo() {
        System.out.println("Animals use sounds for communication");
    }
}

class Dog extends AbstractAnimal implements Soundable {
    private String breed;
    private String owner;
    
    public Dog(String name, String habitat) {
        super(name, habitat);
        this.breed = "Mixed";
        this.owner = "Unknown";
    }
    
    public Dog(String name, String habitat, String breed, String owner) {
        super(name, habitat);
        this.breed = breed;
        this.owner = owner;
    }
    
    @Override
    public void eat() {
        System.out.println(name + " is eating dog food");
        System.out.println("Wagging tail happily while eating");
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " says: Woof! Woof! Bark! Bark!");
        System.out.println(name + " (" + breed + ") is barking loudly");
    }
    
    public void playFetch() {
        System.out.println(name + " is playing fetch with " + owner);
        makeSound();
    }
    
    public String getBreed() { return breed; }
    public String getOwner() { return owner; }
}

class Cat extends AbstractAnimal implements Soundable {
    private String furColor;
    
    public Cat(String name, String habitat, String furColor) {
        super(name, habitat);
        this.furColor = furColor;
    }
    
    @Override
    public void eat() {
        System.out.println(name + " is eating cat food delicately");
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " says: Meow! Meow! Purr...");
    }
}

public class AnimalSoundable {
    public static void main(String[] args) {
        System.out.println("=== Abstract Animal and Soundable Interface Demo ===");
        
        Dog dog1 = new Dog("Buddy", "House", "Golden Retriever", "John Smith");
        Dog dog2 = new Dog("Max", "Backyard", "German Shepherd", "Alice Johnson");
        Cat cat = new Cat("Whiskers", "House", "Orange");
        
        System.out.println("\n=== Dog 1 Demo ===");
        dog1.eat();
        dog1.makeSound();
        dog1.communicationInfo();
        dog1.playFetch();
        
        System.out.println("\n=== Dog 2 Demo ===");
        dog2.eat();
        dog2.makeSound();
        dog2.sleep();
        
        System.out.println("\n=== Cat Demo ===");
        cat.eat();
        cat.makeSound();
        cat.sleep();
        
        System.out.println("\n=== Polymorphic Behavior Demo ===");
        AbstractAnimal[] animals = {dog1, dog2, cat};
        Soundable[] soundMakers = {dog1, dog2, cat};
        
        System.out.println("\nUsing Animal references:");
        for (AbstractAnimal animal : animals) {
            System.out.println(animal.getName() + " lives in " + animal.getHabitat());
            animal.eat();
        }
        
        System.out.println("\nUsing Soundable references:");
        for (Soundable soundMaker : soundMakers) {
            soundMaker.makeSound();
        }
        
        System.out.println("\n=== Key Learning Points ===");
        System.out.println("1. Abstract Animal class provides common animal structure");
        System.out.println("2. Soundable interface defines sound-making contract");
        System.out.println("3. Dog implements both abstract methods and interface methods");
        System.out.println("4. Different animals have different eating and sound behaviors");
        System.out.println("5. Polymorphism enables uniform animal handling");
    }
}