// LAB 1: Food Delivery App - Method Overloading
public class FoodDeliveryApp {
    
    public double calculateDelivery(double distance) {
        double cost = distance * 2.5;
        System.out.println("Basic delivery: $" + cost + " (Distance: " + distance + " miles)");
        return cost;
    }
    
    public double calculateDelivery(double distance, boolean isPremium) {
        double cost = distance * 2.5;
        if (isPremium) {
            cost += 5.0;
            System.out.println("Premium delivery: $" + cost + " (Distance: " + distance + " miles + $5 priority fee)");
        } else {
            calculateDelivery(distance);
        }
        return cost;
    }
    
    public double calculateDelivery(double distance, int orderCount) {
        double cost = distance * 2.5;
        double discount = orderCount > 3 ? cost * 0.15 : 0;
        cost -= discount;
        System.out.println("Group delivery: $" + cost + " (Distance: " + distance + " miles, " + orderCount + " orders, $" + discount + " discount)");
        return cost;
    }
    
    public double calculateDelivery(double distance, double discountPercent, double orderAmount) {
        double cost = distance * 2.5;
        if (orderAmount >= 50.0) {
            cost = 0;
            System.out.println("Festival special: FREE delivery! (Order $" + orderAmount + " qualifies for free delivery)");
        } else {
            double discount = cost * (discountPercent / 100);
            cost -= discount;
            System.out.println("Festival special: $" + cost + " (Distance: " + distance + " miles, " + discountPercent + "% discount = $" + discount + " off)");
        }
        return cost;
    }
    
    public static void main(String[] args) {
        FoodDeliveryApp app = new FoodDeliveryApp();
        
        System.out.println("=== Food Delivery Calculations ===");
        app.calculateDelivery(5.0);
        app.calculateDelivery(3.0, true);
        app.calculateDelivery(4.0, 5);
        app.calculateDelivery(6.0, 20.0, 45.0);
        app.calculateDelivery(2.0, 15.0, 60.0);
    }
}