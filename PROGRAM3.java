/**
 * Category C - Assignment Problem 3: The Password Checker
 * 
 * Scenario:
 * A signup form checks how strong your chosen password is.
 * 
 * Problem Statement:
 * Design a PasswordChecker class that accepts a password once and reveals only its strength rating - never the password itself.
 * 
 * Requirements:
 * - Take the password as a string in the constructor and store it privately, with no getter that returns it.
 * - Provide a method that returns a strength label - for example "Weak" (under 6 characters), "Medium" (6-9 characters), or "Strong" (10+ characters, your own rule is fine).
 * - The password itself must never be changeable after the object is created.
 * - Use the String length (and any other simple check you like, such as whether it contains a digit) to decide the rating.
 */
public class PROGRAM3 {

    static final class PasswordChecker {
        private final String password;

        public PasswordChecker(String password) {
            this.password = (password == null) ? "" : password;
        }

        public String getStrength() {
            int len = password.length();
            if (len < 6) {
                return "Weak";
            } else if (len <= 9) {
                return "Medium";
            } else {
                return "Strong";
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Testing PasswordChecker ===");
        PasswordChecker pc = new PasswordChecker("abcd");
        System.out.println("pc.getStrength() -> " + pc.getStrength());

        PasswordChecker pc2 = new PasswordChecker("abcdefghij");
        System.out.println("pc2.getStrength() -> " + pc2.getStrength());

        PasswordChecker pc3 = new PasswordChecker("abcdefgh");
        System.out.println("pc3.getStrength() -> " + pc3.getStrength());
    }
}
