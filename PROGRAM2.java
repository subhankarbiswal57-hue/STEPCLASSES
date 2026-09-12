import java.util.Scanner;

/**
 * Week 5 Assignment - Problem 2: Duplicate Player Pick Checker
 * Category C - Easy Tier
 * Scans a lineup for repeated player names using plain nested loops without Collections.
 */
public class PROGRAM2 {

    /**
     * Checks a submitted lineup for a repeated player name using nested loops.
     *
     * @param playerNames array of player names in the lineup
     * @return confirmation or reporting message of the first duplicate found
     */
    public static String findDuplicatePick(String[] playerNames) {
        if (playerNames == null || playerNames.length == 0) {
            return "No Duplicates Found";
        }

        // Compare each name against only names that come after it
        for (int i = 0; i < playerNames.length; i++) {
            if (playerNames[i] == null) {
                continue;
            }
            for (int j = i + 1; j < playerNames.length; j++) {
                if (playerNames[i].equals(playerNames[j])) {
                    return "Duplicate Found: " + playerNames[i];
                }
            }
        }

        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter lineup size: ");
            if (scanner.hasNextInt()) {
                int count = scanner.nextInt();
                scanner.nextLine(); // consume newline
                String[] lineup = new String[count];
                System.out.println("Enter " + count + " player names:");
                for (int i = 0; i < count; i++) {
                    lineup[i] = scanner.nextLine().trim();
                }

                String result = findDuplicatePick(lineup);
                System.out.println(result);
            }
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
