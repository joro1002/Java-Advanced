import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(tokens[0]);
        int cols = Integer.parseInt(tokens[1]);

        String[][] matrix = new String[rows][cols];
        fillMatrix(matrix);
        printMatrix(matrix);

    }

    public static String[][] fillMatrix(String[][] matrix) {
        char startLetter = 'a';
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                String palindrome = "" + startLetter + (char) (startLetter + col) + startLetter;
                matrix[row][col] = palindrome;
            }
            startLetter += 1;
        }
        return matrix;
    }

    public static String[][] printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
        return matrix;
    }
}
