import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Collections;

public class Arraylist {

    public static void swap(ArrayList<Integer> list, int i1, int i2) {
        int temp = list.get(i1);
        list.set(i1, list.get(i2));
        list.set(i2, temp);
    }

    public static void multiDimen() {
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        mainList.add(list1);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        mainList.add(list2);

        for (int i = 0; i < mainList.size(); i++) {
            ArrayList<Integer> cuArrayList = mainList.get(i);
            for (int j = 0; j < cuArrayList.size(); j++) {
                System.out.print(cuArrayList.get(j) + " ");
            }
            System.out.println();
        }
        System.out.println(mainList);

    }

    public static void multiDimen2() {
        ArrayList<ArrayList<Integer>> mArrayList = new ArrayList<>();
        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        ArrayList<Integer> l3 = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            l1.add(i * 1);
            l2.add(i * 2);
            l3.add(i * 3);
        }
        mArrayList.add(l1);
        mArrayList.add(l2);
        mArrayList.add(l3);
        System.out.println(mArrayList);

        for (int i = 0; i < mArrayList.size(); i++) {
            ArrayList<Integer> cuArrayList = mArrayList.get(i);
            for (int j = 0; j < cuArrayList.size(); j++) {
                System.out.print(cuArrayList.get(j) + " ");
            }
            System.out.println();

        }
    }

    public static int storeWaterBruteForce(ArrayList<Integer> height) {
        // O(n^2)
        int maxWater = 0;
        for (int i = 0; i < height.size(); i++) {
            for (int j = i + 1; j < height.size(); j++) {
                int ht = Math.min(height.get(i), height.get(j));
                int wd = j - i;
                int currentWater = ht * wd;
                maxWater = Math.max(maxWater, currentWater);
            }
        }

        return maxWater;

    }

    public static void storeWaterUsingPointers(ArrayList<Integer> height) {
        // O(n)
        int lp = 0;
        int rp = height.size() - 1;
        int maxWater = 0;
        while (lp < rp) {

            if (height.get(lp) < height.get(rp)) {
                lp++;
            } else {
                rp--;
            }
            int ht = Math.min(height.get(lp), height.get(rp));
            int wd = rp - lp;
            int currentWater = ht * wd;
            maxWater = Math.max(maxWater, currentWater);
        }
        System.out.println(maxWater);
    }

    public static boolean pairSumUsingPointer(ArrayList<Integer> sum, int target) {
        // list must be sorted
        int lp = 0;
        int rp = sum.size() - 1;
        while (lp < rp) {
            if ((sum.get(lp) + sum.get(rp)) == target) {
                System.out.println(sum.get(lp) + "+" + sum.get(rp) + "=" + target);
                return true;
            } else if ((sum.get(lp) + sum.get(rp)) < target) {
                lp++;
            } else {
                rp--;
            }
        }
        return false;

    }

    // O(n)
    public static boolean pairSumInSortedRotatedAL(ArrayList<Integer> rotated, int target) {
        int bp = -1;
        int n = rotated.size();
        for (int i = 0; i < rotated.size(); i++) {
            if (rotated.get(i) > rotated.get(i + 1)) {
                bp = i; // breaking point
                break;
            }
        }

        int lp = bp + 1; // smallest element
        int rp = bp; // largest element

        while (lp != rp) {

            if ((rotated.get(lp) + rotated.get(rp)) == target) {
                System.out.println(rotated.get(lp) + "+" + rotated.get(rp) + "=" + target);
                return true;
            }
            if ((rotated.get(lp) + rotated.get(rp)) < target) {
                lp = (lp + 1) % n;
            } else {
                rp = (n + rp - 1) % n;
            }
        }
        return false;
    }

    // O(n)
    public static boolean monotonicAL() {
        ArrayList<Integer> mono = new ArrayList<>();
        mono.add(1);
        mono.add(6);
        mono.add(5); // 6 5 5 4 3 1
        mono.add(5);
        mono.add(4);
        mono.add(3);
        mono.add(3);
        boolean Increasing = true;
        boolean Decreasing = true;

        for (int i = 0; i < mono.size(); i++) {

            {
                if (mono.get(i) > mono.get(i + 1)) {
                    Increasing = false;
                } else if (mono.get(i) < mono.get(i + 1)) {
                    Decreasing = false;
                }
            }
        }
        return (Increasing || Decreasing);
    }

    // public static boolean monotonicAL2() {
    // ArrayList<Integer> mono = new ArrayList<>();

    // }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(1);
        list.add(20);
        list.add(12);
        list.add(0);
        System.out.println(list);
        System.out.println(list.get(list.size() - 1));
        Collections.sort(list);
        System.out.println(list);
        swap(list, 2, 4);
        System.out.println(list);
        Collections.sort(list, Collections.reverseOrder()); // comparator function
        System.out.println(list);
        multiDimen();
        multiDimen2();

        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);
        System.out.println("Maximum area of water stored is: " + storeWaterBruteForce(height));
        storeWaterUsingPointers(height);

        ArrayList<Integer> sum = new ArrayList<>();
        sum.add(1);
        sum.add(2);
        sum.add(3);
        sum.add(4);
        sum.add(5);
        System.out.println(pairSumUsingPointer(sum, 8));

        ArrayList<Integer> rotated = new ArrayList<>();
        rotated.add(11);
        rotated.add(15);
        rotated.add(6);
        rotated.add(8);
        rotated.add(9);
        rotated.add(10);
        System.out.println(pairSumInSortedRotatedAL(rotated, 16));

        System.out.println(monotonicAL());
    }
}
