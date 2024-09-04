// import static java.io.ObjectInputFilter.merge;

public class DivideConquer {
    public static void mergeSort(int arr[], int si, int ei) {
        if (si >= ei)
            return;

        int mid = si + (ei - si) / 2;
        mergeSort(arr, si, mid); // left part
        mergeSort(arr, mid + 1, ei); // right part
        merge(arr, si, mid, ei);
    }

    public static void merge(int arr[], int si, int mid, int ei) {
        int temp[] = new int[ei - si + 1];
        int i = si; // iterator for left part
        int j = mid + 1; // iterator for right part
        int k = 0; // iterator for temp array
        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        // left part jo bach gya hai
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        // right
        while (j <= ei) {
            temp[k++] = arr[j++];
        }
        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    public static void quickSort(int arr[], int si, int ei) {
        if (si >= ei)
            return;
        // last element -->pivot
        int pIdx = partition(arr, si, ei);
        quickSort(arr, si, pIdx - 1);
        quickSort(arr, pIdx + 1, ei);
    }

    public static int partition(int arr[], int si, int ei) {
        int pivot = arr[ei];
        int i = si - 1; // to make place for elements smaller than pivot
        for (int j = si; j < ei; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
            i++;
            int temp = pivot;
            arr[ei] = arr[i]; // don't use pivot=arr[i]
            arr[i] = temp;
            return i;
        }
        return 0;
    }

    public static int searchRotated(int arr[], int tar, int si, int ei) {
        if (si > ei)
            return -1;

        int mid = si + (ei - si) / 2;
        if (arr[mid] == tar)
            return mid;

        // MID -->line 1
        if (arr[si] <= arr[mid]) {
            // case a: left
            if (arr[si] <= tar && tar <= mid) {
                return searchRotated(arr, tar, si, mid - 1);
            }
            // case b:right
            else {
                return searchRotated(arr, tar, mid + 1, ei);
            }
        }
        // MID -->line 2
        else {
            // case c:right
            if (arr[mid] <= tar && tar <= arr[ei]) {
                return searchRotated(arr, tar, mid + 1, ei);
            } else
                return searchRotated(arr, tar, si, mid - 1);
        }
    }

    public static void print(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 5, 6, 7, 8, 0, 1, 2 };
        // mergeSort(arr,0, arr.length-1);
        // print(arr);
        int tarIdx = searchRotated(arr, 0, 0, arr.length - 1);
        System.out.println(tarIdx);
    }
}
