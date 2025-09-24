// ASSIGNMENT 1: Hotel Booking System - Method Overloading
public class HotelBookingSystem {
    
    public double calculatePrice(String roomType, int nights) {
        double basePrice = getRoomPrice(roomType);
        double total = basePrice * nights;
        System.out.println("Standard Booking:");
        System.out.println("  Room: " + roomType + " x " + nights + " nights");
        System.out.println("  Total: $" + total);
        return total;
    }
    
    public double calculatePrice(String roomType, int nights, double seasonalMultiplier) {
        double basePrice = getRoomPrice(roomType);
        double total = basePrice * nights * seasonalMultiplier;
        double seasonalCharge = (basePrice * nights) * (seasonalMultiplier - 1);
        System.out.println("Seasonal Booking:");
        System.out.println("  Room: " + roomType + " x " + nights + " nights");
        System.out.println("  Base cost: $" + (basePrice * nights));
        System.out.println("  Seasonal charge: $" + seasonalCharge);
        System.out.println("  Total: $" + total);
        return total;
    }
    
    public double calculatePrice(String roomType, int nights, double corporateDiscount, boolean mealPackage) {
        double basePrice = getRoomPrice(roomType);
        double roomCost = basePrice * nights;
        double discount = roomCost * (corporateDiscount / 100);
        double mealCost = mealPackage ? nights * 45.0 : 0;
        double total = roomCost - discount + mealCost;
        
        System.out.println("Corporate Booking:");
        System.out.println("  Room: " + roomType + " x " + nights + " nights = $" + roomCost);
        System.out.println("  Corporate discount (" + corporateDiscount + "%): -$" + discount);
        if (mealPackage) {
            System.out.println("  Meal package: $" + mealCost);
        }
        System.out.println("  Total: $" + total);
        return total;
    }
    
    public double calculatePrice(String roomType, int nights, int guestCount, double decorationFee, String cateringOption) {
        double basePrice = getRoomPrice(roomType);
        double roomCost = basePrice * nights;
        double cateringCost = getCateringCost(cateringOption, guestCount);
        double total = roomCost + decorationFee + cateringCost;
        
        System.out.println("Wedding Package:");
        System.out.println("  Room: " + roomType + " x " + nights + " nights = $" + roomCost);
        System.out.println("  Decoration fee: $" + decorationFee);
        System.out.println("  Catering (" + cateringOption + ") for " + guestCount + " guests: $" + cateringCost);
        System.out.println("  Total: $" + total);
        return total;
    }
    
    private double getRoomPrice(String roomType) {
        switch (roomType.toLowerCase()) {
            case "standard": return 120.0;
            case "deluxe": return 180.0;
            case "suite": return 300.0;
            case "presidential": return 500.0;
            default: return 120.0;
        }
    }
    
    private double getCateringCost(String option, int guests) {
        double perPersonCost = switch (option.toLowerCase()) {
            case "basic" -> 25.0;
            case "premium" -> 45.0;
            case "luxury" -> 75.0;
            default -> 25.0;
        };
        return perPersonCost * guests;
    }
    
    public static void main(String[] args) {
        HotelBookingSystem hotel = new HotelBookingSystem();
        
        System.out.println("=== Hotel Booking System ===\n");
        
        hotel.calculatePrice("Deluxe", 3);
        System.out.println();
        
        hotel.calculatePrice("Suite", 2, 1.5); // 50% seasonal increase
        System.out.println();
        
        hotel.calculatePrice("Standard", 5, 15.0, true); // 15% corporate discount with meals
        System.out.println();
        
        hotel.calculatePrice("Presidential", 2, 150, 2500.0, "luxury"); // Wedding package
    }
}