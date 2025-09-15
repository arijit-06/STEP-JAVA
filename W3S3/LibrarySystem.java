class Book {
    private String bookId;
    private String title;
    private String author;
    private boolean isAvailable;
    private static int totalBooks = 0;
    private static int availableBooks = 0;
    private static int bookCounter = 0;

    public Book(String title, String author) {
        this.bookId = generateBookId();
        this.title = title;
        this.author = author;
        this.isAvailable = true;
        totalBooks++;
        availableBooks++;
    }

    public void issueBook() {
        if (isAvailable) {
            isAvailable = false;
            availableBooks--;
            System.out.println("Book issued: " + title);
        } else {
            System.out.println("Book not available");
        }
    }

    public void returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            availableBooks++;
            System.out.println("Book returned: " + title);
        }
    }

    public void displayBookInfo() {
        System.out.println("ID: " + bookId + ", Title: " + title + ", Author: " + author + ", Available: " + isAvailable);
    }

    public static String generateBookId() {
        bookCounter++;
        return "B" + String.format("%03d", bookCounter);
    }

    public String getBookId() { return bookId; }
    public boolean isAvailable() { return isAvailable; }
    public static int getTotalBooks() { return totalBooks; }
    public static int getAvailableBooks() { return availableBooks; }
}

class Member {
    private String memberId;
    private String memberName;
    private String[] booksIssued;
    private int bookCount;
    private static int memberCounter = 0;

    public Member(String memberName) {
        this.memberId = generateMemberId();
        this.memberName = memberName;
        this.booksIssued = new String[5];
        this.bookCount = 0;
    }

    public void borrowBook(Book book) {
        if (book.isAvailable() && bookCount < 5) {
            book.issueBook();
            booksIssued[bookCount] = book.getBookId();
            bookCount++;
            System.out.println(memberName + " borrowed book ID: " + book.getBookId());
        } else {
            System.out.println("Cannot borrow book");
        }
    }

    public void returnBook(String bookId, Book[] books) {
        for (int i = 0; i < bookCount; i++) {
            if (booksIssued[i].equals(bookId)) {
                for (Book book : books) {
                    if (book.getBookId().equals(bookId)) {
                        book.returnBook();
                        for (int j = i; j < bookCount - 1; j++) {
                            booksIssued[j] = booksIssued[j + 1];
                        }
                        bookCount--;
                        System.out.println(memberName + " returned book ID: " + bookId);
                        return;
                    }
                }
            }
        }
        System.out.println("Book not found in member's list");
    }

    public static String generateMemberId() {
        memberCounter++;
        return "M" + String.format("%03d", memberCounter);
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Book[] books = {
            new Book("Java Programming", "James Gosling"),
            new Book("Data Structures", "Robert Sedgewick"),
            new Book("Algorithms", "Thomas Cormen")
        };

        Member[] members = {
            new Member("Alice Johnson"),
            new Member("Bob Smith")
        };

        for (Book book : books) {
            book.displayBookInfo();
        }

        members[0].borrowBook(books[0]);
        members[1].borrowBook(books[1]);
        
        System.out.println("Available books: " + Book.getAvailableBooks());
        
        members[0].returnBook(books[0].getBookId(), books);
        
        System.out.println("Available books: " + Book.getAvailableBooks());
    }
}