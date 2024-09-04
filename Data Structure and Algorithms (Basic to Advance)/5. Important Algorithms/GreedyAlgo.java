import java.util.*;

public class GreedyAlgo {
    // O(n)
    public static void activitySelection() {
        int start[] = { 1, 3, 0, 5, 8, 5 };
        int end[] = { 2, 4, 6, 7, 9, 9 };
        // end time basis sorted

        int maxAct = 0;
        ArrayList<Integer> act = new ArrayList<>();
        maxAct = 1;
        act.add(0);
        int lastEnd = end[0];
        for (int i = 1; i < end.length; i++) {
            if (start[i] >= lastEnd) {
                maxAct++;
                act.add(i);
                lastEnd = end[i];
            }
        }
        System.out.println("Max activities: " + maxAct);
        for (int i = 0; i < act.size(); i++) {
            System.out.print("A" + act.get(i) + " ");
        }
        System.out.println();
    }

    // O(nlog n)
    public static void activitySelection2() {
        int start[] = { 1, 3, 0, 5, 8, 5 };
        int end[] = { 2, 4, 6, 7, 9, 9 };
        // end time basis sorted

        // if end array is not sorted:
        int activities[][] = new int[start.length][3];
        for (int i = 0; i < start.length; i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }
        // lambda function..
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        int maxAct = 0;
        ArrayList<Integer> act = new ArrayList<>();
        maxAct = 1;
        act.add(activities[0][0]);
        int lastEnd = activities[0][2];
        for (int i = 1; i < end.length; i++) {
            if (activities[i][1] >= lastEnd) {
                maxAct++;
                act.add(activities[i][0]);
                lastEnd = activities[i][2];
            }
        }
        System.out.println("Max activities: " + maxAct);
        for (int i = 0; i < act.size(); i++) {
            System.out.print("A" + act.get(i) + " ");
        }
        System.out.println();
    }

    public static void fractionalKnapsack() {
        int val[] = { 60, 100, 120 };
        int weight[] = { 10, 20, 30 };
        int W = 50;

        double ratio[][] = new double[val.length][2];
        // 0th col:idx
        // 1st col:ratio

        for (int i = 0; i < val.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = val[i] / (double) weight[i];
        }

        // Ascending Order
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int capacity = W;
        int finalVal = 0;
        for (int i = ratio.length - 1; i >= 0; i--) {
            int idx = (int) ratio[i][0];
            if (capacity >= weight[idx]) {
                finalVal += val[idx];
                capacity -= weight[idx];
            } else {
                finalVal += (ratio[i][1] * capacity);
                capacity = 0;
                break;
            }
        }

        System.out.println("Final val: " + finalVal);
    }

    public static void minAbsDiff() {
        // O(nlogn)
        int A[] = { 1, 2, 3 };
        int B[] = { 2, 1, 3 };
        Arrays.sort(A);
        Arrays.sort(B);
        int minDiff = 0;
        for (int i = 0; i < A.length; i++) {
            minDiff += Math.abs(A[i] - B[i]);
        }
        System.out.println("MIN ABSOLUTE DIFF: " + minDiff);
    }

    public static void maxLenChainOfPairs() {
        int pairs[][] = { { 5, 24 }, { 39, 60 }, { 5, 28 }, { 27, 40 }, { 50, 90 } };

        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

        int chainLen = 1;
        int chainEnd = pairs[0][1];

        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > chainEnd) {
                chainLen++;
                chainEnd = pairs[i][1];
            }
        }
        System.out.println("Max len of chain " + chainLen);
    }

    public static void indianCoin() {
        Integer coins[] = { 1, 2, 5, 10, 20, 50, 100, 500, 2000 };

        Arrays.sort(coins, Comparator.reverseOrder());
        int countOfCoins = 0;
        int amt = 590;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < coins.length; i++) {
            if (amt >= coins[i]) {
                while (amt >= coins[i]) {
                    countOfCoins++;
                    ans.add(coins[i]);
                    amt -= coins[i];
                }
            }
        }
        System.out.println("Total min coins used: " + countOfCoins);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }

    static class Job {
        int deadLine;
        int profit;
        int id; // 0 (A) ,1(B) ,2(C)

        public Job(int i, int d, int pr) {
            id = i;
            deadLine = d;
            profit = pr;
        }
    }

    public static void jobSequencing() {
        int jobInfos[][] = { { 4, 20 }, { 1, 10 }, { 1, 40 }, { 1, 30 } };

        ArrayList<Job> jobs = new ArrayList<>();

        for (int i = 0; i < jobInfos.length; i++) {
            jobs.add(new Job(i, jobInfos[i][0], jobInfos[i][1]));
        }

        // sorting of arrayList of objects
        Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit);// descending order...
        // Collections.sort(jobs ,(obj1 ,obj2) -> obj1.profit - obj2.profit); //
        // ascending order...

        ArrayList<Integer> seq = new ArrayList<>();
        int time = 0;
        for (int i = 0; i < jobs.size(); i++) {
            Job cur = jobs.get(i);
            if (cur.deadLine > time) {
                seq.add(cur.id);
                time++;
            }
        }

        System.out.println("max works is : " + seq.size() + " and the jobs are as order is " + seq);
        for (int i = 0; i < seq.size(); i++) {
            System.out.println("{" + jobInfos[seq.get(i)][0] + "," + jobInfos[seq.get(i)][1] + "}");
        }
    }

    public static void chocola() {
        int n = 4, m = 6;
        Integer costVer[] = { 2, 1, 3, 1, 4 };
        Integer costHor[] = { 4, 1, 2 };

        Arrays.sort(costHor, Collections.reverseOrder());
        Arrays.sort(costVer, Collections.reverseOrder());
        int h = 0, v = 0; // HORIZONTAL AND VERTICAL CUT
        int hp = 1, vp = 1; // HORIZONTAL AND VERTICAL PIECES
        int cost = 0;
        while (h < costHor.length && v < costVer.length) {
            if (costHor[h] >= costVer[v]) {
                // vertical cost is less
                cost += costHor[h] * vp;
                hp++;
                h++;
            } else {
                cost += costVer[v] * hp;
                vp++;
                v++;
            }
        }
        while (h < costHor.length) {
            cost += costHor[h] * vp;
            hp++;
            h++;
        }
        while (v < costVer.length) {
            cost += costVer[v] * hp;
            vp++;
            v++;
        }
        System.out.println("Total cost is: " + cost);
        System.out.println("Horizontal pieces: " + hp + " " + "Vertical pieces: " + vp);
    }

    public static void main(String[] args) {
        // activitySelection();
        // activitySelection2();
        // fractionalKnapsack();
        // minAbsDiff();
        // maxLenChainOfPairs();
        // indianCoin();
        // jobSequencing();
        // chocola();

    }
}
