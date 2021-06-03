import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(tokens[0]);
        int cols = Integer.parseInt(tokens[1]);

        String[][] matrix = new String[rows][cols];
        readMatrix(matrix, scanner);

        String command = scanner.nextLine();
        while (!command.equals("END")) {
            String[] data = command.split("\\s+");
            String swap = data[0];

            if (swap.equals("swap")&& data.length == 5) {
                int firstRow = Integer.parseInt(data[1]);
                int firstCol = Integer.parseInt(data[2]);
                int secondRow = Integer.parseInt(data[3]);
                int secondCol = Integer.parseInt(data[4]);
                if (firstRow >= 0 && firstRow < matrix.length &&
                        firstCol >= 0 && firstCol <= cols &&
                        secondRow >= 0 && secondRow < matrix.length &&
                        secondCol >= 0 && secondCol < cols) {
                    String temp = matrix[firstRow][firstCol];
                    matrix[firstRow][firstCol] = matrix[secondRow][secondCol];
                    matrix[secondRow][secondCol] = temp;

                    for (int row = 0; row < matrix.length; row++) {
                        for (int col = 0; col < matrix[row].length; col++) {
                            System.out.print(matrix[row][col] + " ");
                        }
                        System.out.println();
                    }
                }else {
                    System.out.println("Invalid input!");
                }
            } else {
                System.out.println("Invalid input!");
            }

            command = scanner.nextLine();
        }

    }

    public static String[][] readMatrix(String[][] matrix, Scanner sc) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = sc.nextLine().split("\\s+");
        }
        return matrix;
    }
}
