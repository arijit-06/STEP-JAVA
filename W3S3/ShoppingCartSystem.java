class Product {
    private String productId;
    private String productName;
    private double price;
    private String category;
    private int stockQuantity;
    private static int totalProducts = 0;
    private static String[] categories = new String[10];
    private static int categoryCount = 0;

    public Product(String productId, String productName, double price, String category, int stockQuantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.stockQuantity = stockQuantity;
        totalProducts++;
        addCategory(category);
    }

    private static void addCategory(String category) {
        for (int i = 0; i < categoryCount; i++) {
            if (categories[i].equals(category)) return;
        }
        if (categoryCount < categories.length) {
            categories[categoryCount++] = category;
        }
    }

    public static Product findProductById(Product[] products, String productId) {
        for (Product product : products) {
            if (product != null && product.productId.equals(productId)) {
                return product;
            }
        }
        return null;
    }

    public static Product[] getProductsByCategory(Product[] products, String category) {
        Product[] result = new Product[products.length];
        int count = 0;
        for (Product product : products) {
            if (product != null && product.category.equals(category)) {
                result[count++] = product;
            }
        }
        return result;
    }

    public void displayProduct() {
        System.out.println("ID: " + productId + ", Name: " + productName + ", Price: $" + price + 
                          ", Category: " + category + ", Stock: " + stockQuantity);
    }

    public String getProductId() { return productId; }
    public String getProductName() { return productName; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }
    public int getStockQuantity() { return stockQuantity; }
    public void setStockQuantity(int stockQuantity) { this.stockQuantity = stockQuantity; }
    public static int getTotalProducts() { return totalProducts; }
}

class ShoppingCart {
    private String cartId;
    private String customerName;
    private Product[] products;
    private int[] quantities;
    private double cartTotal;
    private int itemCount;
    private static int cartCounter = 0;

    public ShoppingCart(String customerName) {
        this.cartId = "CART" + String.format("%03d", ++cartCounter);
        this.customerName = customerName;
        this.products = new Product[10];
        this.quantities = new int[10];
        this.cartTotal = 0;
        this.itemCount = 0;
    }

    public void addProduct(Product product, int quantity) {
        if (product.getStockQuantity() >= quantity && itemCount < products.length) {
            products[itemCount] = product;
            quantities[itemCount] = quantity;
            itemCount++;
            product.setStockQuantity(product.getStockQuantity() - quantity);
            calculateTotal();
            System.out.println("Added " + quantity + " x " + product.getProductName() + " to cart");
        } else {
            System.out.println("Cannot add product - insufficient stock or cart full");
        }
    }

    public void removeProduct(String productId) {
        for (int i = 0; i < itemCount; i++) {
            if (products[i].getProductId().equals(productId)) {
                products[i].setStockQuantity(products[i].getStockQuantity() + quantities[i]);
                for (int j = i; j < itemCount - 1; j++) {
                    products[j] = products[j + 1];
                    quantities[j] = quantities[j + 1];
                }
                itemCount--;
                calculateTotal();
                System.out.println("Product removed from cart");
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
        for (int i = 0; i < itemCount; i++) {
            System.out.println(products[i].getProductName() + " x " + quantities[i] + 
                              " = $" + (products[i].getPrice() * quantities[i]));
        }
        System.out.println("Total: $" + cartTotal);
    }

    public void checkout() {
        System.out.println("=== CHECKOUT ===");
        displayCart();
        System.out.println("Payment processed for $" + cartTotal);
        System.out.println("Thank you for shopping!");
    }
}

public class ShoppingCartSystem {
    public static void main(String[] args) {
        Product[] products = {
            new Product("P001", "Laptop", 999.99, "Electronics", 10),
            new Product("P002", "Mouse", 29.99, "Electronics", 50),
            new Product("P003", "Keyboard", 79.99, "Electronics", 30),
            new Product("P004", "Monitor", 299.99, "Electronics", 15),
            new Product("P005", "Headphones", 149.99, "Electronics", 25),
            new Product("P006", "Desk Chair", 199.99, "Furniture", 8),
            new Product("P007", "Desk Lamp", 49.99, "Furniture", 20),
            new Product("P008", "Coffee Mug", 12.99, "Kitchen", 100),
            new Product("P009", "Water Bottle", 19.99, "Kitchen", 75),
            new Product("P010", "Notebook", 5.99, "Stationery", 200)
        };

        System.out.println("=== Available Products ===");
        for (Product product : products) {
            product.displayProduct();
        }

        ShoppingCart cart1 = new ShoppingCart("Alice Johnson");
        ShoppingCart cart2 = new ShoppingCart("Bob Smith");

        cart1.addProduct(products[0], 1);
        cart1.addProduct(products[1], 2);
        cart1.addProduct(products[4], 1);

        cart2.addProduct(products[2], 1);
        cart2.addProduct(products[5], 1);

        System.out.println("\n=== Cart 1 ===");
        cart1.displayCart();

        System.out.println("\n=== Cart 2 ===");
        cart2.displayCart();

        cart1.removeProduct("P002");
        
        System.out.println("\n=== After Removal ===");
        cart1.displayCart();

        System.out.println("\n=== Checkout Process ===");
        cart1.checkout();

        System.out.println("\n=== Product Search ===");
        Product found = Product.findProductById(products, "P001");
        if (found != null) {
            System.out.println("Found: " + found.getProductName());
        }

        System.out.println("\nTotal Products: " + Product.getTotalProducts());
    }
}