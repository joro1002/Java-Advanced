import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, String> map = new LinkedHashMap<>();

        String command = scanner.nextLine();

        while (!command.equals("stop")){
            String name = command;
            String email = scanner.nextLine();

            if (!email.endsWith("us") && !email.endsWith("uk") && !email.endsWith("com")){
                map.putIfAbsent(name, "");
                map.put(name, map.get(name) + email);
            }

            command = scanner.nextLine();
        }

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

    }
}
