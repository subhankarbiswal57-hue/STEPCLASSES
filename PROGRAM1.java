import java.util.Scanner;

/**
 * Week 1 - Problem 1: The Exam Hall Seat Duplication Checker
 * Checks for duplicate seat numbers assigned in an exam hall using arrays and loops only (no Collections).
 */
public class PROGRAM1 {

    /**
     * Scans the array of seat numbers and prints duplicates or confirms uniqueness.
     *
     * @param seatNumbers array of integer seat numbers
     */
    public static void checkDuplicateSeats(int[] seatNumbers) {
        if (seatNumbers == null || seatNumbers.length == 0) {
            System.out.println("No Duplicate Seats Found");
            return;
        }

        boolean foundAnyDuplicate = false;
        int totalSeats = seatNumbers.length;

        for (int i = 0; i < totalSeats; i++) {
            // Check if seatNumbers[i] has already been seen earlier to avoid printing the same duplicate multiple times
            boolean alreadyReported = false;
            for (int k = 0; k < i; k++) {
                if (seatNumbers[k] == seatNumbers[i]) {
                    alreadyReported = true;
                    break;
                }
            }
            if (alreadyReported) {
                continue;
            }

            // Check if seatNumbers[i] appears again in the remaining elements
            for (int j = i + 1; j < totalSeats; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    foundAnyDuplicate = true;
                    break;
                }
            }
        }

        if (!foundAnyDuplicate) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter number of assigned seats: ");
            if (scanner.hasNextInt()) {
                int seatCount = scanner.nextInt();
                int[] assignedSeats = new int[seatCount];
                System.out.println("Enter " + seatCount + " seat numbers:");
                for (int i = 0; i < seatCount; i++) {
                    assignedSeats[i] = scanner.nextInt();
                }
                checkDuplicateSeats(assignedSeats);
            }
        } catch (Exception e) {
            System.err.println("An error occurred while reading seat inputs: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}