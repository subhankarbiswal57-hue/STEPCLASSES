import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 * Week 8 Assignment - Problem 3: The Hostel Electricity Bill
 * Category C
 * 
 * Demonstrates polymorphism:
 * Base class HostelRoom with subclasses SingleRoom, SharedRoom, ACRoom.
 */
public class PROGRAM3 {

    abstract static class HostelRoom {
        protected int units;

        public HostelRoom(int units) {
            this.units = units;
        }

        public abstract String getRoomType();
        public abstract double calculateBill();
    }

    static class SingleRoom extends HostelRoom {
        public SingleRoom(int units) {
            super(units);
        }

        @Override
        public String getRoomType() {
            return "SINGLE";
        }

        @Override
        public double calculateBill() {
            // Single room: 8 per unit
            return units * 8.0;
        }
    }

    static class SharedRoom extends HostelRoom {
        private int occupants;

        public SharedRoom(int units, int occupants) {
            super(units);
            this.occupants = occupants;
        }

        @Override
        public String getRoomType() {
            return "SHARED";
        }

        @Override
        public double calculateBill() {
            // Shared room: 6 per unit, divided equally by the number of occupants
            return (units * 6.0) / occupants;
        }
    }

    static class ACRoom extends HostelRoom {
        public ACRoom(int units) {
            super(units);
        }

        @Override
        public String getRoomType() {
            return "AC";
        }

        @Override
        public double calculateBill() {
            // AC room: 10 per unit, plus a fixed charge of 200
            return (units * 10.0) + 200.0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        List<HostelRoom> rooms = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int units = scanner.nextInt();

            if ("SINGLE".equalsIgnoreCase(type)) {
                rooms.add(new SingleRoom(units));
            } else if ("SHARED".equalsIgnoreCase(type)) {
                int occupants = scanner.nextInt();
                rooms.add(new SharedRoom(units, occupants));
            } else if ("AC".equalsIgnoreCase(type)) {
                rooms.add(new ACRoom(units));
            }
        }

        double total = 0.0;
        for (HostelRoom room : rooms) {
            double bill = room.calculateBill();
            System.out.printf("%s: %.2f\n", room.getRoomType(), bill);
            total += bill;
        }

        System.out.printf("Total: %.2f\n", total);
        scanner.close();
    }
}
