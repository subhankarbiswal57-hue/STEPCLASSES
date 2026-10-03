import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 * Week 9 Practice - Problem 5: Electricity Tariff Bill Generator
 *
 * Demonstrates polymorphism:
 * Base class Consumer with subclasses ResidentialConsumer, CommercialConsumer, IndustrialConsumer.
 * Each category has a different per-unit electricity rate and fixed charge.
 */
public class W9PRACTICE5 {

    abstract static class Consumer {
        protected String consumerId;
        protected double unitsConsumed;

        public Consumer(String consumerId, double unitsConsumed) {
            this.consumerId = consumerId;
            this.unitsConsumed = unitsConsumed;
        }

        public String getConsumerId() {
            return consumerId;
        }

        public abstract double getUnitRate();
        public abstract double getFixedCharge();
        public abstract String getCategory();

        public double calculateBill() {
            return getFixedCharge() + (getUnitRate() * unitsConsumed);
        }
    }

    static class ResidentialConsumer extends Consumer {
        public ResidentialConsumer(String consumerId, double unitsConsumed) {
            super(consumerId, unitsConsumed);
        }

        @Override
        public double getUnitRate() {
            return 4.0; // Rs 4 per unit
        }

        @Override
        public double getFixedCharge() {
            return 50.0; // Rs 50 fixed charge
        }

        @Override
        public String getCategory() {
            return "RESIDENTIAL";
        }
    }

    static class CommercialConsumer extends Consumer {
        public CommercialConsumer(String consumerId, double unitsConsumed) {
            super(consumerId, unitsConsumed);
        }

        @Override
        public double getUnitRate() {
            return 7.5; // Rs 7.50 per unit
        }

        @Override
        public double getFixedCharge() {
            return 200.0; // Rs 200 fixed charge
        }

        @Override
        public String getCategory() {
            return "COMMERCIAL";
        }
    }

    static class IndustrialConsumer extends Consumer {
        public IndustrialConsumer(String consumerId, double unitsConsumed) {
            super(consumerId, unitsConsumed);
        }

        @Override
        public double getUnitRate() {
            return 6.0; // Rs 6 per unit
        }

        @Override
        public double getFixedCharge() {
            return 500.0; // Rs 500 fixed charge
        }

        @Override
        public String getCategory() {
            return "INDUSTRIAL";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        scanner.nextLine();
        List<Consumer> consumers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            String[] parts = line.split(" ");
            String category = parts[0];
            String id = parts[1];
            double units = Double.parseDouble(parts[2]);

            if ("RESIDENTIAL".equalsIgnoreCase(category)) {
                consumers.add(new ResidentialConsumer(id, units));
            } else if ("COMMERCIAL".equalsIgnoreCase(category)) {
                consumers.add(new CommercialConsumer(id, units));
            } else if ("INDUSTRIAL".equalsIgnoreCase(category)) {
                consumers.add(new IndustrialConsumer(id, units));
            }
        }

        for (Consumer c : consumers) {
            System.out.printf("%s (%s): %.2f%n", c.getConsumerId(), c.getCategory(), c.calculateBill());
        }
        scanner.close();
    }
}
