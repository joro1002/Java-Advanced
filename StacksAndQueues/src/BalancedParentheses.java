import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<Character> stack = new ArrayDeque<>();

        boolean isBalanced = false;

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);

            if (current == '(' || current == '[' || current == '{') {
                stack.push(current);
            } else if (current == ')' || current == ']' || current == '}') {
                if (stack.isEmpty()) {
                    isBalanced = false;
                    break;
                }
                char lastOpen = stack.pop();

                if (lastOpen == '(' && current == ')') {
                    isBalanced = true;
                } else if (lastOpen == '[' && current == ']') {
                    isBalanced = true;
                } else if (lastOpen == '{' && current == '}') {
                    isBalanced = true;
                } else {
                    isBalanced = false;
                    break;
                }
            }
        }
        if (!isBalanced) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }

    }
}
