public class _1Fibonacci {

    /* RECURSION --> */

    // Exponentenial (complexity)
    public static int fibonacciThroughRecursion(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fibonacciThroughRecursion(n - 1) + fibonacciThroughRecursion(n - 2);
    }

    public static void fibonacciThroughRecursionCall() {
        System.out.println(fibonacciThroughRecursion(2));
        System.out.println(fibonacciThroughRecursion(11));
        System.out.println(fibonacciThroughRecursion(16));
    }

    /* DP ---> */
    // Dynamic Programming is optimized recursion.
    /*
     * How to identify DP ->
     * 1. Optimized Problem
     * 2. some choice is given (multiple branches in recursion tree)
     */

    // DP is a technique in computer programming that helps to efficiently solve a
    // class of problems that have OVERLAPPING SUBPROBLEMS ans OPTIMAL SUBSTRUCTURE
    // property.

    // O(n)
    public static int fibonacciThroughMemo(int n, int dp[]) {
        if (n == 0 || n == 1) {
            return n;
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        return dp[n] = fibonacciThroughMemo(n - 1, dp) + fibonacciThroughMemo(n - 2, dp);
    }

    public static void fibonacciThroughMemoCall() {
        System.out.println(fibonacciThroughMemo(2, new int[2 + 1]));
        System.out.println(fibonacciThroughMemo(10, new int[10 + 1]));
        System.out.println(fibonacciThroughMemo(25, new int[25 + 1]));
        System.out.println(fibonacciThroughMemo(16, new int[16 + 1]));
    }

    // O(n)
    public static int fibonacciThroughTabulation(int n, int dp[]) {
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void fibonacciThroughTabulationCall() {
        System.out.println(fibonacciThroughTabulation(5, new int[5 + 1]));
        System.out.println(fibonacciThroughTabulation(10, new int[10 + 1]));
    }

    public static void main(String[] args) {
        // fibonacciThroughRecursionCall();
        // fibonacciThroughMemoCall();
        // fibonacciThroughTabulationCall();
    }

    /*
     * WAYS OF DP ------->
     * 1. Memoization (Top Down) --> recursion + storage
     * 
     * 
     * 2. Tabultion (Bottom Up) --> iteration , table/set/storage (more efficient)
     * 
     */
}
