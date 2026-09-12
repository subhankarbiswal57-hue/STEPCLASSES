/**
 * Week 6 Practice - Problem 5: Library Management System (Encapsulation + Composition)
 * Classes: Book, Member, Library. Demonstrates object composition, search, and borrow/return.
 */
public class PROGRAM5 {

    static class Book {
        private String title;
        private String author;
        private boolean isBorrowed;

        public Book(String title, String author) {
            this.title = title;
            this.author = author;
            this.isBorrowed = false;
        }

        public String getTitle() { return title; }
        public String getAuthor() { return author; }
        public boolean isBorrowed() { return isBorrowed; }
        public void setBorrowed(boolean borrowed) { isBorrowed = borrowed; }

        @Override
        public String toString() {
            return "\"" + title + "\" by " + author + (isBorrowed ? " [BORROWED]" : " [AVAILABLE]");
        }
    }

    static class Member {
        private String name;
        private int memberId;

        public Member(String name, int memberId) {
            this.name = name;
            this.memberId = memberId;
        }

        public String getName() { return name; }
        public int getMemberId() { return memberId; }

        @Override
        public String toString() {
            return "Member #" + memberId + ": " + name;
        }
    }

    static class Library {
        private Book[] books;
        private int bookCount;

        public Library(int capacity) {
            this.books = new Book[capacity];
            this.bookCount = 0;
        }

        public void addBook(Book book) {
            if (bookCount < books.length) {
                books[bookCount++] = book;
            } else {
                System.out.println("Library is full. Cannot add: " + book.getTitle());
            }
        }

        public Book searchByTitle(String title) {
            for (int i = 0; i < bookCount; i++) {
                if (books[i].getTitle().equalsIgnoreCase(title)) {
                    return books[i];
                }
            }
            return null;
        }

        public boolean borrowBook(String title, Member member) {
            Book book = searchByTitle(title);
            if (book == null) {
                System.out.println("Book \"" + title + "\" not found.");
                return false;
            }
            if (book.isBorrowed()) {
                System.out.println("Book \"" + title + "\" is already borrowed.");
                return false;
            }
            book.setBorrowed(true);
            System.out.println(member.getName() + " borrowed \"" + title + "\"");
            return true;
        }

        public boolean returnBook(String title) {
            Book book = searchByTitle(title);
            if (book == null || !book.isBorrowed()) {
                System.out.println("Cannot return \"" + title + "\".");
                return false;
            }
            book.setBorrowed(false);
            System.out.println("\"" + title + "\" has been returned.");
            return true;
        }

        public void displayCatalog() {
            System.out.println("--- Library Catalog ---");
            for (int i = 0; i < bookCount; i++) {
                System.out.println((i + 1) + ". " + books[i]);
            }
        }
    }

    public static void main(String[] args) {
        Library library = new Library(10);
        library.addBook(new Book("Clean Code", "Robert C. Martin"));
        library.addBook(new Book("Effective Java", "Joshua Bloch"));
        library.addBook(new Book("Head First Java", "Kathy Sierra"));

        Member m1 = new Member("Subhankar", 201);
        Member m2 = new Member("Priya", 202);

        library.displayCatalog();
        System.out.println();

        library.borrowBook("Clean Code", m1);
        library.borrowBook("Clean Code", m2); // should fail
        library.displayCatalog();
        System.out.println();

        library.returnBook("Clean Code");
        library.displayCatalog();
    }
}