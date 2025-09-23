class Product {
    private String productId;
    private String productName;
    private double price;
    private int quantity;
    private String supplierName;
    private String category;
    
    private static int totalProducts = 0;
    private static double totalInventoryValue = 0;
    private static int lowStockCount = 0;
    private static String[] categories = new String[10];
    private static int categoryCount = 0;
    
    public Product(String productName, double price, int quantity, String supplierName, String category) {
        this.productId = generateProductId();
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.supplierName = supplierName;
        this.category = category;
        totalProducts++;
        updateInventoryValue();
        addCategory(category);
        if (isLowStock()) lowStockCount++;
    }
    
    private static String generateProductId() {
        return "P" + String.format("%03d", totalProducts + 1);
    }
    
    private static void addCategory(String category) {
        for (int i = 0; i < categoryCount; i++) {
            if (categories[i].equals(category)) return;
        }
        if (categoryCount < categories.length) {
            categories[categoryCount] = category;
            categoryCount++;
        }
    }
    
    public void addStock(int quantity) {
        if (quantity > 0) {
            boolean wasLowStock = isLowStock();
            this.quantity += quantity;
            updateInventoryValue();
            System.out.println("Added " + quantity + " units to " + productName);
            if (wasLowStock && !isLowStock()) lowStockCount--;
        } else {
            System.out.println("Invalid quantity to add");
        }
    }
    
    public void reduceStock(int quantity) {
        if (quantity > 0 && quantity <= this.quantity) {
            boolean wasLowStock = isLowStock();
            this.quantity -= quantity;
            updateInventoryValue();
            System.out.println("Reduced " + quantity + " units from " + productName);
            if (!wasLowStock && isLowStock()) lowStockCount++;
        } else if (quantity > this.quantity) {
            System.out.println("Insufficient stock for " + productName);
        } else {
            System.out.println("Invalid quantity to reduce");
        }
    }
    
    public boolean isLowStock() {
        return quantity < 10;
    }
    
    public double calculateProductValue() {
        return price * quantity;
    }
    
    public void updatePrice(double newPrice) {
        if (newPrice > 0) {
            this.price = newPrice;
            updateInventoryValue();
            System.out.println("Updated price for " + productName + " to $" + newPrice);
        } else {
            System.out.println("Invalid price");
        }
    }
    
    private void updateInventoryValue() {
        // Recalculate total inventory value (simplified approach)
        totalInventoryValue = 0; // Reset and recalculate in main method
    }
    
    public void displayProductInfo() {
        System.out.println(productId + ": " + productName + " - $" + price + " x " + quantity + 
                          " (" + category + ", " + supplierName + ")" + 
                          (isLowStock() ? " [LOW STOCK]" : ""));
    }
    
    public static double calculateTotalInventoryValue(Product[] products) {
        double total = 0;
        for (Product p : products) {
            if (p != null) total += p.calculateProductValue();
        }
        totalInventoryValue = total;
        return total;
    }
    
    public static Product[] findLowStockProducts(Product[] products) {
        Product[] lowStock = new Product[products.length];
        int count = 0;
        for (Product p : products) {
            if (p != null && p.isLowStock()) {
                lowStock[count++] = p;
            }
        }
        return lowStock;
    }
    
    public static void generateInventoryReport(Product[] products) {
        System.out.println("=== INVENTORY REPORT ===");
        System.out.println("Total Products: " + totalProducts);
        System.out.println("Total Inventory Value: $" + calculateTotalInventoryValue(products));
        System.out.println("Low Stock Items: " + lowStockCount);
        System.out.print("Categories: ");
        for (int i = 0; i < categoryCount; i++) {
            System.out.print(categories[i] + (i < categoryCount - 1 ? ", " : ""));
        }
        System.out.println();
    }
    
    public static Product searchProduct(Product[] products, String productName) {
        for (Product p : products) {
            if (p != null && p.productName.equalsIgnoreCase(productName)) {
                return p;
            }
        }
        return null;
    }
    
    public String getProductName() { return productName; }
    public String getCategory() { return category; }
    public int getQuantity() { return quantity; }
    public static int getTotalProducts() { return totalProducts; }
}

public class ProductInventorySystem {
    public static void main(String[] args) {
        Product[] products = new Product[10];
        
        products[0] = new Product("Laptop", 999.99, 15, "TechCorp", "Electronics");
        products[1] = new Product("Mouse", 25.50, 8, "TechCorp", "Electronics");
        products[2] = new Product("Keyboard", 75.00, 12, "TechCorp", "Electronics");
        products[3] = new Product("Office Chair", 199.99, 5, "FurniturePlus", "Furniture");
        products[4] = new Product("Desk", 299.99, 3, "FurniturePlus", "Furniture");
        products[5] = new Product("Notebook", 5.99, 50, "OfficeSupply", "Stationery");
        products[6] = new Product("Pen", 1.99, 100, "OfficeSupply", "Stationery");
        
        System.out.println("=== Product Inventory System ===");
        Product.generateInventoryReport(products);
        
        System.out.println("\n=== Current Inventory ===");
        for (Product p : products) {
            if (p != null) p.displayProductInfo();
        }
        
        System.out.println("\n=== Stock Operations ===");
        products[1].addStock(15); // Add stock to Mouse (was low stock)
        products[3].reduceStock(2); // Reduce Office Chair stock
        products[4].reduceStock(10); // Try to reduce more than available (should fail)
        
        System.out.println("\n=== Price Updates ===");
        products[0].updatePrice(899.99); // Update laptop price
        
        System.out.println("\n=== Updated Inventory ===");
        for (Product p : products) {
            if (p != null) p.displayProductInfo();
        }
        
        System.out.println("\n=== Low Stock Products ===");
        Product[] lowStock = Product.findLowStockProducts(products);
        for (Product p : lowStock) {
            if (p != null) p.displayProductInfo();
        }
        
        System.out.println("\n=== Product Search ===");
        Product found = Product.searchProduct(products, "Laptop");
        if (found != null) {
            System.out.print("Found: ");
            found.displayProductInfo();
        }
        
        System.out.println("\n=== Final Inventory Report ===");
        Product.generateInventoryReport(products);
        
        System.out.println("\n=== Category Analysis ===");
        String[] categories = {"Electronics", "Furniture", "Stationery"};
        for (String category : categories) {
            int count = 0;
            double value = 0;
            for (Product p : products) {
                if (p != null && p.getCategory().equals(category)) {
                    count++;
                    value += p.calculateProductValue();
                }
            }
            System.out.println(category + ": " + count + " products, $" + value + " value");
        }
        
        System.out.println("\n=== Static vs Instance Methods Demonstrated ===");
        System.out.println("✓ Static methods: generateInventoryReport, findLowStockProducts, searchProduct");
        System.out.println("✓ Instance methods: addStock, reduceStock, calculateProductValue");
        System.out.println("✓ Static variables: totalProducts, totalInventoryValue, categories");
        System.out.println("✓ Instance variables: productId, productName, price, quantity");
    }
}