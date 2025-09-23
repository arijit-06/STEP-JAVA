// File: InventoryManager.java
// ASSIGNMENT 6: Inventory Management System

public class InventoryManager {
    
    public static class Product {
        private String name;
        private int quantity;
        private double price;
        private static int totalProducts = 0;
        private static double totalValue = 0;
        
        public Product(String name, int quantity, double price) {
            this.name = name;
            this.quantity = quantity;
            this.price = price;
            totalProducts++;
            totalValue += quantity * price;
        }
        
        public void restock(int amount) {
            quantity += amount;
            totalValue += amount * price;
        }
        
        public boolean sell(int amount) {
            if (quantity >= amount) {
                quantity -= amount;
                totalValue -= amount * price;
                return true;
            }
            return false;
        }
        
        public static double getTotalValue() { return totalValue; }
        public static int getTotalProducts() { return totalProducts; }
        
        public void displayProduct() {
            System.out.println(name + ": " + quantity + " units @ $" + price + " each");
        }
    }
    
    public static void main(String[] args) {
        Product p1 = new Product("Laptop", 10, 1000);
        Product p2 = new Product("Mouse", 50, 25);
        Product p3 = new Product("Keyboard", 30, 75);
        
        p1.displayProduct();
        p2.displayProduct();
        p3.displayProduct();
        
        System.out.println("Total inventory value: $" + Product.getTotalValue());
        
        p1.sell(2);
        p2.restock(20);
        
        System.out.println("After transactions:");
        System.out.println("Total inventory value: $" + Product.getTotalValue());
    }
}