// Virtual Pet Evolution Simulator - Extra Practice Problem 1
import java.util.*;

class Pet {
    // Static fields for tracking
    private static int totalPetsCreated = 0;
    private static Map<String, Integer> speciesCounts = new HashMap<>();
    private static final String[] DEFAULT_SPECIES = {"Dog", "Cat", "Bird", "Fish", "Hamster"};
    
    // Instance fields
    private String petId;
    private String name;
    private String species;
    private int age;
    private int happiness;
    private int health;
    private int evolutionStage;
    
    // Static initialization block
    static {
        System.out.println("Pet class initialized - Evolution system ready!");
        for (String species : DEFAULT_SPECIES) {
            speciesCounts.put(species, 0);
        }
    }
    
    // Default constructor - creates random pet
    public Pet() {
        this(generateRandomName(), getRandomSpecies());
    }
    
    // Constructor with name only
    public Pet(String name) {
        this(name, getRandomSpecies(), 50, 50);
    }
    
    // Constructor with name and species
    public Pet(String name, String species) {
        this(name, species, 60, 60);
    }
    
    // Main constructor - all others chain to this
    public Pet(String name, String species, int happiness, int health) {
        this.petId = "PET" + String.format("%03d", ++totalPetsCreated);
        this.name = (name != null && !name.trim().isEmpty()) ? name : "Unnamed Pet";
        this.species = (species != null) ? species : "Unknown";
        this.age = 0;
        this.happiness = Math.max(0, Math.min(100, happiness));
        this.health = Math.max(0, Math.min(100, health));
        this.evolutionStage = 1;
        
        // Update species count
        speciesCounts.put(this.species, speciesCounts.getOrDefault(this.species, 0) + 1);
        
        System.out.println("New pet created: " + this.name + " the " + this.species + " (ID: " + this.petId + ")");
    }
    
    // Static utility methods
    private static String generateRandomName() {
        String[] names = {"Buddy", "Luna", "Max", "Bella", "Charlie", "Lucy", "Cooper", "Daisy"};
        return names[new Random().nextInt(names.length)];
    }
    
    private static String getRandomSpecies() {
        return DEFAULT_SPECIES[new Random().nextInt(DEFAULT_SPECIES.length)];
    }
    
    public static int getTotalPetsCreated() {
        return totalPetsCreated;
    }
    
    public static Map<String, Integer> getSpeciesCounts() {
        return new HashMap<>(speciesCounts);
    }
    
    public static void displayGlobalStats() {
        System.out.println("\n=== Global Pet Statistics ===");
        System.out.println("Total pets created: " + totalPetsCreated);
        System.out.println("Species distribution:");
        for (Map.Entry<String, Integer> entry : speciesCounts.entrySet()) {
            System.out.println("  " + entry.getKey() + ": " + entry.getValue());
        }
    }
    
    public static void resetGlobalStats() {
        totalPetsCreated = 0;
        speciesCounts.clear();
        for (String species : DEFAULT_SPECIES) {
            speciesCounts.put(species, 0);
        }
        System.out.println("Global pet statistics reset");
    }
    
    // Instance methods using 'this' for method chaining
    public Pet feed(String foodType) {
        System.out.println("Feeding " + this.name + " with " + foodType);
        this.happiness += 10;
        this.health += 5;
        this.checkEvolution();
        return this; // Method chaining
    }
    
    public Pet play(String gameType) {
        System.out.println(this.name + " is playing " + gameType);
        this.happiness += 15;
        this.health += 3;
        this.age++;
        this.checkEvolution();
        return this; // Method chaining
    }
    
    public Pet rest() {
        System.out.println(this.name + " is resting");
        this.health += 20;
        this.happiness += 5;
        return this; // Method chaining
    }
    
    public Pet train() {
        System.out.println(this.name + " is training");
        this.happiness += 8;
        this.health += 10;
        this.checkEvolution();
        return this; // Method chaining
    }
    
    private void checkEvolution() {
        int oldStage = this.evolutionStage;
        if (this.happiness > 80 && this.health > 80 && this.age > 10) {
            this.evolutionStage = 3; // Fully evolved
        } else if (this.happiness > 60 && this.health > 60 && this.age > 5) {
            this.evolutionStage = 2; // Intermediate
        }
        
        if (this.evolutionStage > oldStage) {
            System.out.println("🎉 " + this.name + " evolved to stage " + this.evolutionStage + "!");
        }
    }
    
    public void displayStatus() {
        System.out.println("\n=== " + this.name + " Status ===");
        System.out.println("ID: " + this.petId);
        System.out.println("Species: " + this.species);
        System.out.println("Age: " + this.age);
        System.out.println("Happiness: " + this.happiness + "/100");
        System.out.println("Health: " + this.health + "/100");
        System.out.println("Evolution Stage: " + this.evolutionStage + "/3");
    }
    
    // Getters
    public String getPetId() { return petId; }
    public String getName() { return name; }
    public String getSpecies() { return species; }
    public int getAge() { return age; }
    public int getHappiness() { return happiness; }
    public int getHealth() { return health; }
    public int getEvolutionStage() { return evolutionStage; }
}

// Pet Manager class demonstrating instanceof usage
class PetManager {
    private List<Object> pets; // Stores different pet types
    
    public PetManager() {
        this.pets = new ArrayList<>();
    }
    
    public void addPet(Object pet) {
        if (pet instanceof Pet) {
            pets.add(pet);
            Pet p = (Pet) pet;
            System.out.println("Added " + p.getName() + " to the pet collection");
        } else {
            System.out.println("Error: Can only add Pet objects");
        }
    }
    
    // Method using instanceof for different pet processing
    public void processPets() {
        System.out.println("\n=== Processing All Pets ===");
        for (Object obj : pets) {
            if (obj instanceof Pet) {
                Pet pet = (Pet) obj;
                System.out.println("Processing " + pet.getName() + " (" + pet.getSpecies() + ")");
                
                // Different care based on species using instanceof-like logic
                processSpecificCare(pet);
            }
        }
    }
    
    private void processSpecificCare(Pet pet) {
        String species = pet.getSpecies().toLowerCase();
        switch (species) {
            case "dog":
                System.out.println("  - Taking for a walk and playing fetch");
                break;
            case "cat":
                System.out.println("  - Providing scratching post and catnip");
                break;
            case "bird":
                System.out.println("  - Cleaning cage and providing fresh seeds");
                break;
            case "fish":
                System.out.println("  - Cleaning tank and checking water temperature");
                break;
            default:
                System.out.println("  - Providing general care");
        }
    }
    
    public void findPetsByEvolutionStage(int stage) {
        System.out.println("\n=== Pets at Evolution Stage " + stage + " ===");
        for (Object obj : pets) {
            if (obj instanceof Pet) {
                Pet pet = (Pet) obj;
                if (pet.getEvolutionStage() == stage) {
                    System.out.println("- " + pet.getName() + " (" + pet.getSpecies() + ")");
                }
            }
        }
    }
    
    public void displayManagerStats() {
        int totalPets = 0;
        Map<String, Integer> speciesCount = new HashMap<>();
        
        for (Object obj : pets) {
            if (obj instanceof Pet) {
                Pet pet = (Pet) obj;
                totalPets++;
                String species = pet.getSpecies();
                speciesCount.put(species, speciesCount.getOrDefault(species, 0) + 1);
            }
        }
        
        System.out.println("\n=== Pet Manager Statistics ===");
        System.out.println("Pets under management: " + totalPets);
        System.out.println("Species breakdown:");
        for (Map.Entry<String, Integer> entry : speciesCount.entrySet()) {
            System.out.println("  " + entry.getKey() + ": " + entry.getValue());
        }
    }
}

public class VirtualPetSystem {
    public static void main(String[] args) {
        System.out.println("=== Virtual Pet Evolution Simulator ===");
        
        // Demonstrate different constructor patterns
        Pet pet1 = new Pet(); // Default constructor
        Pet pet2 = new Pet("Fluffy"); // Name only
        Pet pet3 = new Pet("Rex", "Dog"); // Name and species
        Pet pet4 = new Pet("Whiskers", "Cat", 70, 80); // Full constructor
        
        // Display initial stats
        Pet.displayGlobalStats();
        
        // Demonstrate method chaining with 'this'
        System.out.println("\n=== Method Chaining Demo ===");
        pet1.feed("Premium Food")
            .play("Fetch")
            .rest()
            .train()
            .displayStatus();
        
        pet2.feed("Cat Food")
            .play("Laser Pointer")
            .feed("Treats")
            .play("Feather Toy")
            .displayStatus();
        
        // Create pet manager and demonstrate instanceof
        PetManager manager = new PetManager();
        manager.addPet(pet1);
        manager.addPet(pet2);
        manager.addPet(pet3);
        manager.addPet(pet4);
        manager.addPet("Not a pet"); // This should fail
        
        manager.processPets();
        manager.displayManagerStats();
        
        // More pet interactions
        System.out.println("\n=== Advanced Pet Care ===");
        pet3.feed("Dog Biscuits")
            .play("Tug of War")
            .train()
            .feed("Bone")
            .play("Ball")
            .displayStatus();
        
        pet4.feed("Fish")
            .play("Mouse Toy")
            .rest()
            .train()
            .displayStatus();
        
        // Find pets by evolution stage
        manager.findPetsByEvolutionStage(1);
        manager.findPetsByEvolutionStage(2);
        manager.findPetsByEvolutionStage(3);
        
        // Final statistics
        Pet.displayGlobalStats();
        
        // Demonstrate static method usage
        System.out.println("\n=== Creating More Pets ===");
        Pet pet5 = new Pet("Goldie", "Fish");
        Pet pet6 = new Pet("Tweety", "Bird");
        
        pet5.feed("Fish Flakes").rest().displayStatus();
        pet6.feed("Seeds").play("Mirror").train().displayStatus();
        
        Pet.displayGlobalStats();
        
        // Test instanceof with mixed objects
        System.out.println("\n=== instanceof Testing ===");
        Object[] objects = {pet1, pet2, "String", 42, pet3};
        
        for (Object obj : objects) {
            if (obj instanceof Pet) {
                Pet p = (Pet) obj;
                System.out.println("✓ " + p.getName() + " is a Pet");
            } else {
                System.out.println("✗ " + obj + " is not a Pet (it's a " + obj.getClass().getSimpleName() + ")");
            }
        }
    }
}