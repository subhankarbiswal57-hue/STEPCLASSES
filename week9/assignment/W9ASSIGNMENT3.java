import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 * Week 9 Assignment - Problem 3: The Food Delivery Charge Estimator
 *
 * Demonstrates polymorphism:
 * Base class DeliveryOrder with subclasses StandardDelivery, ExpressDelivery, ScheduledDelivery.
 * Calculates total bill including delivery charges based on distance.
 */
public class W9ASSIGNMENT3 {

    abstract static class DeliveryOrder {
        protected String orderId;
        protected double orderAmount;
        protected double distanceKm;

        public DeliveryOrder(String orderId, double orderAmount, double distanceKm) {
            this.orderId = orderId;
            this.orderAmount = orderAmount;
            this.distanceKm = distanceKm;
        }

        public String getOrderId() {
            return orderId;
        }

        public abstract double getDeliveryChargePerKm();
        public abstract String getDeliveryType();

        public double calculateDeliveryCharge() {
            return getDeliveryChargePerKm() * distanceKm;
        }

        public double calculateTotalBill() {
            return orderAmount + calculateDeliveryCharge();
        }
    }

    static class StandardDelivery extends DeliveryOrder {
        public StandardDelivery(String orderId, double orderAmount, double distanceKm) {
            super(orderId, orderAmount, distanceKm);
        }

        @Override
        public double getDeliveryChargePerKm() {
            return 5.0; // Rs 5 per km
        }

        @Override
        public String getDeliveryType() {
            return "STANDARD";
        }
    }

    static class ExpressDelivery extends DeliveryOrder {
        public ExpressDelivery(String orderId, double orderAmount, double distanceKm) {
            super(orderId, orderAmount, distanceKm);
        }

        @Override
        public double getDeliveryChargePerKm() {
            return 12.0; // Rs 12 per km
        }

        @Override
        public String getDeliveryType() {
            return "EXPRESS";
        }
    }

    static class ScheduledDelivery extends DeliveryOrder {
        public ScheduledDelivery(String orderId, double orderAmount, double distanceKm) {
            super(orderId, orderAmount, distanceKm);
        }

        @Override
        public double getDeliveryChargePerKm() {
            return 3.0; // Rs 3 per km (cheapest, scheduled in advance)
        }

        @Override
        public String getDeliveryType() {
            return "SCHEDULED";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        scanner.nextLine();
        List<DeliveryOrder> orders = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            String[] parts = line.split(" ");
            String type = parts[0];
            String orderId = parts[1];
            double amount = Double.parseDouble(parts[2]);
            double distance = Double.parseDouble(parts[3]);

            if ("STANDARD".equalsIgnoreCase(type)) {
                orders.add(new StandardDelivery(orderId, amount, distance));
            } else if ("EXPRESS".equalsIgnoreCase(type)) {
                orders.add(new ExpressDelivery(orderId, amount, distance));
            } else if ("SCHEDULED".equalsIgnoreCase(type)) {
                orders.add(new ScheduledDelivery(orderId, amount, distance));
            }
        }

        for (DeliveryOrder o : orders) {
            System.out.printf("Order %s (%s) - Delivery: %.2f, Total: %.2f%n",
                    o.getOrderId(), o.getDeliveryType(),
                    o.calculateDeliveryCharge(), o.calculateTotalBill());
        }
        scanner.close();
    }
}
