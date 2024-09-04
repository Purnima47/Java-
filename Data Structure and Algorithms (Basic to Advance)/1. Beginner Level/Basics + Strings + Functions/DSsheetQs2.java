import java.util.*;

public class DSsheetQs2 {
    public static void Binary(int arr[], int n, int search) {
        int beg = 0;
        int last = n - 1;
        int mid = (beg + last) / 2;
        while (beg <= last) {
            if (arr[mid] == search) {
                System.out.println("Element found at " + mid);
            } else if (arr[mid] > search) {
                last = mid - 1;
            } else {
                beg = mid + 1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter no. of elements");
        n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter elements");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int search;
        System.out.println("Enter element to be searched");
        search = sc.nextInt();
        Binary(arr, n, search);
    }
}
