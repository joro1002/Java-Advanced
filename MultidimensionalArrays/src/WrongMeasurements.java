import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][];
        readMatrix(matrix, scanner);

        int[][] newMatrix = new int[n][];

        for (int row = 0; row < newMatrix.length; row++) {
            int[] numbers = new int[matrix[row].length];
            newMatrix[row] = numbers;
        }

        String[] tokens = scanner.nextLine().split("\\s+");
        int wrongRow = Integer.parseInt(tokens[0]);
        int wrongCol = Integer.parseInt(tokens[1]);

        int wrongNumber = matrix[wrongRow][wrongCol];

        replacedMatrix(matrix, newMatrix, wrongNumber);
        printMatrix(newMatrix);
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

    public static int[][] replacedMatrix(int[][] matrix, int[][] newMatrix, int wrongNumber) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int sum = 0;
                if (matrix[row][col] == wrongNumber) {
                    if (col - 1 >= 0 && col - 1 < matrix[row].length
                            && matrix[row][col - 1] != wrongNumber) {
                        sum += matrix[row][col - 1];
                    }
                    if (col + 1 < matrix[row].length
                            && matrix[row][col + 1] != wrongNumber) {
                        sum += matrix[row][col + 1];
                    }
                    if (row + 1 < matrix.length && matrix[row + 1][col] != wrongNumber) {
                        sum += matrix[row + 1][col];
                    }

                    if (row - 1 >= 0 && matrix[row - 1][col] != wrongNumber) {
                        sum += matrix[row - 1][col];
                    }
                    newMatrix[row][col] = sum;
                }else {
                    newMatrix[row][col] = matrix[row][col];
                }
            }
        }

        return newMatrix;
    }

    public static int[][] readMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return matrix;
    }
}
