/**
 * Category C - Practice Problem 4: The Locker Code
 * 
 * Scenario:
 * A gym locker has a combination code that members can change.
 * 
 * Problem Statement:
 * Design a Locker class where the combination can be changed, but never read back directly from outside the class.
 * 
 * Requirements:
 * - The combination code must be private, with no getter at all.
 * - Provide a method to change the code that requires the current code to be entered correctly first.
 * - If the wrong current code is given, the change must be rejected and the code must stay the same.
 * - Give the locker a final locker number, fixed at creation.
 */
public class PROGRAM4 {

    static class Locker {
        private final int lockerNumber;
        private String code;

        public Locker(int lockerNumber, String initialCode) {
            this.lockerNumber = lockerNumber;
            this.code = initialCode;
        }

        public int getLockerNumber() {
            return lockerNumber;
        }

        public boolean changeCode(String currentCode, String newCode) {
            if (this.code.equals(currentCode)) {
                this.code = newCode;
                System.out.println("Code change -> success");
                return true;
            } else {
                System.out.println("Code change -> rejected, code remains unchanged");
                return false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Testing Locker ===");
        Locker l = new Locker(101, "1234");
        System.out.println("Created Locker: " + l.getLockerNumber());

        l.changeCode("1234", "5678");
        l.changeCode("0000", "9999");
    }
}
