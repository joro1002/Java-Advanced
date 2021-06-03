import java.util.*;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        TreeSet<String> elements = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            elements.addAll(Arrays.asList(tokens));
        }

        System.out.println(String.join(" ", elements));
    }
}
