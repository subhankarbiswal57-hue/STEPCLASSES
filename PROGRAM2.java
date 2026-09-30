import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Week 8 Practice - Problem 2: Library Item Due Date Calculator
 * 
 * Demonstrates inheritance and polymorphism:
 * Base class LibraryItem with specialized subclasses Book, Dvd, Magazine.
 */
public class PROGRAM2 {

    abstract static class LibraryItem {
        protected String title;
        protected LocalDate borrowedDate;

        public LibraryItem(String title, LocalDate borrowedDate) {
            this.title = title;
            this.borrowedDate = borrowedDate;
        }

        public String getTitle() {
            return title;
        }

        public abstract LocalDate calculateDueDate();
    }

    static class Book extends LibraryItem {
        public Book(String title, LocalDate borrowedDate) {
            super(title, borrowedDate);
        }

        @Override
        public LocalDate calculateDueDate() {
            return borrowedDate.plusDays(14); // 14 days borrowing period
        }
    }

    static class Dvd extends LibraryItem {
        public Dvd(String title, LocalDate borrowedDate) {
            super(title, borrowedDate);
        }

        @Override
        public LocalDate calculateDueDate() {
            return borrowedDate.plusDays(7); // 7 days borrowing period
        }
    }

    static class Magazine extends LibraryItem {
        public Magazine(String title, LocalDate borrowedDate) {
            super(title, borrowedDate);
        }

        @Override
        public LocalDate calculateDueDate() {
            return borrowedDate.plusDays(3); // 3 days borrowing period
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = Integer.parseInt(scanner.nextLine().trim());
        LocalDate currentDate = LocalDate.parse("2023-10-26");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        List<LibraryItem> items = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            int spaceIdx = line.indexOf(' ');
            String itemType = line.substring(0, spaceIdx).trim();
            String titleRaw = line.substring(spaceIdx + 1).trim();
            if (titleRaw.startsWith("\"") && titleRaw.endsWith("\"")) {
                titleRaw = titleRaw.substring(1, titleRaw.length() - 1);
            }

            if ("BOOK".equalsIgnoreCase(itemType)) {
                items.add(new Book(titleRaw, currentDate));
            } else if ("DVD".equalsIgnoreCase(itemType)) {
                items.add(new Dvd(titleRaw, currentDate));
            } else if ("MAGAZINE".equalsIgnoreCase(itemType)) {
                items.add(new Magazine(titleRaw, currentDate));
            }
        }

        for (LibraryItem item : items) {
            System.out.printf("%s: %s\n", item.getTitle(), item.calculateDueDate().format(formatter));
        }

        scanner.close();
    }
}
