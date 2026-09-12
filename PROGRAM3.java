import java.util.Scanner;

/**
 * Week 5 Assignment - Problem 3: Top Performer Tracker
 * Category C - Intermediate Tier
 * Finds minimum, maximum, and spread in a single pass without sorting.
 */
public class PROGRAM3 {

    /**
     * Finds min, max, and spread in a single pass through the scores array.
     *
     * @param scores array of scores (length >= 2)
     * @return formatted string reporting Min, Max, and Spread
     */
    public static String findMinMaxSpread(int[] scores) {
        if (scores == null || scores.length < 2) {
            throw new IllegalArgumentException("Array must contain at least 2 scores.");
        }

        int min = scores[0];
        int max = scores[0];

        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < min) {
                min = scores[i];
            }
            if (scores[i] > max) {
                max = scores[i];
            }
        }

        int spread = max - min;
        return "Min: " + min + " | Max: " + max + " | Spread: " + spread;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter number of scores: ");
            if (scanner.hasNextInt()) {
                int count = scanner.nextInt();
                int[] scores = new int[count];
                System.out.println("Enter " + count + " scores:");
                for (int i = 0; i < count; i++) {
                    scores[i] = scanner.nextInt();
                }

                String result = findMinMaxSpread(scores);
                System.out.println(result);
            }
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
