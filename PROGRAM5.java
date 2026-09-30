import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 * Week 8 Practice - Problem 5: Public Transport Fare Calculator
 * 
 * Demonstrates polymorphism:
 * Base class PublicTransport with subclasses Bus, Train, Metro.
 */
public class PROGRAM5 {

    abstract static class PublicTransport {
        protected double distance;

        public PublicTransport(double distance) {
            this.distance = distance;
        }

        public abstract String getTransportType();
        public abstract double calculateFare();
    }

    static class Bus extends PublicTransport {
        public Bus(double distance) {
            super(distance);
        }

        @Override
        public String getTransportType() {
            return "BUS";
        }

        @Override
        public double calculateFare() {
            // Base fare $2, plus $0.10 per km. Max fare $10.
            double fare = 2.0 + (0.10 * distance);
            return Math.min(fare, 10.0);
        }
    }

    static class Train extends PublicTransport {
        public Train(double distance) {
            super(distance);
        }

        @Override
        public String getTransportType() {
            return "TRAIN";
        }

        @Override
        public double calculateFare() {
            // Base fare $3, plus $0.15 per km.
            return 3.0 + (0.15 * distance);
        }
    }

    static class Metro extends PublicTransport {
        private double peakHourFactor;

        public Metro(double distance, double peakHourFactor) {
            super(distance);
            this.peakHourFactor = peakHourFactor;
        }

        @Override
        public String getTransportType() {
            return "METRO";
        }

        @Override
        public double calculateFare() {
            // Base fare $1.50, plus $0.20 per km, multiplied by a PeakHourFactor.
            return (1.50 + 0.20 * distance) * peakHourFactor;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        List<PublicTransport> journeys = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double distance = scanner.nextDouble();

            if ("BUS".equalsIgnoreCase(type)) {
                journeys.add(new Bus(distance));
            } else if ("TRAIN".equalsIgnoreCase(type)) {
                journeys.add(new Train(distance));
            } else if ("METRO".equalsIgnoreCase(type)) {
                double factor = scanner.nextDouble();
                journeys.add(new Metro(distance, factor));
            }
        }

        double grandTotal = 0.0;
        for (PublicTransport journey : journeys) {
            double fare = journey.calculateFare();
            System.out.printf("%s: %.2f\n", journey.getTransportType(), fare);
            grandTotal += fare;
        }

        System.out.printf("Total: %.2f\n", grandTotal);
        scanner.close();
    }
}