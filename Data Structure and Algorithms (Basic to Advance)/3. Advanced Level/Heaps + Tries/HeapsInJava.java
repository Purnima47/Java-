import java.util.*;

public class HeapsInJava {
    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) { // O(log n)
            arr.add(data);

            int x = arr.size() - 1; // x is the child index
            int par = (x - 1) / 2; // parent index

            while (arr.get(x) < arr.get(par)) { // O(n)
                // SWAP
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);

                x = par;
                par = (x - 1) / 2;
            }
        }

        public int peek() {
            return arr.get(0);
        }

        private void HeapIFY(int i) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int minIdx = i;

            if (left < arr.size() - 1 && arr.get(minIdx) > arr.get(left)) {
                minIdx = left;
            }

            if (right < arr.size() - 1 && arr.get(minIdx) > arr.get(right)) {
                minIdx = right;
            }

            if (minIdx != i) {
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                HeapIFY(minIdx);
            }
        }

        public int remove() {
            int data = arr.get(0);

            // swap 1st and last ele --> step-1
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);

            // delete last ele --> step-2
            arr.remove(arr.size() - 1);

            // HeapIFY -->step-3
            HeapIFY(0);
            return data;
        }

        public boolean isEmpty() {
            return arr.size() == 0;
        }
    }

    public static void main(String[] args) {
        Heap h = new Heap();
        // h.add(35);
        // h.add(40);
        // h.add(12);
        // h.add(5);
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);

        while (!h.isEmpty()) {
            System.out.print(h.peek() + " ");
            h.remove();
        }
    }
}
