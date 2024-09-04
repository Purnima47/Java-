import java.io.*;

public class BinarySearch {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, search;
        System.out.println("Enter no. of elements");
        n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        System.out.println("Enter elements in array");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println("Enter element to be searched");
        search = Integer.parseInt(br.readLine());
        // for (int i = 0; i <n ; i++) {
        // for (int j = 0; j < ; j++) {
        //
        // }
        // }
        int beg, end, mid;
        beg = 0;
        end = arr.length - 1;
        while (beg <= end) {
            mid = (beg + end) / 2;
            if (arr[mid] == search) {
                System.out.println("Element is present at " + mid);
                break;
            } else if (arr[mid] < search) {
                beg = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if (beg > end) {
            System.out.println("Element not found");
        }

    }
}
