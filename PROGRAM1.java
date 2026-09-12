/**
 * Week 6 Assignment - Problem 1: Library Inventory Management
 * Refactors parallel arrays into an OOP design with BookInventory class.
 */
public class PROGRAM1 {

    static class BookInventory {
        private String title;
        private String author;
        private int copiesAvailable;

        public BookInventory(String title, String author, int copiesAvailable) {
            this.title = title;
            this.author = author;
            this.copiesAvailable = copiesAvailable;
        }

        public void printEntry() {
            System.out.println(title + " by " + author + " - " + copiesAvailable + " copies available");
        }
    }

    public static void main(String[] args) {
        BookInventory[] books = {
            new BookInventory("Clean Code", "Robert C. Martin", 3),
            new BookInventory("Effective Java", "Joshua Bloch", 5),
            new BookInventory("Refactoring", "Martin Fowler", 0),
            new BookInventory("Design Patterns", "GoF", 2)
        };

        for (BookInventory book : books) {
            book.printEntry();
        }
    }
}