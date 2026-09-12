import java.util.Scanner;

/**
 * Week 1 Practice - Problem 2: Palindrome Checker (3 Approaches)
 * Day 1 Live-Coding Session
 * Verifies palindromes using 3 independent approaches:
 * 1. Iterative check
 * 2. Recursive check
 * 3. Array-reversal check
 */
public class PROGRAM2 {

    /**
     * Iterative check: compares characters from both ends moving toward the middle.
     */
    public static boolean isPalindromeIterative(String text) {
        if (text == null) {
            return false;
        }

        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    /**
     * Recursive check: recursively compares first and last character.
     */
    public static boolean isPalindromeRecursive(String text) {
        if (text == null) {
            return false;
        }
        if (text.length() <= 1) {
            return true;
        }

        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }

        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    /**
     * Array-reversal check: converts string to char array, reverses it, and compares.
     */
    public static boolean isPalindromeArrayReversal(String text) {
        if (text == null) {
            return false;
        }

        char[] originalChars = text.toCharArray();
        int len = originalChars.length;
        char[] reversedChars = new char[len];

        for (int i = 0; i < len; i++) {
            reversedChars[i] = originalChars[len - 1 - i];
        }

        String reversedText = new String(reversedChars);
        return text.equals(reversedText);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter text: ");
            if (scanner.hasNextLine()) {
                String input = scanner.nextLine();

                boolean iterResult = isPalindromeIterative(input);
                boolean recurResult = isPalindromeRecursive(input);
                boolean arrayResult = isPalindromeArrayReversal(input);

                String iterStr = iterResult ? "Palindrome" : "Not Palindrome";
                String recurStr = recurResult ? "Palindrome" : "Not Palindrome";
                String arrayStr = arrayResult ? "Palindrome" : "Not Palindrome";

                System.out.println("Iterative: " + iterStr + " | Recursive: " + recurStr + " | Array Reversal: " + arrayStr);
            }
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
