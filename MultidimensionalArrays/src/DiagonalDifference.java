import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][n];
        readMatrix(matrix, scanner);
        int sumPrimaryDiagonal = primaryDiagonalSum(matrix);
        int sumSecondaryDiagonal = secondaryDiagonalSum(matrix);
        int difference = Math.abs(sumPrimaryDiagonal - sumSecondaryDiagonal);
        System.out.println(difference);

    }

    public static int[][] readMatrix(int[][] matrix, Scanner sc){
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(sc.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return matrix;
    }

    public static int primaryDiagonalSum(int[][] matrix){
        int row = 0;
        int col = 0;
        int sum = 0;

        while (row < matrix.length && col < matrix[row].length){
            sum += matrix[row][col];
            row++;
            col++;
        }
        return sum;
    }

    public static int secondaryDiagonalSum(int[][] matrix){
        int row = 0;
        int col = matrix.length - 1;
        int sum = 0;

        while (row <matrix.length && col >= 0){
            sum += matrix[row][col];
            row++;
            col--;
        }
        return sum;
    }
}
