import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        String [][] firstMatrix = new String[rows][cols];
        String[][] secondMatrix = new String[rows][cols];

        readMatrix(firstMatrix, scanner);
        readMatrix(secondMatrix, scanner);

        String[][] resultMatrix = new String[rows][cols];

        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < firstMatrix[row].length; col++) {
                if (firstMatrix[row][col].equals(secondMatrix[row][col])){
                    resultMatrix[row][col] = firstMatrix[row][col];
                }else {
                    resultMatrix[row][col] = "*";
                }
            }
        }

        printMatrix(resultMatrix);
    }

    public static String[][] readMatrix(String[][] matrix, Scanner scanner) {

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
        return matrix;
    }

    public static String[][] printMatrix(String[][] matrix){
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
        return matrix;
    }
}
