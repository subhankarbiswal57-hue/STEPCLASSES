import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 * Week 8 Practice - Problem 3: Delivery Fee Calculator
 * 
 * Demonstrates polymorphism:
 * Base class DeliveryRequest with specialized subclasses StandardDelivery, ExpressDelivery, InternationalDelivery.
 */
public class PROGRAM3 {

    abstract static class DeliveryRequest {
        protected double weight;
        protected double distance;

        public DeliveryRequest(double weight, double distance) {
            this.weight = weight;
            this.distance = distance;
        }

        public abstract String getDeliveryType();
        public abstract double calculateFee();
    }

    static class StandardDelivery extends DeliveryRequest {
        public StandardDelivery(double weight, double distance) {
            super(weight, distance);
        }

        @Override
        public String getDeliveryType() {
            return "STANDARD";
        }

        @Override
        public double calculateFee() {
            return 5.0 + (0.50 * weight) + (0.10 * distance);
        }
    }

    static class ExpressDelivery extends DeliveryRequest {
        public ExpressDelivery(double weight, double distance) {
            super(weight, distance);
        }

        @Override
        public String getDeliveryType() {
            return "EXPRESS";
        }

        @Override
        public double calculateFee() {
            return 15.0 + (1.00 * weight) + (0.20 * distance);
        }
    }

    static class InternationalDelivery extends DeliveryRequest {
        private double customsFee;

        public InternationalDelivery(double weight, double distance, double customsFee) {
            super(weight, distance);
            this.customsFee = customsFee;
        }

        @Override
        public String getDeliveryType() {
            return "INTERNATIONAL";
        }

        @Override
        public double calculateFee() {
            return 25.0 + (2.00 * weight) + (0.50 * distance) + customsFee;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        List<DeliveryRequest> requests = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double weight = scanner.nextDouble();
            double distance = scanner.nextDouble();

            if ("STANDARD".equalsIgnoreCase(type)) {
                requests.add(new StandardDelivery(weight, distance));
            } else if ("EXPRESS".equalsIgnoreCase(type)) {
                requests.add(new ExpressDelivery(weight, distance));
            } else if ("INTERNATIONAL".equalsIgnoreCase(type)) {
                double customsFee = scanner.nextDouble();
                requests.add(new InternationalDelivery(weight, distance, customsFee));
            }
        }

        double totalFee = 0.0;
        for (DeliveryRequest req : requests) {
            double fee = req.calculateFee();
            System.out.printf("%s: %.2f\n", req.getDeliveryType(), fee);
            totalFee += fee;
        }

        System.out.printf("Total: %.2f\n", totalFee);
        scanner.close();
    }
}
