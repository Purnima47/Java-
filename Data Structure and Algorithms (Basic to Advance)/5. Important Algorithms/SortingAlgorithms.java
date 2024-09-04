import java.io.*;

public class Sorting {
    public static void BubbleSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) { // for no. of turns
            for (int j = 0; j < arr.length - i - 1; j++) { // for no. to be swaped
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void SelectionSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                min = j;
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

    public static void InsertionSort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];
            int prev = i - 1;
            while (prev >= 0 && arr[prev] > curr) {
                arr[prev + 1] = arr[prev];
                prev--;
            }
            arr[prev + 1] = curr;
        }
    }

    // INBUILT SORT: use package of import java.util.Arrays;
    // Arrays.sort(arr) --> complexity O(n logn)
    // Arrays.sort(arr,start,end)
    // import java.util.Collections;
    // Arrays.sort(arr,Collections.reverseOrder())
    // Arrays.sort(arr,start,end,Collections.reverseOrder())

    public static void CountingSort(int arr2[]) {
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr2.length; i++) {
            largest = Math.max(largest, arr2[i]);
        }
        int count[] = new int[largest + 1];
        for (int i = 0; i < arr2.length; i++) {
            count[arr2[i]]++;
        }

        // sorting
        int j = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr2[j] = i;
                j++;
                count[i]--;
            }
        }
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();
    }

    public static void print(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arr[] = { 5, 9, 2, 1, 3 };
        int arr2[] = { 1, 1, 1, 2, 6, 5, 2 };
        BubbleSort(arr);
        print(arr);
        CountingSort(arr2);

    }
}
