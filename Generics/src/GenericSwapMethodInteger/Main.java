package GenericSwapMethodInteger;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Box<Integer> box = new Box<>();

        for (int i = 0; i < n; i++) {
            int element = Integer.parseInt(scanner.nextLine());
            box.add(element);
        }
        String[] swapTokens = scanner.nextLine().split("\\s+");
        int first = Integer.parseInt(swapTokens[0]);
        int second = Integer.parseInt(swapTokens[1]);

        box.swap(first, second);
        System.out.println(box);
    }
}
