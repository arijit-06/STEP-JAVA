public class ProductInventory {
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
    private static int productCounter = 0;

    public ProductInventory(String productName, double price, int quantity, String supplierName, String category) {
        this.productId = generateProductId();
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.supplierName = supplierName;
        this.category = category;
        totalProducts++;
        addCategory(category);
        updateTotalValue();
    }

    public void addStock(int quantity) {
        if (quantity > 0) {
            this.quantity += quantity;
            updateTotalValue();
            System.out.println("Added " + quantity + " units to " + productName);
        }
    }

    public void reduceStock(int quantity) {
        if (quantity > 0 && quantity <= this.quantity) {
            this.quantity -= quantity;
            updateTotalValue();
            System.out.println("Reduced " + quantity + " units from " + productName);
        } else {
            System.out.println("Invalid quantity or insufficient stock");
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
            updateTotalValue();
            System.out.println("Price updated for " + productName + ": $" + newPrice);
        }
    }

    public void displayProductInfo() {
        System.out.println("ID: " + productId + ", Name: " + productName + ", Price: $" + price + 
                          ", Qty: " + quantity + ", Supplier: " + supplierName + ", Category: " + category);
    }

    private void updateTotalValue() {
        totalInventoryValue = 0;
        lowStockCount = 0;
    }

    private static void addCategory(String category) {
        for (int i = 0; i < categoryCount; i++) {
            if (categories[i].equals(category)) return;
        }
        if (categoryCount < categories.length) {
            categories[categoryCount++] = category;
        }
    }

    private static String generateProductId() {
        productCounter++;
        return "P" + String.format("%03d", productCounter);
    }

    public static double calculateTotalInventoryValue(ProductInventory[] products) {
        double total = 0;
        for (ProductInventory p : products) {
            total += p.calculateProductValue();
        }
        totalInventoryValue = total;
        return total;
    }

    public static void findLowStockProducts(ProductInventory[] products) {
        System.out.println("=== LOW STOCK PRODUCTS ===");
        lowStockCount = 0;
        for (ProductInventory p : products) {
            if (p.isLowStock()) {
                p.displayProductInfo();
                lowStockCount++;
            }
        }
        System.out.println("Total low stock products: " + lowStockCount);
    }

    public static void generateInventoryReport(ProductInventory[] products) {
        System.out.println("=== INVENTORY REPORT ===");
        System.out.println("Total Products: " + totalProducts);
        System.out.println("Total Inventory Value: $" + calculateTotalInventoryValue(products));
        findLowStockProducts(products);
    }

    public static ProductInventory searchProduct(ProductInventory[] products, String productName) {
        for (ProductInventory p : products) {
            if (p.productName.equalsIgnoreCase(productName)) {
                return p;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ProductInventory[] products = {
            new ProductInventory("Laptop", 1000, 15, "TechCorp", "Electronics"),
            new ProductInventory("Mouse", 25, 5, "TechCorp", "Electronics"),
            new ProductInventory("Desk", 200, 8, "FurnitureCo", "Furniture"),
            new ProductInventory("Chair", 150, 12, "FurnitureCo", "Furniture")
        };

        for (ProductInventory p : products) {
            p.displayProductInfo();
        }

        products[0].addStock(5);
        products[1].reduceStock(2);
        products[2].updatePrice(180);

        generateInventoryReport(products);

        ProductInventory found = searchProduct(products, "Laptop");
        if (found != null) {
            System.out.println("Found product:");
            found.displayProductInfo();
        }
    }
}