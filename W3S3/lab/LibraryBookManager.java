class Book {
    private String bookId;
    private String title;
    private String author;
    private boolean isAvailable;
    private static int totalBooks = 0;
    private static int availableBooks = 0;
    
    public Book(String title, String author) {
        this.bookId = generateBookId();
        this.title = title;
        this.author = author;
        this.isAvailable = true;
        totalBooks++;
        availableBooks++;
    }
    
    private static String generateBookId() {
        return "B" + String.format("%03d", totalBooks + 1);
    }
    
    public static int getTotalBooks() { return totalBooks; }
    public static int getAvailableBooks() { return availableBooks; }
    
    public void issueBook() {
        if (isAvailable) {
            isAvailable = false;
            availableBooks--;
            System.out.println("Book issued: " + title);
        } else {
            System.out.println("Book not available: " + title);
        }
    }
    
    public void returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            availableBooks++;
            System.out.println("Book returned: " + title);
        } else {
            System.out.println("Book was not issued: " + title);
        }
    }
    
    public void displayBookInfo() {
        System.out.println(bookId + ": " + title + " by " + author + " - " + 
                          (isAvailable ? "Available" : "Issued"));
    }
    
    public String getBookId() { return bookId; }
    public String getTitle() { return title; }
    public boolean isAvailable() { return isAvailable; }
}

class Member {
    private String memberId;
    private String memberName;
    private String[] booksIssued;
    private int bookCount;
    private static int totalMembers = 0;
    
    public Member(String memberName) {
        this.memberId = generateMemberId();
        this.memberName = memberName;
        this.booksIssued = new String[5]; // Max 5 books
        this.bookCount = 0;
        totalMembers++;
    }
    
    private static String generateMemberId() {
        return "M" + String.format("%03d", totalMembers + 1);
    }
    
    public static int getTotalMembers() { return totalMembers; }
    
    public void borrowBook(Book book) {
        if (bookCount < 5 && book.isAvailable()) {
            book.issueBook();
            booksIssued[bookCount] = book.getBookId();
            bookCount++;
            System.out.println(memberName + " borrowed: " + book.getTitle());
        } else if (bookCount >= 5) {
            System.out.println("Member has reached borrowing limit");
        }
    }
    
    public void returnBook(String bookId, Book[] books) {
        for (int i = 0; i < bookCount; i++) {
            if (booksIssued[i].equals(bookId)) {
                // Find and return the book
                for (Book book : books) {
                    if (book.getBookId().equals(bookId)) {
                        book.returnBook();
                        // Remove from member's list
                        for (int j = i; j < bookCount - 1; j++) {
                            booksIssued[j] = booksIssued[j + 1];
                        }
                        bookCount--;
                        System.out.println(memberName + " returned book: " + bookId);
                        return;
                    }
                }
            }
        }
        System.out.println("Book not found in member's issued list");
    }
    
    public void displayMemberInfo() {
        System.out.println("Member: " + memberId + " - " + memberName + " (Books: " + bookCount + ")");
        for (int i = 0; i < bookCount; i++) {
            System.out.println("  Issued: " + booksIssued[i]);
        }
    }
    
    public String getMemberId() { return memberId; }
    public String getMemberName() { return memberName; }
}

public class LibraryBookManager {
    public static void main(String[] args) {
        Book[] books = {
            new Book("Java Programming", "John Smith"),
            new Book("Data Structures", "Jane Doe"),
            new Book("Algorithms", "Bob Johnson"),
            new Book("Database Systems", "Alice Brown"),
            new Book("Web Development", "Charlie Wilson")
        };
        
        Member[] members = {
            new Member("Alice Johnson"),
            new Member("Bob Smith"),
            new Member("Carol Davis")
        };
        
        System.out.println("=== Library Book Management System ===");
        System.out.println("Total Books: " + Book.getTotalBooks());
        System.out.println("Available Books: " + Book.getAvailableBooks());
        System.out.println("Total Members: " + Member.getTotalMembers());
        
        System.out.println("\n=== Initial Book Status ===");
        for (Book book : books) {
            book.displayBookInfo();
        }
        
        System.out.println("\n=== Book Borrowing Operations ===");
        members[0].borrowBook(books[0]); // Alice borrows Java Programming
        members[0].borrowBook(books[1]); // Alice borrows Data Structures
        members[1].borrowBook(books[0]); // Bob tries to borrow Java (should fail)
        members[1].borrowBook(books[2]); // Bob borrows Algorithms
        
        System.out.println("\n=== Updated Book Status ===");
        for (Book book : books) {
            book.displayBookInfo();
        }
        System.out.println("Available Books: " + Book.getAvailableBooks());
        
        System.out.println("\n=== Member Information ===");
        for (Member member : members) {
            member.displayMemberInfo();
        }
        
        System.out.println("\n=== Book Return Operations ===");
        members[0].returnBook("B001", books); // Alice returns Java Programming
        
        System.out.println("\n=== Final Status ===");
        for (Book book : books) {
            book.displayBookInfo();
        }
        System.out.println("Available Books: " + Book.getAvailableBooks());
        
        System.out.println("\n=== Object Interaction Demonstration ===");
        System.out.println("✓ Member objects interact with Book objects");
        System.out.println("✓ Static variables track library-wide statistics");
        System.out.println("✓ Instance variables maintain individual object states");
    }
}