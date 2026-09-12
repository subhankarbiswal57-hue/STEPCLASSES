import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Week 4 Assignment - Problem 3: 3Sum
 * Category C - A3
 * Finds all unique triplets that sum to 0 in O(n^2) using sorting and two pointers.
 */
public class PROGRAM3 {

    /**
     * Finds all distinct triplets in nums that sum to 0.
     *
     * @param nums integer array
     * @return 2D array of unique triplets
     */
    public static int[][] threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new int[0][0];
        }

        // Setup step: Sort array
        Arrays.sort(nums);
        List<int[]> resultList = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            // Early break if first number is greater than 0 (no three positive numbers sum to 0)
            if (nums[i] > 0) {
                break;
            }

            // Skip duplicate outer elements
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    resultList.add(new int[]{nums[i], nums[left], nums[right]});

                    // Skip duplicates for second element
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // Skip duplicates for third element
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return resultList.toArray(new int[0][]);
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

                int[][] triplets = threeSum(nums);
                System.out.println(Arrays.deepToString(triplets));
            }
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
