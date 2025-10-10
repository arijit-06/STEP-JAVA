/*
LAB PROBLEM 1: Comparing Objects Using equals() and == 
Topic: Object Class Methods – equals() vs ==
*/

import java.util.Objects;

class Book {
    private String title;
    private String author;
    
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }
    
    @Override
    public String toString() {
        return "Book{title='" + title + "', author='" + author + "'}";
    }
}

public class BookComparison {
    public static void main(String[] args) {
        Book book1 = new Book("Java Programming", "John Doe");
        Book book2 = new Book("Java Programming", "John Doe");
        Book book3 = book1;
        
        System.out.println("=== Book Comparison Demo ===");
        System.out.println("Book1: " + book1);
        System.out.println("Book2: " + book2);
        System.out.println("Book3: " + book3);
        
        System.out.println("\n--- Reference Comparison (==) ---");
        System.out.println("book1 == book2: " + (book1 == book2)); // false
        System.out.println("book1 == book3: " + (book1 == book3)); // true
        
        System.out.println("\n--- Content Comparison (.equals()) ---");
        System.out.println("book1.equals(book2): " + book1.equals(book2)); // true
        System.out.println("book1.equals(book3): " + book1.equals(book3)); // true
        
        System.out.println("\n--- Analysis ---");
        System.out.println("== compares memory references");
        System.out.println(".equals() compares actual content");
    }
}