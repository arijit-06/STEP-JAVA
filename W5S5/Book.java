public class Book {
    private String title;
    private String author;
    private int pages;
    private double price;
    
    // Default constructor
    public Book() {
        this("Unknown", "Anonymous", 0, 0.0);
    }
    
    // Constructor with title only
    public Book(String title) {
        this(title, "Anonymous", 100, 10.0);
    }
    
    // Constructor with title and author
    public Book(String title, String author) {
        this(title, author, 200, 15.0);
    }
    
    // Full constructor (all others chain to this)
    public Book(String title, String author, int pages, double price) {
        this.title = (title != null && !title.trim().isEmpty()) ? title : "Unknown";
        this.author = (author != null && !author.trim().isEmpty()) ? author : "Anonymous";
        this.pages = (pages >= 0) ? pages : 0;
        this.price = (price >= 0) ? price : 0.0;
    }
    
    public void displayInfo() {
        System.out.println("Book: " + title + " by " + author + 
                         " (" + pages + " pages, $" + price + ")");
    }
    
    public boolean isExpensive() {
        return price > 20.0;
    }
    
    public String getBookSummary() {
        return title + " - " + (isExpensive() ? "Premium" : "Standard") + " book";
    }
    
    // Getters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getPages() { return pages; }
    public double getPrice() { return price; }
    
    public static void main(String[] args) {
        System.out.println("=== Book Constructor Demo ===");
        
        Book book1 = new Book();
        book1.displayInfo();
        System.out.println("Summary: " + book1.getBookSummary());
        
        Book book2 = new Book("Java Programming");
        book2.displayInfo();
        System.out.println("Summary: " + book2.getBookSummary());
        
        Book book3 = new Book("Advanced Java", "John Doe");
        book3.displayInfo();
        System.out.println("Summary: " + book3.getBookSummary());
        
        Book book4 = new Book("Expert Java", "Jane Smith", 500, 25.0);
        book4.displayInfo();
        System.out.println("Summary: " + book4.getBookSummary());
        System.out.println("Is expensive: " + book4.isExpensive());
    }
}