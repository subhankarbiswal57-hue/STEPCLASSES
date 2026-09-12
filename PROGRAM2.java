import java.util.Scanner;

/**
 * Problem 2: Word Reversal Encoder
 * Reverses each word individually in a sentence while maintaining word order.
 */
public class PROGRAM2 {

    /**
     * Reverses each word individually within the sentence.
     *
     * @param sentence the input sentence
     * @return the sentence with each individual word reversed
     */
    public static String reverseEachWord(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return "";
        }

        String[] words = sentence.split(" ");
        StringBuilder reversedSentence = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            StringBuilder reversedWord = new StringBuilder();

            // Reverse the current word using a loop
            for (int j = word.length() - 1; j >= 0; j--) {
                reversedWord.append(word.charAt(j));
            }

            reversedSentence.append(reversedWord);

            // Append space between words if not the last word
            if (i < words.length - 1) {
                reversedSentence.append(" ");
            }
        }

        return reversedSentence.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter sentence: ");
            if (scanner.hasNextLine()) {
                String inputSentence = scanner.nextLine();
                String result = reverseEachWord(inputSentence);
                System.out.println(result);
            }
        } catch (Exception e) {
            System.err.println("An error occurred while processing input: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
