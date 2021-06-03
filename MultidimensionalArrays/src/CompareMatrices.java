import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(tokens[0]);
        int cols = Integer.parseInt(tokens[1]);

        int[][] firstMatrix = new int[rows][cols];

        readMatrix(scanner, firstMatrix);

        String[]secondTokens = scanner.nextLine().split("\\s+");
        int secondRows = Integer.parseInt(secondTokens[0]);
        int secondCols = Integer.parseInt(secondTokens[1]);

        int [][] secondMatrix = new int[secondRows][secondCols];

        readMatrix(scanner, secondMatrix);

        boolean equal = isEqual(firstMatrix, secondMatrix);
        if (equal){
            System.out.println("equal");
        }else {
            System.out.println("not equal");
        }
    }

    private static int[][] readMatrix(Scanner scanner, int[][] firstMatrix) {
        for (int row = 0; row < firstMatrix.length; row++) {
           firstMatrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                   .mapToInt(Integer::parseInt)
                   .toArray();
        }
        return firstMatrix;
    }

    private static int[][] printMatrix(int[][] firstMatrix) {
        for (int i = 0; i < firstMatrix.length; i++) {
            for (int j = 0; j < firstMatrix[i].length; j++) {
                System.out.print(firstMatrix[i][j] + " ");
            }
            System.out.println();
        }
        return firstMatrix;
    }

    private static boolean isEqual(int[][] firstMatrix, int[][] secondMatrix){
        if (firstMatrix.length != secondMatrix.length){
            return false;
        }
        for (int row = 0; row < firstMatrix.length; row++) {
            if (firstMatrix[row].length != secondMatrix[row].length){
                return false;
            }

            for (int col = 0; col < firstMatrix[row].length; col++) {
                if (firstMatrix[row][col] != secondMatrix[row][col]){
                    return false;
                }
            }
        }
        return true;
    }

}

