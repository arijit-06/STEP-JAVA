/*
Topic 4: Interface Inheritance (Extending Interface)
Problem Statement:
Create an interface Animal with method eat().
Create another interface Pet that extends Animal and adds method play().
Create a class Dog that implements Pet. Demonstrate interface inheritance in action.
Hints:
● Use interface Pet extends Animal.
● Dog must implement both eat() and play().
● Create object of Dog and test.
*/

interface Animal {
    void eat();
    
    default void sleep() {
        System.out.println("Animal is sleeping peacefully");
    }
    
    static void animalFacts() {
        System.out.println("Animal Facts:");
        System.out.println("- All animals need food to survive");
        System.out.println("- Animals have different dietary requirements");
        System.out.println("- Proper nutrition is essential for animal health");
        System.out.println("- Animals adapt their eating habits to their environment");
    }
}

interface Pet extends Animal {
    void play();
    
    default void showAffection() {
        System.out.println("Pet is showing affection to its owner");
    }
    
    default void respondToName() {
        System.out.println("Pet responds when called by name");
    }
    
    static void petCareTips() {
        System.out.println("Pet Care Tips:");
        System.out.println("- Provide regular meals and fresh water");
        System.out.println("- Ensure adequate exercise and playtime");
        System.out.println("- Schedule regular veterinary checkups");
        System.out.println("- Maintain a clean and safe environment");
        System.out.println("- Show love and attention daily");
    }
}

class Dog implements Pet {
    private String name;
    private String breed;
    private int age;
    private String owner;
    private boolean isHungry;
    private boolean isPlayful;
    private boolean isTrained;
    private String[] tricks;
    private String favoriteFood;
    private String favoriteToy;
    
    public Dog(String name, String breed, int age, String owner) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.owner = owner;
        this.isHungry = true;
        this.isPlayful = true;
        this.isTrained = false;
        this.tricks = new String[0];
        this.favoriteFood = "Dog biscuits";
        this.favoriteToy = "Tennis ball";
    }
    
    public Dog(String name, String breed, int age, String owner, String favoriteFood, String favoriteToy) {
        this(name, breed, age, owner);
        this.favoriteFood = favoriteFood;
        this.favoriteToy = favoriteToy;
    }
    
    @Override
    public void eat() {
        System.out.println("\n🐕 " + name + " is eating...");
        
        if (isHungry) {
            System.out.println("*Chomp chomp* " + name + " is hungrily eating " + favoriteFood);
            System.out.println(name + " is wagging tail while eating");
            System.out.println("*Crunch crunch* Delicious!");
            System.out.println(name + " finished eating and looks satisfied");
            isHungry = false;
            
            // Eating makes the dog more playful
            isPlayful = true;
        } else {
            System.out.println(name + " sniffs the food but isn't hungry right now");
            System.out.println("Maybe later... *walks away*");
        }
    }
    
    @Override
    public void play() {
        System.out.println("\n🎾 " + name + " wants to play!");
        
        if (isPlayful) {
            System.out.println(name + " is excitedly running around");
            System.out.println("*Woof woof* Let's play with the " + favoriteToy + "!");
            System.out.println(name + " is jumping and spinning in circles");
            System.out.println("Fetching the " + favoriteToy + " and bringing it back");
            System.out.println(name + " drops the " + favoriteToy + " at " + owner + "'s feet");
            System.out.println("*Panting happily* That was fun!");
            
            isPlayful = false;
            isHungry = true; // Playing makes the dog hungry
        } else {
            System.out.println(name + " is tired and just wants to rest");
            System.out.println("*Yawn* Maybe we can play later?");
        }
    }
    
    @Override
    public void sleep() {
        System.out.println("\n😴 " + name + " is getting ready to sleep...");
        System.out.println(name + " circles around a few times");
        System.out.println("*Plop* " + name + " lies down on the favorite spot");
        System.out.println(name + " is sleeping peacefully, occasionally twitching while dreaming");
        System.out.println("*Soft snoring sounds*");
        
        // Sleeping restores energy
        isPlayful = true;
        isHungry = true;
    }
    
    @Override
    public void showAffection() {
        System.out.println("\n❤️ " + name + " is showing affection to " + owner);
        System.out.println(name + " is wagging tail enthusiastically");
        System.out.println("*Lick lick* " + name + " gives gentle kisses");
        System.out.println(name + " nuzzles against " + owner + "'s leg");
        System.out.println("*Happy whimpering* " + name + " loves " + owner + " so much!");
    }
    
    @Override
    public void respondToName() {
        System.out.println("\n👂 " + owner + " calls: '" + name + "!'");
        System.out.println(name + "'s ears perk up immediately");
        System.out.println("*Woof!* " + name + " barks in response");
        System.out.println(name + " comes running to " + owner);
        System.out.println("*Tail wagging intensifies*");
    }
    
    public void displayDogInfo() {
        System.out.println("\n=== Dog Information ===");
        System.out.println("Name: " + name);
        System.out.println("Breed: " + breed);
        System.out.println("Age: " + age + " years old");
        System.out.println("Owner: " + owner);
        System.out.println("Favorite Food: " + favoriteFood);
        System.out.println("Favorite Toy: " + favoriteToy);
        System.out.println("Status: " + getStatus());
        System.out.println("Trained: " + (isTrained ? "Yes" : "No"));
        System.out.println("Known Tricks: " + (tricks.length > 0 ? String.join(", ", tricks) : "None"));
    }
    
    public void bark() {
        System.out.println("\n🔊 " + name + " is barking:");
        System.out.println("Woof! Woof! Bark! Bark!");
        
        if (isPlayful) {
            System.out.println("*Excited barking* - " + name + " wants to play!");
        } else if (isHungry) {
            System.out.println("*Demanding barking* - " + name + " wants food!");
        } else {
            System.out.println("*Happy barking* - " + name + " is just saying hello!");
        }
    }
    
    public void learnTrick(String trick) {
        String[] newTricks = new String[tricks.length + 1];
        System.arraycopy(tricks, 0, newTricks, 0, tricks.length);
        newTricks[tricks.length] = trick;
        tricks = newTricks;
        
        System.out.println("\n🎪 " + name + " is learning a new trick: " + trick);
        System.out.println("*Concentrating hard* " + name + " is trying to understand");
        System.out.println("Good job! " + name + " learned: " + trick);
        
        if (tricks.length >= 3) {
            isTrained = true;
            System.out.println("🏆 " + name + " is now considered well-trained!");
        }
    }
    
    public void performTrick(String trick) {
        boolean knowsTrick = false;
        for (String knownTrick : tricks) {
            if (knownTrick.equalsIgnoreCase(trick)) {
                knowsTrick = true;
                break;
            }
        }
        
        if (knowsTrick) {
            System.out.println("\n🎭 " + name + " performs: " + trick);
            System.out.println("*Focused concentration*");
            System.out.println("Perfect execution! " + name + " did it!");
            System.out.println("*Tail wagging proudly*");
            showAffection(); // Reward with affection
        } else {
            System.out.println("\n❓ " + name + " doesn't know the trick: " + trick);
            System.out.println("*Confused head tilt*");
            System.out.println("*Whimpering* " + name + " needs to learn this trick first");
        }
    }
    
    public void goForWalk() {
        System.out.println("\n🚶 " + owner + " is taking " + name + " for a walk");
        System.out.println(name + " is excited and pulling on the leash");
        System.out.println("*Sniff sniff* Exploring all the interesting smells");
        System.out.println(name + " meets other dogs and wags tail friendly");
        System.out.println("After a good walk, " + name + " is happy and tired");
        
        isPlayful = false; // Tired after walk
        isHungry = true;   // Walk makes hungry
    }
    
    private String getStatus() {
        String status = "";
        if (isHungry) status += "Hungry ";
        if (isPlayful) status += "Playful ";
        if (!isHungry && !isPlayful) status += "Content ";
        return status.trim();
    }
    
    public String getName() { return name; }
    public String getBreed() { return breed; }
    public int getAge() { return age; }
    public String getOwner() { return owner; }
    public boolean isHungry() { return isHungry; }
    public boolean isPlayful() { return isPlayful; }
    public boolean isTrained() { return isTrained; }
}

class Cat implements Pet {
    private String name;
    private String color;
    private boolean isIndoor;
    
    public Cat(String name, String color, boolean isIndoor) {
        this.name = name;
        this.color = color;
        this.isIndoor = isIndoor;
    }
    
    @Override
    public void eat() {
        System.out.println("\n🐱 " + name + " is eating cat food delicately");
        System.out.println("*Purr purr* Enjoying the meal");
    }
    
    @Override
    public void play() {
        System.out.println("\n🧶 " + name + " is playing with a ball of yarn");
        System.out.println("Pouncing and batting at the yarn playfully");
    }
    
    public void meow() {
        System.out.println("Meow! Meow! - " + name + " says hello");
    }
}

public class InterfaceInheritance {
    public static void main(String[] args) {
        System.out.println("=== Interface Inheritance (Extending Interface) Demo ===");
        
        Animal.animalFacts();
        System.out.println();
        Pet.petCareTips();
        
        Dog dog1 = new Dog("Buddy", "Golden Retriever", 3, "John Smith", "Chicken treats", "Frisbee");
        Dog dog2 = new Dog("Max", "German Shepherd", 5, "Alice Johnson", "Beef jerky", "Rope toy");
        Cat cat = new Cat("Whiskers", "Orange", true);
        
        System.out.println("\n=== Dog 1 Comprehensive Demo ===");
        dog1.displayDogInfo();
        
        // Test Animal interface methods (inherited through Pet)
        dog1.eat();
        dog1.sleep();
        
        // Test Pet interface methods
        dog1.play();
        dog1.showAffection();
        dog1.respondToName();
        
        // Test Dog-specific methods
        dog1.bark();
        dog1.goForWalk();
        
        // Training demonstration
        dog1.learnTrick("Sit");
        dog1.learnTrick("Stay");
        dog1.learnTrick("Roll Over");
        dog1.performTrick("Sit");
        dog1.performTrick("Jump"); // Unknown trick
        
        System.out.println("\n" + "=".repeat(70));
        System.out.println("\n=== Dog 2 Demo ===");
        dog2.displayDogInfo();
        dog2.eat();
        dog2.play();
        dog2.bark();
        
        System.out.println("\n" + "=".repeat(70));
        System.out.println("\n=== Cat Demo ===");
        cat.eat();
        cat.play();
        cat.showAffection();
        cat.meow();
        
        System.out.println("\n=== Interface Inheritance Demonstration ===");
        
        // Using Animal reference (base interface)
        System.out.println("\nUsing Animal references:");
        Animal animal1 = new Dog("Rex", "Bulldog", 2, "Bob Wilson");
        Animal animal2 = new Cat("Fluffy", "White", true);
        
        animal1.eat();
        animal1.sleep();
        animal2.eat();
        animal2.sleep();
        
        // Using Pet reference (extended interface)
        System.out.println("\nUsing Pet references:");
        Pet pet1 = new Dog("Luna", "Husky", 4, "Carol Davis");
        Pet pet2 = new Cat("Shadow", "Black", false);
        
        // Pet interface has both Animal methods (inherited) and Pet methods
        pet1.eat();    // From Animal interface
        pet1.play();   // From Pet interface
        pet1.showAffection(); // Default method from Pet interface
        
        pet2.eat();    // From Animal interface
        pet2.play();   // From Pet interface
        pet2.respondToName(); // Default method from Pet interface
        
        System.out.println("\n=== Polymorphic Array Processing ===");
        Pet[] pets = {dog1, dog2, cat, pet1, pet2};
        
        System.out.println("Feeding time for all pets:");
        for (Pet pet : pets) {
            pet.eat();
        }
        
        System.out.println("\nPlay time for all pets:");
        for (Pet pet : pets) {
            pet.play();
        }
        
        System.out.println("\nAffection time for all pets:");
        for (Pet pet : pets) {
            pet.showAffection();
        }
        
        System.out.println("\n=== Daily Pet Care Routine ===");
        System.out.println("Morning routine for " + dog1.getName() + ":");
        dog1.respondToName();
        dog1.eat();
        dog1.goForWalk();
        dog1.play();
        
        System.out.println("\nEvening routine for " + dog1.getName() + ":");
        dog1.eat();
        dog1.showAffection();
        dog1.performTrick("Stay");
        dog1.sleep();
        
        System.out.println("\n=== Key Learning Points ===");
        System.out.println("1. Pet interface extends Animal interface (interface inheritance)");
        System.out.println("2. Dog implements Pet, so it must implement both Animal and Pet methods");
        System.out.println("3. Interface inheritance creates an 'is-a' relationship hierarchy");
        System.out.println("4. Pet objects can be referenced as both Pet and Animal types");
        System.out.println("5. Default methods in interfaces provide additional functionality");
        System.out.println("6. Static methods in interfaces offer utility functions");
        System.out.println("7. Multiple levels of interface inheritance are possible");
        System.out.println("8. Polymorphism works with interface inheritance hierarchies");
    }
}