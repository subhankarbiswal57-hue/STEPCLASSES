import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 * Week 9 Practice - Problem 2: Gym Membership Bill Calculator
 *
 * Demonstrates inheritance and polymorphism:
 * Base class GymMembership with subclasses BasicMembership, PremiumMembership, EliteMembership.
 * Each has a different monthly rate and includes different add-on costs.
 */
public class W9PRACTICE2 {

    abstract static class GymMembership {
        protected String memberName;
        protected int months;

        public GymMembership(String memberName, int months) {
            this.memberName = memberName;
            this.months = months;
        }

        public String getMemberName() {
            return memberName;
        }

        public abstract double getMonthlyRate();
        public abstract String getMembershipType();

        public double calculateTotal() {
            return getMonthlyRate() * months;
        }
    }

    static class BasicMembership extends GymMembership {
        public BasicMembership(String memberName, int months) {
            super(memberName, months);
        }

        @Override
        public double getMonthlyRate() {
            return 500.0;
        }

        @Override
        public String getMembershipType() {
            return "BASIC";
        }
    }

    static class PremiumMembership extends GymMembership {
        public PremiumMembership(String memberName, int months) {
            super(memberName, months);
        }

        @Override
        public double getMonthlyRate() {
            return 1200.0;
        }

        @Override
        public String getMembershipType() {
            return "PREMIUM";
        }
    }

    static class EliteMembership extends GymMembership {
        public EliteMembership(String memberName, int months) {
            super(memberName, months);
        }

        @Override
        public double getMonthlyRate() {
            return 2500.0;
        }

        @Override
        public String getMembershipType() {
            return "ELITE";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        scanner.nextLine();
        List<GymMembership> memberships = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            String[] parts = line.split(" ");
            String type = parts[0];
            String name = parts[1];
            int months = Integer.parseInt(parts[2]);

            if ("BASIC".equalsIgnoreCase(type)) {
                memberships.add(new BasicMembership(name, months));
            } else if ("PREMIUM".equalsIgnoreCase(type)) {
                memberships.add(new PremiumMembership(name, months));
            } else if ("ELITE".equalsIgnoreCase(type)) {
                memberships.add(new EliteMembership(name, months));
            }
        }

        for (GymMembership m : memberships) {
            System.out.printf("%s (%s): %.2f%n", m.getMemberName(), m.getMembershipType(), m.calculateTotal());
        }
        scanner.close();
    }
}
