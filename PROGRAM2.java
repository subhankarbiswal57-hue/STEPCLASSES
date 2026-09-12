/**
 * Week 6 Assignment - Problem 2: Payroll Salary Management
 * Encapsulated PayrollAccount class preventing invalid direct access or modifications.
 */
public class PROGRAM2 {

    static class PayrollAccount {
        private double basicSalary;
        private double bonus;

        public PayrollAccount(double openingSalary) {
            if (openingSalary < 0) {
                System.out.println("Warning: Negative opening salary given. Defaulting to 0.");
                this.basicSalary = 0;
            } else {
                this.basicSalary = openingSalary;
            }
            this.bonus = 0;
        }

        public void creditBonus(double amount) {
            if (amount <= 0) {
                System.out.println("Bonus amount must be greater than 0.");
                return;
            }
            this.bonus += amount;
            System.out.println("Bonus credited: Rs " + amount);
        }

        public void deductTax(double percent) {
            if (percent < 0 || percent > 100) {
                System.out.println("Tax percentage must be between 0 and 100.");
                return;
            }
            this.basicSalary -= this.basicSalary * (percent / 100.0);
            System.out.println("Tax deducted: " + (int) percent + "%");
        }

        public double getNetSalary() {
            return this.basicSalary + this.bonus;
        }
    }

    public static void main(String[] args) {
        PayrollAccount account = new PayrollAccount(50000);
        account.creditBonus(5000);
        account.deductTax(10);
        System.out.println("Net salary: Rs " + account.getNetSalary());
    }
}
