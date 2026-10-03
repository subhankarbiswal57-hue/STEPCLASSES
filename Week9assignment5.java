import java.util.*;

abstract class Appliance {
    static final double RATE = 8;
    abstract double powerWatts();
    double units(double hours) { return powerWatts() * hours / 1000.0; }
    double cost(double units) { return units * RATE; }
}

interface SaverMode {
    double SAVING = 0.25;
    default double saverUnits(double units) { return units * (1 - SAVING); }
}

class Fridge extends Appliance { double powerWatts() { return 150; } }
class AirConditioner extends Appliance implements SaverMode { double powerWatts() { return 1500; } }
class Tv extends Appliance { double powerWatts() { return 100; } }
class WashingMachine extends Appliance implements SaverMode { double powerWatts() { return 500; } }

public class Week9assignment5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");
            String name = p[0];
            double hours = Double.parseDouble(p[1]);
            boolean saver = p.length > 2 && p[2].equals("SAVER");
            Appliance a;
            switch (name) {
                case "FRIDGE": a = new Fridge(); break;
                case "AC": a = new AirConditioner(); break;
                case "TV": a = new Tv(); break;
                default: a = new WashingMachine();
            }
            double units = a.units(hours);
            if (saver) {
                if (a instanceof SaverMode) {
                    units = ((SaverMode) a).saverUnits(units);
                } else {
                    System.out.println(name + ": saver mode not supported");
                    continue;
                }
            }
            double cost = a.cost(units);
            total += cost;
            System.out.printf("%s: Units=%.2f Cost=%.2f%n", name, units, cost);
        }
        System.out.printf("Total Cost: %.2f%n", total);
    }
}