import java.util.Scanner;

/**
 * Week 5 - Problem 4: Hackathon Seating Grid Optimizer
 * Category C - Intermediate
 * Classifies grid rows as "Quiet Zone" or "Buzzing Zone" using a dedicated helper method.
 */
public class PROGRAM4 {

    /**
     * Private helper method that computes the average score of a row.
     * Handles jagged rows safely.
     *
     * @param row array representing a single row of seating scores
     * @return average score of the row, or 0.0 if row is empty/null
     */
    static double rowAverage(int[] row) {
        if (row == null || row.length == 0) {
            return 0.0;
        }

        double sum = 0.0;
        for (int score : row) {
            sum += score;
        }
        return sum / row.length;
    }

    /**
     * Classifies each row in the seating grid against a threshold score.
     *
     * @param seatingScores jagged 2D array of scores
     * @param threshold     threshold value
     * @return formatted classification string
     */
    public static String classifyRows(int[][] seatingScores, int threshold) {
        if (seatingScores == null || seatingScores.length == 0) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < seatingScores.length; i++) {
            double avg = rowAverage(seatingScores[i]);
            String classification = (avg < threshold) ? "Quiet Zone" : "Buzzing Zone";

            result.append("Row ").append(i).append(": ").append(classification);
            if (i < seatingScores.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter number of rows: ");
            if (scanner.hasNextInt()) {
                int rowCount = scanner.nextInt();
                int[][] seatingScores = new int[rowCount][];

                for (int i = 0; i < rowCount; i++) {
                    System.out.print("Enter number of columns in row " + i + ": ");
                    int colCount = scanner.nextInt();
                    seatingScores[i] = new int[colCount];
                    System.out.println("Enter " + colCount + " scores for row " + i + ":");
                    for (int j = 0; j < colCount; j++) {
                        seatingScores[i][j] = scanner.nextInt();
                    }
                }

                System.out.print("Enter threshold: ");
                int threshold = scanner.nextInt();

                String classificationResult = classifyRows(seatingScores, threshold);
                System.out.println(classificationResult);
            }
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
