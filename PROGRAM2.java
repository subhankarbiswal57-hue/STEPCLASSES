/**
 * Category C - Practice Problem 2: The Quiz Scorecard
 * 
 * Scenario:
 * A quiz app records whether each answer you gave was right or wrong.
 * 
 * Problem Statement:
 * Design a Scorecard class that stores each answer's result privately, and reveals only the final score - never the raw list of right/wrong answers.
 * 
 * Requirements:
 * - Store the results (true for correct, false for incorrect) in a private array, filled in one answer at a time.
 * - Provide a method to record the next answer's result.
 * - Expose only the total score (count of correct answers) - never the array itself, in any form.
 * - The total number of questions must be fixed when the scorecard is created.
 */
public class PROGRAM2 {

    static class Scorecard {
        private final boolean[] results;
        private int recordedCount;

        public Scorecard(int totalQuestions) {
            this.results = new boolean[totalQuestions];
            this.recordedCount = 0;
        }

        public void recordAnswer(boolean isCorrect) {
            if (recordedCount < results.length) {
                results[recordedCount] = isCorrect;
                recordedCount++;
            } else {
                System.out.println("All questions have already been recorded.");
            }
        }

        public int getScore() {
            int score = 0;
            for (int i = 0; i < recordedCount; i++) {
                if (results[i]) {
                    score++;
                }
            }
            return score;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Testing Scorecard ===");
        Scorecard sc = new Scorecard(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("sc.getScore() -> " + sc.getScore());
    }
}
