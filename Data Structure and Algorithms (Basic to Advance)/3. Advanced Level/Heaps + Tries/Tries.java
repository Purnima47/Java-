public class Tries {
    static class Node {
        Node child[] = new Node[26];
        boolean eow = false;

        Node() {
            for (int i = 0; i < child.length; i++) {
                child[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {
        Node cur = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (cur.child[idx] == null) {
                cur.child[idx] = new Node();
            }
            cur = cur.child[idx];
        }

        cur.eow = true;
    }

    public static boolean search(String key) {
        Node cur = root;
        for (int level = 0; level < key.length(); level++) {
            int idx = key.charAt(level) - 'a';
            if (cur.child[idx] == null) {
                cur.child[idx] = new Node();
            }
            cur = cur.child[idx];
        }

        return cur.eow == true;
    }

    public static boolean wordBreak(String key) {
        // Given an input string and a dictionary of words, find out if the input string
        // can be broken into a space-separated sequence of dictionary words.
        if (key.length() == 0) {
            return true;
        }
        for (int i = 1; i <= key.length(); i++) {
            if (search(key.substring(0, i)) && wordBreak(key.substring(i))) {
                return true;
            }
        }
        return false;
    }

    // ---------------------------------------------------------------------------------------

    static class PreNode {
        PreNode child[] = new PreNode[26];
        boolean eow;
        int freq;

        public PreNode() {
            for (int i = 0; i < child.length; i++) {
                child[i] = null;
            }
            eow = false;
            freq = 1;
        }
    }

    public static PreNode PreRoot = new PreNode();

    public static void insertPre(String word) {
        PreNode cur = PreRoot;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (cur.child[idx] == null) {
                cur.child[idx] = new PreNode();
            } else {
                cur.child[idx].freq++;
            }
            cur = cur.child[idx];
        }
        cur.eow = true;
    }

    public static void findPre(PreNode root2, String ans) { // O(L) L:Longest Word
        if (root2 == null) {
            return;
        }

        if (root2.freq == 1) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < root2.child.length; i++) {
            if (root2.child[i] != null) {
                findPre(root2.child[i], ans + (char) (i + 'a'));
            }
        }
    }

    public static boolean startWith(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if (cur.child[idx] == null) {
                return false;
            }
            cur = cur.child[idx];
        }
        return true;
    }

    public static void countUniqueSub() {
        String str = "ababa";
        for (int i = 0; i < str.length(); i++) {
            String suffix = str.substring(i);
            insert(suffix);
        }
        System.out.println(countNode(root));
    }

    public static int countNode(Node root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (root.child[i] != null) {
                count += countNode(root.child[i]);
            }
        }
        return count + 1;
    }

    public static String ans = "";

    public static void longestWord(Node root, StringBuilder temp) {
        if (root == null) {
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (root.child[i] != null && root.child[i].eow == true) {
                char ch = (char) (i + 'a');
                temp.append(ch);
                // if (temp.length() > ans.length() ) { //if we want
                // lexicographically(alphabetically) smaller
                if (temp.length() > ans.length() || temp.toString().compareTo(ans) > 0) {
                    // if we want lexicographically(alphabetically) larger
                    // or we can reverse the loop
                    ans = temp.toString();
                }
                longestWord(root.child[i], temp);
                // backtrack
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }

    public static void longestWordWithAllPrefixes() { // lexicographically
        String words[] = { "a", "banana", "app", "appl", "ap", "apply", "apple" };

        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        longestWord(root, new StringBuilder(""));
        System.out.println(ans);
    }

    public static void main(String[] args) {
        // String words[] = { "the", "a", "there", "their", "any", "thee" };
        // for (int i = 0; i < words.length; i++) {
        // insert(words[i]);
        // }

        // System.out.println(search("there"));
        // System.out.println(search("thor"));

        // String arr[] = { "i", "like", "sam", "samsung", "mobile", "ice" };
        // for (int i = 0; i < arr.length; i++) {
        // insert(arr[i]);
        // }

        // String key = "ilikesamsung";
        // System.out.println(wordBreak(key));

        // String prefix[] = { "zebra", "dog", "duck", "dove" };
        // for (int i = 0; i < prefix.length; i++) {
        // insertPre(prefix[i]);
        // }

        // PreRoot.freq = -1;
        // findPre(PreRoot, "");

        // String words[] = { "apple", "app", "mango", "man", "woman" };
        // String prefix1 = "app";
        // String prefix2 = "moon";
        // for (int i = 0; i < words.length; i++) {
        // insert(words[i]);
        // }

        // System.out.println(startWith(prefix1));
        // System.out.println(startWith(prefix2));

        // countUniqueSub();
        longestWordWithAllPrefixes();

    }
}
