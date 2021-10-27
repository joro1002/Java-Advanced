import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Consumer<List<Integer>> list = x -> {
            int min = Integer.MAX_VALUE;

            for (int num: x) {
                if (num < min){
                    min = num;
                }
            }
            System.out.println(x.lastIndexOf(min));
        };

        list.accept(numbers);
    }
}
