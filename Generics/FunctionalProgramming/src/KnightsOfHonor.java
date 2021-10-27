import java.util.Scanner;
import java.util.function.Consumer;

public class KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split("\\s+");

        Consumer<String[]> print = x-> {
            for (String name: names) {
                System.out.println("Sir " + name);
            }
        };
        print.accept(names);
    }
}
