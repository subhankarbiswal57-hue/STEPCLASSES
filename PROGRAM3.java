import java.util.Scanner;

/**
 * Week 1 - Problem 3: The Traffic Signal Streak Analyzer
 * Scans a sequence of signal readings and finds the longest continuous streak of the same color.
 */
public class PROGRAM3 {

    /**
     * Finds and prints the color and length of the longest continuous streak.
     *
     * @param signalLog sequence string containing signal readings (e.g., 'R', 'Y', 'G')
     */
    public static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.isEmpty()) {
            System.out.println("Invalid or empty signal log.");
            return;
        }

        char longestColor = signalLog.charAt(0);
        int maxStreakLength = 1;

        char currentColor = signalLog.charAt(0);
        int currentStreakLength = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            char reading = signalLog.charAt(i);
            if (reading == currentColor) {
                currentStreakLength++;
            } else {
                if (currentStreakLength > maxStreakLength) {
                    maxStreakLength = currentStreakLength;
                    longestColor = currentColor;
                }
                currentColor = reading;
                currentStreakLength = 1;
            }
        }

        // Check the final streak
        if (currentStreakLength > maxStreakLength) {
            maxStreakLength = currentStreakLength;
            longestColor = currentColor;
        }

        System.out.println("Longest Streak: '" + longestColor + "' repeated " + maxStreakLength + " times");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter signal log: ");
            if (scanner.hasNextLine()) {
                String logInput = scanner.nextLine().trim();
                findLongestStreak(logInput);
            }
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
