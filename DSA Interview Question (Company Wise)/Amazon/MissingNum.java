/*Given an array arr containing n distinct numbers in the range
return the only number in the range that is missing from the array. */

public class MissingNum {
    public static void main(String[] args) {
        int arr[] = { 3, 0, 1,2 };
        int nXor = arr.length;
        for (int i = 0; i < arr.length; i++) {
            nXor = nXor ^ i;
            nXor = nXor ^ arr[i];
        }
        System.out.println(nXor);
    }
}
