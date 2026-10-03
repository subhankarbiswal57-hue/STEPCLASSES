import java.util.*;

abstract class Student {
    protected String name;
    Student(String name) { this.name = name; }
    abstract double tuition();
    double totalFee() { return tuition(); }
    String getName() { return name; }
}

interface BusUser {
    double TRANSPORT_FEE = 12000; // written once
}

class DayScholar extends Student implements BusUser {
    DayScholar(String n) { super(n); }
    double tuition() { return 40000; }
    @Override double totalFee() { return tuition() + TRANSPORT_FEE; }
}

class Hosteller extends Student {
    Hosteller(String n) { super(n); }
    double tuition() { return 40000 + 60000; }
}

class ScholarStudent extends Student implements BusUser {
    ScholarStudent(String n) { super(n); }
    double tuition() { return 40000 / 2.0; }
    @Override double totalFee() { return tuition() + TRANSPORT_FEE; }
}

public class Week9assignment3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.nextLine().trim();
            Student s;
            switch (type) {
                case "DAY_SCHOLAR": s = new DayScholar(name); break;
                case "HOSTELLER": s = new Hosteller(name); break;
                default: s = new ScholarStudent(name);
            }
            double fee = s.totalFee();
            total += fee;
            System.out.printf("%s: %.2f%n", s.getName(), fee);
        }
        System.out.printf("Total Collected: %.2f%n", total);
    }
}