import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Week 4 Assignment - Problem 4: Subarray Sum Equals K
 * Category C - A4
 * Running prefix sums combined with hash map frequency counting: O(n) time, O(n) space.
 */
public class PROGRAM4 {

    /**
     * Counts the total number of continuous subarrays whose sum equals k.
     *
     * @param nums integer array (may contain positive and negative numbers)
     * @param k    target sum
     * @return count of matching subarrays
     */
    public static int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Map from prefix sum to its frequency
        Map<Integer, Integer> prefixSumCounts = new HashMap<>();
        // Base case: empty prefix has a sum of 0 occurring once
        prefixSumCounts.put(0, 1);

        int currentRunningSum = 0;
        int totalMatchCount = 0;

        for (int num : nums) {
            currentRunningSum += num;

            // If (currentRunningSum - k) occurred before, each occurrence forms a valid subarray ending here
            int neededPrefix = currentRunningSum - k;
            if (prefixSumCounts.containsKey(neededPrefix)) {
                totalMatchCount += prefixSumCounts.get(neededPrefix);
            }

            // Record current running sum frequency
            prefixSumCounts.put(currentRunningSum, prefixSumCounts.getOrDefault(currentRunningSum, 0) + 1);
        }

        return totalMatchCount;
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

                System.out.print("Enter target k: ");
                int k = scanner.nextInt();

                int result = subarraySum(nums, k);
                System.out.println(result);
            }
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
