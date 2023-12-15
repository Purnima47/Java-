// You are given two integer arrays nums1 and nums2, sorted in non-
// decreasing order, and two integer?OndO
// n representing the number of
// elements in nums1 and nums2 respectively.
// Merge nums1 and nums2 into a single array sorted in non-decreasing
// order.
// Note: The final sorted array should not be returned by the function, but
// instead be stored inside the array nums1. To accommodate this, nums1
// has a length of m + n

public class MergeSortedArr {
    public static void main(String[] args) {
        int nums1[] = { 5, 6, 7, 0, 0, 0 };
        int m = 3;
        int nums2[] = { 1, 2, 3 };
        int n = 3;

        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (j >= 0 && i >= 0) {
            if (nums1[i] < nums2[j]) {
                int temp = nums2[j];
                nums2[j] = nums1[k];
                nums1[k] = temp;
                j--;
            } else {
                int temp = nums1[i];
                nums1[i] = nums1[k];
                nums1[k] = temp;
                i--;
            }
            k--;
        }

        while (j >= 0) {
            int temp = nums2[j];
            nums2[j] = nums1[k];
            nums1[k] = temp;
            j--;
            k--;
        }

        while (i >= 0) {
            int temp = nums1[i];
            nums1[i] = nums1[k];
            nums1[k] = temp;
            i--;
            k--;
        }

        for (int k2 = 0; k2 < nums1.length; k2++) {
            System.out.print(nums1[k2] + " ");
        }

    }
}
