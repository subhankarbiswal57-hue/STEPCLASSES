/**
 * Week 6 Practice - Problem 3: Vehicle Rental System (Interface + Polymorphism)
 * Interface Rentable with Car, Bike, and Truck implementations.
 */
public class PROGRAM3 {

    interface Rentable {
        double calculateRentalCost(int days);
        String getVehicleInfo();
    }

    static class Car implements Rentable {
        private String model;
        private double dailyRate;
        public Car(String model, double dailyRate) { this.model = model; this.dailyRate = dailyRate; }
        @Override public double calculateRentalCost(int days) { return dailyRate * days; }
        @Override public String getVehicleInfo() { return "Car: " + model + " @ " + dailyRate + "/day"; }
    }

    static class Bike implements Rentable {
        private String model;
        private double dailyRate;
        public Bike(String model, double dailyRate) { this.model = model; this.dailyRate = dailyRate; }
        @Override public double calculateRentalCost(int days) { return dailyRate * days; }
        @Override public String getVehicleInfo() { return "Bike: " + model + " @ " + dailyRate + "/day"; }
    }

    static class Truck implements Rentable {
        private String model;
        private double dailyRate;
        private double loadSurcharge;
        public Truck(String model, double dailyRate, double loadSurcharge) {
            this.model = model; this.dailyRate = dailyRate; this.loadSurcharge = loadSurcharge;
        }
        @Override public double calculateRentalCost(int days) { return (dailyRate + loadSurcharge) * days; }
        @Override public String getVehicleInfo() { return "Truck: " + model + " @ " + dailyRate + "/day + " + loadSurcharge + " surcharge"; }
    }

    public static void generateInvoice(Rentable[] vehicles, int rentalDays) {
        System.out.println("--- Rental Invoice (" + rentalDays + " days) ---");
        double grandTotal = 0;
        for (Rentable v : vehicles) {
            double cost = v.calculateRentalCost(rentalDays);
            grandTotal += cost;
            System.out.println(v.getVehicleInfo() + " | Total: " + String.format("%.2f", cost));
        }
        System.out.println("Grand Total: " + String.format("%.2f", grandTotal));
    }

    public static void main(String[] args) {
        Rentable[] fleet = {
            new Car("Honda City", 1500), new Bike("Royal Enfield", 500), new Truck("Tata Ace", 2000, 800)
        };
        generateInvoice(fleet, 5);
    }
}
