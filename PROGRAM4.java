import java.util.Scanner;

/**
 * Week 1 Practice - Problem 4: Number Guessing Game
 * Day 2 Live-Coding Session
 * Computer picks a random number 1-100; player guesses with hints until correct.
 */
public class PROGRAM4 {

    /**
     * Provides feedback for a guess against the target.
     *
     * @param guess  player's guess
     * @param target hidden number
     * @return "Too Low", "Too High", or "Correct"
     */
    public static String evaluateGuess(int guess, int target) {
        if (guess < target) {
            return "Too Low";
        } else if (guess > target) {
            return "Too High";
        } else {
            return "Correct";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            int target = (int) (Math.random() * 100) + 1;
            int maxAttempts = 7;
            int attemptCount = 0;
            boolean guessedCorrectly = false;

            System.out.println("Guess the number (1-100). You have " + maxAttempts + " attempts.");

            while (attemptCount < maxAttempts) {
                System.out.print("Attempt " + (attemptCount + 1) + ": ");
                if (scanner.hasNextInt()) {
                    int guess = scanner.nextInt();
                    attemptCount++;
                    String feedback = evaluateGuess(guess, target);
                    System.out.println(feedback);

                    if (feedback.equals("Correct")) {
                        guessedCorrectly = true;
                        break;
                    }
                } else {
                    System.out.println("Please enter a valid integer.");
                    scanner.next(); // consume invalid token
                }
            }

            if (guessedCorrectly) {
                System.out.println("You guessed it in " + attemptCount + " attempts!");
            } else {
                System.out.println("Out of attempts! The number was " + target);
            }
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
