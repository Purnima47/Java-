import java.io.*;

public class StringsInJava {
    public static boolean isPalindrome(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            int n = str.length();
            if (str.charAt(i) != str.charAt(n - 1 - i)) {
                System.out.println("Not a palindrome string");
                return false;
            }
        }
        System.out.println("Given string is a palindrome string");
        return true;
    }

    public static void getShortestPath(String path) {
        int x = 0, y = 0;

        for (int i = 0; i < path.length(); i++) {
            char dir = path.charAt(i);
            if (dir == 'N')
                y++;

            else if (dir == 'S')
                y--;

            else if (dir == 'E')
                x++;

            else {
                x--;
            }

        }
        System.out.println("shortest path is " + Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)));
    }

    public static void Substring(String str) {
        System.out.println(str.substring(0, 5));
    }

    public static void SubstringO(String str, int si, int ei) {
        String sub = "";
        for (int i = si; i < ei; i++) {

            sub += str.charAt(i);
        }
        System.out.println(sub);
    }

    public static void Compare(String fruits[]) {
        String largest = fruits[0];
        for (int i = 1; i < fruits.length; i++) {
            if (largest.compareTo(fruits[i]) < 0) {
                largest = fruits[i];
            }
        }
        System.out.println(largest);
    }

    public static void Stringbuilder() {
        StringBuilder sb = new StringBuilder("");
        for (char ch = 'a'; ch <= 'z'; ch++) {
            sb.append(ch);
        }
        System.out.println(sb);
    }

    public static void UpperCase(String name) {
        StringBuilder sb = new StringBuilder("");

        char ch = Character.toUpperCase(name.charAt(0));
        sb.append(ch);

        for (int i = 1; i < name.length(); i++) {
            if ((name.charAt(i) == ' ') && (i < name.length() - 1)) {
                sb.append(name.charAt(i));
                i++;
                sb.append(Character.toUpperCase(name.charAt(i)));
            } else {
                sb.append(name.charAt(i));
            }
        }
        System.out.println(sb.toString());
    }

    public static void Compression(String comp) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < comp.length(); i++) {
            Integer count = 1;
            while ((i < comp.length() - 1) && (comp.charAt(i) == comp.charAt(i + 1))) {
                count++;
                i++;
            }
            sb.append(comp.charAt(i));
            if (count > 1) {
                sb.append(count.toString());
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "racecar";
        String path = "WNEENESENNN";
        String fruits[] = { "apple", "mango", "banana" };
        String name = "hi, i am purnima";
        String comp = "aaaabbbccd";
        System.out.println(isPalindrome(str));
        getShortestPath(path);
        Substring(str);
        SubstringO(str, 0, 4);
        Compare(fruits);
        Stringbuilder();
        UpperCase(name);
        Compression(comp);
    }
}
