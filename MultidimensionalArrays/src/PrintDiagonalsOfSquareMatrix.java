import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][n];
        readMatrix(matrix, scanner);

        int row = 0;
        int col = 0;

        while (row < matrix.length){
            System.out.print(matrix[row][col] + " ");
            row++;
            col++;
        }
        System.out.println();
        row = matrix.length - 1;
        col = 0;

        while (col < matrix.length){
            System.out.print(matrix[row][col] + " ");
            row--;
            col++;
        }

    }

    public static int[][] readMatrix(int[][] matrix, Scanner scanner){
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return matrix;
    }
}
