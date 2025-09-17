public class LibraryBook {
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;
    
    public LibraryBook() {
        this.title = "";
        this.author = "";
        this.isbn = "";
        this.isAvailable = true;
    }
    
    public LibraryBook(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }
    
    public LibraryBook(String title, String author, String isbn, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = isAvailable;
    }
    
    public void borrowBook() {
        isAvailable = false;
    }
    
    public void returnBook() {
        isAvailable = true;
    }
    
    public void displayBookInfo() {
        System.out.println("Title: " + title + ", Author: " + author + 
                          ", ISBN: " + isbn + ", Available: " + isAvailable);
    }
    
    public static void main(String[] args) {
        LibraryBook book1 = new LibraryBook();
        LibraryBook book2 = new LibraryBook("Java Programming", "Oracle");
        LibraryBook book3 = new LibraryBook("Clean Code", "Robert Martin", "978-0132350884", true);
        
        System.out.println("Initial Status:");
        book1.displayBookInfo();
        book2.displayBookInfo();
        book3.displayBookInfo();
        
        book2.borrowBook();
        book3.borrowBook();
        
        System.out.println("\nAfter borrowing:");
        book2.displayBookInfo();
        book3.displayBookInfo();
        
        book2.returnBook();
        
        System.out.println("\nAfter returning book2:");
        book2.displayBookInfo();
    }
}