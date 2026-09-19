public class PRACTICE2 {
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