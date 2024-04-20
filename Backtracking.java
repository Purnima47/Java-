public class Backtracking {
    public static void ChangeArray(int arr[], int i, int val) {
        if (i == arr.length) {
            print(arr);
            return;
        }
        arr[i] = val;
        ChangeArray(arr, i + 1, val + 1);
        arr[i] = arr[i] - 2;
    }

    public static void print(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void Subsets(String str, String ans, int i) {
        // BASE CASE
        if (i == str.length()) {
            if (ans.length() == 0) {
                System.out.println("null");
            } else
                System.out.println(ans);
            return;
        }

        // if it is a yes:(call original string for i+1 th index since it has already
        // asked the ith index for its choice)
        Subsets(str, ans + str.charAt(i), i + 1);
        // if it is a no:
        Subsets(str, ans, i + 1);
        // TC:O(n*2^n)
        // SC:O(n)
    }

    public static void Permutation(String str, String ans) {
        // base case
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        // backtrack
        for (int i = 0; i < str.length(); i++) {
            // it will extract each character one by one
            char ch = str.charAt(i);
            // Now we have to remove that character from string
            String strn = str.substring(0, i) + str.substring(i + 1);
            // And we will add it to the ans and we will pass new string formed
            Permutation(strn, ans + ch);
        }
    }

    // CHESSBOARD FOR N QUEENS:
    // TC:O(n!)...
    public static void printBoard(char chessBoard[][]) {
        System.out.println("---chessboard---");
        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard.length; j++) {
                System.out.print(chessBoard[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean isSafe(char chessBoard[][], int row, int col) {
        // vertical up..
        for (int i = row - 1; i >= 0; i--) {
            if (chessBoard[i][col] == 'Q') {
                return false;
            }
        }

        // diagonal left
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessBoard[i][j] == 'Q') {
                return false;
            }
        }

        // diagonal right
        for (int i = row - 1, j = col + 1; i >= 0 && j < chessBoard.length; i--, j++) {
            if (chessBoard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void NQueens(char chessBoard[][], int row) {
        if (row == chessBoard.length) {
            printBoard(chessBoard);
            count++;
            return;
        }
        for (int j = 0; j < chessBoard.length; j++) {
            if (isSafe(chessBoard, row, j)) {
                chessBoard[row][j] = 'Q';
                NQueens(chessBoard, row + 1);
                chessBoard[row][j] = 'x';
            }

        }

    }

    // TC: O(2^(n*m))
    // Exponential time complexity
    public static int GridWaysToReachTarget(int i, int j, int n, int m) {
        if (i == n - 1 && j == m - 1) {
            return 1;
        } else if (i == n || j == m) {
            return 0;
        }
        int w1 = GridWaysToReachTarget(i + 1, j, n, m);
        int w2 = GridWaysToReachTarget(i, j + 1, n, m);
        return w1 + w2;
    }

    // TC:O(n+m)
    // Permutation for characters(RD...) i.e R = Right, D = Down
    public static void GridWaysToReachTarget2() {

    }

    public static boolean isSafeSudoku(int sudoku[][], int row, int col, int digit) {

        // to check whether the other same digit occurs in that column or not
        for (int i = 0; i <= 8; i++) {
            if (sudoku[i][col] == digit) {
                return false;
            }
        }

        // to check whether the other same digit occurs in that row or not
        for (int j = 0; j <= 8; j++) {
            if (sudoku[row][j] == digit) {
                return false;
            }
        }

        // grid
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (sudoku[i][j] == digit) {
                    return false;
                }
            }
        }
        return true;

    }

    public static boolean sudokuSolver(int sudoku[][], int row, int col) {
        if (row == 9) {
            return true;
        }

        int nextRow = row, nextCol = col + 1;
        if (col + 1 == 9) {
            nextRow = row + 1;
            nextCol = 0;
        }

        if (sudoku[row][col] != 0) {
            return sudokuSolver(sudoku, nextRow, nextCol);
        }

        for (int digit = 1; digit <= 9; digit++) {
            if (isSafeSudoku(sudoku, row, col, digit)) {
                sudoku[row][col] = digit;
                if (sudokuSolver(sudoku, nextRow, nextCol)) {
                    return true;
                }
                sudoku[row][col] = 0;
            }
        }
        return false;
    }

    public static void printSudoku(int sudoku[][]) {
        for (int i = 0; i <= 8; i++) {
            for (int j = 0; j <= 8; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static int count = 0;

    public static void main(String[] args) {

        int arr[] = new int[5];
        ChangeArray(arr, 0, 1);
        print(arr);

        Subsets("abc", "", 0);

        Permutation("abc", "");

        int n = 4;
        char chessBoard[][] = new char[n][n];
        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard.length; j++) {
                chessBoard[i][j] = 'x';
            }
        }
        NQueens(chessBoard, 0);
        System.out.println("Toatal no. of ways = " + count);

        int row = 3, col = 4;
        System.out.println("No. of ways to reach the target in a grid is: " + GridWaysToReachTarget(0, 0, row, col));

        int sudoku[][] = { { 0, 0, 8, 0, 0, 0, 0, 0, 0 }, { 4, 9, 0, 1, 5, 7, 0, 0, 2 }, { 0, 0, 3, 0, 0, 4, 1, 9, 0 },
                { 1, 8, 5, 0, 6, 0, 0, 2, 0 }, { 0, 0, 0, 0, 2, 0, 0, 6, 0 }, { 9, 6, 0, 4, 0, 5, 3, 0, 0 },
                { 0, 3, 0, 0, 7, 2, 0, 0, 4 }, { 0, 4, 9, 0, 3, 0, 0, 5, 7 }, { 8, 2, 7, 0, 0, 9, 0, 1, 3 } };

        if (sudokuSolver(sudoku, 0, 0)) {
            System.out.println("Solution exists");
            printSudoku(sudoku);
        }

    }
}
