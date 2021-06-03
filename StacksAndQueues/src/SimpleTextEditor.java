import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();
        StringBuilder text = new StringBuilder();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            switch (tokens[0]) {
                case "1":
                    String string = tokens[1];
                    stack.push(text.toString());
                    text.append(string);
                    break;
                case "2":
                    int count = Integer.parseInt(tokens[1]);
                    stack.push(text.toString());
                    text = new StringBuilder(text.substring(0, text.length() - count));
                    break;
                case "3":
                    int index = Integer.parseInt(tokens[1]);
                    System.out.println(text.charAt(index - 1));
                    break;
                case "4":
                    text =  new StringBuilder(stack.pop());
                    break;
            }
        }
    }
}
