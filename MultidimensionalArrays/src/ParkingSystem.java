import java.util.Scanner;

public class ParkingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        boolean[][] matrix = new boolean[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row][0] = true;
        }

        String command = scanner.nextLine();
        while (!command.equals("stop")){
            String[] tokens = command.split("\\s+");
            int currentRow = Integer.parseInt(tokens[0]);
            int targetRow = Integer.parseInt(tokens[1]);
            int targetCol = Integer.parseInt(tokens[2]);

            int count = 1;

            count += Math.abs(targetRow - currentRow);

            boolean flag = false;

            if (!matrix[targetRow][targetCol]){
                count+= targetCol;
                matrix[targetRow][targetCol] = true;
                flag = true;
            }else {

                for (int row = 1; row < matrix[targetRow].length; row++) {
                    if (targetCol - row > 0 && !matrix[targetRow][targetCol - row]){
                        matrix[targetRow][targetCol - row] = true;
                        flag = true;
                        count+= targetCol - row;
                        break;
                    }
                    if (targetCol + row < matrix[targetRow].length && !matrix[targetRow][targetCol + row]){
                        matrix[targetRow][targetCol + row] = true;
                        flag = true;
                        count += targetCol + row;
                        break;
                    }
                }
            }

            if (flag){
                System.out.println(count);
            }else {
                System.out.printf("Row %d full%n", targetRow);
            }

            command = scanner.nextLine();
        }
    }
}
