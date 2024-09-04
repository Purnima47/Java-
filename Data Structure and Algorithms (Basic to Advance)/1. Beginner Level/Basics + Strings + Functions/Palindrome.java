import java.util.*;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, num, rev, rem, i;
        System.out.println("Enter no. to check palindrome");
        n = sc.nextInt();
        num = n;
        rev = 0;
        i = 0;
        while (n > 0) {
            rem = n % 10;
            rev = rev * 10 + rem;
            n /= 10;
            i++;
        }
        if (num == rev) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a palindrome");
        }
    }
}
