import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 * Week 8 Assignment - Problem 2: The Campus Parking Charge Calculator
 * Category C
 * 
 * Demonstrates polymorphism:
 * Base class Vehicle with subclasses Bike, Car, Truck.
 */
public class PROGRAM2 {

    abstract static class Vehicle {
        protected int hours;

        public Vehicle(int hours) {
            this.hours = hours;
        }

        public abstract String getVehicleType();
        public abstract double calculateParkingCharge();
    }

    static class Bike extends Vehicle {
        public Bike(int hours) {
            super(hours);
        }

        @Override
        public String getVehicleType() {
            return "BIKE";
        }

        @Override
        public double calculateParkingCharge() {
            // Bike: 10 per hour
            return hours * 10.0;
        }
    }

    static class Car extends Vehicle {
        public Car(int hours) {
            super(hours);
        }

        @Override
        public String getVehicleType() {
            return "CAR";
        }

        @Override
        public double calculateParkingCharge() {
            // Car: 30 for first hour, plus 20 for each additional hour
            if (hours <= 1) {
                return 30.0;
            } else {
                return 30.0 + (hours - 1) * 20.0;
            }
        }
    }

    static class Truck extends Vehicle {
        public Truck(int hours) {
            super(hours);
        }

        @Override
        public String getVehicleType() {
            return "TRUCK";
        }

        @Override
        public double calculateParkingCharge() {
            // Truck: 50 per hour, with a minimum charge of 100
            double charge = hours * 50.0;
            return Math.max(charge, 100.0);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        List<Vehicle> vehicles = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int hours = scanner.nextInt();

            if ("BIKE".equalsIgnoreCase(type)) {
                vehicles.add(new Bike(hours));
            } else if ("CAR".equalsIgnoreCase(type)) {
                vehicles.add(new Car(hours));
            } else if ("TRUCK".equalsIgnoreCase(type)) {
                vehicles.add(new Truck(hours));
            }
        }

        double grandTotal = 0.0;
        for (Vehicle v : vehicles) {
            double charge = v.calculateParkingCharge();
            System.out.printf("%s: %.2f\n", v.getVehicleType(), charge);
            grandTotal += charge;
        }

        System.out.printf("Total: %.2f\n", grandTotal);
        scanner.close();
    }
}
