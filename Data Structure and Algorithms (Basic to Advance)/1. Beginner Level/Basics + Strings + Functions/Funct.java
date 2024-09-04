
import java.util.*;

public class Funct {
    // public static int print(){
    // System.out.println("Hello");
    // System.out.println("Hello");
    // System.out.println("Hello");
    // return 4;
    // }

    public static void binomial(int n, int r) {
        int nr, dr;
        nr = 1;
        dr = 1;
        if (n >= r) {
            for (int i = n; i >= n - r + 1; i--) {
                nr *= i;
            }
            for (int i = r; i >= 1; i--) {
                dr *= i;
            }

            System.out.println("The value of binomial coefficient is: " + nr / dr);
        } else {
            System.out.println("Binomial can't be found");
        }
    }

    public static void main(String[] args) {
        // print();
        Scanner sc = new Scanner(System.in);
        int n, r;
        System.out.println("Enter the value of n");
        n = sc.nextInt();
        System.out.println("Enter the value of r");
        r = sc.nextInt();
        binomial(n, r);

    }
}
