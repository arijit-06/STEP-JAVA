// Library Book Management - Assignment Problem 3
import java.util.*;

class LibraryBook {
    private static int totalBooks = 0;
    private static Map<String, Integer> genreCount = new HashMap<>();
    
    private final String bookId;
    private String title;
    private String author;
    private String genre;
    private boolean isAvailable;
    private String borrowedBy;
    
    public LibraryBook(String title) {
        this(title, "Unknown Author", "General", true);
    }
    
    public LibraryBook(String title, String author) {
        this(title, author, "Fiction", true);
    }
    
    public LibraryBook(String title, String author, String genre) {
        this(title, author, genre, true);
    }
    
    public LibraryBook(String title, String author, String genre, boolean available) {
        this.bookId = "BOOK" + String.format("%05d", ++totalBooks);
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = available;
        this.borrowedBy = null;
        
        genreCount.put(genre, genreCount.getOrDefault(genre, 0) + 1);
        System.out.println("Book added: " + title + " by " + author + " (ID: " + bookId + ")");
    }
    
    public LibraryBook borrowBook(String memberName) {
        if (this.isAvailable) {
            this.isAvailable = false;
            this.borrowedBy = memberName;
            System.out.println(memberName + " borrowed: " + this.title);
        } else {
            System.out.println("Book not available: " + this.title);
        }
        return this;
    }
    
    public LibraryBook returnBook() {
        if (!this.isAvailable) {
            System.out.println(this.borrowedBy + " returned: " + this.title);
            this.isAvailable = true;
            this.borrowedBy = null;
        }
        return this;
    }
    
    public static int getTotalBooks() { return totalBooks; }
    public static Map<String, Integer> getGenreCount() { return new HashMap<>(genreCount); }
    public static void displayLibraryStats() {
        System.out.println("=== Library Statistics ===");
        System.out.println("Total Books: " + totalBooks);
        System.out.println("Genre Distribution:");
        for (Map.Entry<String, Integer> entry : genreCount.entrySet()) {
            System.out.println("  " + entry.getKey() + ": " + entry.getValue());
        }
    }
    
    public String getBookId() { return bookId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getGenre() { return genre; }
    public boolean isAvailable() { return isAvailable; }
    public String getBorrowedBy() { return borrowedBy; }
}

class TextBook extends LibraryBook {
    private String subject;
    private int edition;
    
    public TextBook(String title, String author, String subject) {
        super(title, author, "Textbook");
        this.subject = subject;
        this.edition = 1;
    }
    
    public TextBook(String title, String author, String subject, int edition) {
        super(title, author, "Textbook");
        this.subject = subject;
        this.edition = edition;
    }
    
    public String getSubject() { return subject; }
    public int getEdition() { return edition; }
}

class ReferenceBook extends LibraryBook {
    private boolean canBorrow;
    
    public ReferenceBook(String title, String author) {
        super(title, author, "Reference", false);
        this.canBorrow = false;
    }
    
    public ReferenceBook(String title, String author, boolean canBorrow) {
        super(title, author, "Reference", canBorrow);
        this.canBorrow = canBorrow;
    }
    
    @Override
    public LibraryBook borrowBook(String memberName) {
        if (canBorrow) {
            return super.borrowBook(memberName);
        } else {
            System.out.println("Reference books cannot be borrowed: " + getTitle());
            return this;
        }
    }
}

class DigitalBook extends LibraryBook {
    private String downloadLink;
    private int downloadCount;
    
    public DigitalBook(String title, String author) {
        super(title, author, "Digital");
        this.downloadLink = "http://library.com/books/" + getBookId();
        this.downloadCount = 0;
    }
    
    public DigitalBook(String title, String author, String genre) {
        super(title, author, genre);
        this.downloadLink = "http://library.com/books/" + getBookId();
        this.downloadCount = 0;
    }
    
    @Override
    public LibraryBook borrowBook(String memberName) {
        downloadCount++;
        System.out.println(memberName + " downloaded: " + getTitle() + " (Downloads: " + downloadCount + ")");
        return this;
    }
    
    public String getDownloadLink() { return downloadLink; }
    public int getDownloadCount() { return downloadCount; }
}

class LibraryMember {
    private static int totalMembers = 0;
    
    private final String memberId;
    private String name;
    private String membershipType;
    private List<String> borrowedBooks;
    private int borrowLimit;
    
    public LibraryMember(String name) {
        this(name, "Basic");
    }
    
    public LibraryMember(String name, String membershipType) {
        this.memberId = "MEM" + String.format("%04d", ++totalMembers);
        this.name = name;
        this.membershipType = membershipType;
        this.borrowedBooks = new ArrayList<>();
        this.borrowLimit = membershipType.equals("Premium") ? 10 : 5;
        System.out.println("Member registered: " + name + " (" + membershipType + ")");
    }
    
    public LibraryMember borrowBook(LibraryBook book) {
        if (this.borrowedBooks.size() < this.borrowLimit) {
            book.borrowBook(this.name);
            if (!book.isAvailable()) {
                this.borrowedBooks.add(book.getTitle());
            }
        } else {
            System.out.println("Borrow limit reached for " + this.name);
        }
        return this;
    }
    
    public LibraryMember returnBook(LibraryBook book) {
        book.returnBook();
        this.borrowedBooks.remove(book.getTitle());
        return this;
    }
    
    public LibraryMember upgradeMembership() {
        this.membershipType = "Premium";
        this.borrowLimit = 10;
        System.out.println(this.name + " upgraded to Premium membership");
        return this;
    }
    
    public static int getTotalMembers() { return totalMembers; }
    public String getName() { return name; }
    public String getMembershipType() { return membershipType; }
    public List<String> getBorrowedBooks() { return new ArrayList<>(borrowedBooks); }
}

class StudentMember extends LibraryMember {
    private String studentId;
    private String school;
    
    public StudentMember(String name, String studentId, String school) {
        super(name, "Student");
        this.studentId = studentId;
        this.school = school;
    }
    
    public String getStudentId() { return studentId; }
    public String getSchool() { return school; }
}

class FacultyMember extends LibraryMember {
    private String department;
    private String position;
    
    public FacultyMember(String name, String department) {
        super(name, "Faculty");
        this.department = department;
        this.position = "Professor";
    }
    
    public FacultyMember(String name, String department, String position) {
        super(name, "Faculty");
        this.department = department;
        this.position = position;
    }
    
    public String getDepartment() { return department; }
    public String getPosition() { return position; }
}

class LibraryManagementSystem {
    private static final Map<String, Object> bookCatalog = new HashMap<>();
    private static final Map<String, Object> memberRegistry = new HashMap<>();
    
    public static void addBook(Object book) {
        if (book instanceof LibraryBook) {
            LibraryBook b = (LibraryBook) book;
            bookCatalog.put(b.getBookId(), book);
        }
    }
    
    public static void registerMember(Object member) {
        if (member instanceof LibraryMember) {
            LibraryMember m = (LibraryMember) member;
            memberRegistry.put(m.getName(), member);
        }
    }
    
    public static void processBooksByType(String bookType) {
        System.out.println("\n=== Processing " + bookType + " Books ===");
        for (Object obj : bookCatalog.values()) {
            if (bookType.equals("TextBook") && obj instanceof TextBook) {
                TextBook textbook = (TextBook) obj;
                System.out.println("Textbook: " + textbook.getTitle() + " (Subject: " + textbook.getSubject() + ")");
            } else if (bookType.equals("Reference") && obj instanceof ReferenceBook) {
                ReferenceBook refBook = (ReferenceBook) obj;
                System.out.println("Reference: " + refBook.getTitle() + " (Available: " + refBook.isAvailable() + ")");
            } else if (bookType.equals("Digital") && obj instanceof DigitalBook) {
                DigitalBook digitalBook = (DigitalBook) obj;
                System.out.println("Digital: " + digitalBook.getTitle() + " (Downloads: " + digitalBook.getDownloadCount() + ")");
            }
        }
    }
    
    public static void processMembersByType(String memberType) {
        System.out.println("\n=== Processing " + memberType + " Members ===");
        for (Object obj : memberRegistry.values()) {
            if (memberType.equals("Student") && obj instanceof StudentMember) {
                StudentMember student = (StudentMember) obj;
                System.out.println("Student: " + student.getName() + " from " + student.getSchool());
            } else if (memberType.equals("Faculty") && obj instanceof FacultyMember) {
                FacultyMember faculty = (FacultyMember) obj;
                System.out.println("Faculty: " + faculty.getName() + " (" + faculty.getDepartment() + ")");
            }
        }
    }
    
    public static void displaySystemStats() {
        System.out.println("\n=== Library Management Statistics ===");
        System.out.println("Books in catalog: " + bookCatalog.size());
        System.out.println("Registered members: " + memberRegistry.size());
        LibraryBook.displayLibraryStats();
        System.out.println("Total members: " + LibraryMember.getTotalMembers());
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        System.out.println("=== Library Book Management System ===");
        
        // Create different book types with constructor patterns
        LibraryBook book1 = new LibraryBook("Java Programming");
        LibraryBook book2 = new LibraryBook("Data Structures", "Robert Sedgewick");
        TextBook textbook1 = new TextBook("Calculus", "James Stewart", "Mathematics", 8);
        ReferenceBook refBook1 = new ReferenceBook("Encyclopedia Britannica", "Various Authors");
        DigitalBook digitalBook1 = new DigitalBook("Digital Design", "Morris Mano", "Engineering");
        
        // Register books
        LibraryManagementSystem.addBook(book1);
        LibraryManagementSystem.addBook(book2);
        LibraryManagementSystem.addBook(textbook1);
        LibraryManagementSystem.addBook(refBook1);
        LibraryManagementSystem.addBook(digitalBook1);
        
        // Create different member types with constructor chaining
        LibraryMember member1 = new LibraryMember("John Doe");
        StudentMember student1 = new StudentMember("Alice Smith", "STU001", "MIT");
        FacultyMember faculty1 = new FacultyMember("Dr. Brown", "Computer Science", "Professor");
        
        // Register members
        LibraryManagementSystem.registerMember(member1);
        LibraryManagementSystem.registerMember(student1);
        LibraryManagementSystem.registerMember(faculty1);
        
        // Demonstrate method chaining with 'this'
        System.out.println("\n=== Method Chaining Demo ===");
        member1.borrowBook(book1).borrowBook(book2);
        student1.borrowBook(textbook1).upgradeMembership();
        
        // Test different book borrowing behaviors using instanceof
        faculty1.borrowBook(refBook1); // Should fail for reference book
        student1.borrowBook(digitalBook1); // Should work for digital book
        
        // Process books and members by type using instanceof
        LibraryManagementSystem.processBooksByType("TextBook");
        LibraryManagementSystem.processBooksByType("Digital");
        LibraryManagementSystem.processMembersByType("Student");
        LibraryManagementSystem.processMembersByType("Faculty");
        
        // Return books using method chaining
        System.out.println("\n=== Returning Books ===");
        member1.returnBook(book1).returnBook(book2);
        
        // Display final statistics
        LibraryManagementSystem.displaySystemStats();
        
        // Test instanceof with mixed objects
        System.out.println("\n=== Type Testing ===");
        Object[] items = {book1, textbook1, digitalBook1, member1, student1, "Not a library item"};
        
        for (Object obj : items) {
            if (obj instanceof TextBook) {
                System.out.println("✓ TextBook found");
            } else if (obj instanceof DigitalBook) {
                System.out.println("✓ DigitalBook found");
            } else if (obj instanceof LibraryBook) {
                System.out.println("✓ LibraryBook found");
            } else if (obj instanceof StudentMember) {
                System.out.println("✓ StudentMember found");
            } else if (obj instanceof LibraryMember) {
                System.out.println("✓ LibraryMember found");
            } else {
                System.out.println("✗ Unknown item: " + obj);
            }
        }
    }
}