// File: InteractiveStoryGenerator.java
// PRACTICE PROBLEM 4: Complete Inheritance System
// Topic: Combining all inheritance concepts in a comprehensive story system

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InteractiveStoryGenerator {
    
    // Base Character class
    public static abstract class Character {
        protected String name;
        protected int health;
        protected int level;
        protected String characterClass;
        protected List<String> abilities;
        
        public Character(String name, int health, int level, String characterClass) {
            this.name = name;
            this.health = health;
            this.level = level;
            this.characterClass = characterClass;
            this.abilities = new ArrayList<>();
            System.out.println("Character " + name + " created as " + characterClass);
        }
        
        public abstract void performSpecialAbility();
        public abstract String getCharacterDescription();
        
        public void attack(Character target) {
            int damage = level * 10;
            target.takeDamage(damage);
            System.out.println(name + " attacks " + target.name + " for " + damage + " damage!");
        }
        
        public void takeDamage(int damage) {
            health -= damage;
            if (health < 0) health = 0;
            System.out.println(name + " takes " + damage + " damage. Health: " + health);
        }
        
        public boolean isAlive() {
            return health > 0;
        }
        
        public void levelUp() {
            level++;
            health += 20;
            System.out.println(name + " leveled up to " + level + "! Health increased to " + health);
        }
        
        public final void displayStats() {
            System.out.println("=== " + name + " Stats ===");
            System.out.println("Class: " + characterClass + ", Level: " + level + ", Health: " + health);
            System.out.println("Abilities: " + String.join(", ", abilities));
        }
    }
    
    // Warrior class - focuses on physical combat
    public static class Warrior extends Character {
        private int strength;
        private String weaponType;
        private boolean hasShield;
        
        public Warrior(String name, int strength, String weaponType, boolean hasShield) {
            super(name, 120, 1, "Warrior");
            this.strength = strength;
            this.weaponType = weaponType;
            this.hasShield = hasShield;
            abilities.add("Power Strike");
            abilities.add("Shield Block");
            System.out.println("Warrior equipped with " + weaponType);
        }
        
        @Override
        public void performSpecialAbility() {
            System.out.println(name + " performs POWER STRIKE with " + weaponType + "!");
            System.out.println("Deals " + (strength * 2) + " bonus damage!");
        }
        
        @Override
        public String getCharacterDescription() {
            return "A mighty warrior wielding " + weaponType + 
                   (hasShield ? " and shield" : "") + " with " + strength + " strength";
        }
        
        @Override
        public void attack(Character target) {
            System.out.println(name + " swings " + weaponType + " at " + target.name + "!");
            super.attack(target);
            if (hasShield && new Random().nextBoolean()) {
                System.out.println(name + " blocks incoming damage with shield!");
            }
        }
        
        public void chargeAttack(Character target) {
            System.out.println(name + " charges forward with " + weaponType + "!");
            int chargeDamage = (level * 15) + strength;
            target.takeDamage(chargeDamage);
        }
        
        public void defendAlly(Character ally) {
            System.out.println(name + " moves to protect " + ally.name + " with shield!");
        }
    }
    
    // Mage class - focuses on magical abilities
    public static class Mage extends Character {
        private int mana;
        private String magicSchool;
        private List<String> spells;
        
        public Mage(String name, int mana, String magicSchool) {
            super(name, 80, 1, "Mage");
            this.mana = mana;
            this.magicSchool = magicSchool;
            this.spells = new ArrayList<>();
            spells.add("Fireball");
            spells.add("Heal");
            spells.add("Lightning Bolt");
            abilities.add("Cast Spell");
            abilities.add("Mana Shield");
            System.out.println("Mage specialized in " + magicSchool + " magic");
        }
        
        @Override
        public void performSpecialAbility() {
            if (mana >= 20) {
                String spell = spells.get(new Random().nextInt(spells.size()));
                System.out.println(name + " casts " + spell + " using " + magicSchool + " magic!");
                mana -= 20;
                System.out.println("Mana remaining: " + mana);
            } else {
                System.out.println(name + " is out of mana!");
            }
        }
        
        @Override
        public String getCharacterDescription() {
            return "A wise mage of " + magicSchool + " school with " + mana + " mana points";
        }
        
        @Override
        public void attack(Character target) {
            System.out.println(name + " casts a spell at " + target.name + "!");
            super.attack(target);
            mana -= 10;
        }
        
        public void healAlly(Character ally) {
            if (mana >= 15) {
                int healAmount = level * 15;
                ally.health += healAmount;
                mana -= 15;
                System.out.println(name + " heals " + ally.name + " for " + healAmount + " health!");
            }
        }
        
        public void restoreMana() {
            mana += 30;
            System.out.println(name + " meditates and restores mana to " + mana);
        }
    }
    
    // Rogue class - focuses on stealth and agility
    public static class Rogue extends Character {
        private int agility;
        private boolean isStealthed;
        private int criticalChance;
        
        public Rogue(String name, int agility, int criticalChance) {
            super(name, 100, 1, "Rogue");
            this.agility = agility;
            this.criticalChance = criticalChance;
            this.isStealthed = false;
            abilities.add("Stealth");
            abilities.add("Critical Strike");
            abilities.add("Poison Blade");
            System.out.println("Rogue with " + agility + " agility created");
        }
        
        @Override
        public void performSpecialAbility() {
            if (!isStealthed) {
                isStealthed = true;
                System.out.println(name + " vanishes into the shadows!");
                System.out.println("Next attack will be a critical strike!");
            } else {
                System.out.println(name + " is already stealthed!");
            }
        }
        
        @Override
        public String getCharacterDescription() {
            return "A nimble rogue with " + agility + " agility and " + 
                   criticalChance + "% critical chance";
        }
        
        @Override
        public void attack(Character target) {
            if (isStealthed) {
                System.out.println(name + " strikes from the shadows!");
                int criticalDamage = level * 20;
                target.takeDamage(criticalDamage);
                isStealthed = false;
                System.out.println("Critical hit for " + criticalDamage + " damage!");
            } else {
                System.out.println(name + " attacks swiftly with daggers!");
                super.attack(target);
                if (new Random().nextInt(100) < criticalChance) {
                    System.out.println("Critical hit!");
                    target.takeDamage(level * 5);
                }
            }
        }
        
        public void pickLock() {
            System.out.println(name + " skillfully picks the lock with " + agility + " agility!");
        }
        
        public void disarmTrap() {
            System.out.println(name + " carefully disarms the trap!");
        }
    }
    
    // Story management class
    public static class StoryManager {
        private List<Character> party;
        private Random random;
        
        public StoryManager() {
            this.party = new ArrayList<>();
            this.random = new Random();
        }
        
        public void addCharacter(Character character) {
            party.add(character);
            System.out.println(character.name + " joins the party!");
        }
        
        public void displayParty() {
            System.out.println("\n=== Current Party ===");
            for (Character character : party) {
                character.displayStats();
                System.out.println("Description: " + character.getCharacterDescription());
                System.out.println();
            }
        }
        
        public void simulateBattle() {
            System.out.println("\n=== Battle Simulation ===");
            
            if (party.size() < 2) {
                System.out.println("Need at least 2 characters for battle!");
                return;
            }
            
            Character attacker = party.get(0);
            Character defender = party.get(1);
            
            System.out.println(attacker.name + " vs " + defender.name);
            
            // Demonstrate polymorphic behavior
            attacker.performSpecialAbility();
            attacker.attack(defender);
            
            if (defender.isAlive()) {
                defender.performSpecialAbility();
                defender.attack(attacker);
            }
        }
        
        public void demonstratePolymorphism() {
            System.out.println("\n=== Polymorphic Behavior Demonstration ===");
            
            for (Character character : party) {
                System.out.println("\n" + character.name + ":");
                character.performSpecialAbility();
                System.out.println("Description: " + character.getCharacterDescription());
                
                // Type-specific actions
                if (character instanceof Warrior) {
                    Warrior warrior = (Warrior) character;
                    warrior.defendAlly(party.get(0));
                } else if (character instanceof Mage) {
                    Mage mage = (Mage) character;
                    mage.restoreMana();
                } else if (character instanceof Rogue) {
                    Rogue rogue = (Rogue) character;
                    rogue.pickLock();
                }
            }
        }
        
        public void levelUpParty() {
            System.out.println("\n=== Party Level Up ===");
            for (Character character : party) {
                character.levelUp();
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Interactive Story Generator ===");
        
        StoryManager story = new StoryManager();
        
        System.out.println("\n=== Creating Characters ===");
        
        // Create different character types
        Warrior knight = new Warrior("Sir Galahad", 18, "Longsword", true);
        Mage wizard = new Mage("Gandalf", 100, "Elemental");
        Rogue assassin = new Rogue("Shadow", 20, 25);
        
        // Add to party
        story.addCharacter(knight);
        story.addCharacter(wizard);
        story.addCharacter(assassin);
        
        // Display initial party
        story.displayParty();
        
        System.out.println("\n=== Testing Inheritance Features ===");
        
        // Test method overriding
        System.out.println("\n1. Method Overriding Test:");
        knight.attack(wizard);
        wizard.attack(assassin);
        assassin.attack(knight);
        
        // Test polymorphic behavior
        story.demonstratePolymorphism();
        
        // Test special abilities
        System.out.println("\n=== Special Abilities Test ===");
        knight.performSpecialAbility();
        wizard.performSpecialAbility();
        assassin.performSpecialAbility();
        
        // Test type-specific methods
        System.out.println("\n=== Type-Specific Methods ===");
        knight.chargeAttack(wizard);
        wizard.healAlly(knight);
        assassin.disarmTrap();
        
        // Simulate battle
        story.simulateBattle();
        
        // Level up party
        story.levelUpParty();
        
        // Final party status
        story.displayParty();
        
        System.out.println("\n=== Inheritance Relationships Test ===");
        
        // Test instanceof
        Character[] characters = {knight, wizard, assassin};
        for (Character c : characters) {
            System.out.println(c.name + " instanceof Character: " + (c instanceof Character));
            System.out.println(c.name + " instanceof Warrior: " + (c instanceof Warrior));
            System.out.println(c.name + " instanceof Mage: " + (c instanceof Mage));
            System.out.println(c.name + " instanceof Rogue: " + (c instanceof Rogue));
            System.out.println();
        }
        
        System.out.println("=== Story Complete ===");
    }
}