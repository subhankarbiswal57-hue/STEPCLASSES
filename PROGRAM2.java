import java.util.Scanner;

/**
 * Week 1 - Problem 2: The Typing Speed Test Accuracy Checker
 * Compares typed text against original passage character by character and calculates accuracy percentage.
 */
public class PROGRAM2 {

    /**
     * Compares original and typed strings and prints accuracy and first mismatch info.
     *
     * @param original original passage text
     * @param typed    user's typed text
     */
    public static void checkTypingAccuracy(String original, String typed) {
        if (original == null || typed == null) {
            System.out.println("Invalid input: Strings cannot be null.");
            return;
        }

        int originalLength = original.length();
        int typedLength = typed.length();

        // Compare up to the length of the strings
        int totalLength = Math.min(originalLength, typedLength);
        if (totalLength == 0) {
            System.out.println("Matched: 0/0 | Accuracy: 0.00% | No Mismatches");
            return;
        }

        int matchedCount = 0;
        int firstMismatchPosition = -1;
        char originalCharMismatch = ' ';
        char typedCharMismatch = ' ';

        for (int i = 0; i < totalLength; i++) {
            char origChar = original.charAt(i);
            char typedChar = typed.charAt(i);

            if (origChar == typedChar) {
                matchedCount++;
            } else if (firstMismatchPosition == -1) {
                firstMismatchPosition = i + 1; // 1-based index position
                originalCharMismatch = origChar;
                typedCharMismatch = typedChar;
            }
        }

        double accuracyPercentage = ((double) matchedCount / totalLength) * 100.0;

        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append("Matched: ").append(matchedCount).append("/").append(totalLength)
                     .append(" | Accuracy: ").append(String.format("%.2f", accuracyPercentage)).append("%");

        if (firstMismatchPosition != -1) {
            reportBuilder.append(" | First Mismatch at position ").append(firstMismatchPosition)
                         .append(" ('").append(originalCharMismatch).append("' vs '")
                         .append(typedCharMismatch).append("')");
        } else if (originalLength != typedLength) {
            reportBuilder.append(" | First Mismatch at position ").append(totalLength + 1)
                         .append(" (Length difference)");
        } else {
            reportBuilder.append(" | No Mismatches");
        }

        System.out.println(reportBuilder.toString());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter original passage: ");
            String originalText = scanner.nextLine();
            System.out.print("Enter typed text: ");
            String typedText = scanner.nextLine();
            checkTypingAccuracy(originalText, typedText);
        } catch (Exception e) {
            System.err.println("An error occurred while evaluating typing accuracy: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
