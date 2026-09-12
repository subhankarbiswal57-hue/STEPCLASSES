/**
 * Week 6 Practice - Problem 4: Bank Account with Encapsulation & Exception Handling
 * Encapsulated BankAccount class with deposit, withdraw (checked exception), and transfer.
 */
public class PROGRAM4 {

    static class InsufficientFundsException extends Exception {
        public InsufficientFundsException(String message) { super(message); }
    }

    static class BankAccount {
        private String accountHolder;
        private double balance;

        public BankAccount(String accountHolder, double initialBalance) {
            this.accountHolder = accountHolder;
            this.balance = Math.max(initialBalance, 0);
        }

        public String getAccountHolder() { return accountHolder; }
        public double getBalance() { return balance; }

        public void deposit(double amount) {
            if (amount <= 0) throw new IllegalArgumentException("Deposit amount must be positive.");
            this.balance += amount;
        }

        public void withdraw(double amount) throws InsufficientFundsException {
            if (amount <= 0) throw new IllegalArgumentException("Withdrawal amount must be positive.");
            if (amount > this.balance) {
                throw new InsufficientFundsException(
                    "Cannot withdraw " + amount + " from " + accountHolder + " (Balance: " + balance + ")");
            }
            this.balance -= amount;
        }

        public void transferTo(BankAccount recipient, double amount) throws InsufficientFundsException {
            this.withdraw(amount);
            recipient.deposit(amount);
        }

        @Override
        public String toString() {
            return accountHolder + " | Balance: " + String.format("%.2f", balance);
        }
    }

    public static void main(String[] args) {
        BankAccount alice = new BankAccount("Alice", 10000);
        BankAccount bob = new BankAccount("Bob", 5000);

        System.out.println("--- Initial Balances ---");
        System.out.println(alice);
        System.out.println(bob);

        try {
            alice.deposit(2000);
            System.out.println("\nAfter Alice deposits 2000: " + alice);
            alice.transferTo(bob, 4000);
            System.out.println("After Alice transfers 4000 to Bob:");
            System.out.println(alice);
            System.out.println(bob);
            System.out.println("\nAttempting overdraft withdrawal from Bob...");
            bob.withdraw(20000);
        } catch (InsufficientFundsException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        System.out.println("\n--- Final Balances ---");
        System.out.println(alice);
        System.out.println(bob);
    }
}
