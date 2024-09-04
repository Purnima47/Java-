import java.util.*;

public class J_43Heap {

      static class Heap {
            ArrayList<Integer> arr = new ArrayList<>();

            // Add function...
            public void add(int data) { // O( log n)
                  arr.add(data); // add at last integer... O(1)

                  int childIdx = arr.size() - 1;
                  int parentIdx = (childIdx - 1) / 2; // O(1)

                  // while(arr.get(childIdx) < arr.get(parentIdx)){ // O(log n)
                  while (arr.get(childIdx) > arr.get(parentIdx)) { // :for descending order(maxHeap)
                        // swap...
                        int temp = arr.get(childIdx);
                        arr.set(childIdx, arr.get(parentIdx));
                        arr.set(parentIdx, temp);

                        childIdx = parentIdx;
                        parentIdx = (childIdx - 1) / 2;
                  }
            }

            public int peek() {
                  return arr.get(0);
            }

            private void heapIfy(int i) { // O(log n)
                  int leftIdx = 2 * i + 1;
                  int rightIdx = 2 * i + 2;
                  int minIdx = i;

                  // If left child is small...
                  // if (leftIdx < arr.size() && arr.get(minIdx) > arr.get(leftIdx)) {
                  if (leftIdx < arr.size() && arr.get(minIdx) < arr.get(leftIdx)) { // maxHeap
                        minIdx = leftIdx;
                  }

                  // If right child is small...
                  // if (rightIdx < arr.size() && arr.get(minIdx) > arr.get(rightIdx)) {
                  if (rightIdx < arr.size() && arr.get(minIdx) < arr.get(rightIdx)) { // maxHeap
                        minIdx = rightIdx;
                  }

                  // change...
                  if (minIdx != i) {
                        // swap with the smallerOne...
                        int temp = arr.get(i);
                        arr.set(i, arr.get(minIdx));
                        arr.set(minIdx, temp);

                        // if does not set proper then call for minIdx...
                        heapIfy(minIdx);
                  }
            }

            public int remove() {
                  int data = arr.get(0); // min value will delete...

                  // step -1 swap first and last
                  int temp = arr.get(0);
                  arr.set(0, arr.get(arr.size() - 1));
                  arr.set(arr.size() - 1, temp);

                  // delete the last node from arraylist
                  arr.remove(arr.size() - 1);

                  // heapIfy ... it will correct the heap...
                  heapIfy(0);
                  return data;
            }

            public boolean isEmpty() {
                  return arr.size() == 0;
            }
      }

      public static void heapIFY2(int arr[], int i, int size) {
            int leftIdx = 2 * i + 1;
            int rightIdx = 2 * i + 2;
            int maxIdx = i;

            // if (leftIdx < size && arr[maxIdx] < arr[leftIdx]) {
            if (leftIdx < size && arr[maxIdx] > arr[leftIdx]) {
                  maxIdx = leftIdx;
            }

            // if (rightIdx < size && arr[maxIdx] < arr[rightIdx]) {
            if (rightIdx < size && arr[maxIdx] > arr[rightIdx]) { // descending order..
                  maxIdx = rightIdx;
            }

            if (maxIdx != i) {
                  int temp = arr[i];
                  arr[i] = arr[maxIdx];
                  arr[maxIdx] = temp;

                  heapIFY2(arr, maxIdx, size);
            }

      }

      public static void heapSort(int arr[]) {
            // Step 1: build maxHeap
            int n = arr.length;
            for (int i = n / 2; i >= 0; i--) {
                  heapIFY2(arr, i, n);
            }

            // Step 2: push largest at the end
            for (int i = n - 1; i > 0; i--) {
                  // swap largest-first with last
                  int temp = arr[0];
                  arr[0] = arr[i];
                  arr[i] = temp;

                  heapIFY2(arr, 0, i);
            }
      }

      static class Point implements Comparable<Point> {
            int x;
            int y;
            int distSq;
            int idx;

            public Point(int x, int y, int distSq, int idx) {
                  this.x = x;
                  this.y = y;
                  this.distSq = distSq;
                  this.idx = idx;
            }

            @Override
            public int compareTo(Point p2) {
                  return this.distSq - p2.distSq;
            }
      }

      public static void nearByCars() {
            int pts[][] = { { 3, 3 }, { 5, 1 }, { -2, 4 } };
            int k = 2;

            PriorityQueue<Point> pq = new PriorityQueue<>();
            for (int i = 0; i < pts.length; i++) {
                  int distSq = pts[i][0] * pts[i][0] + pts[i][1] * pts[i][1];
                  pq.add(new Point(pts[i][0], pts[i][1], distSq, i));
            }

            for (int i = 0; i < k; i++) {
                  System.out.println("C" + pq.remove().idx);
            }
      }

      public static void connectNRopes() {
            int ropes[] = { 2, 3, 3, 4, 6 };

            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int i = 0; i < ropes.length; i++) {
                  pq.add(ropes[i]);
            }

            int cost = 0;
            while (pq.size() > 1) {
                  int min1 = pq.remove();
                  int min2 = pq.remove();
                  cost += min1 + min2;
                  pq.add(min1 + min2);
            }

            System.out.println("Cost of connecting N ropes with min cost = " + cost);
      }

      static class Row implements Comparable<Row> {
            int soldiers;
            int idx;

            public Row(int soldiers, int idx) {
                  this.soldiers = soldiers;
                  this.idx = idx;
            }

            @Override
            public int compareTo(Row r2) {
                  if (this.soldiers == r2.soldiers) {
                        return this.idx - r2.idx;
                  } else {
                        return this.soldiers - r2.soldiers;
                  }
            }

      }

      public static void weakSoldier() {
            // WEAK SOLDIERS:
            int army[][] = { { 1, 0, 0, 0 }, { 1, 1, 1, 1 }, { 1, 0, 0, 0 }, { 1, 0, 0, 0 } };
            int k = 2;

            PriorityQueue<Row> pq = new PriorityQueue<>();

            for (int i = 0; i < army.length; i++) {
                  int count = 0;
                  for (int j = 0; j < army[0].length; j++) {
                        count += army[i][j] == 1 ? 1 : 0;
                  }
                  pq.add(new Row(count, i));
            }

            for (int i = 0; i < k; i++) {
                  System.out.print("R" + pq.remove().idx + "  ");
            }
      }

      // Window Sliding
      static class Pair implements Comparable<Pair> {
            int val;
            int idx;

            public Pair(int val, int idx) {
                  this.val = val;
                  this.idx = idx;
            }

            @Override
            public int compareTo(Pair p2) {
                  // ascending
                  // return this.val-p2.val;

                  // descending
                  return p2.val - this.val;
            }
      }

      // BY SLIDING WINDOW METHOD --> O(n log k)
      public static void maxEleInSubArr() {
            int arr[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
            int k = 3;
            int res[] = new int[arr.length - k + 1];

            PriorityQueue<Pair> pq = new PriorityQueue<>();

            // 1st window
            for (int i = 0; i < k; i++) {
                  pq.add(new Pair(arr[i], i));
            }

            res[0] = pq.peek().val;

            for (int i = k; i < arr.length; i++) {
                  while (pq.size() > 0 && pq.peek().idx <= (i - k)) {
                        pq.remove();
                  }

                  pq.add(new Pair(arr[i], i));
                  res[i - k + 1] = pq.peek().val;
            }

            // Print the result
            for (int i = 0; i < res.length; i++) {
                  System.out.print(res[i] + " ");
            }
            System.out.println();
      }

      public static void main(String[] args) {
            // Heap h = new Heap();
            // h.add(3);
            // h.add(4);
            // h.add(1);
            // h.add(5);

            // while (!h.isEmpty()) { // HEAP SORT(O(n log n))
            // System.out.print(h.peek() + " ");
            // h.remove();
            // }

            // int arr[] = { 4, 2, 1, 6, 7 };
            // heapSort(arr);

            // for (int i = 0; i < arr.length; i++) {
            // System.out.print(arr[i] + " ");
            // }
            // System.out.println();

            // nearByCars();
            // connectNRopes();
            // weakSoldier();

            maxEleInSubArr();

      }
}
