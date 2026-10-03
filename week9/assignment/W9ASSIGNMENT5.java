import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 * Week 9 Assignment - Problem 5: The Movie Theatre Ticket Pricing System
 *
 * Demonstrates polymorphism:
 * Base class Ticket with subclasses ChildTicket, AdultTicket, SeniorTicket.
 * Applies different pricing and concessions per category.
 * Generates a complete booking summary.
 */
public class W9ASSIGNMENT5 {

    abstract static class Ticket {
        protected String seatNumber;
        protected String showName;

        public Ticket(String seatNumber, String showName) {
            this.seatNumber = seatNumber;
            this.showName = showName;
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        public String getShowName() {
            return showName;
        }

        public abstract double getBasePrice();
        public abstract double getDiscount();
        public abstract String getTicketCategory();

        public double calculateFinalPrice() {
            return getBasePrice() - getDiscount();
        }
    }

    static class ChildTicket extends Ticket {
        public ChildTicket(String seatNumber, String showName) {
            super(seatNumber, showName);
        }

        @Override
        public double getBasePrice() {
            return 150.0;
        }

        @Override
        public double getDiscount() {
            return 50.0; // Rs 50 off for children
        }

        @Override
        public String getTicketCategory() {
            return "CHILD";
        }
    }

    static class AdultTicket extends Ticket {
        public AdultTicket(String seatNumber, String showName) {
            super(seatNumber, showName);
        }

        @Override
        public double getBasePrice() {
            return 300.0;
        }

        @Override
        public double getDiscount() {
            return 0.0; // No discount for adults
        }

        @Override
        public String getTicketCategory() {
            return "ADULT";
        }
    }

    static class SeniorTicket extends Ticket {
        public SeniorTicket(String seatNumber, String showName) {
            super(seatNumber, showName);
        }

        @Override
        public double getBasePrice() {
            return 300.0;
        }

        @Override
        public double getDiscount() {
            return 75.0; // Rs 75 off for senior citizens
        }

        @Override
        public String getTicketCategory() {
            return "SENIOR";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        scanner.nextLine();
        List<Ticket> tickets = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            String[] parts = line.split(" ");
            String category = parts[0];
            String seat = parts[1];
            String show = parts[2];

            if ("CHILD".equalsIgnoreCase(category)) {
                tickets.add(new ChildTicket(seat, show));
            } else if ("ADULT".equalsIgnoreCase(category)) {
                tickets.add(new AdultTicket(seat, show));
            } else if ("SENIOR".equalsIgnoreCase(category)) {
                tickets.add(new SeniorTicket(seat, show));
            }
        }

        double totalRevenue = 0.0;
        System.out.println("--- Booking Summary ---");
        for (Ticket t : tickets) {
            double price = t.calculateFinalPrice();
            System.out.printf("Seat %s | %s | %s | Rs %.2f%n",
                    t.getSeatNumber(), t.getShowName(), t.getTicketCategory(), price);
            totalRevenue += price;
        }
        System.out.printf("Total Revenue: %.2f%n", totalRevenue);
        scanner.close();
    }
}
