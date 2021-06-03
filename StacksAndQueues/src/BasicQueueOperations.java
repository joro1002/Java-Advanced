import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        String[] input = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);
        int x = Integer.parseInt(input[2]);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < n; i++) {
            queue.offer(numbers[i]);
        }

        for (int i = 0; i < s; i++) {
            queue.poll();
        }
        if (queue.isEmpty()) {
            System.out.println("0");
        } else {
            if (queue.contains(x)) {
                System.out.println("true");
            } else {
                minElement(queue);
            }
        }
    }

    public static void minElement(ArrayDeque<Integer> queue) {
        int minValue = Integer.MAX_VALUE;

        for (int number :
                queue) {
            if (number < minValue) {
                minValue = number;
            }
        }
        System.out.println(minValue);
    }
}
