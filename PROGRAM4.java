import java.util.Scanner;

/**
 * Problem 4: Library ISBN Normalizer & Validator
 * Normalizes and validates 13-character ISBN-style codes:
 * 3 letters (publisher code) + 4 digits (year) + 6 digits (catalog number).
 */
public class PROGRAM4 {

    /**
     * Normalizes raw code: trims whitespace and uppercases only the first 3 characters.
     *
     * @param raw the input raw code string
     * @return normalized string
     */
    public static String normalizeCode(String raw) {
        if (raw == null) {
            return "";
        }
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }
        // Uppercase only the first 3 characters using substring() + concatenation
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    /**
     * Validates normalized code and returns formatted line or error reason.
     *
     * @param code the normalized code string
     * @return formatted record string or validation error message
     */
    public static String validateAndFormat(String code) {
        if (code == null || code.length() != 13) {
            return "Invalid: wrong length";
        }

        // Validate first 3 characters are letters without regex
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        // Validate remaining 10 characters are digits without regex
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }

        String pubCode = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalogNumber = code.substring(7);

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(pubCode).append("] YEAR: ").append(year)
          .append(" | CATALOG: ").append(catalogNumber);

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter ISBN code: ");
            if (scanner.hasNextLine()) {
                String rawInput = scanner.nextLine();
                String normalized = normalizeCode(rawInput);
                String result = validateAndFormat(normalized);
                System.out.println(result);
            }
        } catch (Exception e) {
            System.err.println("An error occurred during validation: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
