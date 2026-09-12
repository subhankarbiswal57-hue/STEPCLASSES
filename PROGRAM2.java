import java.util.Scanner;

/**
 * Week 5 - Problem 2: Duplicate Team Name Finder
 * Category C - Easy
 * Scans list of team names using plain nested loops (no Collections) and reports the first duplicate.
 */
public class PROGRAM2 {

    /**
     * Finds the first duplicate team name using plain nested loops.
     *
     * @param teamNames array of team names
     * @return message indicating the first duplicate found or confirming no duplicates
     */
    public static String findDuplicateTeam(String[] teamNames) {
        if (teamNames == null || teamNames.length == 0) {
            return "No Duplicates Found";
        }

        // Compare each name against only the names that come after it
        for (int i = 0; i < teamNames.length; i++) {
            if (teamNames[i] == null) {
                continue;
            }
            for (int j = i + 1; j < teamNames.length; j++) {
                if (teamNames[i].equals(teamNames[j])) {
                    return "Duplicate Found: " + teamNames[i];
                }
            }
        }

        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter number of teams: ");
            if (scanner.hasNextInt()) {
                int count = scanner.nextInt();
                scanner.nextLine(); // consume newline
                String[] teams = new String[count];
                System.out.println("Enter " + count + " team names:");
                for (int i = 0; i < count; i++) {
                    teams[i] = scanner.nextLine().trim();
                }

                String result = findDuplicateTeam(teams);
                System.out.println(result);
            }
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
