import java.util.Scanner;

/**
 * Week 4 Assignment - Problem 2: Maximum Subarray
 * Category C - A2
 * Kadane's algorithm: O(n) time, O(1) space to find maximum contiguous subarray sum.
 */
public class PROGRAM2 {

    /**
     * Finds maximum subarray sum using Kadane's algorithm.
     *
     * @param nums integer array (may contain negative numbers)
     * @return maximum subarray sum
     */
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array must not be empty.");
        }

        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Decide whether to extend current subarray or start fresh from nums[i]
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter number of elements: ");
            if (scanner.hasNextInt()) {
                int count = scanner.nextInt();
                int[] nums = new int[count];
                System.out.println("Enter " + count + " integers:");
                for (int i = 0; i < count; i++) {
                    nums[i] = scanner.nextInt();
                }

                int result = maxSubArray(nums);
                System.out.println(result);
            }
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
