public class Book {
    String title;
    String author;
    double price;
    
    public Book() {
        this.title = "Generic Book";
        this.author = "Unknown Author";
        this.price = 0.0;
    }
    
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
    
    public void display() {
        System.out.println("Title: " + title + ", Author: " + author + ", Price: " + price);
    }
    
    public static void main(String[] args) {
        Book book1 = new Book();
        Book book2 = new Book("Java Programming", "Oracle", 299.99);
        
        book1.display();
        book2.display();
    }
}