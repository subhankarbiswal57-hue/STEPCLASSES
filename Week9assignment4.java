import java.util.*;

abstract class Cab {
    static final double MIN_FARE = 100; // shared rule
    abstract double rate();
    double fare(double km) { return Math.max(km * rate(), MIN_FARE); }
}

interface NightService {
    double NIGHT_SURCHARGE = 0.20;
    default double nightFare(double baseFare) { return baseFare * (1 + NIGHT_SURCHARGE); }
}

class Mini extends Cab { double rate() { return 10; } }
class Sedan extends Cab implements NightService { double rate() { return 14; } }
class Suv extends Cab implements NightService { double rate() { return 18; } }

public class Week9assignment4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();
            Cab c;
            switch (type) {
                case "MINI": c = new Mini(); break;
                case "SEDAN": c = new Sedan(); break;
                default: c = new Suv();
            }
            double fare = c.fare(km);
            if (time.equals("NIGHT")) {
                if (c instanceof NightService) {
                    fare = ((NightService) c).nightFare(fare);
                } else {
                    System.out.println(type + ": night service not available");
                    continue;
                }
            }
            total += fare;
            System.out.printf("%s: %.2f%n", type, fare);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}