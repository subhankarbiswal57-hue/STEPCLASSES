import java.util.Scanner;

/**
 * Week 1 Practice - Problem 5: Student Grade Book
 * Day 2 Live-Coding Session
 * Reads subject marks from parallel arrays, computes averages, assigns letter grades, finds class topper.
 */
public class PROGRAM5 {

    /**
     * Assigns a letter grade based on score.
     *
     * @param score numeric score (0-100)
     * @return letter grade
     */
    public static String assignGrade(double score) {
        if (score >= 90) {
            return "A+";
        } else if (score >= 80) {
            return "A";
        } else if (score >= 70) {
            return "B";
        } else if (score >= 60) {
            return "C";
        } else if (score >= 50) {
            return "D";
        } else {
            return "F";
        }
    }

    /**
     * Computes average from an integer array.
     *
     * @param marks array of marks
     * @return average
     */
    public static double computeAverage(int[] marks) {
        if (marks == null || marks.length == 0) {
            return 0.0;
        }
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return (double) sum / marks.length;
    }

    /**
     * Prints formatted grade book table for all students and identifies the class topper.
     *
     * @param names    student names
     * @param allMarks 2D array where allMarks[i] contains marks for student i
     */
    public static void printGradeBook(String[] names, int[][] allMarks) {
        if (names == null || allMarks == null || names.length != allMarks.length) {
            System.out.println("Invalid data.");
            return;
        }

        System.out.printf("%-15s | %-8s | %-6s%n", "Student", "Average", "Grade");
        System.out.println("--------------------------------------");

        double highestAvg = -1;
        String topperName = "";

        for (int i = 0; i < names.length; i++) {
            double avg = computeAverage(allMarks[i]);
            String grade = assignGrade(avg);

            System.out.printf("%-15s | %-8.2f | %-6s%n", names[i], avg, grade);

            if (avg > highestAvg) {
                highestAvg = avg;
                topperName = names[i];
            }
        }

        System.out.println("\nClass Topper: " + topperName + " (Avg: " + String.format("%.2f", highestAvg) + ")");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter number of students: ");
            int studentCount = scanner.nextInt();
            System.out.print("Enter number of subjects: ");
            int subjectCount = scanner.nextInt();
            scanner.nextLine(); // consume newline

            String[] names = new String[studentCount];
            int[][] allMarks = new int[studentCount][subjectCount];

            for (int i = 0; i < studentCount; i++) {
                System.out.print("Enter name for student " + (i + 1) + ": ");
                names[i] = scanner.nextLine().trim();
                System.out.println("Enter " + subjectCount + " marks for " + names[i] + ":");
                for (int j = 0; j < subjectCount; j++) {
                    allMarks[i][j] = scanner.nextInt();
                }
                if (i < studentCount - 1) {
                    scanner.nextLine(); // consume newline before next name
                }
            }

            printGradeBook(names, allMarks);
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}