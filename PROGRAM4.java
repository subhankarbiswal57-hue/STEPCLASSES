import java.util.Scanner;

/**
 * Week 1 - Problem 4: The Warehouse Inventory Balancer
 * Computes section totals, evaluates inventory balance, and tracks the maximum quantity item.
 */
public class PROGRAM4 {

    /**
     * Computes totals for section A and section B, compares balances,
     * and locates the overall highest quantity item.
     *
     * @param sectionA array of item quantities in Section A
     * @param sectionB array of item quantities in Section B
     */
    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        if (sectionA == null || sectionB == null || sectionA.length == 0 || sectionB.length == 0) {
            System.out.println("Invalid inventory data.");
            return;
        }

        int lengthA = sectionA.length;
        int lengthB = sectionB.length;

        int totalA = 0;
        int totalB = 0;

        int maxQuantity = Integer.MIN_VALUE;
        String maxSection = "";
        int maxIndex = -1; // 1-based item index

        // Scan Section A
        for (int i = 0; i < lengthA; i++) {
            totalA += sectionA[i];
            if (sectionA[i] > maxQuantity) {
                maxQuantity = sectionA[i];
                maxSection = "Section A";
                maxIndex = i + 1; // 1-based index (e.g. Item 1, Item 2...)
            }
        }

        // Scan Section B
        for (int i = 0; i < lengthB; i++) {
            totalB += sectionB[i];
            if (sectionB[i] > maxQuantity) {
                maxQuantity = sectionB[i];
                maxSection = "Section B";
                maxIndex = i + 1;
            }
        }

        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

        System.out.println("Section A Total: " + totalA + " | Section B Total: " + totalB +
                           " | Status: " + status + " | Highest Quantity: " + maxQuantity +
                           " (" + maxSection + ", Item " + maxIndex + ")");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter number of categories per section: ");
            if (scanner.hasNextInt()) {
                int count = scanner.nextInt();
                int[] sectionA = new int[count];
                int[] sectionB = new int[count];

                System.out.println("Enter " + count + " quantities for Section A:");
                for (int i = 0; i < count; i++) {
                    sectionA[i] = scanner.nextInt();
                }

                System.out.println("Enter " + count + " quantities for Section B:");
                for (int i = 0; i < count; i++) {
                    sectionB[i] = scanner.nextInt();
                }

                analyzeInventory(sectionA, sectionB);
            }
        } catch (Exception e) {
            System.err.println("An error occurred while analyzing inventory: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
