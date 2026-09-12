import java.util.Arrays;
import java.util.Scanner;

/**
 * Week 5 - Problem 1: Hackathon Score Curve Booster
 * Category C - Easy
 * Boosts every score in-place by a flat bonus and formats using Arrays.toString().
 */
public class PROGRAM1 {

    /**
     * Modifies the caller's original array directly by adding bonus to each score.
     *
     * @param scores array of integer scores
     * @param bonus  non-negative integer bonus
     */
    public static void curveScores(int[] scores, int bonus) {
        if (scores == null || bonus < 0) {
            return;
        }

        for (int i = 0; i < scores.length; i++) {
            scores[i] += bonus;
        }
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

                System.out.print("Enter bonus: ");
                int bonus = scanner.nextInt();

                curveScores(scores, bonus);
                System.out.println(Arrays.toString(scores));
            }
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}