public class VirtualPet {
    private final String petId;
    private String petName;
    private String species;
    private int age;
    private int happiness;
    private int health;
    private String evolutionStage;
    
    private static final String[] EVOLUTION_STAGES = {"Egg", "Baby", "Child", "Teen", "Adult", "Elder"};
    private static int totalPetsCreated = 0;
    
    public VirtualPet() {
        this("Mystery Pet", "Unknown", 0, 50, 100);
        this.evolutionStage = "Egg";
    }
    
    public VirtualPet(String petName) {
        this(petName, "Cat", 1, 60, 90);
        this.evolutionStage = "Baby";
    }
    
    public VirtualPet(String petName, String species) {
        this(petName, species, 3, 70, 85);
        this.evolutionStage = "Child";
    }
    
    public VirtualPet(String petName, String species, int age, int happiness, int health) {
        this.petId = generatePetId();
        this.petName = petName;
        this.species = species;
        this.age = age;
        this.happiness = happiness;
        this.health = health;
        this.evolutionStage = "Adult";
        totalPetsCreated++;
    }
    
    private static String generatePetId() {
        return "PET-" + (int)(Math.random() * 10000);
    }
    
    public void evolvePet() {
        if (health > 0 && age >= 5 && happiness > 70) {
            int currentStage = 0;
            for (int i = 0; i < EVOLUTION_STAGES.length; i++) {
                if (EVOLUTION_STAGES[i].equals(evolutionStage)) {
                    currentStage = i;
                    break;
                }
            }
            if (currentStage < EVOLUTION_STAGES.length - 1) {
                evolutionStage = EVOLUTION_STAGES[currentStage + 1];
                System.out.println(petName + " evolved to " + evolutionStage + "!");
            }
        }
    }
    
    public void feedPet() {
        happiness += 10;
        health += 5;
        System.out.println(petName + " has been fed!");
    }
    
    public void playWithPet() {
        happiness += 15;
        health -= 2;
        System.out.println("Played with " + petName + "!");
    }
    
    public void simulateDay() {
        age++;
        happiness -= 5;
        health -= 3;
        if (health <= 0) {
            species = "Ghost";
            System.out.println(petName + " became a ghost!");
        }
    }
    
    public String getPetStatus() {
        return petName + " (" + species + ") - Stage: " + evolutionStage + 
               ", Age: " + age + ", Happiness: " + happiness + ", Health: " + health;
    }
    
    public static void main(String[] args) {
        System.out.println("=== VIRTUAL PET DAYCARE ===");
        
        VirtualPet pet1 = new VirtualPet();
        VirtualPet pet2 = new VirtualPet("Fluffy");
        VirtualPet pet3 = new VirtualPet("Rex", "Dog");
        
        System.out.println("Initial Status:");
        System.out.println(pet1.getPetStatus());
        System.out.println(pet2.getPetStatus());
        System.out.println(pet3.getPetStatus());
        
        for (int day = 1; day <= 3; day++) {
            System.out.println("\n--- Day " + day + " ---");
            pet1.feedPet();
            pet2.playWithPet();
            pet3.feedPet();
            
            pet1.simulateDay();
            pet2.simulateDay();
            pet3.simulateDay();
            
            pet1.evolvePet();
            pet2.evolvePet();
            pet3.evolvePet();
        }
        
        System.out.println("\nFinal Status:");
        System.out.println(pet1.getPetStatus());
        System.out.println(pet2.getPetStatus());
        System.out.println(pet3.getPetStatus());
        System.out.println("Total pets created: " + totalPetsCreated);
    }
}