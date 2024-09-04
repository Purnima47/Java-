import java.util.Scanner;

public class BinToDeci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your no. in binary");
        int n, last, power, sum;
        sum = 0;
        power = 0;
        power = 0;
        n = sc.nextInt();
        while (n > 0) {
            last = n % 10;
            sum += last * (int) Math.pow(2, power);
            power++;
            n = n / 10;
        }
        System.out.println("The decimal value is :" + sum);
    }
}
