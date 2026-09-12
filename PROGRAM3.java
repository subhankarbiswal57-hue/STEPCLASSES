import java.util.Arrays;
import java.util.Scanner;

/**
 * Week 5 - Problem 3: Top-3 Podium Finder
 * Category C - Intermediate
 * Finds the top 3 scores in descending order in a single pass without sorting the array.
 */
public class PROGRAM3 {

    /**
     * Scans through the scores array once to identify the top 3 scores (descending order).
     *
     * @param scores array of scores (length >= 3)
     * @return array of 3 top scores in descending order
     */
    public static int[] findTopThreeScores(int[] scores) {
        if (scores == null || scores.length < 3) {
            throw new IllegalArgumentException("Scores array must have at least 3 elements.");
        }

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for (int score : scores) {
            if (score >= first) {
                third = second;
                second = first;
                first = score;
            } else if (score >= second) {
                third = second;
                second = score;
            } else if (score > third) {
                third = score;
            }
        }

        return new int[]{first, second, third};
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

                int[] topThree = findTopThreeScores(scores);
                System.out.println(Arrays.toString(topThree));
            }
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
