import java.util.Scanner;

/**
 * Week 4 Practice - Problem 2: Best Time to Buy and Sell Stock
 * Category C - L2
 * Single-pass tracking of running minimum price and maximum profit.
 */
public class PROGRAM2 {

    /**
     * Calculates the maximum profit achievable with one buy and one sell in chronological order.
     *
     * @param prices daily stock prices array
     * @return maximum profit, or 0 if no profit can be made
     */
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                int currentProfit = prices[i] - minPrice;
                if (currentProfit > maxProfit) {
                    maxProfit = currentProfit;
                }
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter number of days: ");
            if (scanner.hasNextInt()) {
                int count = scanner.nextInt();
                int[] prices = new int[count];
                System.out.println("Enter " + count + " prices:");
                for (int i = 0; i < count; i++) {
                    prices[i] = scanner.nextInt();
                }

                int result = maxProfit(prices);
                System.out.println(result);
            }
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
