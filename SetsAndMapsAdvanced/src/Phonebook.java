import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        LinkedHashMap<String, String> map = new LinkedHashMap<>();

        while (!command.equals("search")){
            String[] tokens = command.split("-");
            String name = tokens[0];
            String phone = tokens[1];

            map.putIfAbsent(name, "");
            map.put(name, map.get(name) + phone);

            command = scanner.nextLine();
        }

        command = scanner.nextLine();
        while (!command.equals("stop")){
            String name = command;

            if (map.containsKey(name)){
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (entry.getKey().equals(name)){
                        System.out.println(entry.getKey() + " -> " + entry.getValue());
                    }
                }

            }else {
                System.out.printf("Contact %s does not exist.%n", name);
            }

            command = scanner.nextLine();
        }
    }
}
