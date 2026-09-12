import java.util.*;

/**
 * Problem 5: Stop-Word-Filtered Word Frequency Report
 * Performs frequency analysis of feedback paragraphs excluding filler words.
 */
public class PROGRAM5 {

    // Predefined stop-words list
    private static final Set<String> STOP_WORDS = new HashSet<>(
            Arrays.asList("the", "was", "and", "a", "is", "of", "in")
    );

    /**
     * Normalizes text, filters stop words, counts word frequencies,
     * and prints unique words sorted in descending order of count.
     *
     * @param feedback paragraph text
     */
    public static void printFilteredWordFrequency(String feedback) {
        if (feedback == null || feedback.trim().isEmpty()) {
            return;
        }

        // Normalize: convert to lowercase and strip punctuation (periods and commas) using replace()
        String cleaned = feedback.toLowerCase()
                                 .replace(".", "")
                                 .replace(",", "")
                                 .replace("!", "")
                                 .replace("?", "")
                                 .replace(";", "")
                                 .replace(":", "");

        // Split into words using whitespace pattern
        String[] words = cleaned.trim().split("\\s+");

        // Count frequency of non-stop-words
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            if (word.isEmpty() || STOP_WORDS.contains(word)) {
                continue;
            }
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        // Sort entries by count in descending order
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(frequencyMap.entrySet());
        sortedList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        // Print results
        for (Map.Entry<String, Integer> entry : sortedList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter feedback text (type an empty line to finish):");
            StringBuilder feedbackBuilder = new StringBuilder();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.isEmpty()) {
                    break;
                }
                feedbackBuilder.append(line).append(" ");
            }
            printFilteredWordFrequency(feedbackBuilder.toString());
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}