import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();

        String[] command = scanner.nextLine().split("\\s+");

        for (int i = command.length - 1; i >= 0 ; i--) {
            stack.push(command[i]);
        }

        while (stack.size() > 1) {
            int first = Integer.parseInt(stack.pop());
            String operation = stack.pop();
            int second = Integer.parseInt(stack.pop());

            int sum;
            if (operation.equals("+")) {
                sum = first + second;
            } else {
                sum = first - second;
            }
            stack.push(String.valueOf(sum));
        }

        System.out.println(stack.pop());
    }
}
