import java.util.Scanner;

/**
 * Problem 3: Product Inventory CSV Parser
 * Parses a CSV line in the format "ProductName,SKU,Quantity" and displays a formatted inventory record.
 */
public class PROGRAM3 {

    /**
     * Parses and formats an inventory record from a CSV line.
     *
     * @param csvLine comma-separated input string
     */
    public static void parseInventoryRecord(String csvLine) {
        if (csvLine == null || csvLine.trim().isEmpty()) {
            System.out.println("Invalid Record");
            return;
        }

        String[] fields = csvLine.split(",");

        // Validate that exactly 3 fields are present
        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String productName = fields[0].trim();
        String sku = fields[1].trim();
        String quantity = fields[2].trim();

        System.out.println("Product: " + productName + " | SKU: " + sku + " | Qty: " + quantity);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter CSV line: ");
            if (scanner.hasNextLine()) {
                String inputLine = scanner.nextLine();
                parseInventoryRecord(inputLine);
            }
        } catch (Exception e) {
            System.err.println("An error occurred while parsing record: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
