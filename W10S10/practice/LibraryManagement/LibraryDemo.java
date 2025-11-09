public class LibraryDemo {
    public static void main(String[] args) {
        Library lib = new Library("Central City");
        
        Book book1 = new Book("Java Programming", "James Gosling", "978-0134685991");
        Book book2 = new Book("Clean Code", "Robert Martin", "978-0132350884");
        Book book3 = new Book("Design Patterns", "Gang of Four", "978-0201633612");
        
        lib.addBook(book1);
        lib.addBook(book2);
        lib.addBook(book3);
        
        lib.showBooks();
        
        Member member = new Member("Ravi");
        member.borrowBook(book1);
        member.borrowBook(book2);
        
        member.showBorrowedBooks();
    }
}