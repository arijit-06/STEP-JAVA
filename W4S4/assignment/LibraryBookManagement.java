import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;
    
    // Default constructor
    public Book() {
        this.title = "Unknown Title";
        this.author = "Unknown Author";
        this.isbn = "000-0000000000";
        this.isAvailable = true;
    }
    
    // Constructor with title and author
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isbn = "000-0000000000";
        this.isAvailable = true;
    }
    
    // Constructor with all details
    public Book(String title, String author, String isbn, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = isAvailable;
    }
    
    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Book borrowed successfully!");
        } else {
            System.out.println("Book is not available!");
        }
    }
    
    public void returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println("Book returned successfully!");
        } else {
            System.out.println("Book was not borrowed!");
        }
    }
    
    public void displayBookInfo() {
        System.out.println("📚 BOOK INFORMATION 📚");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("Status: " + (isAvailable ? "Available" : "Borrowed"));
        System.out.println("-------------------");
    }
}

public class LibraryBookManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== LIBRARY BOOK MANAGEMENT SYSTEM ===\n");
        
        // Default book
        Book book1 = new Book();
        System.out.println("Default Book:");
        book1.displayBookInfo();
        
        // Book with title and author
        Book book2 = new Book("Java Programming", "James Gosling");
        System.out.println("Book with Title and Author:");
        book2.displayBookInfo();
        
        // Book with all details
        Book book3 = new Book("Clean Code", "Robert Martin", "978-0132350884", true);
        System.out.println("Book with All Details:");
        book3.displayBookInfo();
        
        // Perform operations
        System.out.println("Borrowing and returning books:");
        book2.borrowBook();
        book2.displayBookInfo();
        
        book2.returnBook();
        book2.displayBookInfo();
        
        book3.borrowBook();
        book3.displayBookInfo();
        
        sc.close();
    }
}