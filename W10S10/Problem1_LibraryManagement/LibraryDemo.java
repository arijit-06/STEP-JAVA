public class LibraryDemo {
    public static void main(String[] args) {
        // Step 1 - Create a Library object
        Library lib = new Library("Central City");

        // Step 2 - Create 3 Book objects with sample data
        Book book1 = new Book("Java Programming", "James Gosling", "978-0134685991");
        Book book2 = new Book("Data Structures", "Robert Lafore", "978-0672324536");
        Book book3 = new Book("Algorithms", "Thomas Cormen", "978-0262033848");

        // Step 3 - Add books to library using addBook()
        lib.addBook(book1);
        lib.addBook(book2);
        lib.addBook(book3);

        // Step 4 - Display all books in the library using showBooks()
        lib.showBooks();

        // Step 5 - Create a Member object
        Member member = new Member("Ravi");

        // Step 6 - Borrow 2 books using borrowBook()
        member.borrowBook(book1);
        member.borrowBook(book2);

        // Step 7 - Display borrowed books using showBorrowedBooks()
        member.showBorrowedBooks();
    }
}