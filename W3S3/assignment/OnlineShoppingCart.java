import java.util.Scanner;

class Product {
    private String productId;
    private String productName;
    private double price;
    private String category;
    private int stockQuantity;
    
    private static int totalProducts = 0;
    private static String[] categories = {"Electronics", "Clothing", "Books", "Home", "Sports"};
    
    public Product(String productName, double price, String category, int stockQuantity) {
        this.productId = generateProductId();
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.stockQuantity = stockQuantity;
        totalProducts++;
    }
    
    private static String generateProductId() {
        return "P" + String.format("%03d", totalProducts + 1);
    }
    
    public static int getTotalProducts() { return totalProducts; }
    
    public static Product findProductById(Product[] products, String productId) {
        for (Product p : products) {
            if (p != null && p.productId.equals(productId)) {
                return p;
            }
        }
        return null;
    }
    
    public static Product[] getProductsByCategory(Product[] products, String category) {
        Product[] result = new Product[products.length];
        int count = 0;
        for (Product p : products) {
            if (p != null && p.category.equalsIgnoreCase(category)) {
                result[count++] = p;
            }
        }
        return result;
    }
    
    public void displayProduct() {
        System.out.println(productId + ": " + productName + " - $" + price + " (" + category + ") Stock: " + stockQuantity);
    }
    
    public boolean reduceStock(int quantity) {
        if (stockQuantity >= quantity) {
            stockQuantity -= quantity;
            return true;
        }
        return false;
    }
    
    public String getProductId() { return productId; }
    public String getProductName() { return productName; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }
    public int getStockQuantity() { return stockQuantity; }
    public static String[] getCategories() { return categories; }
}

class ShoppingCart {
    private String cartId;
    private String customerName;
    private Product[] products;
    private int[] quantities;
    private double cartTotal;
    private int itemCount;
    
    public ShoppingCart(String customerName, int capacity) {
        this.cartId = generateCartId();
        this.customerName = customerName;
        this.products = new Product[capacity];
        this.quantities = new int[capacity];
        this.cartTotal = 0;
        this.itemCount = 0;
    }
    
    private static String generateCartId() {
        return "CART" + System.currentTimeMillis() % 10000;
    }
    
    public void addProduct(Product product, int quantity) {
        if (product.getStockQuantity() >= quantity) {
            // Check if product already in cart
            for (int i = 0; i < itemCount; i++) {
                if (products[i].getProductId().equals(product.getProductId())) {
                    quantities[i] += quantity;
                    System.out.println("Updated quantity for " + product.getProductName());
                    calculateTotal();
                    return;
                }
            }
            
            // Add new product
            if (itemCount < products.length) {
                products[itemCount] = product;
                quantities[itemCount] = quantity;
                itemCount++;
                System.out.println("Added " + quantity + " x " + product.getProductName() + " to cart");
                calculateTotal();
            } else {
                System.out.println("Cart is full!");
            }
        } else {
            System.out.println("Insufficient stock for " + product.getProductName());
        }
    }
    
    public void removeProduct(String productId) {
        for (int i = 0; i < itemCount; i++) {
            if (products[i].getProductId().equals(productId)) {
                System.out.println("Removed " + products[i].getProductName() + " from cart");
                // Shift items
                for (int j = i; j < itemCount - 1; j++) {
                    products[j] = products[j + 1];
                    quantities[j] = quantities[j + 1];
                }
                itemCount--;
                calculateTotal();
                return;
            }
        }
        System.out.println("Product not found in cart");
    }
    
    public void calculateTotal() {
        cartTotal = 0;
        for (int i = 0; i < itemCount; i++) {
            cartTotal += products[i].getPrice() * quantities[i];
        }
    }
    
    public void displayCart() {
        System.out.println("=== Shopping Cart: " + cartId + " ===");
        System.out.println("Customer: " + customerName);
        if (itemCount == 0) {
            System.out.println("Cart is empty");
            return;
        }
        
        for (int i = 0; i < itemCount; i++) {
            System.out.println((i + 1) + ". " + products[i].getProductName() + 
                             " x " + quantities[i] + " = $" + 
                             (products[i].getPrice() * quantities[i]));
        }
        System.out.println("Total: $" + cartTotal);
        System.out.println("Items: " + itemCount);
    }
    
    public void checkout() {
        if (itemCount == 0) {
            System.out.println("Cannot checkout empty cart");
            return;
        }
        
        System.out.println("=== CHECKOUT ===");
        displayCart();
        
        // Reduce stock for all items
        for (int i = 0; i < itemCount; i++) {
            products[i].reduceStock(quantities[i]);
        }
        
        System.out.println("Order placed successfully!");
        System.out.println("Total paid: $" + cartTotal);
        
        // Clear cart
        itemCount = 0;
        cartTotal = 0;
    }
    
    public double getCartTotal() { return cartTotal; }
    public int getItemCount() { return itemCount; }
}

public class OnlineShoppingCart {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Initialize products
        Product[] products = {
            new Product("Laptop", 999.99, "Electronics", 10),
            new Product("Smartphone", 699.99, "Electronics", 15),
            new Product("T-Shirt", 29.99, "Clothing", 50),
            new Product("Jeans", 79.99, "Clothing", 30),
            new Product("Java Book", 49.99, "Books", 20),
            new Product("Python Guide", 39.99, "Books", 25),
            new Product("Coffee Maker", 89.99, "Home", 12),
            new Product("Basketball", 24.99, "Sports", 8)
        };
        
        ShoppingCart cart = new ShoppingCart("John Doe", 10);
        
        System.out.println("=== Online Shopping System ===");
        System.out.println("Total Products Available: " + Product.getTotalProducts());
        
        boolean shopping = true;
        while (shopping) {
            System.out.println("\n1. Browse All Products");
            System.out.println("2. Browse by Category");
            System.out.println("3. Add to Cart");
            System.out.println("4. View Cart");
            System.out.println("5. Remove from Cart");
            System.out.println("6. Checkout");
            System.out.println("7. Exit");
            System.out.print("Choose option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    System.out.println("\n=== All Products ===");
                    for (Product p : products) {
                        p.displayProduct();
                    }
                    break;
                    
                case 2:
                    System.out.println("\nAvailable Categories:");
                    String[] categories = Product.getCategories();
                    for (int i = 0; i < categories.length; i++) {
                        System.out.println((i + 1) + ". " + categories[i]);
                    }
                    System.out.print("Choose category: ");
                    String category = scanner.nextLine();
                    
                    Product[] categoryProducts = Product.getProductsByCategory(products, category);
                    System.out.println("\n=== " + category + " Products ===");
                    for (Product p : categoryProducts) {
                        if (p != null) p.displayProduct();
                    }
                    break;
                    
                case 3:
                    System.out.print("Enter Product ID: ");
                    String productId = scanner.nextLine();
                    Product product = Product.findProductById(products, productId);
                    
                    if (product != null) {
                        System.out.print("Enter quantity: ");
                        int quantity = scanner.nextInt();
                        cart.addProduct(product, quantity);
                    } else {
                        System.out.println("Product not found!");
                    }
                    break;
                    
                case 4:
                    cart.displayCart();
                    break;
                    
                case 5:
                    System.out.print("Enter Product ID to remove: ");
                    String removeId = scanner.nextLine();
                    cart.removeProduct(removeId);
                    break;
                    
                case 6:
                    cart.checkout();
                    break;
                    
                case 7:
                    shopping = false;
                    break;
                    
                default:
                    System.out.println("Invalid option!");
            }
        }
        
        System.out.println("\n=== Object Relationships Demonstrated ===");
        System.out.println("✓ ShoppingCart contains Product objects");
        System.out.println("✓ Products maintain their own stock levels");
        System.out.println("✓ Cart calculates totals using Product prices");
        System.out.println("✓ Static methods provide utility functions");
        
        scanner.close();
    }
}