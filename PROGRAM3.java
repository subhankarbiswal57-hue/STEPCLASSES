import java.util.Scanner;

/**
 * Week 1 Practice - Problem 3: BMI Calculator for a Team
 * Day 1 Live-Coding Session
 * Computes BMI, classifies status, and prints formatted report table.
 */
public class PROGRAM3 {

    /**
     * Classifies BMI status based on standard health ranges:
     * BMI < 18.5 -> Underweight
     * 18.5 - 24.9 -> Normal
     * 25.0 - 29.9 -> Overweight
     * >= 30.0 -> Obese
     *
     * @param bmi calculated body mass index
     * @return status string
     */
    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25.0) {
            return "Normal";
        } else if (bmi < 30.0) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    /**
     * Calculates BMI for parallel arrays of heights and weights and prints a tabular report.
     *
     * @param heights array of heights in meters
     * @param weights array of weights in kilograms
     */
    public static void printWellnessReport(double[] heights, double[] weights) {
        if (heights == null || weights == null || heights.length != weights.length) {
            System.out.println("Invalid or mismatched height/weight data.");
            return;
        }

        System.out.printf("%-10s | %-12s | %-12s | %-8s | %-12s%n", "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("------------------------------------------------------------------");

        for (int i = 0; i < heights.length; i++) {
            double h = heights[i];
            double w = weights[i];

            if (h <= 0) {
                System.out.printf("Person %-3d | %-12.2f | %-12.2f | %-8s | %-12s%n", (i + 1), h, w, "N/A", "Invalid Height");
                continue;
            }

            double bmi = w / (h * h);
            String status = getBmiStatus(bmi);

            System.out.printf("Person %-3d | %-12.2f | %-12.2f | %-8.2f | %-12s%n", (i + 1), h, w, bmi, status);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter number of people: ");
            if (scanner.hasNextInt()) {
                int count = scanner.nextInt();
                double[] heights = new double[count];
                double[] weights = new double[count];

                System.out.println("Enter height (m) and weight (kg) for each person:");
                for (int i = 0; i < count; i++) {
                    heights[i] = scanner.nextDouble();
                    weights[i] = scanner.nextDouble();
                }

                printWellnessReport(heights, weights);
            }
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
