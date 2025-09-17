// Medieval Kingdom Builder with Magic System - Extra Practice Problem 2
import java.util.*;

final class KingdomConfig {
    private final String kingdomName;
    private final int foundingYear;
    private final String[] allowedStructureTypes;
    private final Map<String, Integer> resourceLimits;
    
    public KingdomConfig(String kingdomName, int foundingYear, String[] allowedStructureTypes, Map<String, Integer> resourceLimits) {
        this.kingdomName = kingdomName;
        this.foundingYear = foundingYear;
        this.allowedStructureTypes = allowedStructureTypes.clone();
        this.resourceLimits = new HashMap<>(resourceLimits);
    }
    
    public static KingdomConfig createDefaultKingdom() {
        String[] types = {"Castle", "Tower", "Wall", "Farm"};
        Map<String, Integer> limits = new HashMap<>();
        limits.put("Gold", 1000);
        limits.put("Stone", 500);
        limits.put("Wood", 300);
        return new KingdomConfig("Default Kingdom", 2024, types, limits);
    }
    
    public String getKingdomName() { return kingdomName; }
    public int getFoundingYear() { return foundingYear; }
    public String[] getAllowedStructureTypes() { return allowedStructureTypes.clone(); }
    public Map<String, Integer> getResourceLimits() { return new HashMap<>(resourceLimits); }
}

class MagicalStructure {
    private final String structureId;
    private final long constructionTimestamp;
    private final String structureName;
    private final String location;
    private int magicPower;
    private boolean isActive;
    private String currentMaintainer;
    
    static final int MIN_MAGIC_POWER = 0;
    static final int MAX_MAGIC_POWER = 1000;
    public static final String MAGIC_SYSTEM_VERSION = "3.0";
    
    public MagicalStructure(String name, String location) {
        this(name, location, 100, true);
    }
    
    public MagicalStructure(String name, String location, int power) {
        this(name, location, power, true);
    }
    
    public MagicalStructure(String name, String location, int power, boolean active) {
        this.structureId = "STR" + System.currentTimeMillis();
        this.constructionTimestamp = System.currentTimeMillis();
        this.structureName = name;
        this.location = location;
        this.magicPower = Math.max(MIN_MAGIC_POWER, Math.min(MAX_MAGIC_POWER, power));
        this.isActive = active;
        this.currentMaintainer = "None";
    }
    
    public String getStructureName() { return structureName; }
    public String getLocation() { return location; }
    public int getMagicPower() { return magicPower; }
    public boolean isActive() { return isActive; }
}

class WizardTower extends MagicalStructure {
    private final int maxSpellCapacity;
    private List<String> knownSpells;
    private String currentWizard;
    
    public WizardTower() {
        super("Wizard Tower", "Central");
        this.maxSpellCapacity = 10;
        this.knownSpells = new ArrayList<>();
        this.currentWizard = "None";
    }
    
    public WizardTower(String location, int spellCapacity) {
        super("Wizard Tower", location, 200);
        this.maxSpellCapacity = spellCapacity;
        this.knownSpells = new ArrayList<>();
        this.currentWizard = "None";
    }
    
    public WizardTower(String location, int spellCapacity, String wizard) {
        super("Wizard Tower", location, 300, true);
        this.maxSpellCapacity = spellCapacity;
        this.knownSpells = new ArrayList<>();
        this.currentWizard = wizard;
    }
}

class EnchantedCastle extends MagicalStructure {
    private final String castleType;
    private int defenseRating;
    private boolean hasDrawbridge;
    
    public EnchantedCastle() {
        super("Enchanted Castle", "Kingdom Center");
        this.castleType = "Royal";
        this.defenseRating = 100;
        this.hasDrawbridge = true;
    }
    
    public EnchantedCastle(String location, String type) {
        super("Enchanted Castle", location, 500);
        this.castleType = type;
        this.defenseRating = type.equals("Fortress") ? 200 : 100;
        this.hasDrawbridge = true;
    }
}

class MysticLibrary extends MagicalStructure {
    private final Map<String, String> bookCollection;
    private int knowledgeLevel;
    
    public MysticLibrary() {
        super("Mystic Library", "Academy");
        this.bookCollection = new HashMap<>();
        this.knowledgeLevel = 50;
    }
    
    public MysticLibrary(String location, int initialBooks) {
        super("Mystic Library", location, 150);
        this.bookCollection = new HashMap<>();
        this.knowledgeLevel = initialBooks * 2;
    }
}

class DragonLair extends MagicalStructure {
    private final String dragonType;
    private long treasureValue;
    private int territorialRadius;
    
    public DragonLair() {
        super("Dragon Lair", "Mountain");
        this.dragonType = "Fire";
        this.treasureValue = 1000;
        this.territorialRadius = 5;
    }
    
    public DragonLair(String location, String dragonType) {
        super("Dragon Lair", location, 800);
        this.dragonType = dragonType;
        this.treasureValue = dragonType.equals("Ancient") ? 5000 : 1000;
        this.territorialRadius = 10;
    }
}

class KingdomManager {
    private final List<Object> structures;
    private final KingdomConfig config;
    
    public KingdomManager(KingdomConfig config) {
        this.structures = new ArrayList<>();
        this.config = config;
    }
    
    public static boolean canStructuresInteract(Object s1, Object s2) {
        if (s1 instanceof WizardTower && s2 instanceof MysticLibrary) {
            return true; // Wizards can use libraries
        }
        if (s1 instanceof DragonLair && s2 instanceof EnchantedCastle) {
            return true; // Dragons can attack castles
        }
        return false;
    }
    
    public static String performMagicBattle(Object attacker, Object defender) {
        if (attacker instanceof DragonLair && defender instanceof WizardTower) {
            return "Dragon breathes fire at the tower!";
        }
        if (attacker instanceof WizardTower && defender instanceof DragonLair) {
            return "Wizard casts protective spells!";
        }
        return "No battle possible";
    }
    
    public static int calculateKingdomPower(Object[] structures) {
        int totalPower = 0;
        for (Object obj : structures) {
            if (obj instanceof MagicalStructure) {
                MagicalStructure structure = (MagicalStructure) obj;
                totalPower += structure.getMagicPower();
            }
        }
        return totalPower;
    }
    
    private String determineStructureCategory(Object structure) {
        if (structure instanceof WizardTower) return "Magical Education";
        if (structure instanceof EnchantedCastle) return "Defense";
        if (structure instanceof MysticLibrary) return "Knowledge";
        if (structure instanceof DragonLair) return "Danger Zone";
        return "Unknown";
    }
}

public class MedievalKingdom {
    public static void main(String[] args) {
        System.out.println("=== Medieval Kingdom Builder ===");
        
        KingdomConfig config = KingdomConfig.createDefaultKingdom();
        KingdomManager manager = new KingdomManager(config);
        
        // Create structures with different constructors
        WizardTower tower1 = new WizardTower();
        WizardTower tower2 = new WizardTower("North Gate", 15);
        EnchantedCastle castle1 = new EnchantedCastle();
        EnchantedCastle castle2 = new EnchantedCastle("South Wall", "Fortress");
        MysticLibrary library = new MysticLibrary("Academy District", 100);
        DragonLair lair = new DragonLair("Dark Mountain", "Ancient");
        
        Object[] structures = {tower1, tower2, castle1, castle2, library, lair};
        
        // Test instanceof interactions
        System.out.println("Structure interactions:");
        System.out.println("Tower-Library: " + KingdomManager.canStructuresInteract(tower1, library));
        System.out.println("Dragon-Castle: " + KingdomManager.canStructuresInteract(lair, castle1));
        
        System.out.println("\nMagic battles:");
        System.out.println(KingdomManager.performMagicBattle(lair, tower1));
        System.out.println(KingdomManager.performMagicBattle(tower2, lair));
        
        System.out.println("\nTotal Kingdom Power: " + KingdomManager.calculateKingdomPower(structures));
    }
}