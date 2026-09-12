import java.util.Scanner;

/**
 * Week 1 - Problem 5: The Movie Review Word Length Profiler
 * Scans a review text, splits into individual words, and categorizes lengths:
 * Short (1-4 letters), Medium (5-8 letters), Long (9+ letters).
 */
public class PROGRAM5 {

    /**
     * Splits review text into words, categorizes each word by character length, and prints counts.
     *
     * @param review movie review string
     */
    public static void classifyWordLengths(String review) {
        if (review == null || review.trim().isEmpty()) {
            System.out.println("Short: 0 | Medium: 0 | Long: 0");
            return;
        }

        // Split review into individual words using whitespace regex
        String[] words = review.trim().split("\\s+");

        int shortCount = 0;
        int mediumCount = 0;
        int longCount = 0;

        for (String rawWord : words) {
            // Count letter characters in the word (strip punctuation if any)
            int letterLength = 0;
            for (int i = 0; i < rawWord.length(); i++) {
                if (Character.isLetter(rawWord.charAt(i))) {
                    letterLength++;
                }
            }

            // If no letters found, fallback to total length
            int effectiveLength = (letterLength > 0) ? letterLength : rawWord.length();

            if (effectiveLength >= 1 && effectiveLength <= 4) {
                shortCount++;
            } else if (effectiveLength >= 5 && effectiveLength <= 8) {
                mediumCount++;
            } else if (effectiveLength >= 9) {
                longCount++;
            }
        }

        System.out.println("Short: " + shortCount + " | Medium: " + mediumCount + " | Long: " + longCount);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter movie review: ");
            if (scanner.hasNextLine()) {
                String reviewText = scanner.nextLine();
                classifyWordLengths(reviewText);
            }
        } catch (Exception e) {
            System.err.println("An error occurred while profiling review: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}