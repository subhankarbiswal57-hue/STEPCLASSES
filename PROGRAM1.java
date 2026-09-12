import java.util.Arrays;
import java.util.Scanner;

/**
 * Week 4 Practice - Problem 1: Two Sum
 * Category C - L1
 * Finds two indices in an array such that their values add up to target.
 */
public class PROGRAM1 {

    /**
     * Finds two indices such that nums[i] + nums[j] == target using nested loops.
     *
     * @param nums   integer array
     * @param target target sum
     * @return array of two indices [i, j]
     */
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[0];
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[0];
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

                System.out.print("Enter target sum: ");
                int target = scanner.nextInt();

                int[] result = twoSum(nums, target);
                System.out.println(Arrays.toString(result));
            }
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}