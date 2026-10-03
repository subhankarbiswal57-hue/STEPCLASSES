import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 * Week 9 Assignment - Problem 2: The Hospital Ward Billing System
 *
 * Demonstrates inheritance and polymorphism:
 * Base class Ward with subclasses GeneralWard, SemiPrivateWard, PrivateWard.
 * Bill is calculated based on ward type, days stayed, and doctor consultation fee.
 */
public class W9ASSIGNMENT2 {

    abstract static class Ward {
        protected String patientName;
        protected int daysStayed;
        protected double doctorFee;

        public Ward(String patientName, int daysStayed, double doctorFee) {
            this.patientName = patientName;
            this.daysStayed = daysStayed;
            this.doctorFee = doctorFee;
        }

        public String getPatientName() {
            return patientName;
        }

        public abstract double getRoomRatePerDay();
        public abstract String getWardType();

        public double calculateTotalBill() {
            return (getRoomRatePerDay() * daysStayed) + doctorFee;
        }
    }

    static class GeneralWard extends Ward {
        public GeneralWard(String patientName, int daysStayed, double doctorFee) {
            super(patientName, daysStayed, doctorFee);
        }

        @Override
        public double getRoomRatePerDay() {
            return 500.0;
        }

        @Override
        public String getWardType() {
            return "GENERAL";
        }
    }

    static class SemiPrivateWard extends Ward {
        public SemiPrivateWard(String patientName, int daysStayed, double doctorFee) {
            super(patientName, daysStayed, doctorFee);
        }

        @Override
        public double getRoomRatePerDay() {
            return 1500.0;
        }

        @Override
        public String getWardType() {
            return "SEMI_PRIVATE";
        }
    }

    static class PrivateWard extends Ward {
        public PrivateWard(String patientName, int daysStayed, double doctorFee) {
            super(patientName, daysStayed, doctorFee);
        }

        @Override
        public double getRoomRatePerDay() {
            return 4000.0;
        }

        @Override
        public String getWardType() {
            return "PRIVATE";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        scanner.nextLine();
        List<Ward> wards = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            String[] parts = line.split(" ");
            String type = parts[0];
            String name = parts[1];
            int days = Integer.parseInt(parts[2]);
            double docFee = Double.parseDouble(parts[3]);

            if ("GENERAL".equalsIgnoreCase(type)) {
                wards.add(new GeneralWard(name, days, docFee));
            } else if ("SEMI_PRIVATE".equalsIgnoreCase(type)) {
                wards.add(new SemiPrivateWard(name, days, docFee));
            } else if ("PRIVATE".equalsIgnoreCase(type)) {
                wards.add(new PrivateWard(name, days, docFee));
            }
        }

        for (Ward w : wards) {
            System.out.printf("%s (%s): %.2f%n", w.getPatientName(), w.getWardType(), w.calculateTotalBill());
        }
        scanner.close();
    }
}
