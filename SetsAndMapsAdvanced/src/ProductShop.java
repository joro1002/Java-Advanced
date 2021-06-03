import java.util.*;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, LinkedHashMap<String, Double>> map = new TreeMap<>();

        String command = scanner.nextLine();

        while (!command.equals("Revision")) {
            String[] tokens = command.split(", ");
            String shop = tokens[0];
            String product = tokens[1];
            double price = Double.parseDouble(tokens[2]);

            map.putIfAbsent(shop, new LinkedHashMap<>());
            map.get(shop).putIfAbsent(product, 0.0);
            map.get(shop).put(product, price);


            command = scanner.nextLine();
        }

        for (Map.Entry<String, LinkedHashMap<String, Double>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "->");
            LinkedHashMap<String, Double> value = entry.getValue();
            for (Map.Entry<String, Double> inner : value.entrySet()) {
                System.out.printf("Product: %s, Price: %.1f%n", inner.getKey(), inner.getValue());
            }
        }
    }
}
