import java.util.Arrays;
import java.util.Scanner;

/**
 * Week 4 Practice - Problem 5: Rotate Array
 * Category C - L5
 * Rotates an array to the right by k steps using modulo arithmetic and a new array.
 */
public class PROGRAM5 {

    /**
     * Rotates an integer array to the right by k positions.
     *
     * @param nums integer array
     * @param k    number of positions to rotate
     * @return rotated array
     */
    public static int[] rotateArray(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return nums != null ? nums.clone() : new int[0];
        }

        int n = nums.length;
        // Reduce k to avoid unnecessary full rotations
        k = k % n;
        if (k < 0) {
            k += n;
        }

        int[] rotated = new int[n];
        for (int i = 0; i < n; i++) {
            rotated[(i + k) % n] = nums[i];
        }

        // Copy back to nums in-place as well
        System.arraycopy(rotated, 0, nums, 0, n);

        return rotated;
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

                System.out.print("Enter k (rotation steps): ");
                int k = scanner.nextInt();

                int[] result = rotateArray(nums, k);
                System.out.println(Arrays.toString(result));
            }
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}