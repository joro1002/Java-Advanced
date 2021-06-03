import java.util.*;

public class CitiesContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashMap<String, List<String>>> map = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String continent = tokens[0];
            String country = tokens[1];
            String city = tokens[2];

            map.putIfAbsent(continent, new LinkedHashMap<>());
            map.get(continent).putIfAbsent(country, new ArrayList<>());
            map.get(continent).get(country).add(city);
        }

        for (Map.Entry<String, LinkedHashMap<String, List<String>>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":");
            LinkedHashMap<String, List<String>> inner = entry.getValue();

            for (Map.Entry<String, List<String>> value : inner.entrySet()) {
                System.out.printf("  %s -> %s%n", value.getKey(), String.join(", ", value.getValue()));
            }

        }

    }
}
