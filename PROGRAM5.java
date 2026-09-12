import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Week 5 Assignment - Problem 5: Fantasy League Auto-Draft Ranking Engine
 * Category C - Advanced Tier
 * Overloaded eligibility rules, Comparable<Player> sorting via Arrays.sort(), and auto-draft ranking.
 */
public class PROGRAM5 {

    /**
     * Player model implementing Comparable<Player> to sort descending by battingAverage.
     */
    public static class Player implements Comparable<Player> {
        private String name;
        private int matchesPlayed;
        private double battingAverage;
        private boolean injured;

        public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }

        public String getName() {
            return name;
        }

        public int getMatchesPlayed() {
            return matchesPlayed;
        }

        public double getBattingAverage() {
            return battingAverage;
        }

        public boolean isInjured() {
            return injured;
        }

        /**
         * Orders players descending by fantasy points (battingAverage).
         */
        @Override
        public int compareTo(Player other) {
            return Double.compare(other.battingAverage, this.battingAverage);
        }
    }

    /**
     * Overloaded draft check: established player cutoff based on experience alone (matches >= 10).
     *
     * @param matchesPlayed count of matches played
     * @return true if draftable on experience alone
     */
    public static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    /**
     * Overloaded draft check: combined matches and fitness check.
     * Established players (matches >= 10) qualify regardless of injury.
     * Newer players qualify if reasonably experienced (matches >= 5) and not injured.
     *
     * @param matchesPlayed count of matches played
     * @param injured       fitness status
     * @return true if draftable
     */
    public static boolean isDraftable(int matchesPlayed, boolean injured) {
        if (isDraftable(matchesPlayed)) {
            return true;
        }
        return matchesPlayed >= 5 && !injured;
    }

    /**
     * Filters draftable players and uses Arrays.sort() to rank them descending by battingAverage.
     *
     * @param players input array of players
     * @return formatted ranking string
     */
    public static String draftAndRank(Player[] players) {
        if (players == null || players.length == 0) {
            return "";
        }

        List<Player> draftableList = new ArrayList<>();
        for (Player p : players) {
            if (isDraftable(p.getMatchesPlayed(), p.isInjured())) {
                draftableList.add(p);
            }
        }

        Player[] draftableArray = draftableList.toArray(new Player[0]);

        // Standard library Arrays.sort relies directly on Player's compareTo
        Arrays.sort(draftableArray);

        StringBuilder rankBuilder = new StringBuilder();
        for (int i = 0; i < draftableArray.length; i++) {
            rankBuilder.append(i + 1).append(". ").append(draftableArray[i].getName());
            if (i < draftableArray.length - 1) {
                rankBuilder.append(" | ");
            }
        }

        return rankBuilder.toString();
    }

    public static void main(String[] args) {
        Player[] samplePlayers = new Player[]{
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };

        String result = draftAndRank(samplePlayers);
        System.out.println(result);
    }
}