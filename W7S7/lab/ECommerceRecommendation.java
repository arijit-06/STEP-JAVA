// LAB 7: E-Commerce Recommendation Engine - Multiple Polymorphism Integration
abstract class Product {
    protected String name;
    protected double price;
    protected String brand;
    protected double rating;
    
    public Product(String name, double price, String brand, double rating) {
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.rating = rating;
    }
    
    public abstract void recommend();
    
    // Method overloading for different update types
    public void updateInfo(double newPrice) {
        price = newPrice;
        System.out.println("💰 Price updated to $" + newPrice + " for " + name);
    }
    
    public void updateInfo(double newPrice, double newRating) {
        price = newPrice;
        rating = newRating;
        System.out.println("📊 Price and rating updated for " + name + " - $" + newPrice + ", ⭐" + newRating);
    }
    
    public void updateInfo(String newBrand, double newPrice) {
        brand = newBrand;
        price = newPrice;
        System.out.println("🏷️ Brand and price updated for " + name + " - " + newBrand + ", $" + newPrice);
    }
}

class Electronics extends Product {
    private int warrantyYears;
    private String[] techSpecs;
    
    public Electronics(String name, double price, String brand, double rating, int warrantyYears, String[] techSpecs) {
        super(name, price, brand, rating);
        this.warrantyYears = warrantyYears;
        this.techSpecs = techSpecs;
    }
    
    @Override
    public void recommend() {
        System.out.println("🔌 Electronics Recommendation: " + name + " by " + brand);
        System.out.println("   💰 Price: $" + price + " | ⭐ Rating: " + rating + " | 🛡️ Warranty: " + warrantyYears + " years");
        System.out.print("   🔧 Tech Specs: ");
        for (String spec : techSpecs) {
            System.out.print(spec + " | ");
        }
        System.out.println();
    }
    
    public void showWarrantyInfo() {
        System.out.println("🛡️ " + name + " comes with " + warrantyYears + " year warranty");
    }
}

class Clothing extends Product {
    private String[] sizes;
    private String style;
    private String material;
    
    public Clothing(String name, double price, String brand, double rating, String[] sizes, String style, String material) {
        super(name, price, brand, rating);
        this.sizes = sizes;
        this.style = style;
        this.material = material;
    }
    
    @Override
    public void recommend() {
        System.out.println("👕 Clothing Recommendation: " + name + " by " + brand);
        System.out.println("   💰 Price: $" + price + " | ⭐ Rating: " + rating + " | 🎨 Style: " + style);
        System.out.print("   📏 Available sizes: ");
        for (String size : sizes) {
            System.out.print(size + " ");
        }
        System.out.println("| 🧵 Material: " + material);
    }
    
    public void showSizeChart() {
        System.out.print("📏 Size chart for " + name + ": ");
        for (String size : sizes) {
            System.out.print(size + " ");
        }
        System.out.println();
    }
}

class Book extends Product {
    private String author;
    private String genre;
    private int pages;
    
    public Book(String name, double price, String author, double rating, String genre, int pages) {
        super(name, price, "Publisher", rating);
        this.author = author;
        this.genre = genre;
        this.pages = pages;
    }
    
    @Override
    public void recommend() {
        System.out.println("📚 Book Recommendation: " + name + " by " + author);
        System.out.println("   💰 Price: $" + price + " | ⭐ Rating: " + rating + " | 📖 Genre: " + genre + " | 📄 Pages: " + pages);
    }
    
    public void showAuthorDetails() {
        System.out.println("✍️ Author: " + author + " specializes in " + genre + " literature");
    }
}

public class ECommerceRecommendation {
    public static void processProductCatalog(Product[] products) {
        System.out.println("=== Product Recommendation Engine ===");
        
        for (Product product : products) {
            // Polymorphic recommendation
            product.recommend();
            
            // Safe downcasting for specific features
            if (product instanceof Electronics) {
                Electronics electronics = (Electronics) product;
                electronics.showWarrantyInfo();
            } else if (product instanceof Clothing) {
                Clothing clothing = (Clothing) product;
                clothing.showSizeChart();
            } else if (product instanceof Book) {
                Book book = (Book) product;
                book.showAuthorDetails();
            }
            
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        Product[] catalog = {
            new Electronics("iPhone 15", 999.99, "Apple", 4.5, 2, new String[]{"128GB", "A17 Chip", "48MP Camera"}),
            new Clothing("Denim Jacket", 79.99, "Levi's", 4.2, new String[]{"S", "M", "L", "XL"}, "Casual", "100% Cotton"),
            new Book("Clean Code", 42.99, "Robert Martin", 4.8, "Programming", 464)
        };
        
        processProductCatalog(catalog);
        
        System.out.println("=== Product Updates Demo ===");
        // Method overloading examples
        catalog[0].updateInfo(899.99); // Price only
        catalog[1].updateInfo(69.99, 4.5); // Price and rating
        catalog[2].updateInfo("O'Reilly", 39.99); // Brand and price
    }
}