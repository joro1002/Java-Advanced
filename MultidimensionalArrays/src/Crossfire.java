import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");
        int rowsMatrix = Integer.parseInt(tokens[0]);
        int colsMatrix = Integer.parseInt(tokens[1]);

        List<List<Integer>> matrix = new ArrayList<>();
        fillMatrix(matrix, rowsMatrix, colsMatrix);

        String command = scanner.nextLine();
        while (!command.equals("Nuke it from orbit")) {
            String[] input = command.split("\\s+");
            int row = Integer.parseInt(input[0]);
            int col = Integer.parseInt(input[1]);
            int radius = Integer.parseInt(input[2]);

            for (int i = row - radius; i <= row + radius; i++) {
                if (validMatrix(i, col, matrix) && i != row) {
                    matrix.get(i).remove(col);
                }
            }

            for (int i = col + radius; i >= col - radius; i--) {
                if (validMatrix(row, i, matrix)) {
                    matrix.get(row).remove(i);
                }
            }
            matrix.removeIf(List::isEmpty);

            command = scanner.nextLine();
        }
        printMatrix(matrix);
    }

    private static boolean validMatrix(int rows, int cols, List<List<Integer>> matrix) {
        return rows >= 0 && rows < matrix.size() && cols >= 0 && cols < matrix.get(rows).size();
    }

    public static List<List<Integer>> fillMatrix(List<List<Integer>> matrix, int rows, int cols) {
        int number = 1;
        for (int row = 0; row < rows; row++) {
            matrix.add(new ArrayList<>());
            for (int col = 0; col < cols; col++) {
                matrix.get(row).add(number);
                number++;
            }

        }
        return matrix;
    }

    public static List<List<Integer>> printMatrix(List<List<Integer>> matrix) {
        for (List<Integer> row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
        return matrix;
    }
}
