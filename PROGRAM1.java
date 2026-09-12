import java.util.Arrays;
import java.util.Scanner;

/**
 * Week 4 Assignment - Problem 1: Product of Array Except Self
 * Category C - A1
 * O(n) time, two-pass solution without using division.
 */
public class PROGRAM1 {

    /**
     * Calculates array where answer[i] is the product of every element except nums[i].
     *
     * @param nums integer array (length >= 2)
     * @return answer array
     */
    public static int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length < 2) {
            return new int[0];
        }

        int n = nums.length;
        int[] answer = new int[n];

        // Pass 1: Forward pass accumulating prefix products
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Pass 2: Backward pass multiplying running suffix product
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * rightProduct;
            rightProduct *= nums[i];
        }

        return answer;
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

                int[] result = productExceptSelf(nums);
                System.out.println(Arrays.toString(result));
            }
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}