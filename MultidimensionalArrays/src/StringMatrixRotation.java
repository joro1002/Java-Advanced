import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rotate = scanner.nextLine().split("[()]+");
        int angleRotate = Integer.parseInt(rotate[1]) % 360;

        String command = scanner.nextLine();

        List<String> words = new ArrayList<>();

        int maxLength = 0;
        while (!command.equals("END")) {
            words.add(command);
            if (command.length() > maxLength) {
                maxLength = command.length();
            }

            command = scanner.nextLine();
        }

        int rows = words.size();
        int cols = maxLength;

        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (col < words.get(row).length()) {
                    matrix[row][col] = words.get(row).charAt(col);
                } else {
                    matrix[row][col] = ' ';
                }
            }
        }

        if (angleRotate == 90) {
            for (int col = 0; col < cols; col++) {
                for (int row = matrix.length - 1; row >= 0 ; row--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        }else if (angleRotate == 180){
            for (int row = matrix.length - 1; row >= 0 ; row--) {
                for (int col = matrix[row].length - 1; col >= 0; col--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        }else if (angleRotate == 270){
            for (int col = cols - 1; col >= 0 ; col--) {
                for (int row =0; row < matrix.length ; row++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        }else {
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[row].length; col++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        }
    }
}

