import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Unleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashMap<String, Integer>> map = new LinkedHashMap<>();

        String command = scanner.nextLine();

        while (!command.equals("End")) {
            if (!command.contains("@") && command.charAt(command.indexOf("@") - 1) != ' ') {
                command = scanner.nextLine();
                continue;
            }

            String singer = command.substring(0, command.indexOf("@") - 1);
            int endIndex = 0;

            for (int i = command.indexOf("@"); i < command.length(); i++) {
                char current = command.charAt(i);
                if (Character.isDigit(current) && command.charAt(i - 1) == ' ') {
                    endIndex = i;
                    break;
                }
            }

            if (endIndex == 0) {
                command = scanner.nextLine();
                continue;
            }

            String venue = command.substring(command.indexOf("@") + 1, endIndex - 1);

            String numbers = command.substring(endIndex);

            String[] tokens = numbers.split("\\s+");
            if (tokens.length != 2) {
                command = scanner.nextLine();
                continue;
            }
            int price = Integer.parseInt(tokens[0]);
            int capacity = Integer.parseInt(tokens[1]);

            if (!map.containsKey(venue)) {
                LinkedHashMap<String, Integer> singers = new LinkedHashMap<>();
                singers.put(singer, price * capacity);
                map.put(venue, singers);
            } else {
                LinkedHashMap<String, Integer> currentSingers = map.get(venue);
                if (currentSingers.containsKey(singer)) {
                    currentSingers.put(singer, currentSingers.get(singer) + price * capacity);
                } else {
                    currentSingers.put(singer, price * capacity);
                }

                map.put(venue, currentSingers);
            }
            command = scanner.nextLine();
        }

        for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            HashMap<String, Integer> inner = entry.getValue();
            inner.entrySet().stream()
                    .sorted((f,s) -> s.getValue().compareTo(f.getValue()))
                    .forEach(e -> System.out.println("#  " + e.getKey() + " -> " + e.getValue()));

        }
    }
}
