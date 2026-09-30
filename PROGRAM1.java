import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 * Week 8 Assignment - Problem 1: The Canteen Billing Counter
 * Category C
 * 
 * Demonstrates polymorphism:
 * Base class Customer with specialized subclasses StudentCustomer, StaffCustomer, GuestCustomer.
 */
public class PROGRAM1 {

    abstract static class Customer {
        protected double amount;

        public Customer(double amount) {
            this.amount = amount;
        }

        public abstract String getCustomerType();
        public abstract double calculateFinalAmount();
    }

    static class StudentCustomer extends Customer {
        public StudentCustomer(double amount) {
            super(amount);
        }

        @Override
        public String getCustomerType() {
            return "STUDENT";
        }

        @Override
        public double calculateFinalAmount() {
            // Students get a 10% discount
            return amount * 0.90;
        }
    }

    static class StaffCustomer extends Customer {
        public StaffCustomer(double amount) {
            super(amount);
        }

        @Override
        public String getCustomerType() {
            return "STAFF";
        }

        @Override
        public double calculateFinalAmount() {
            // Staff get a 5% discount
            return amount * 0.95;
        }
    }

    static class GuestCustomer extends Customer {
        public GuestCustomer(double amount) {
            super(amount);
        }

        @Override
        public String getCustomerType() {
            return "GUEST";
        }

        @Override
        public double calculateFinalAmount() {
            // Guests pay full amount plus 10 service charge
            return amount + 10.0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        List<Customer> customers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double amount = scanner.nextDouble();

            if ("STUDENT".equalsIgnoreCase(type)) {
                customers.add(new StudentCustomer(amount));
            } else if ("STAFF".equalsIgnoreCase(type)) {
                customers.add(new StaffCustomer(amount));
            } else if ("GUEST".equalsIgnoreCase(type)) {
                customers.add(new GuestCustomer(amount));
            }
        }

        double total = 0.0;
        for (Customer c : customers) {
            double finalAmount = c.calculateFinalAmount();
            System.out.printf("%s: %.2f\n", c.getCustomerType(), finalAmount);
            total += finalAmount;
        }

        System.out.printf("Total: %.2f\n", total);
        scanner.close();
    }
}