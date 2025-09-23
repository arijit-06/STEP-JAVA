import java.util.Scanner;

class Book {
    String title;
    String author;
    double price;
    
    // Default constructor
    public Book() {
        this.title = "Unknown Title";
        this.author = "Unknown Author";
        this.price = 0.0;
    }
    
    // Parameterized constructor
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
    
    public void displayBook() {
        System.out.println("📚 BOOK DETAILS 📚");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: ₹" + price);
        System.out.println("-------------------");
    }
}

public class BookManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== BOOK MANAGEMENT SYSTEM ===\n");
        
        // Create book using default constructor
        Book book1 = new Book();
        System.out.println("Book created with default constructor:");
        book1.displayBook();
        
        // Create book using parameterized constructor
        Book book2 = new Book("Java Programming", "James Gosling", 599.99);
        System.out.println("Book created with parameterized constructor:");
        book2.displayBook();
        
        sc.close();
    }
}