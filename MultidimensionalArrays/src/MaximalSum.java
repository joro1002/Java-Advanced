import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(tokens[0]);
        int cols = Integer.parseInt(tokens[1]);

        int[][] matrix = new int[rows][cols];
        readMatrix(matrix, scanner);
        int maxSum = maximalSum(matrix);


        System.out.println("Sum = " + maxSum);
        printMatrix(maxMatrix(matrix));

    }

    public static int[][] readMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return matrix;
    }

    public static int maximalSum(int[][] matrix) {
        int maxSum = Integer.MIN_VALUE;
        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                int sum = matrix[row][col] +
                        matrix[row][col + 1] +
                        matrix[row][col + 2] +
                        matrix[row + 1][col] +
                        matrix[row + 1][col + 1] +
                        matrix[row + 1][col + 2] +
                        matrix[row + 2][col] +
                        matrix[row + 2][col + 1] +
                        matrix[row + 2][col + 2];
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }

    public static int[][] maxMatrix(int[][]matrix){
        int[][] maxMatrix = new int[3][3];

        int maxSum = Integer.MIN_VALUE;
        int first = 0;
        int second = 0;
        int third = 0;
        int forth = 0;
        int fifth = 0;
        int sixth = 0;
        int seventh = 0;
        int eighth = 0;
        int ninth = 0;
        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                int sum = matrix[row][col] +
                        matrix[row][col + 1] +
                        matrix[row][col + 2] +
                        matrix[row + 1][col] +
                        matrix[row + 1][col + 1] +
                        matrix[row + 1][col + 2] +
                        matrix[row + 2][col] +
                        matrix[row + 2][col + 1] +
                        matrix[row + 2][col + 2];
                if (sum > maxSum) {
                    maxSum = sum;
                    first = matrix[row][col];
                    second = matrix[row][col + 1];
                    third = matrix[row][col + 2];
                    forth = matrix[row + 1][col];
                    fifth = matrix[row + 1][col + 1];
                    sixth = matrix[row + 1][col + 2];
                    seventh = matrix[row + 2][col];
                    eighth = matrix[row + 2][col + 1];
                    ninth = matrix[row + 2][col + 2];
                }
            }
        }

        maxMatrix[0][0] = first;
        maxMatrix[0][1] = second;
        maxMatrix[0][2] = third;
        maxMatrix[1][0] = forth;
        maxMatrix[1][1] = fifth;
        maxMatrix[1][2] = sixth;
        maxMatrix[2][0] = seventh;
        maxMatrix[2][1] = eighth;
        maxMatrix[2][2] = ninth;

        return maxMatrix;

    }

    public static int[][] printMatrix(int[][] matrix){
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
        return matrix;
    }
}

