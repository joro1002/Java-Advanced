import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2X2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split(", ");

        int rows = Integer.parseInt(tokens[0]);
        int cols = Integer.parseInt(tokens[1]);

        int[][] matrix = new int[rows][cols];
        readMatrix(matrix, scanner);

        int maxSum = 0;
        int up = 0;
        int upRight = 0;
        int down = 0;
        int downRight = 0;

        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int sum = matrix[row][col] +
                        matrix[row][col + 1] +
                        matrix[row + 1][col] +
                        matrix[row + 1][col + 1];
                if (sum > maxSum) {
                    maxSum = sum;
                    up = matrix[row][col];
                    upRight = matrix[row][col + 1];
                    down = matrix[row + 1][col];
                    downRight = matrix[row + 1][col + 1];
                }
            }
        }
        System.out.println(up + " " + upRight);
        System.out.println(down + " " + downRight);
        System.out.println(maxSum);

    }

    public static int[][] readMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return matrix;
    }
}
