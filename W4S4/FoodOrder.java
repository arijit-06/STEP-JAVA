public class FoodOrder {
    private String customerName;
    private String foodItem;
    private int quantity;
    private double price;
    private static final double FIXED_RATE = 50.0;
    
    public FoodOrder() {
        this.customerName = "Unknown";
        this.foodItem = "Unknown";
        this.quantity = 0;
        this.price = 0.0;
    }
    
    public FoodOrder(String foodItem) {
        this.customerName = "Unknown";
        this.foodItem = foodItem;
        this.quantity = 1;
        this.price = FIXED_RATE;
    }
    
    public FoodOrder(String foodItem, int quantity) {
        this.customerName = "Unknown";
        this.foodItem = foodItem;
        this.quantity = quantity;
        this.price = quantity * FIXED_RATE;
    }
    
    public FoodOrder(String customerName, String foodItem, int quantity, double price) {
        this.customerName = customerName;
        this.foodItem = foodItem;
        this.quantity = quantity;
        this.price = price;
    }
    
    public void printBill() {
        System.out.println("Customer: " + customerName + ", Food: " + foodItem + 
                          ", Quantity: " + quantity + ", Total Price: $" + price);
    }
    
    public static void main(String[] args) {
        System.out.println("=== FOOD DELIVERY ORDERS ===");
        
        FoodOrder order1 = new FoodOrder();
        FoodOrder order2 = new FoodOrder("Pizza");
        FoodOrder order3 = new FoodOrder("Burger", 3);
        FoodOrder order4 = new FoodOrder("John", "Pasta", 2, 120.0);
        
        order1.printBill();
        order2.printBill();
        order3.printBill();
        order4.printBill();
    }
}