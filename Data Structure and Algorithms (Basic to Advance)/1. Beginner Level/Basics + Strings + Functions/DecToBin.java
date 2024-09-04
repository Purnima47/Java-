import java.util.Scanner;

public class DecToBin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, r, sum, i;
        System.out.println("Enter your decimal no.");
        n = sc.nextInt();
        sum = 0;
        i = 0;
        while (n > 0) {
            r = n % 2;
            sum += r * (Math.pow(10, i));
            i++;
            n /= 2;
        }
        System.out.println("Your binary value is : " + sum);
    }
}
