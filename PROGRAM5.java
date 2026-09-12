import java.util.Scanner;

/**
 * Week 4 Assignment - Problem 5: Find Minimum in Rotated Sorted Array
 * Category C - A5
 * Modified binary search in O(log n) time.
 */
public class PROGRAM5 {

    /**
     * Finds the minimum element in an ascending sorted array that has been rotated.
     * All elements are distinct.
     *
     * @param nums rotated sorted array
     * @return minimum element
     */
    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array must not be empty.");
        }

        int left = 0;
        int right = nums.length - 1;

        // If array is not rotated (already sorted)
        if (nums[left] <= nums[right]) {
            return nums[left];
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid element is strictly greater than rightmost element,
            // the inflection point (minimum) must be in the right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // Minimum is at mid or in the left half
                right = mid;
            }
        }

        return nums[left];
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

                int result = findMin(nums);
                System.out.println(result);
            }
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}