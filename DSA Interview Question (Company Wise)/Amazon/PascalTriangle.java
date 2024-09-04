// Given an integer n, print the first n rows of Pascal's triangle.
// In Pascal's triangle, each number is the sum of the two numbers directly
// above it as shown:
// if n=5
/*
 * 1
 * 1 1
 * 1 2 1
 * 1 3 3 1 
 * 1 4 6 4 1
 */

public class PascalTriangle {
    public static void main(String[] args) {
        int n = 5;
        int ans[][]=new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || i == j) {
                    ans[i][j]=1;
                } else {
                    ans[i][j]=ans[i-1][j-1]+ans[i-1][j];
                }
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }

    }
}
