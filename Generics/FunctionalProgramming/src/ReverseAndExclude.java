import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int num = Integer.parseInt(scanner.nextLine());

        Collections.reverse(numbers);

        Predicate<Integer> divisible = x -> x % num == 0;
        numbers.removeIf(divisible);

        Consumer<List<Integer>> print = x -> x.forEach(e -> System.out.print(e + " "));
        print.accept(numbers);
    }
}