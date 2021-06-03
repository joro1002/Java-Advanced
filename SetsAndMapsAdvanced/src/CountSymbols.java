import java.util.*;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        TreeMap<Character, Integer> count = new TreeMap<>();

        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);
            count.putIfAbsent(current, 0);
            count.put(current, count.get(current) + 1);
        }
        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " time/s");
        }

    }
}
