// Given an integer array arr sorted in non-decreasing order, remove the
// duplicates in-place such that each unique element appears only once.
// Return k after placing the final result in the first k slots of arr.

public class RemoveDuplicates {
    public static void main(String[] args) {
        // Time Complexity: O(N)
        // Space Complexity : O(1)
        int arr[] = { 0, 1, 1, 1, 2, 2, 4, 4, 6, 6, 7 };

        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[i] < arr[j]) {
                int temp = arr[i + 1];
                arr[i + 1] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        System.out.println(i + 1);
    }

}