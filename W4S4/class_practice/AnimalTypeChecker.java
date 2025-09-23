import java.util.Scanner;

class Animal {
    protected String name;
    
    public Animal(String name) {
        this.name = name;
    }
    
    public void makeSound() {
        System.out.println(name + " makes a sound");
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " barks: Woof!");
    }
    
    public void wagTail() {
        System.out.println(name + " wags tail happily");
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " meows: Meow!");
    }
    
    public void purr() {
        System.out.println(name + " purrs contentedly");
    }
}

public class AnimalTypeChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== ANIMAL TYPE CHECKER ===\n");
        
        Animal[] animals = { 
            new Dog("Buddy"), 
            new Cat("Whiskers"), 
            new Dog("Max"), 
            new Animal("Generic Animal"),
            new Cat("Luna"),
            new Dog("Charlie")
        };
        
        // Count number of Dog and Cat instances using instanceof
        int dogCount = 0;
        int catCount = 0;
        int animalCount = 0;
        
        System.out.println("Animal Array Contents:");
        for (int i = 0; i < animals.length; i++) {
            System.out.print((i + 1) + ". ");
            animals[i].makeSound();
            
            // Use instanceof to count types
            if (animals[i] instanceof Dog) {
                dogCount++;
                ((Dog) animals[i]).wagTail(); // Safe casting after instanceof check
            } else if (animals[i] instanceof Cat) {
                catCount++;
                ((Cat) animals[i]).purr(); // Safe casting after instanceof check
            } else if (animals[i] instanceof Animal) {
                animalCount++;
            }
        }
        
        // Print results
        System.out.println("\n=== TYPE COUNT RESULTS ===");
        System.out.println("Dogs: " + dogCount);
        System.out.println("Cats: " + catCount);
        System.out.println("Generic Animals: " + animalCount);
        System.out.println("Total Animals: " + animals.length);
        
        // Demonstrate instanceof with different checks
        System.out.println("\n=== INSTANCEOF DEMONSTRATIONS ===");
        for (Animal animal : animals) {
            System.out.print(animal.name + " is: ");
            
            if (animal instanceof Dog) {
                System.out.print("Dog ");
            }
            if (animal instanceof Cat) {
                System.out.print("Cat ");
            }
            if (animal instanceof Animal) {
                System.out.print("Animal ");
            }
            System.out.println();
        }
        
        sc.close();
    }
}