import java.util.*;

class Book {
    private String title;
    private String author;
    
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    
    public void showDetails() {
        System.out.println("Book: " + title + " by " + author);
    }
}

class Member {
    private String name;
    private List<Book> borrowedBooks;
    
    public Member(String name) {
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }
    
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
        System.out.println(name + " borrowed: ");
        book.showDetails();
    }
}

class Librarian {
    private String name;
    
    public Librarian(String name) {
        this.name = name;
    }
    
    public void manageBooks() {
        System.out.println("Librarian " + name + " is managing books");
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Book book1 = new Book("Java Basics", "Oracle");
        Book book2 = new Book("Data Structures", "Cormen");
        
        Member member = new Member("Alice");
        Librarian librarian = new Librarian("Bob");
        
        member.borrowBook(book1);
        member.borrowBook(book2);
        librarian.manageBooks();
    }
}