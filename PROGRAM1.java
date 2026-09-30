import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 * Week 8 Practice - Problem 1: Payment System Fee Calculation
 * 
 * Demonstrates polymorphism:
 * Base class Payment with specialized subclasses CardPayment, WalletPayment, BankTransferPayment.
 */
public class PROGRAM1 {

    abstract static class Payment {
        protected double amount;

        public Payment(double amount) {
            this.amount = amount;
        }

        public abstract String getPaymentType();
        public abstract double calculateAdjustedAmount();
    }

    static class CardPayment extends Payment {
        public CardPayment(double amount) {
            super(amount);
        }

        @Override
        public String getPaymentType() {
            return "CARD";
        }

        @Override
        public double calculateAdjustedAmount() {
            return amount * 1.02; // 2% processing fee
        }
    }

    static class WalletPayment extends Payment {
        public WalletPayment(double amount) {
            super(amount);
        }

        @Override
        public String getPaymentType() {
            return "WALLET";
        }

        @Override
        public double calculateAdjustedAmount() {
            return amount * 1.01; // 1% processing fee
        }
    }

    static class BankTransferPayment extends Payment {
        public BankTransferPayment(double amount) {
            super(amount);
        }

        @Override
        public String getPaymentType() {
            return "BANKTRANSFER";
        }

        @Override
        public double calculateAdjustedAmount() {
            return amount; // No processing fee
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        List<Payment> payments = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double amount = scanner.nextDouble();

            if ("CARD".equalsIgnoreCase(type)) {
                payments.add(new CardPayment(amount));
            } else if ("WALLET".equalsIgnoreCase(type)) {
                payments.add(new WalletPayment(amount));
            } else if ("BANKTRANSFER".equalsIgnoreCase(type)) {
                payments.add(new BankTransferPayment(amount));
            }
        }

        double total = 0.0;
        for (Payment payment : payments) {
            double adjusted = payment.calculateAdjustedAmount();
            System.out.printf("%s: %.2f\n", payment.getPaymentType(), adjusted);
            total += adjusted;
        }

        System.out.printf("Total: %.2f\n", total);
        scanner.close();
    }
}