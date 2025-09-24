// LAB 4: University Library System - Upcasting
class LibraryUser {
    protected String name;
    protected String id;
    protected String userType;
    
    public LibraryUser(String name, String id, String userType) {
        this.name = name;
        this.id = id;
        this.userType = userType;
    }
    
    public void enterLibrary() {
        System.out.println("✅ " + name + " (" + userType + ") entered library - ID: " + id);
    }
    
    public void displayInfo() {
        System.out.println("User: " + name + " | Type: " + userType + " | ID: " + id);
    }
    
    public void browsebooks() {
        System.out.println("📚 " + name + " is browsing books");
    }
}

class Student extends LibraryUser {
    private String major;
    private int borrowLimit;
    
    public Student(String name, String id, String major) {
        super(name, id, "Student");
        this.major = major;
        this.borrowLimit = 5;
    }
    
    public void borrowBook(String book) {
        System.out.println("📖 Student " + name + " borrowed: " + book + " (Limit: " + borrowLimit + ")");
    }
    
    public void accessComputer() {
        System.out.println("💻 " + name + " accessing computer lab for " + major + " studies");
    }
}

class Faculty extends LibraryUser {
    private String department;
    
    public Faculty(String name, String id, String department) {
        super(name, id, "Faculty");
        this.department = department;
    }
    
    public void reserveBook(String book) {
        System.out.println("📋 Prof. " + name + " reserved: " + book + " for " + department + " research");
    }
    
    public void accessResearchDatabase() {
        System.out.println("🔬 " + name + " accessing research databases for " + department);
    }
}

class Guest extends LibraryUser {
    private String purpose;
    
    public Guest(String name, String id, String purpose) {
        super(name, id, "Guest");
        this.purpose = purpose;
    }
    
    public void requestAssistance() {
        System.out.println("🤝 Guest " + name + " requested assistance for: " + purpose);
    }
}

public class UniversityLibrarySystem {
    public static void processEntry(LibraryUser[] users) {
        System.out.println("=== Library Entry Processing ===");
        for (LibraryUser user : users) {
            user.enterLibrary();
            user.displayInfo();
            user.browsebooks();
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        LibraryUser[] visitors = {
            new Student("Alice Johnson", "S2021001", "Computer Science"),
            new Faculty("Dr. Smith", "F2019005", "Mathematics"),
            new Guest("John Visitor", "G2024001", "Research consultation"),
            new Student("Bob Chen", "S2022015", "Physics")
        };
        
        processEntry(visitors);
        
        System.out.println("=== Accessing Common Features ===");
        for (LibraryUser user : visitors) {
            System.out.println("Name: " + user.name + " | Type: " + user.userType);
        }
    }
}