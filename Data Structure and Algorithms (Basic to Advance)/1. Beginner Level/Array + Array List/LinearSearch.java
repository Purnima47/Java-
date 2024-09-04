import java.io.*;

public class LinearSearch {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, search;
        System.out.println("Enter the no. of elements");
        n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        System.out.println("Enter the elements of the array");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println("Enter element to be searched");
        search = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            if (arr[i] == search) {
                System.out.println("Element " + search + " is found at index " + i);
                break;
            }
        }
        if (search == n) {
            System.out.println("Element is not present");
        }
        // arr[0] = Integer.parseInt(br.readLine());
        // arr[1]=Integer.parseInt(br.readLine());
    }
}
