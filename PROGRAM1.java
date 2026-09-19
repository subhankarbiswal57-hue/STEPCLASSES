/**
 * Category C - Practice Problem 1: The Piggy Bank
 * 
 * Scenario:
 * A savings app tracks how much money a kid has put away.
 * 
 * Problem Statement:
 * Create a PiggyBank class where money can only be added or removed through specific actions - never set directly to any amount.
 * 
 * Requirements:
 * - The savings amount must be private, changed only by deposit and withdraw methods.
 * - A withdrawal larger than the current savings must be rejected, not applied.
 * - Give the piggy bank a final ID that's fixed the moment it's created.
 * - Provide a way to check the current savings, but no way to set it directly.
 */
public class PROGRAM1 {

    static class PiggyBank {
        private final String id;
        private double savings;

        public PiggyBank(String id) {
            this.id = id;
            this.savings = 0.0;
        }

        public String getId() {
            return id;
        }

        public void deposit(double amount) {
            if (amount > 0) {
                savings += amount;
                System.out.println("Deposited " + amount + " -> savings = " + (savings % 1 == 0 ? (int)savings : savings));
            } else {
                System.out.println("Invalid deposit amount.");
            }
        }

        public void withdraw(double amount) {
            if (amount <= 0) {
                System.out.println("Invalid withdrawal amount.");
            } else if (amount > savings) {
                System.out.println("Withdrawal of " + amount + " -> rejected, savings stays " + (savings % 1 == 0 ? (int)savings : savings));
            } else {
                savings -= amount;
                System.out.println("Withdrew " + amount + " -> savings = " + (savings % 1 == 0 ? (int)savings : savings));
            }
        }

        public double getSavings() {
            return savings;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Testing PiggyBank ===");
        PiggyBank pb = new PiggyBank("PB-1");
        System.out.println("Created Piggy Bank with ID: " + pb.getId());
        
        pb.deposit(100);
        pb.withdraw(30);
        pb.withdraw(500);
        
        System.out.println("Final savings: " + pb.getSavings());
    }
}