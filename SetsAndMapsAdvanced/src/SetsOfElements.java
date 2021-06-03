import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");
        int firstSetSize = Integer.parseInt(tokens[0]);
        int secondSetSize = Integer.parseInt(tokens[1]);

        LinkedHashSet<Integer> first = new LinkedHashSet<>();
        LinkedHashSet<Integer> second = new LinkedHashSet<>();

        for (int i = 0; i < firstSetSize; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            first.add(number);
        }
        for (int i = 0; i < secondSetSize; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            second.add(number);
        }

        first.retainAll(second);
        first.forEach(e -> System.out.print(e + " "));
    }
}
