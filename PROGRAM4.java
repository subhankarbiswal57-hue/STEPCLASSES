import java.util.Scanner;

/**
 * Week 5 Assignment - Problem 4: Match Day Grid Analyzer
 * Category C - Intermediate Tier
 * Classifies cricket matches as "Power Surge" or "Normal" using a reusable rowAverage helper.
 */
public class PROGRAM4 {

    /**
     * Private helper method that computes the average run rate for an individual match.
     * Reused once per match without duplicating inline logic.
     *
     * @param row array representing runs scored per over in a match
     * @return average runs per over, or 0.0 if row is empty/null
     */
    static double rowAverage(int[] row) {
        if (row == null || row.length == 0) {
            return 0.0;
        }

        double totalRuns = 0.0;
        for (int runs : row) {
            totalRuns += runs;
        }
        return totalRuns / row.length;
    }

    /**
     * Classifies each match into "Power Surge" (avg >= threshold) or "Normal" (avg < threshold).
     * Accommodates jagged arrays where matches have varying numbers of overs.
     *
     * @param runsPerOver 2D array where each row represents a match
     * @param threshold   threshold for Power Surge
     * @return formatted classification report
     */
    public static String classifyMatches(int[][] runsPerOver, int threshold) {
        if (runsPerOver == null || runsPerOver.length == 0) {
            return "";
        }

        StringBuilder reportBuilder = new StringBuilder();
        for (int i = 0; i < runsPerOver.length; i++) {
            double avg = rowAverage(runsPerOver[i]);
            String classification = (avg >= threshold) ? "Power Surge" : "Normal";

            reportBuilder.append("Match ").append(i).append(": ").append(classification);
            if (i < runsPerOver.length - 1) {
                reportBuilder.append(" | ");
            }
        }

        return reportBuilder.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter number of matches: ");
            if (scanner.hasNextInt()) {
                int matchCount = scanner.nextInt();
                int[][] runsPerOver = new int[matchCount][];

                for (int i = 0; i < matchCount; i++) {
                    System.out.print("Enter number of overs in match " + i + ": ");
                    int overCount = scanner.nextInt();
                    runsPerOver[i] = new int[overCount];
                    System.out.println("Enter runs for " + overCount + " overs in match " + i + ":");
                    for (int j = 0; j < overCount; j++) {
                        runsPerOver[i][j] = scanner.nextInt();
                    }
                }

                System.out.print("Enter threshold: ");
                int threshold = scanner.nextInt();

                String result = classifyMatches(runsPerOver, threshold);
                System.out.println(result);
            }
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
