import java.util.Scanner;

/**
 * Problem 1: ATM PIN Length Validator
 * Validates that an entered PIN string is exactly 4 digits long.
 */
public class PROGRAM1 {

    /**
     * Checks whether the PIN length is exactly 4.
     *
     * @param pin the entered PIN string
     */
    public static void checkPinLength(String pin) {
        if (pin == null) {
            System.out.println("Invalid PIN - must be exactly 4 digits.");
            return;
        }

        int pinLength = pin.length();
        if (pinLength != 4) {
            System.out.println("Invalid PIN - must be exactly 4 digits.");
        } else {
            System.out.println("PIN length OK.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter PIN: ");
            if (scanner.hasNextLine()) {
                String inputPin = scanner.nextLine();
                checkPinLength(inputPin);
            }
        } catch (Exception e) {
            System.err.println("An error occurred while reading input: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}