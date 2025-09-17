abstract class MagicalStructure {
    protected String structureName;
    protected int magicPower;
    protected String location;
    protected boolean isActive;
    
    public MagicalStructure() {
        this("Unknown Structure", 10, "Nowhere");
    }
    
    public MagicalStructure(String structureName, int magicPower, String location) {
        this.structureName = structureName;
        this.magicPower = magicPower;
        this.location = location;
        this.isActive = true;
    }
    
    public abstract String castMagicSpell();
}

class WizardTower extends MagicalStructure {
    private int spellCapacity;
    private String[] knownSpells;
    
    public WizardTower() {
        this("Basic Tower", 50, "Hill", 5);
    }
    
    public WizardTower(String name, int power, String location, int capacity) {
        super(name, power, location);
        this.spellCapacity = capacity;
        this.knownSpells = new String[capacity];
    }
    
    public String castMagicSpell() {
        return structureName + " casts a powerful spell!";
    }
}

class EnchantedCastle extends MagicalStructure {
    private int defenseRating;
    private boolean hasDrawbridge;
    
    public EnchantedCastle() {
        this("Stone Castle", 100, "Valley", 80, true);
    }
    
    public EnchantedCastle(String name, int power, String location, int defense, boolean drawbridge) {
        super(name, power, location);
        this.defenseRating = defense;
        this.hasDrawbridge = drawbridge;
    }
    
    public String castMagicSpell() {
        return structureName + " raises magical barriers!";
    }
}

class DragonLair extends MagicalStructure {
    private String dragonType;
    private int treasureValue;
    
    public DragonLair(String name, String dragonType, int treasure) {
        super(name, 150, "Mountain");
        this.dragonType = dragonType;
        this.treasureValue = treasure;
    }
    
    public String castMagicSpell() {
        return structureName + " summons " + dragonType + " dragon!";
    }
}

public class MagicalKingdom {
    public static boolean canStructuresInteract(MagicalStructure s1, MagicalStructure s2) {
        if (s1 instanceof WizardTower && s2 instanceof EnchantedCastle) return true;
        if (s1 instanceof EnchantedCastle && s2 instanceof DragonLair) return true;
        return false;
    }
    
    public static String performMagicBattle(MagicalStructure attacker, MagicalStructure defender) {
        if (attacker instanceof WizardTower && defender instanceof DragonLair) {
            return "Epic magical duel! Tower vs Dragon!";
        }
        return "Standard magical conflict";
    }
    
    public static int calculateKingdomMagicPower(MagicalStructure[] structures) {
        int totalPower = 0;
        int towerCount = 0;
        
        for (MagicalStructure structure : structures) {
            totalPower += structure.magicPower;
            if (structure instanceof WizardTower) {
                towerCount++;
            }
        }
        
        if (towerCount > 1) {
            totalPower *= 1.5; // Magic network bonus
        }
        
        return totalPower;
    }
    
    public static void main(String[] args) {
        System.out.println("=== MAGICAL KINGDOM BUILDER ===");
        
        WizardTower tower1 = new WizardTower();
        EnchantedCastle castle1 = new EnchantedCastle();
        DragonLair lair1 = new DragonLair("Ancient Lair", "Fire", 10000);
        
        MagicalStructure[] kingdom = {tower1, castle1, lair1};
        
        System.out.println(tower1.castMagicSpell());
        System.out.println(castle1.castMagicSpell());
        System.out.println(lair1.castMagicSpell());
        
        System.out.println("Can tower and castle interact? " + canStructuresInteract(tower1, castle1));
        System.out.println("Battle result: " + performMagicBattle(tower1, lair1));
        System.out.println("Kingdom magic power: " + calculateKingdomMagicPower(kingdom));
    }
}