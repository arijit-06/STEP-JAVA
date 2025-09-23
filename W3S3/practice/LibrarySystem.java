class Book {
    private String title;
    private String author;
    private String isbn;
    private double price;
    private int quantity;
    
    public Book(String title, String author, String isbn, double price, int quantity) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
        this.quantity = quantity;
    }
    
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    
    public void updateQuantity(int newQuantity) {
        this.quantity = newQuantity;
    }
    
    public void displayBook() {
        System.out.println(title + " by " + author + " - $" + price + " (Qty: " + quantity + ")");
    }
}

class Library {
    private String libraryName;
    private Book[] books;
    private int totalBooks;
    
    public Library(String libraryName, int capacity) {
        this.libraryName = libraryName;
        this.books = new Book[capacity];
        this.totalBooks = 0;
    }
    
    public void addBook(Book book) {
        if (totalBooks < books.length) {
            books[totalBooks] = book;
            totalBooks++;
            System.out.println("Added: " + book.getTitle());
        } else {
            System.out.println("Library is full!");
        }
    }
    
    public Book searchByTitle(String title) {
        for (int i = 0; i < totalBooks; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }
    
    public Book searchByAuthor(String author) {
        for (int i = 0; i < totalBooks; i++) {
            if (books[i].getAuthor().equalsIgnoreCase(author)) {
                return books[i];
            }
        }
        return null;
    }
    
    public void displayInventory() {
        System.out.println("\n=== " + libraryName + " Inventory ===");
        for (int i = 0; i < totalBooks; i++) {
            books[i].displayBook();
        }
    }
    
    public double calculateTotalValue() {
        double total = 0;
        for (int i = 0; i < totalBooks; i++) {
            total += books[i].getPrice() * books[i].getQuantity();
        }
        return total;
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Library library = new Library("City Central Library", 10);
        
        Book book1 = new Book("Java Programming", "John Smith", "978-1234567890", 45.99, 5);
        Book book2 = new Book("Data Structures", "Jane Doe", "978-0987654321", 52.50, 3);
        Book book3 = new Book("Algorithms", "Bob Johnson", "978-1122334455", 48.75, 4);
        Book book4 = new Book("Database Systems", "Alice Brown", "978-5566778899", 55.00, 2);
        
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        
        library.displayInventory();
        
        System.out.println("\n=== Search Operations ===");
        Book found = library.searchByTitle("Java Programming");
        if (found != null) {
            System.out.print("Found by title: ");
            found.displayBook();
        }
        
        found = library.searchByAuthor("Jane Doe");
        if (found != null) {
            System.out.print("Found by author: ");
            found.displayBook();
        }
        
        System.out.println("\n=== Library Statistics ===");
        System.out.println("Total inventory value: $" + library.calculateTotalValue());
        
        System.out.println("\n=== Object Interaction Demonstration ===");
        System.out.println("// Library object contains Book objects (composition)");
        System.out.println("// Library methods work with Book objects");
        System.out.println("// Books maintain their own state while being managed by Library");
    }
}