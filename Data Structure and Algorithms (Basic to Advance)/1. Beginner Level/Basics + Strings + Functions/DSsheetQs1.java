import java.io.*;

public class DSsheetQs1 {
    public static boolean Repeat(int arr[]) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                    return true;
                    // System.out.println(true);

                }
            }

        }
        // System.out.println("Total no. of repeated elements are: "+count);
        // System.out.println(false);
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        int arr[] = { 1, 2, 4, 5, 1, 2 };
        System.out.println(Repeat(arr));
        // System.out.println("Enter the value of n");
        // n=Integer.parseInt(br.readLine());
        // int arr[]=new int[n];
        // System.out.println("Enter the elements of array");
        // for (int i = 0; i <n ; i++) {
        // arr[i]=Integer.parseInt(br.readLine());
        // }

    }
}
