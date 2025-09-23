// File: LibrarySystem.java
// ASSIGNMENT 3: Library Book Tracking

public class LibrarySystem {
    
    public static class Book {
        private String isbn;
        private String title;
        private boolean isIssued;
        private static int totalBooks = 0;
        private static int issuedBooks = 0;
        
        public Book(String title) {
            this.isbn = generateISBN();
            this.title = title;
            this.isIssued = false;
            totalBooks++;
        }
        
        private static String generateISBN() {
            return "ISBN-" + String.format("%04d", totalBooks + 1);
        }
        
        public void issueBook() {
            if (!isIssued) {
                isIssued = true;
                issuedBooks++;
                System.out.println("Book issued: " + title);
            }
        }
        
        public void returnBook() {
            if (isIssued) {
                isIssued = false;
                issuedBooks--;
                System.out.println("Book returned: " + title);
            }
        }
        
        public static boolean validateISBN(String isbn) {
            return isbn != null && isbn.startsWith("ISBN-");
        }
        
        public static void displayStatistics() {
            System.out.println("Total books: " + totalBooks);
            System.out.println("Issued books: " + issuedBooks);
            System.out.println("Available books: " + (totalBooks - issuedBooks));
        }
        
        public void displayBook() {
            System.out.println(isbn + ": " + title + " - " + (isIssued ? "Issued" : "Available"));
        }
    }
    
    public static void main(String[] args) {
        Book b1 = new Book("Java Programming");
        Book b2 = new Book("Data Structures");
        Book b3 = new Book("Algorithms");
        
        Book.displayStatistics();
        
        b1.issueBook();
        b2.issueBook();
        
        System.out.println("\nAfter issuing books:");
        Book.displayStatistics();
        
        b1.displayBook();
        b2.displayBook();
        b3.displayBook();
    }
}