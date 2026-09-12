import java.util.Random;
import java.util.Scanner;

/**
 * Week 1 Practice - Problem 1: Rock-Paper-Scissors Game
 * Day 1 Live-Coding Session
 * Plays rounds between player and computer, displays tabular summary and statistics.
 */
public class PROGRAM1 {

    private static final String[] MOVES = {"Rock", "Paper", "Scissors"};

    /**
     * Determines the round outcome.
     *
     * @param playerMove   player's choice
     * @param computerMove computer's choice
     * @return "Player Wins", "Computer Wins", or "Draw"
     */
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove == null || computerMove == null) {
            return "Invalid Move";
        }

        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
            (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
            (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        } else {
            return "Computer Wins";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalRounds = 5;
        String[] playerMoves = new String[totalRounds];
        String[] computerMoves = new String[totalRounds];
        String[] results = new String[totalRounds];

        int wins = 0;
        int losses = 0;
        int draws = 0;

        try {
            System.out.println("Starting Rock-Paper-Scissors (5 Rounds)");
            for (int i = 0; i < totalRounds; i++) {
                System.out.print("Round " + (i + 1) + " - Enter your move (Rock, Paper, Scissors): ");
                String pMove = scanner.nextLine().trim();
                if (pMove.isEmpty()) {
                    pMove = "Rock"; // default fallback
                }

                String cMove = MOVES[random.nextInt(3)];
                String outcome = playRound(pMove, cMove);

                playerMoves[i] = pMove;
                computerMoves[i] = cMove;
                results[i] = outcome;

                if (outcome.equals("Player Wins")) {
                    wins++;
                } else if (outcome.equals("Computer Wins")) {
                    losses++;
                } else {
                    draws++;
                }

                System.out.println("Round " + (i + 1) + " — Player: " + pMove + ", Computer: " + cMove + " -> " + outcome);
            }

            System.out.println("\n--- Summary Table ---");
            System.out.printf("%-8s | %-12s | %-14s | %-14s%n", "Round", "Player Move", "Computer Move", "Result");
            System.out.println("-------------------------------------------------------");
            for (int i = 0; i < totalRounds; i++) {
                System.out.printf("%-8d | %-12s | %-14s | %-14s%n", (i + 1), playerMoves[i], computerMoves[i], results[i]);
            }

            double winPercentage = ((double) wins / totalRounds) * 100.0;
            System.out.println("\nFinal Summary (after " + totalRounds + " rounds)");
            System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n", wins, losses, draws, winPercentage);

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}