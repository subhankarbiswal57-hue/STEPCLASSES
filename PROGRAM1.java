import java.util.Arrays;
import java.util.Scanner;

/**
 * Week 5 Assignment - Problem 1: Fantasy Team Score Multiplier
 * Category C - Easy Tier
 * Applies captain (2x) and vice-captain (1.5x) multipliers directly in-place.
 */
public class PROGRAM1 {

    /**
     * Modifies the caller's score array directly by applying 2x to captain and 1.5x to vice-captain.
     *
     * @param playerScores      array of player scores
     * @param captainIndex      index of captain (doubled: 2.0x)
     * @param viceCaptainIndex  index of vice-captain (multiplied by 1.5x)
     */
    public static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        if (playerScores == null) {
            return;
        }

        // Validate index bounds
        if (captainIndex >= 0 && captainIndex < playerScores.length) {
            playerScores[captainIndex] = playerScores[captainIndex] * 2.0;
        }
        if (viceCaptainIndex >= 0 && viceCaptainIndex < playerScores.length) {
            playerScores[viceCaptainIndex] = playerScores[viceCaptainIndex] * 1.5;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter number of players: ");
            if (scanner.hasNextInt()) {
                int count = scanner.nextInt();
                double[] scores = new double[count];
                System.out.println("Enter " + count + " scores:");
                for (int i = 0; i < count; i++) {
                    scores[i] = scanner.nextDouble();
                }

                System.out.print("Enter Captain Index: ");
                int captainIdx = scanner.nextInt();
                System.out.print("Enter Vice-Captain Index: ");
                int viceCaptainIdx = scanner.nextInt();

                applyMultipliers(scores, captainIdx, viceCaptainIdx);
                System.out.println(Arrays.toString(scores));
            }
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}