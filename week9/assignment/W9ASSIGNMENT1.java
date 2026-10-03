import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 * Week 9 Assignment - Problem 1: The Smart Home Appliance Energy Tracker
 *
 * Demonstrates polymorphism:
 * Base class Appliance with subclasses AirConditioner, WashingMachine, Refrigerator.
 * Calculates monthly energy cost based on wattage and daily usage hours.
 */
public class W9ASSIGNMENT1 {

    abstract static class Appliance {
        protected String applianceName;
        protected double wattage;
        protected double dailyHours;

        public Appliance(String applianceName, double wattage, double dailyHours) {
            this.applianceName = applianceName;
            this.wattage = wattage;
            this.dailyHours = dailyHours;
        }

        public String getApplianceName() {
            return applianceName;
        }

        public abstract String getApplianceType();

        // Energy consumed in kWh per month (30 days)
        public double calculateMonthlyUnits() {
            return (wattage * dailyHours * 30) / 1000.0;
        }

        // Cost at Rs 5 per kWh
        public double calculateMonthlyCost() {
            return calculateMonthlyUnits() * 5.0;
        }
    }

    static class AirConditioner extends Appliance {
        public AirConditioner(String applianceName, double wattage, double dailyHours) {
            super(applianceName, wattage, dailyHours);
        }

        @Override
        public String getApplianceType() {
            return "AC";
        }
    }

    static class WashingMachine extends Appliance {
        public WashingMachine(String applianceName, double wattage, double dailyHours) {
            super(applianceName, wattage, dailyHours);
        }

        @Override
        public String getApplianceType() {
            return "WASHING_MACHINE";
        }
    }

    static class Refrigerator extends Appliance {
        public Refrigerator(String applianceName, double wattage, double dailyHours) {
            super(applianceName, wattage, dailyHours);
        }

        @Override
        public String getApplianceType() {
            return "REFRIGERATOR";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        scanner.nextLine();
        List<Appliance> appliances = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            String[] parts = line.split(" ");
            String type = parts[0];
            String name = parts[1];
            double wattage = Double.parseDouble(parts[2]);
            double hours = Double.parseDouble(parts[3]);

            if ("AC".equalsIgnoreCase(type)) {
                appliances.add(new AirConditioner(name, wattage, hours));
            } else if ("WASHING_MACHINE".equalsIgnoreCase(type)) {
                appliances.add(new WashingMachine(name, wattage, hours));
            } else if ("REFRIGERATOR".equalsIgnoreCase(type)) {
                appliances.add(new Refrigerator(name, wattage, hours));
            }
        }

        double totalCost = 0.0;
        for (Appliance a : appliances) {
            double cost = a.calculateMonthlyCost();
            System.out.printf("%s (%s) - Units: %.2f kWh, Cost: %.2f%n",
                    a.getApplianceName(), a.getApplianceType(), a.calculateMonthlyUnits(), cost);
            totalCost += cost;
        }
        System.out.printf("Total Monthly Cost: %.2f%n", totalCost);
        scanner.close();
    }
}
