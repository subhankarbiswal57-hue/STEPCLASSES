import java.util.*;

abstract class Parcel {
    protected double weight, declaredValue;
    Parcel(double w, double v) { weight = w; declaredValue = v; }
    abstract double charge();
}

interface Insurable {
    double INSURANCE_RATE = 0.02;
    double getDeclaredValue();
    default double insurance() { return getDeclaredValue() * INSURANCE_RATE; }
}

class StandardParcel extends Parcel {
    StandardParcel(double w, double v) { super(w, v); }
    double charge() { return 40 + 10 * weight; }
}

class ExpressParcel extends Parcel implements Insurable {
    ExpressParcel(double w, double v) { super(w, v); }
    double charge() { return 80 + 15 * weight; }
    public double getDeclaredValue() { return declaredValue; }
}

class FragileParcel extends Parcel implements Insurable {
    FragileParcel(double w, double v) { super(w, v); }
    double charge() { return 40 + 10 * weight + 50; }
    public double getDeclaredValue() { return declaredValue; }
}

public class Week9assignment2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double grand = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double w = sc.nextDouble(), v = sc.nextDouble();
            Parcel p;
            switch (type) {
                case "STANDARD": p = new StandardParcel(w, v); break;
                case "EXPRESS": p = new ExpressParcel(w, v); break;
                default: p = new FragileParcel(w, v);
            }
            double c = p.charge();
            double ins = (p instanceof Insurable) ? ((Insurable) p).insurance() : 0;
            double t = c + ins;
            grand += t;
            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n", type, c, ins, t);
        }
        System.out.printf("Grand Total: %.2f%n", grand);
    }
}
