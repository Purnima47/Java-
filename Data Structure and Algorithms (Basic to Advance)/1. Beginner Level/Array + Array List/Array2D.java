import java.io.*;

public class Array2D {

    public static void Spiral(int matrix[][]) {
        int sR = 0, sC = 0, eR = matrix.length - 1, eC = matrix[0].length - 1;
        while (sR <= eR && sC <= eC) {
            // top
            for (int j = sC; j <= eC; j++) {
                System.out.print(matrix[sR][j] + " ");
            }
            // right
            for (int i = sR + 1; i < eR; i++) {
                System.out.print(matrix[i][eC] + " ");
            }
            // bottom
            for (int j = eC - 1; j >= sC; j--) {
                if (sR == eR) {
                    break;
                }
                System.out.print(matrix[eR][j] + " ");
            }
            // left
            for (int i = eR - 1; i >= sR + 1; i--) {
                if (sC == eC) {
                    break;
                }
                System.out.print(matrix[i][sC] + " ");
            }
        }

    }

    public static int DiagonalSum(int matrix[][]) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];

            if (i != matrix.length - 1 - i) {
                sum += matrix[i][matrix.length - i - 1];
            }
        }
        return sum;
    }

    public static boolean Search(int matrix[][], int key) {
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == key) {
                System.out.println("Found key at (" + row + "," + col + ")");
                return true;
            } else if (key < matrix[row][col]) {
                col--;
            } else {
                row++;
            }
        }
        System.out.println("Key not found");
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int matrix[][] = new int[3][3];
        int key = 2;
        int m = matrix.length, n = matrix[0].length;
        System.out.println("Enter your elements");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(br.readLine());
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Sum of principal and secondary diagonal is:" + DiagonalSum(matrix));
        System.out.println(Search(matrix, key));
    }
}
