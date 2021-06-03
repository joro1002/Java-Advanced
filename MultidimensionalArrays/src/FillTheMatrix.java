import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split(", ");
        int n = Integer.parseInt(tokens[0]);
        String type = tokens[1];
        int[][] matrix = new int[n][n];

        if (type.equals("A")) {
            readPatternA(matrix, n);
            printMatrix(matrix);
        }else {
            readPatternB(matrix, n);
            printMatrix(matrix);
        }

    }

    public static void readPatternA(int[][] matrix, int n) {
        int number = 1;

        for (int col = 0; col < n; col++) {
            for (int row = 0; row < n; row++) {
                matrix[row][col] = number++;
            }
        }
    }

    public static void readPatternB(int[][] matrix, int n) {
        int number = 1;

        for (int col = 0; col < n; col++) {
            if (col % 2 == 0){
                for (int row = 0; row < n; row++) {
                    matrix[row][col] = number++;
                }
            }else {
                for (int row = n - 1; row >= 0 ; row--) {
                    matrix[row][col] = number++;
                }
            }
        }
    }

    public static int[][] printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
        return matrix;
    }
}
