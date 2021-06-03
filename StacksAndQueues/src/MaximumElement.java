import java.util.ArrayDeque;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            switch (tokens[0]) {
                case "1":
                    int number = Integer.parseInt(tokens[1]);
                    stack.push(number);
                    break;
                case "2":
                    stack.pop();
                    break;
                case "3":
                    maxElement(stack);
                    break;
            }
        }
    }

    public static void maxElement(ArrayDeque<Integer> stack) {
        int maxValue = Integer.MIN_VALUE;

        for (int number :
                stack) {
            if (number > maxValue) {
                maxValue = number;
            }
        }
        System.out.println(maxValue);
    }
}
