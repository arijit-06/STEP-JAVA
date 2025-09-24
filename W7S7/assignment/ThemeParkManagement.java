// ASSIGNMENT 4: Theme Park Management System - Complete Polymorphism Mastery
abstract class Attraction {
    protected String name;
    protected int capacity;
    protected boolean isOperational;
    protected double ticketPrice;
    
    public Attraction(String name, int capacity, double ticketPrice) {
        this.name = name;
        this.capacity = capacity;
        this.ticketPrice = ticketPrice;
        this.isOperational = true;
    }
    
    // Common entry method (inheritance)
    public void processEntry(String visitorName) {
        System.out.println("🎫 " + visitorName + " entering " + name + " - Welcome!");
    }
    
    // Abstract methods for polymorphic behavior
    public abstract void operate();
    public abstract void performSafetyCheck();
    
    // Method overloading for different ticket pricing
    public double calculateTicket() {
        System.out.println("💰 Standard ticket for " + name + ": $" + ticketPrice);
        return ticketPrice;
    }
    
    public double calculateTicket(boolean isChild) {
        double price = isChild ? ticketPrice * 0.7 : ticketPrice;
        String type = isChild ? "Child" : "Adult";
        System.out.println("💰 " + type + " ticket for " + name + ": $" + price);
        return price;
    }
    
    public double calculateTicket(int groupSize, double groupDiscount) {
        double totalPrice = ticketPrice * groupSize;
        double discount = totalPrice * (groupDiscount / 100);
        double finalPrice = totalPrice - discount;
        System.out.println("💰 Group ticket (" + groupSize + " people) for " + name + 
                         ": $" + finalPrice + " (Saved $" + discount + ")");
        return finalPrice;
    }
    
    public void displayInfo() {
        System.out.println("🎢 " + name + " - Capacity: " + capacity + 
                         " | Status: " + (isOperational ? "Open" : "Closed"));
    }
}

class RollerCoaster extends Attraction {
    private int heightRequirement;
    private String thrillLevel;
    private boolean safetyCheckPassed;
    
    public RollerCoaster(String name, int capacity, double ticketPrice, int heightRequirement, String thrillLevel) {
        super(name, capacity, ticketPrice);
        this.heightRequirement = heightRequirement;
        this.thrillLevel = thrillLevel;
        this.safetyCheckPassed = false;
    }
    
    @Override
    public void operate() {
        if (safetyCheckPassed) {
            System.out.println("🎢 " + name + " is operating! " + thrillLevel + " thrill level!");
            System.out.println("   Height requirement: " + heightRequirement + " inches minimum");
        } else {
            System.out.println("⚠️ " + name + " cannot operate - safety check required!");
        }
    }
    
    @Override
    public void performSafetyCheck() {
        safetyCheckPassed = true;
        System.out.println("✅ Safety check completed for " + name + " - All systems go!");
    }
    
    public boolean checkHeightRequirement(int visitorHeight) {
        boolean canRide = visitorHeight >= heightRequirement;
        if (canRide) {
            System.out.println("✅ Height check passed for " + name);
        } else {
            System.out.println("❌ Sorry, minimum height " + heightRequirement + " inches required for " + name);
        }
        return canRide;
    }
}

class WaterRide extends Attraction {
    private boolean requiresSwimming;
    private boolean weatherDependent;
    private String[] equipmentNeeded;
    
    public WaterRide(String name, int capacity, double ticketPrice, boolean requiresSwimming, String[] equipment) {
        super(name, capacity, ticketPrice);
        this.requiresSwimming = requiresSwimming;
        this.weatherDependent = true;
        this.equipmentNeeded = equipment;
    }
    
    @Override
    public void operate() {
        if (checkWeatherConditions()) {
            System.out.println("🌊 " + name + " is operating! Perfect weather for water fun!");
            if (requiresSwimming) {
                System.out.println("   Swimming ability required");
            }
        } else {
            System.out.println("🌧️ " + name + " closed due to weather conditions");
            isOperational = false;
        }
    }
    
    @Override
    public void performSafetyCheck() {
        System.out.println("🏊 Water safety check for " + name + " - Lifeguards on duty!");
    }
    
    private boolean checkWeatherConditions() {
        // Simulate weather check
        return Math.random() > 0.2; // 80% chance of good weather
    }
    
    public void rentEquipment(String visitorName) {
        System.out.print("🏊 Equipment rental for " + visitorName + ": ");
        for (String item : equipmentNeeded) {
            System.out.print(item + " ");
        }
        System.out.println("- $5 rental fee");
    }
}

class Show extends Attraction {
    private String[] showtimes;
    private String ageRating;
    private int currentShowIndex;
    
    public Show(String name, int capacity, double ticketPrice, String[] showtimes, String ageRating) {
        super(name, capacity, ticketPrice);
        this.showtimes = showtimes;
        this.ageRating = ageRating;
        this.currentShowIndex = 0;
    }
    
    @Override
    public void operate() {
        String currentTime = showtimes[currentShowIndex % showtimes.length];
        System.out.println("🎭 " + name + " show starting at " + currentTime);
        System.out.println("   Age rating: " + ageRating + " | Seating: " + capacity);
        currentShowIndex++;
    }
    
    @Override
    public void performSafetyCheck() {
        System.out.println("🎪 Safety check for " + name + " - Emergency exits clear, sound levels checked");
    }
    
    public void displaySchedule() {
        System.out.print("📅 " + name + " showtimes: ");
        for (String time : showtimes) {
            System.out.print(time + " ");
        }
        System.out.println();
    }
    
    public boolean checkAgeAppropriate(int visitorAge) {
        boolean appropriate = switch (ageRating) {
            case "G" -> true;
            case "PG" -> visitorAge >= 8;
            case "PG-13" -> visitorAge >= 13;
            case "R" -> visitorAge >= 17;
            default -> true;
        };
        
        if (!appropriate) {
            System.out.println("⚠️ " + name + " is rated " + ageRating + " - not suitable for age " + visitorAge);
        }
        return appropriate;
    }
}

class Game extends Attraction {
    private String skillLevel;
    private String[] prizes;
    private boolean allowsGroups;
    
    public Game(String name, int capacity, double ticketPrice, String skillLevel, String[] prizes) {
        super(name, capacity, ticketPrice);
        this.skillLevel = skillLevel;
        this.prizes = prizes;
        this.allowsGroups = true;
    }
    
    @Override
    public void operate() {
        System.out.println("🎯 " + name + " game is active! Skill level: " + skillLevel);
        System.out.print("   Win prizes: ");
        for (String prize : prizes) {
            System.out.print(prize + " | ");
        }
        System.out.println();
    }
    
    @Override
    public void performSafetyCheck() {
        System.out.println("🎮 Game safety check for " + name + " - Equipment secure, rules posted");
    }
    
    public void playGame(String playerName) {
        boolean won = Math.random() > 0.6; // 40% win rate
        if (won) {
            String prize = prizes[(int)(Math.random() * prizes.length)];
            System.out.println("🏆 " + playerName + " won " + prize + " at " + name + "!");
        } else {
            System.out.println("🎯 " + playerName + " played " + name + " - Better luck next time!");
        }
    }
}

public class ThemeParkManagement {
    public static void operateAttractions(Attraction[] attractions) {
        System.out.println("=== Daily Attraction Operations ===\n");
        
        for (Attraction attraction : attractions) {
            System.out.println("--- " + attraction.name + " ---");
            
            // Common entry processing (inheritance)
            attraction.processEntry("Guest");
            
            // Polymorphic operations (overriding)
            attraction.performSafetyCheck();
            attraction.operate();
            
            // Method overloading examples
            attraction.calculateTicket();
            attraction.calculateTicket(true); // Child ticket
            attraction.calculateTicket(5, 15.0); // Group discount
            
            // Safe downcasting for specific features
            if (attraction instanceof RollerCoaster) {
                RollerCoaster coaster = (RollerCoaster) attraction;
                coaster.checkHeightRequirement(48);
            } else if (attraction instanceof WaterRide) {
                WaterRide waterRide = (WaterRide) attraction;
                waterRide.rentEquipment("Alice");
            } else if (attraction instanceof Show) {
                Show show = (Show) attraction;
                show.displaySchedule();
                show.checkAgeAppropriate(12);
            } else if (attraction instanceof Game) {
                Game game = (Game) attraction;
                game.playGame("Bob");
            }
            
            attraction.displayInfo();
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        Attraction[] parkAttractions = {
            new RollerCoaster("Thunder Mountain", 24, 15.99, 48, "Extreme"),
            new WaterRide("Splash Rapids", 12, 12.99, false, new String[]{"Life Jacket", "Goggles"}),
            new Show("Magic Castle Show", 200, 8.99, new String[]{"2:00 PM", "4:00 PM", "7:00 PM"}, "G"),
            new Game("Ring Toss Challenge", 6, 5.99, "Easy", new String[]{"Teddy Bear", "Keychain", "Sticker"})
        };
        
        operateAttractions(parkAttractions);
        
        System.out.println("=== Park Summary ===");
        for (Attraction attraction : parkAttractions) {
            System.out.println("🎢 " + attraction.name + " (" + attraction.getClass().getSimpleName() + 
                             ") - $" + attraction.ticketPrice);
        }
    }
}