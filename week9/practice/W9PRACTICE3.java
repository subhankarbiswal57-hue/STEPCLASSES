import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 * Week 9 Practice - Problem 3: Vehicle Toll Booth Calculator
 *
 * Demonstrates polymorphism:
 * Base class Vehicle with subclasses Bike, Car, Truck.
 * Each vehicle type pays a different toll fee per km.
 */
public class W9PRACTICE3 {

    abstract static class Vehicle {
        protected String vehicleId;
        protected double distanceKm;

        public Vehicle(String vehicleId, double distanceKm) {
            this.vehicleId = vehicleId;
            this.distanceKm = distanceKm;
        }

        public String getVehicleId() {
            return vehicleId;
        }

        public abstract double getTollRate(); // per km
        public abstract String getVehicleType();

        public double calculateToll() {
            return getTollRate() * distanceKm;
        }
    }

    static class Bike extends Vehicle {
        public Bike(String vehicleId, double distanceKm) {
            super(vehicleId, distanceKm);
        }

        @Override
        public double getTollRate() {
            return 0.5; // Rs 0.50 per km
        }

        @Override
        public String getVehicleType() {
            return "BIKE";
        }
    }

    static class Car extends Vehicle {
        public Car(String vehicleId, double distanceKm) {
            super(vehicleId, distanceKm);
        }

        @Override
        public double getTollRate() {
            return 2.0; // Rs 2.00 per km
        }

        @Override
        public String getVehicleType() {
            return "CAR";
        }
    }

    static class Truck extends Vehicle {
        public Truck(String vehicleId, double distanceKm) {
            super(vehicleId, distanceKm);
        }

        @Override
        public double getTollRate() {
            return 5.0; // Rs 5.00 per km
        }

        @Override
        public String getVehicleType() {
            return "TRUCK";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        scanner.nextLine();
        List<Vehicle> vehicles = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            String[] parts = line.split(" ");
            String type = parts[0];
            String id = parts[1];
            double distance = Double.parseDouble(parts[2]);

            if ("BIKE".equalsIgnoreCase(type)) {
                vehicles.add(new Bike(id, distance));
            } else if ("CAR".equalsIgnoreCase(type)) {
                vehicles.add(new Car(id, distance));
            } else if ("TRUCK".equalsIgnoreCase(type)) {
                vehicles.add(new Truck(id, distance));
            }
        }

        for (Vehicle v : vehicles) {
            System.out.printf("%s (%s): %.2f%n", v.getVehicleId(), v.getVehicleType(), v.calculateToll());
        }
        scanner.close();
    }
}
