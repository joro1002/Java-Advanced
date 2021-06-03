import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

        while (!command.equals("stop")){
            String resource = command;
            int quantity = Integer.parseInt(scanner.nextLine());

            map.putIfAbsent(resource, 0);
            map.put(resource, map.get(resource) + quantity);

            command = scanner.nextLine();
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

    }
}
