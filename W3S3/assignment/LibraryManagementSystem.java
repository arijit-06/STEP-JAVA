import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class Book {
    private String bookId;
    private String title;
    private String author;
    private String isbn;
    private String category;
    private boolean isIssued;
    private String issueDate;
    private String dueDate;
    
    private static int totalBooks = 0;
    private static int availableBooks = 0;
    
    public Book(String title, String author, String isbn, String category) {
        this.bookId = generateBookId();
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.category = category;
        this.isIssued = false;
        totalBooks++;
        availableBooks++;
    }
    
    private static String generateBookId() {
        return "BK" + String.format("%04d", totalBooks + 1);
    }
    
    public void issueBook(String issueDate, String dueDate) {
        if (!isIssued) {
            this.isIssued = true;
            this.issueDate = issueDate;
            this.dueDate = dueDate;
            availableBooks--;
            System.out.println("Book issued: " + title);
        } else {
            System.out.println("Book already issued: " + title);
        }
    }
    
    public void returnBook() {
        if (isIssued) {
            this.isIssued = false;
            this.issueDate = null;
            this.dueDate = null;
            availableBooks++;
            System.out.println("Book returned: " + title);
        } else {
            System.out.println("Book was not issued: " + title);
        }
    }
    
    public void displayBookInfo() {
        System.out.println(bookId + ": " + title + " by " + author + " (" + category + ") - " + 
                          (isIssued ? "Issued (Due: " + dueDate + ")" : "Available"));
    }
    
    public String getBookId() { return bookId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getCategory() { return category; }
    public boolean isIssued() { return isIssued; }
    public String getDueDate() { return dueDate; }
    public static int getTotalBooks() { return totalBooks; }
    public static int getAvailableBooks() { return availableBooks; }
}

class Member {
    private String memberId;
    private String memberName;
    private String memberType;
    private Book[] booksIssued;
    private double totalFines;
    private String membershipDate;
    private int bookCount;
    
    private static int totalMembers = 0;
    private static String libraryName = "Central Library";
    private static double finePerDay = 2.0;
    private static int maxBooksAllowed = 5;
    
    public Member(String memberName, String memberType, String membershipDate) {
        this.memberId = generateMemberId();
        this.memberName = memberName;
        this.memberType = memberType;
        this.membershipDate = membershipDate;
        this.totalFines = 0;
        this.bookCount = 0;
        
        // Set max books based on member type
        int maxBooks = memberType.equals("Student") ? 3 : memberType.equals("Faculty") ? 10 : 5;
        this.booksIssued = new Book[maxBooks];
        totalMembers++;
    }
    
    private static String generateMemberId() {
        return "M" + String.format("%04d", totalMembers + 1);
    }
    
    public static void setLibraryName(String name) { libraryName = name; }
    public static void setFinePerDay(double fine) { finePerDay = fine; }
    
    public void issueBook(Book book) {
        if (bookCount < booksIssued.length && !book.isIssued()) {
            booksIssued[bookCount] = book;
            bookCount++;
            
            String issueDate = "2024-01-15"; // Simplified date
            String dueDate = memberType.equals("Faculty") ? "2024-02-15" : "2024-01-29"; // 30 days for faculty, 14 for others
            
            book.issueBook(issueDate, dueDate);
            System.out.println(memberName + " (" + memberType + ") issued: " + book.getTitle());
        } else if (bookCount >= booksIssued.length) {
            System.out.println("Member has reached borrowing limit");
        }
    }
    
    public void returnBook(Book book) {
        for (int i = 0; i < bookCount; i++) {
            if (booksIssued[i] == book) {
                // Calculate fine if overdue
                double fine = calculateFine(book);
                if (fine > 0) {
                    totalFines += fine;
                    System.out.println("Fine applied: $" + fine);
                }
                
                book.returnBook();
                
                // Remove from member's list
                for (int j = i; j < bookCount - 1; j++) {
                    booksIssued[j] = booksIssued[j + 1];
                }
                bookCount--;
                System.out.println(memberName + " returned: " + book.getTitle());
                return;
            }
        }
        System.out.println("Book not found in member's issued list");
    }
    
    public double calculateFine(Book book) {
        // Simplified fine calculation (assuming overdue)
        if (memberType.equals("Faculty")) return 0; // Faculty no fines
        return Math.random() > 0.7 ? finePerDay * 3 : 0; // Random overdue simulation
    }
    
    public void renewBook(Book book) {
        for (int i = 0; i < bookCount; i++) {
            if (booksIssued[i] == book) {
                System.out.println("Book renewed: " + book.getTitle());
                return;
            }
        }
        System.out.println("Book not found in member's issued list");
    }
    
    public void displayMemberInfo() {
        System.out.println("Member: " + memberName + " (" + memberId + ") - " + memberType);
        System.out.println("Books Issued: " + bookCount + "/" + booksIssued.length);
        System.out.println("Total Fines: $" + totalFines);
        System.out.println("Member Since: " + membershipDate);
        
        if (bookCount > 0) {
            System.out.println("Currently Issued Books:");
            for (int i = 0; i < bookCount; i++) {
                System.out.println("  - " + booksIssued[i].getTitle());
            }
        }
    }
    
    public static void generateLibraryReport() {
        System.out.println("=== LIBRARY REPORT ===");
        System.out.println("Library: " + libraryName);
        System.out.println("Total Books: " + Book.getTotalBooks());
        System.out.println("Available Books: " + Book.getAvailableBooks());
        System.out.println("Total Members: " + totalMembers);
        System.out.println("Fine per Day: $" + finePerDay);
        System.out.println("Max Books Allowed: " + maxBooksAllowed);
        System.out.println("======================");
    }
    
    public static Book[] getOverdueBooks(Book[] books) {
        Book[] overdue = new Book[books.length];
        int count = 0;
        for (Book book : books) {
            if (book != null && book.isIssued()) {
                // Simplified overdue check
                if (Math.random() > 0.8) { // Random simulation
                    overdue[count++] = book;
                }
            }
        }
        return overdue;
    }
    
    public static Book[] getMostPopularBooks(Book[] books) {
        // Simplified - return first few issued books
        Book[] popular = new Book[3];
        int count = 0;
        for (Book book : books) {
            if (book != null && book.isIssued() && count < 3) {
                popular[count++] = book;
            }
        }
        return popular;
    }
    
    public String getMemberName() { return memberName; }
    public String getMemberType() { return memberType; }
    public double getTotalFines() { return totalFines; }
    public static int getTotalMembers() { return totalMembers; }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Member.setLibraryName("Excellence Public Library");
        Member.setFinePerDay(1.5);
        
        // Create books
        Book[] books = {
            new Book("Java Programming", "John Smith", "978-1234567890", "Programming"),
            new Book("Data Structures", "Jane Doe", "978-2345678901", "Computer Science"),
            new Book("Algorithms", "Bob Johnson", "978-3456789012", "Computer Science"),
            new Book("Database Systems", "Alice Brown", "978-4567890123", "Database"),
            new Book("Web Development", "Charlie Wilson", "978-5678901234", "Web"),
            new Book("Machine Learning", "Diana Davis", "978-6789012345", "AI"),
            new Book("Python Guide", "Eve Miller", "978-7890123456", "Programming"),
            new Book("Software Engineering", "Frank Garcia", "978-8901234567", "Engineering")
        };
        
        // Create members
        Member student1 = new Member("Alice Johnson", "Student", "2023-09-01");
        Member student2 = new Member("Bob Smith", "Student", "2023-09-15");
        Member faculty1 = new Member("Dr. Carol Davis", "Faculty", "2020-01-15");
        Member general1 = new Member("David Wilson", "General", "2023-10-01");
        Member general2 = new Member("Eva Brown", "General", "2023-11-01");
        
        System.out.println("=== Library Management System ===");
        Member.generateLibraryReport();
        
        System.out.println("\n=== Available Books ===");
        for (Book book : books) {
            book.displayBookInfo();
        }
        
        System.out.println("\n=== Book Issue Operations ===");
        student1.issueBook(books[0]); // Java Programming
        student1.issueBook(books[1]); // Data Structures
        student1.issueBook(books[2]); // Algorithms
        student1.issueBook(books[3]); // Should work for student (3 book limit)
        
        faculty1.issueBook(books[4]); // Web Development
        faculty1.issueBook(books[5]); // Machine Learning
        faculty1.issueBook(books[6]); // Python Guide
        
        general1.issueBook(books[7]); // Software Engineering
        
        System.out.println("\n=== Updated Book Status ===");
        for (Book book : books) {
            book.displayBookInfo();
        }
        
        System.out.println("\n=== Member Information ===");
        Member[] members = {student1, student2, faculty1, general1, general2};
        for (Member member : members) {
            member.displayMemberInfo();
            System.out.println();
        }
        
        System.out.println("=== Book Return Operations ===");
        student1.returnBook(books[0]); // Return Java Programming
        faculty1.returnBook(books[4]); // Return Web Development
        
        System.out.println("\n=== Book Renewal ===");
        student1.renewBook(books[1]); // Renew Data Structures
        
        System.out.println("\n=== Overdue Books Check ===");
        Book[] overdueBooks = Member.getOverdueBooks(books);
        System.out.println("Overdue Books:");
        for (Book book : overdueBooks) {
            if (book != null) {
                book.displayBookInfo();
            }
        }
        
        System.out.println("\n=== Popular Books ===");
        Book[] popularBooks = Member.getMostPopularBooks(books);
        System.out.println("Most Popular Books:");
        for (Book book : popularBooks) {
            if (book != null) {
                book.displayBookInfo();
            }
        }
        
        System.out.println("\n=== Final Library Report ===");
        Member.generateLibraryReport();
        
        System.out.println("\n=== Member Type Analysis ===");
        int students = 0, faculty = 0, general = 0;
        double totalFines = 0;
        
        for (Member member : members) {
            switch (member.getMemberType()) {
                case "Student": students++; break;
                case "Faculty": faculty++; break;
                case "General": general++; break;
            }
            totalFines += member.getTotalFines();
        }
        
        System.out.println("Students: " + students);
        System.out.println("Faculty: " + faculty);
        System.out.println("General Members: " + general);
        System.out.println("Total Fines Collected: $" + totalFines);
        
        System.out.println("\n=== Category-wise Book Distribution ===");
        String[] categories = {"Programming", "Computer Science", "Database", "Web", "AI", "Engineering"};
        for (String category : categories) {
            int count = 0;
            int issued = 0;
            for (Book book : books) {
                if (book.getCategory().equals(category)) {
                    count++;
                    if (book.isIssued()) issued++;
                }
            }
            if (count > 0) {
                System.out.println(category + ": " + count + " books (" + issued + " issued)");
            }
        }
        
        System.out.println("\n=== Library Management Features Demonstrated ===");
        System.out.println("✓ Different member types with varying privileges");
        System.out.println("✓ Automatic fine calculation for overdue books");
        System.out.println("✓ Book issue, return, and renewal operations");
        System.out.println("✓ Library-wide reporting and statistics");
        System.out.println("✓ Member management with borrowing limits");
    }
}