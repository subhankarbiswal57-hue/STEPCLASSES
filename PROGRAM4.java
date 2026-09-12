import java.util.Arrays;
import java.util.Scanner;

/**
 * Week 4 Practice - Problem 4: Merge Two Sorted Arrays
 * Category C - L4
 * Two-pointer technique to merge two sorted arrays without full re-sorting.
 */
public class PROGRAM4 {

    /**
     * Merges two sorted integer arrays into a single sorted array using two pointers.
     *
     * @param arr1 first sorted array
     * @param arr2 second sorted array
     * @return merged and sorted array
     */
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        if (arr1 == null && arr2 == null) {
            return new int[0];
        }
        if (arr1 == null || arr1.length == 0) {
            return arr2 != null ? arr2.clone() : new int[0];
        }
        if (arr2 == null || arr2.length == 0) {
            return arr1.clone();
        }

        int len1 = arr1.length;
        int len2 = arr2.length;
        int[] result = new int[len1 + len2];

        int ptr1 = 0;
        int ptr2 = 0;
        int k = 0;

        // Repeatedly compare current elements and take the smaller one
        while (ptr1 < len1 && ptr2 < len2) {
            if (arr1[ptr1] <= arr2[ptr2]) {
                result[k++] = arr1[ptr1++];
            } else {
                result[k++] = arr2[ptr2++];
            }
        }

        // Copy any remaining elements from arr1
        while (ptr1 < len1) {
            result[k++] = arr1[ptr1++];
        }

        // Copy any remaining elements from arr2
        while (ptr2 < len2) {
            result[k++] = arr2[ptr2++];
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter size of first array: ");
            int n1 = scanner.nextInt();
            int[] arr1 = new int[n1];
            System.out.println("Enter " + n1 + " sorted integers for arr1:");
            for (int i = 0; i < n1; i++) {
                arr1[i] = scanner.nextInt();
            }

            System.out.print("Enter size of second array: ");
            int n2 = scanner.nextInt();
            int[] arr2 = new int[n2];
            System.out.println("Enter " + n2 + " sorted integers for arr2:");
            for (int i = 0; i < n2; i++) {
                arr2[i] = scanner.nextInt();
            }

            int[] merged = mergeSortedArrays(arr1, arr2);
            System.out.println(Arrays.toString(merged));
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
