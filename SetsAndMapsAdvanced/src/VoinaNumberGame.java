import java.util.*;
import java.util.stream.Collectors;

public class VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<Integer> firstCards = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        LinkedHashSet<Integer> secondCards = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        int rounds = 50;

        while (rounds > 0 || firstCards.isEmpty() || secondCards.isEmpty()){
            rounds--;
            int first = firstNumber(firstCards);
            int second = firstNumber(secondCards);
            firstCards.remove(first);
            secondCards.remove(second);

            if (first > second){
                firstCards.add(first);
                firstCards.add(second);
            }else if (second > first){
                secondCards.add(first);
                secondCards.add(second);
            }
        }

        if (firstCards.size() < secondCards.size()){
            System.out.println("Second player win!");
        }else if (firstCards.size() > secondCards.size()){
            System.out.println("First player win!");
        }else {
            System.out.println("Draw!");
        }

    }

    public static int firstNumber(LinkedHashSet<Integer> set) {
        return set.stream().findFirst().orElse(0);
    }
}
