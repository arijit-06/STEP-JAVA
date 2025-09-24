// LAB 3: Gaming Character System - Dynamic Method Dispatch
abstract class Character {
    protected String name;
    protected int health;
    protected int level;
    
    public Character(String name, int health, int level) {
        this.name = name;
        this.health = health;
        this.level = level;
    }
    
    public abstract void attack();
    public abstract void defend();
    
    public void displayStats() {
        System.out.println(name + " (Level " + level + ", Health: " + health + ")");
    }
}

class Warrior extends Character {
    private String weapon;
    private int defense;
    
    public Warrior(String name, String weapon) {
        super(name, 120, 1);
        this.weapon = weapon;
        this.defense = 80;
    }
    
    @Override
    public void attack() {
        int damage = 45 + (level * 5);
        System.out.println("⚔️ " + name + " swings " + weapon + " dealing " + damage + " damage!");
    }
    
    @Override
    public void defend() {
        System.out.println("🛡️ " + name + " raises shield (Defense: " + defense + ")");
    }
}

class Mage extends Character {
    private int mana;
    private String spell;
    
    public Mage(String name, String spell) {
        super(name, 80, 1);
        this.mana = 100;
        this.spell = spell;
    }
    
    @Override
    public void attack() {
        if (mana >= 20) {
            int damage = 60 + (level * 8);
            mana -= 20;
            System.out.println("🔮 " + name + " casts " + spell + " for " + damage + " magic damage! (Mana: " + mana + ")");
        } else {
            System.out.println("💫 " + name + " is out of mana!");
        }
    }
    
    @Override
    public void defend() {
        System.out.println("✨ " + name + " creates magic barrier");
    }
}

class Archer extends Character {
    private int arrows;
    private int range;
    
    public Archer(String name) {
        super(name, 90, 1);
        this.arrows = 30;
        this.range = 150;
    }
    
    @Override
    public void attack() {
        if (arrows > 0) {
            int damage = 35 + (level * 6);
            arrows--;
            System.out.println("🏹 " + name + " shoots arrow for " + damage + " damage from " + range + "m! (Arrows: " + arrows + ")");
        } else {
            System.out.println("🎯 " + name + " is out of arrows!");
        }
    }
    
    @Override
    public void defend() {
        System.out.println("🏃 " + name + " dodges with agility");
    }
}

public class GamingCharacterSystem {
    public static void battleSimulation(Character[] army) {
        System.out.println("=== Battle Simulation ===");
        for (Character character : army) {
            character.displayStats();
            character.attack();
            character.defend();
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        Character[] mixedArmy = {
            new Warrior("Thorin", "Battle Axe"),
            new Mage("Gandalf", "Fireball"),
            new Archer("Legolas"),
            new Warrior("Aragorn", "Sword"),
            new Mage("Saruman", "Lightning Bolt")
        };
        
        battleSimulation(mixedArmy);
    }
}