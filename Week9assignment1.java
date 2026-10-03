import java.util.*;

abstract class Ticket {
    static final double CONVENIENCE_FEE = 20; // written once
    abstract double price();
    double amount(int count) { return count * (price() + CONVENIENCE_FEE); }
}

class RegularTicket extends Ticket { double price() { return 150; } }
class PremiumTicket extends Ticket { double price() { return 250; } }
class ReclinerTicket extends Ticket { double price() { return 400; } }

public class Week9assignment1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String seat = sc.next();
            int count = sc.nextInt();
            Ticket t;
            switch (seat) {
                case "REGULAR": t = new RegularTicket(); break;
                case "PREMIUM": t = new PremiumTicket(); break;
                default: t = new ReclinerTicket();
            }
            double amt = t.amount(count);
            total += amt;
            System.out.printf("%s: %.2f%n", seat, amt);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
