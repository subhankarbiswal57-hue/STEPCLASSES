import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Week 5 - Problem 5: Placement Drive Shortlisting & Ranking Engine
 * Category C - Advanced
 * Implements eligibility filters (method overloading), Comparable for composite sorting via Arrays.sort(),
 * and shortlisting with ranking.
 */
public class PROGRAM5 {

    /**
     * Candidate model class implementing Comparable<Candidate>.
     */
    public static class Candidate implements Comparable<Candidate> {
        private String name;
        private double cgpa;
        private int codingScore;

        public Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
        }

        public String getName() {
            return name;
        }

        public double getCgpa() {
            return cgpa;
        }

        public int getCodingScore() {
            return codingScore;
        }

        /**
         * Calculates composite score: (cgpa * 10) + (codingScore * 0.5)
         *
         * @return composite score
         */
        public double getCompositeScore() {
            return (this.cgpa * 10.0) + (this.codingScore * 0.5);
        }

        /**
         * Compares this candidate against another in descending order of composite score.
         */
        @Override
        public int compareTo(Candidate other) {
            return Double.compare(other.getCompositeScore(), this.getCompositeScore());
        }
    }

    /**
     * Overloaded eligibility check: CGPA-only filter.
     * Strong CGPA threshold is >= 7.5.
     *
     * @param cgpa candidate's CGPA
     * @return true if eligible by CGPA alone
     */
    public static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }

    /**
     * Overloaded eligibility check: Combined CGPA and coding score filter.
     * Borderline CGPA threshold is >= 6.5 along with coding score >= 60.
     *
     * @param cgpa        candidate's CGPA
     * @param codingScore candidate's coding score
     * @return true if eligible by combined score
     */
    public static boolean isEligible(double cgpa, int codingScore) {
        if (isEligible(cgpa)) {
            return true;
        }
        return cgpa >= 6.5 && codingScore >= 60;
    }

    /**
     * Filters eligible candidates, sorts them using Arrays.sort, and generates ranked output string.
     *
     * @param candidates array of candidates
     * @return formatted ranking string
     */
    public static String shortlistAndRank(Candidate[] candidates) {
        if (candidates == null || candidates.length == 0) {
            return "";
        }

        List<Candidate> eligibleList = new ArrayList<>();
        for (Candidate c : candidates) {
            if (isEligible(c.getCgpa(), c.getCodingScore())) {
                eligibleList.add(c);
            }
        }

        Candidate[] shortlistedArray = eligibleList.toArray(new Candidate[0]);

        // Uses Arrays.sort with Candidate's compareTo implementation
        Arrays.sort(shortlistedArray);

        StringBuilder rankedResult = new StringBuilder();
        for (int i = 0; i < shortlistedArray.length; i++) {
            Candidate c = shortlistedArray[i];
            rankedResult.append(i + 1).append(". ")
                        .append(c.getName())
                        .append(" (")
                        .append(String.format("%.1f", c.getCompositeScore()))
                        .append(")");

            if (i < shortlistedArray.length - 1) {
                rankedResult.append(" | ");
            }
        }

        return rankedResult.toString();
    }

    public static void main(String[] args) {
        Candidate[] sampleCandidates = new Candidate[]{
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };

        String result = shortlistAndRank(sampleCandidates);
        System.out.println(result);
    }
}