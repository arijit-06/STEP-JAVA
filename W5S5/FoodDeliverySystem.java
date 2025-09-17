// Food Delivery Order System - Assignment Problem 4
import java.util.*;

class FoodItem {
    private static int totalItems = 0;
    private static Map<String, Integer> categoryCount = new HashMap<>();
    
    private final String itemId;
    private String name;
    private String category;
    private double price;
    private boolean isAvailable;
    private String restaurant;
    
    public FoodItem(String name) {
        this(name, "General", 10.0, true, "Default Restaurant");
    }
    
    public FoodItem(String name, String category) {
        this(name, category, 15.0, true, "Popular Restaurant");
    }
    
    public FoodItem(String name, String category, double price) {
        this(name, category, price, true, "Premium Restaurant");
    }
    
    public FoodItem(String name, String category, double price, boolean available, String restaurant) {
        this.itemId = "ITEM" + String.format("%04d", ++totalItems);
        this.name = name;
        this.category = category;
        this.price = Math.max(price, 0.0);
        this.isAvailable = available;
        this.restaurant = restaurant;
        
        categoryCount.put(category, categoryCount.getOrDefault(category, 0) + 1);
        System.out.println("Food item added: " + name + " (" + category + ") - $" + price);
    }
    
    public static int getTotalItems() { return totalItems; }
    public static Map<String, Integer> getCategoryCount() { return new HashMap<>(categoryCount); }
    public static void displayFoodStats() {
        System.out.println("=== Food Statistics ===");
        System.out.println("Total Items: " + totalItems);
        System.out.println("Category Distribution:");
        for (Map.Entry<String, Integer> entry : categoryCount.entrySet()) {
            System.out.println("  " + entry.getKey() + ": " + entry.getValue());
        }
    }
    
    public String getItemId() { return itemId; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public boolean isAvailable() { return isAvailable; }
    public String getRestaurant() { return restaurant; }
}

class Pizza extends FoodItem {
    private String size;
    private List<String> toppings;
    
    public Pizza(String name) {
        super(name, "Pizza");
        this.size = "Medium";
        this.toppings = new ArrayList<>();
        toppings.add("Cheese");
    }
    
    public Pizza(String name, String size) {
        super(name, "Pizza", size.equals("Large") ? 18.0 : 12.0);
        this.size = size;
        this.toppings = new ArrayList<>();
        toppings.add("Cheese");
    }
    
    public Pizza(String name, String size, List<String> toppings) {
        super(name, "Pizza", calculatePrice(size, toppings));
        this.size = size;
        this.toppings = new ArrayList<>(toppings);
    }
    
    private static double calculatePrice(String size, List<String> toppings) {
        double basePrice = size.equals("Large") ? 15.0 : size.equals("Medium") ? 12.0 : 10.0;
        return basePrice + (toppings.size() * 2.0);
    }
    
    public String getSize() { return size; }
    public List<String> getToppings() { return new ArrayList<>(toppings); }
}

class Burger extends FoodItem {
    private boolean hasCombo;
    private String meatType;
    
    public Burger(String name) {
        super(name, "Burger");
        this.hasCombo = false;
        this.meatType = "Beef";
    }
    
    public Burger(String name, boolean hasCombo) {
        super(name, "Burger", hasCombo ? 12.0 : 8.0);
        this.hasCombo = hasCombo;
        this.meatType = "Beef";
    }
    
    public Burger(String name, boolean hasCombo, String meatType) {
        super(name, "Burger", hasCombo ? 14.0 : 10.0);
        this.hasCombo = hasCombo;
        this.meatType = meatType;
    }
    
    public boolean hasCombo() { return hasCombo; }
    public String getMeatType() { return meatType; }
}

class Dessert extends FoodItem {
    private boolean isVegan;
    private int calories;
    
    public Dessert(String name) {
        super(name, "Dessert", 6.0);
        this.isVegan = false;
        this.calories = 300;
    }
    
    public Dessert(String name, boolean isVegan) {
        super(name, "Dessert", 7.0);
        this.isVegan = isVegan;
        this.calories = isVegan ? 250 : 350;
    }
    
    public boolean isVegan() { return isVegan; }
    public int getCalories() { return calories; }
}

class DeliveryOrder {
    private static int totalOrders = 0;
    private static double totalRevenue = 0.0;
    
    private final String orderId;
    private String customerName;
    private List<Object> items;
    private double totalAmount;
    private String orderStatus;
    private String deliveryAddress;
    
    public DeliveryOrder(String customerName) {
        this(customerName, "123 Main St");
    }
    
    public DeliveryOrder(String customerName, String address) {
        this.orderId = "ORD" + String.format("%05d", ++totalOrders);
        this.customerName = customerName;
        this.deliveryAddress = address;
        this.items = new ArrayList<>();
        this.totalAmount = 0.0;
        this.orderStatus = "Pending";
        System.out.println("Order created: " + orderId + " for " + customerName);
    }
    
    public DeliveryOrder addItem(Object item) {
        if (item instanceof FoodItem) {
            FoodItem food = (FoodItem) item;
            this.items.add(item);
            this.totalAmount += food.getPrice();
            System.out.println("Added " + food.getName() + " to order " + this.orderId);
        }
        return this;
    }
    
    public DeliveryOrder removeItem(Object item) {
        if (item instanceof FoodItem && this.items.contains(item)) {
            FoodItem food = (FoodItem) item;
            this.items.remove(item);
            this.totalAmount -= food.getPrice();
            System.out.println("Removed " + food.getName() + " from order " + this.orderId);
        }
        return this;
    }
    
    public DeliveryOrder confirmOrder() {
        this.orderStatus = "Confirmed";
        totalRevenue += this.totalAmount;
        System.out.println("Order " + this.orderId + " confirmed. Total: $" + String.format("%.2f", this.totalAmount));
        return this;
    }
    
    public DeliveryOrder updateStatus(String status) {
        this.orderStatus = status;
        System.out.println("Order " + this.orderId + " status: " + status);
        return this;
    }
    
    public static int getTotalOrders() { return totalOrders; }
    public static double getTotalRevenue() { return totalRevenue; }
    public static void displayOrderStats() {
        System.out.println("=== Order Statistics ===");
        System.out.println("Total Orders: " + totalOrders);
        System.out.println("Total Revenue: $" + String.format("%.2f", totalRevenue));
    }
    
    public String getOrderId() { return orderId; }
    public String getCustomerName() { return customerName; }
    public double getTotalAmount() { return totalAmount; }
    public String getOrderStatus() { return orderStatus; }
    public List<Object> getItems() { return new ArrayList<>(items); }
}

class DeliveryCustomer {
    private static int totalCustomers = 0;
    
    private final String customerId;
    private String name;
    private String phone;
    private String address;
    private List<String> orderHistory;
    private String loyaltyLevel;
    
    public DeliveryCustomer(String name, String phone) {
        this(name, phone, "123 Default St", "Bronze");
    }
    
    public DeliveryCustomer(String name, String phone, String address) {
        this(name, phone, address, "Silver");
    }
    
    public DeliveryCustomer(String name, String phone, String address, String loyaltyLevel) {
        this.customerId = "CUST" + String.format("%04d", ++totalCustomers);
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.loyaltyLevel = loyaltyLevel;
        this.orderHistory = new ArrayList<>();
        System.out.println("Customer registered: " + name + " (" + loyaltyLevel + " level)");
    }
    
    public DeliveryCustomer placeOrder(DeliveryOrder order) {
        this.orderHistory.add(order.getOrderId());
        System.out.println(this.name + " placed order: " + order.getOrderId());
        return this;
    }
    
    public DeliveryCustomer updateAddress(String newAddress) {
        this.address = newAddress;
        System.out.println(this.name + " updated address to: " + newAddress);
        return this;
    }
    
    public DeliveryCustomer upgradeLoyalty() {
        if (this.loyaltyLevel.equals("Bronze")) {
            this.loyaltyLevel = "Silver";
        } else if (this.loyaltyLevel.equals("Silver")) {
            this.loyaltyLevel = "Gold";
        }
        System.out.println(this.name + " upgraded to " + this.loyaltyLevel + " level");
        return this;
    }
    
    public static int getTotalCustomers() { return totalCustomers; }
    public String getName() { return name; }
    public String getLoyaltyLevel() { return loyaltyLevel; }
    public List<String> getOrderHistory() { return new ArrayList<>(orderHistory); }
}

class DeliverySystem {
    private static final Map<String, Object> menuItems = new HashMap<>();
    private static final Map<String, Object> customerDatabase = new HashMap<>();
    private static final List<DeliveryOrder> activeOrders = new ArrayList<>();
    
    public static void addMenuItem(Object item) {
        if (item instanceof FoodItem) {
            FoodItem food = (FoodItem) item;
            menuItems.put(food.getItemId(), item);
        }
    }
    
    public static void registerCustomer(Object customer) {
        if (customer instanceof DeliveryCustomer) {
            DeliveryCustomer c = (DeliveryCustomer) customer;
            customerDatabase.put(c.getName(), customer);
        }
    }
    
    public static void processOrdersByType() {
        System.out.println("\n=== Processing Orders by Food Type ===");
        for (DeliveryOrder order : activeOrders) {
            for (Object item : order.getItems()) {
                if (item instanceof Pizza) {
                    Pizza pizza = (Pizza) item;
                    System.out.println("Preparing pizza: " + pizza.getName() + " (" + pizza.getSize() + ")");
                } else if (item instanceof Burger) {
                    Burger burger = (Burger) item;
                    System.out.println("Grilling burger: " + burger.getName() + " (" + burger.getMeatType() + ")");
                } else if (item instanceof Dessert) {
                    Dessert dessert = (Dessert) item;
                    System.out.println("Preparing dessert: " + dessert.getName() + " (Vegan: " + dessert.isVegan() + ")");
                }
            }
        }
    }
    
    public static void processCustomersByLoyalty(String level) {
        System.out.println("\n=== Processing " + level + " Customers ===");
        for (Object obj : customerDatabase.values()) {
            if (obj instanceof DeliveryCustomer) {
                DeliveryCustomer customer = (DeliveryCustomer) obj;
                if (customer.getLoyaltyLevel().equals(level)) {
                    System.out.println(level + " customer: " + customer.getName() + 
                                     " (Orders: " + customer.getOrderHistory().size() + ")");
                }
            }
        }
    }
    
    public static void addActiveOrder(DeliveryOrder order) {
        activeOrders.add(order);
    }
    
    public static void displaySystemStats() {
        System.out.println("\n=== Delivery System Statistics ===");
        System.out.println("Menu items: " + menuItems.size());
        System.out.println("Registered customers: " + customerDatabase.size());
        System.out.println("Active orders: " + activeOrders.size());
        FoodItem.displayFoodStats();
        DeliveryOrder.displayOrderStats();
        System.out.println("Total customers: " + DeliveryCustomer.getTotalCustomers());
    }
}

public class FoodDeliverySystem {
    public static void main(String[] args) {
        System.out.println("=== Food Delivery Order System ===");
        
        // Create different food items with constructor chaining
        Pizza pizza1 = new Pizza("Margherita");
        Pizza pizza2 = new Pizza("Pepperoni", "Large");
        Burger burger1 = new Burger("Classic Burger", true);
        Burger burger2 = new Burger("Veggie Burger", false, "Plant-based");
        Dessert dessert1 = new Dessert("Chocolate Cake");
        Dessert dessert2 = new Dessert("Fruit Tart", true);
        
        // Add items to menu
        DeliverySystem.addMenuItem(pizza1);
        DeliverySystem.addMenuItem(pizza2);
        DeliverySystem.addMenuItem(burger1);
        DeliverySystem.addMenuItem(burger2);
        DeliverySystem.addMenuItem(dessert1);
        DeliverySystem.addMenuItem(dessert2);
        
        // Create customers with different constructor patterns
        DeliveryCustomer customer1 = new DeliveryCustomer("John Doe", "555-1234");
        DeliveryCustomer customer2 = new DeliveryCustomer("Jane Smith", "555-5678", "456 Oak Ave");
        DeliveryCustomer customer3 = new DeliveryCustomer("Bob Wilson", "555-9012", "789 Pine St", "Gold");
        
        // Register customers
        DeliverySystem.registerCustomer(customer1);
        DeliverySystem.registerCustomer(customer2);
        DeliverySystem.registerCustomer(customer3);
        
        // Create orders with method chaining
        System.out.println("\n=== Order Creation Demo ===");
        DeliveryOrder order1 = new DeliveryOrder("John Doe")
            .addItem(pizza1)
            .addItem(burger1)
            .addItem(dessert1)
            .confirmOrder();
        
        DeliveryOrder order2 = new DeliveryOrder("Jane Smith", "456 Oak Ave")
            .addItem(pizza2)
            .addItem(dessert2)
            .confirmOrder()
            .updateStatus("Preparing");
        
        // Customer interactions with method chaining
        customer1.placeOrder(order1).upgradeLoyalty();
        customer2.placeOrder(order2).updateAddress("New Address 123");
        
        // Add orders to system
        DeliverySystem.addActiveOrder(order1);
        DeliverySystem.addActiveOrder(order2);
        
        // Process orders by food type using instanceof
        DeliverySystem.processOrdersByType();
        
        // Process customers by loyalty level
        DeliverySystem.processCustomersByLoyalty("Silver");
        DeliverySystem.processCustomersByLoyalty("Gold");
        
        // Display system statistics
        DeliverySystem.displaySystemStats();
        
        // Test instanceof with mixed objects
        System.out.println("\n=== Type Testing ===");
        Object[] items = {pizza1, burger1, dessert1, customer1, order1, "Not food related"};
        
        for (Object obj : items) {
            if (obj instanceof Pizza) {
                Pizza p = (Pizza) obj;
                System.out.println("✓ Pizza: " + p.getName() + " (" + p.getSize() + ")");
            } else if (obj instanceof Burger) {
                Burger b = (Burger) obj;
                System.out.println("✓ Burger: " + b.getName() + " (Combo: " + b.hasCombo() + ")");
            } else if (obj instanceof Dessert) {
                Dessert d = (Dessert) obj;
                System.out.println("✓ Dessert: " + d.getName() + " (Vegan: " + d.isVegan() + ")");
            } else if (obj instanceof DeliveryCustomer) {
                DeliveryCustomer c = (DeliveryCustomer) obj;
                System.out.println("✓ Customer: " + c.getName());
            } else if (obj instanceof DeliveryOrder) {
                DeliveryOrder o = (DeliveryOrder) obj;
                System.out.println("✓ Order: " + o.getOrderId());
            } else {
                System.out.println("✗ Unknown item: " + obj);
            }
        }
    }
}