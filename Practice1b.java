class Practice1a {
    private final String id;
    private int savings;

    public Practice1a(String id) {
        this.id = id;
        savings = 0;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            savings += amount;
        }
    }

    public void withdraw(int amount) {
        if (amount > 0 && amount <= savings) {
            savings -= amount;
        } else {
            System.out.println("Withdrawal rejected");
        }
    }

    public int getSavings() {
        return savings;
    }

    public String getId() {
        return id;
    }
}

public class Practice1b {
    public static void main(String[] args) {
        Practice1a pb = new Practice1a("PB-1");
        pb.deposit(100);
        System.out.println("Savings: " + pb.getSavings());
        pb.withdraw(30);
        System.out.println("Savings: " + pb.getSavings());
        pb.withdraw(500);
        System.out.println("Savings: " + pb.getSavings());
    }
}