import java.io.*;

public class Conditional {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the value of a");
        int a = Integer.parseInt(br.readLine());
        System.out.println("the value of a is: " + a);
    }
}
