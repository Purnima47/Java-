public class MaxSubSum3 {
    public static void main(String[] args) {
        int arr[] = { 2, 4, 6, 8 };
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            if (currSum < 0) {
                currSum = 0;
            }
            maxSum = Math.max(currSum, maxSum);
        }
        System.out.println("Max sum is:" + maxSum);
    }
}
