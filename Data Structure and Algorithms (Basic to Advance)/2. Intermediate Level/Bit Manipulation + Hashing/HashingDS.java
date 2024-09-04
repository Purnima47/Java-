import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.TreeMap;
import java.util.*;

public class HashingDS {
    public static void hashMapOpr() {
        HashMap<String, Integer> hm = new HashMap<>();

        // Insertion - O(1)
        hm.put("India", 150);
        hm.put("China", 160);
        hm.put("US", 70);

        // Print(doesn't have any specific order)
        // // it will print in "{}" brackets
        System.out.println("Hashmap has following key value pair: " + hm);

        // Get-O(1)
        // (if it has same key as in hashmap then it will give its value otherwise will
        // return null)
        System.out.println("Value of key is: " + hm.get("Nepal"));

        // ContainsKey-O(1)
        // returns true or false it it has that key then it would return true otherwise
        // it would return false
        System.out.println("Contains key: " + hm.containsKey("Bhutan"));

        // remove -O(1)
        System.out.println(hm.remove("China", 160));

        // size -O(1)
        // it calculates the size of hashmap
        System.out.println("size: " + hm.size());

        // isEmpty - it checks if the hashmap is empty or not
        System.out.println("Hashmap is empty: " + hm.isEmpty());

        // clear
        hm.clear();
        System.out.println(hm);
    }

    public static void iterationOnMaps() {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 150);
        hm.put("China", 160);
        hm.put("US", 70);
        hm.put("Indonesia", 60);
        hm.put("Nepal", 50);

        Set<String> keys = hm.keySet(); // it returns a set of keys in map
        System.out.println(keys); // it will print in [] brackets

        System.out.println(hm.entrySet());

        for (String k : keys) {
            System.out.println("Key is: " + k + ", value is: " + hm.get(k));
        }
    }

    public static void linkedHashMapDSA() {
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>(); // doubly ll is used in LHM
        lhm.put("India", 150);
        lhm.put("China", 160);
        lhm.put("US", 70);
        lhm.put("Indonesia", 60);

        System.out.println(lhm);
    }

    public static void treeMapsInDS() {
        // keys are sorted in this type of map
        // so put, get, remove time complexity becomes O(log n)
        // red black tree implementation is used in TM (self balancing trees)
        TreeMap<String, Integer> tm = new TreeMap<>();
        tm.put("India", 150);
        tm.put("China", 160);
        tm.put("US", 70);
        tm.put("Indonesia", 60);

        System.out.println(tm);
    }

    public static void majorityElement() {
        int arr[] = { 1, 3, 2, 5, 1, 3, 1, 5, 1 };
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {

            /* METHOD - 1 */
            // if (freq.containsKey(arr[i])) {
            // freq.put(arr[i], freq.get(arr[i]) + 1);
            // } else {
            // freq.put(arr[i], 1);
            // }

            /* METHOD - 2 */
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
        }

        // Set<Integer> keySet = freq.keySet();
        // for (Integer key : keySet) {
        // if (freq.get(key) > arr.length / 3) {
        // System.out.println(key);
        // }
        // }

        for (Integer key : freq.keySet()) {
            if (freq.get(key) > arr.length / 3) {
                System.out.println(key);
            }
        }
    }

    public static boolean validAnagram(String s, String t) {
        HashMap<Character, Integer> freq = new HashMap<>();

        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (freq.get(ch) != null) {
                if (freq.get(ch) == 1) {
                    freq.remove(ch);
                } else {
                    freq.put(ch, freq.get(ch) - 1);
                }
            } else {
                return false;
            }
        }
        return freq.isEmpty();
    }

    public static void set() {
        HashSet<Integer> s = new HashSet<>();

        s.add(1);
        s.add(2);
        s.add(3);
        s.add(1);
        System.out.println(s);

        if (s.contains(2)) {
            System.out.println("It contains 2");
        }

        if (s.contains(5)) {
            System.out.println("It does't contain");
        }

        // System.out.println(s.remove(1)); //returns true if it has val
        s.remove(1);
        System.out.println(s);
        s.clear();
        System.out.println(s);
        System.out.println(s.size());
        System.out.println(s.isEmpty());
    }

    public static void iterationOnSet() {
        HashSet<Integer> s = new HashSet<>();
        s.add(6);
        s.add(1);
        s.add(12);
        s.add(7);
        s.add(9);
        s.add(0);
        s.add(13);

        Iterator it = s.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        HashSet<String> cities = new HashSet<>();
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Greater Noida");
        cities.add("Mirzapur");

        // Iterator city = cities.iterator();
        // while (city.hasNext()) {
        // System.out.print(city.next() + " ");
        // }
        // System.out.println();

        for (String city : cities) {
            System.out.print(city + " ");
        }
        System.out.println();

    }

    public static void linkedHashSet() {
        LinkedHashSet<String> cities = new LinkedHashSet<>();
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Greater Noida");
        cities.add("Mirzapur");
        System.out.println(cities);

        cities.remove("Mumbai");
        System.out.println(cities);
    }

    public static void treeSet() {
        // sorted in ascending order
        // null values are not allowed
        // Work on red black
        // O(log n)
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(5);
        ts.add(2);
        ts.add(51);
        ts.add(1);
        ts.add(47);

        System.out.println(ts);
    }

    public static void countDistEle() {
        int num[] = { 4, 3, 2, 5, 6, 7, 3, 4, 2, 1 };
        HashSet<Integer> s = new HashSet<>();
        for (int i = 0; i < num.length; i++) {
            s.add(num[i]);
        }

        System.out.println(s.size());
    }

    public static void unionNInter() {
        int arr1[] = { 7, 3, 9 };
        int arr2[] = { 6, 3, 9, 2, 9, 4 };
        HashSet<Integer> union = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            union.add(i);
        }
        for (int i = 0; i < arr2.length; i++) {
            union.add(i);
        }
        System.out.println("Union of arrays is: " + union + " size is: " + union.size());

        HashSet<Integer> inter = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            inter.add(arr1[i]);
        }
        HashSet<Integer> intersection = new HashSet<>();
        int count = 0;
        for (int i = 0; i < arr2.length; i++) {
            if (inter.contains(arr2[i])) {
                count++;
                intersection.add(arr2[i]);
                inter.remove(arr2[i]);
            }
        }
        System.out.println(intersection);
        System.out.println(count);
    }

    public static void itineraryForTick() {
        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("Chennai", "Bengaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        HashMap<String, String> revMap = new HashMap<>();
        for (String key : tickets.keySet()) {
            revMap.put(tickets.get(key), key);
        }
        String sp = "";
        for (String key : tickets.keySet()) {
            if (!revMap.containsKey(key)) {
                sp = key; // Starting point
            } else {
                sp = "null";
            }
        }

        System.out.print(sp);
        for (String key : tickets.keySet()) {
            System.out.print("->" + tickets.get(sp));
            sp = tickets.get(sp);
        }

    }

    public static void largestSumSubArr() {
        int arr[] = { 15, -2, 2, -8, 1, 7, 10, 23 };

        HashMap<Integer, Integer> hm = new HashMap<>();
        int sum = 0, len = 0;
        LinkedHashSet<Integer> sumZero = new LinkedHashSet<>();
        for (int j = 0; j < arr.length; j++) {
            sum += arr[j];
            if (hm.containsKey(sum)) {

                len = Math.max(len, j - hm.get(sum));
                for (int i = hm.get(sum) + 1; i <= j; i++) {
                    sumZero.add(arr[i]);
                }

            } else {
                hm.put(sum, j);
            }
        }

        System.out.println(sumZero);

        System.out.println(len);
    }

    public static void subArrSumETk() {
        int arr[] = { 10, 2, -2, -20, 10 };
        int k = -10;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0;
        int ans = 0;

        for (int j = 0; j < arr.length; j++) { // O(n)
            sum += arr[j];
            if (map.containsKey(sum - k)) {
                ans += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        // hashMapOpr();
        // iterationOnMaps();
        // linkedHashMapDSA();
        // treeMapsInDS();
        // majorityElement();
        // System.out.println(validAnagram("race", "carE"));
        // set();
        // iterationOnSet();
        // linkedHashSet();
        // treeSet();
        // countDistEle();
        // unionNInter();
        // itineraryForTick();
        // largestSumSubArr();
        subArrSumETk();
    }
}
