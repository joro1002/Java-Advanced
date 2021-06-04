import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, LinkedHashMap<String, Integer>> map = new TreeMap<>();

        String command = scanner.nextLine();

        while (!command.equals("end")){
            String[] tokens = command.split("\\s+");
            String ip = tokens[0].split("=")[1];
            String user = tokens[2].split("=")[1];

            map.putIfAbsent(user, new LinkedHashMap<>());
            map.get(user).putIfAbsent(ip, 0);
            map.get(user).put(ip, map.get(user).get(ip) + 1);


            command = scanner.nextLine();
        }

        for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": ");
            LinkedHashMap<String, Integer> inner = entry.getValue();
            int innerCount = 0;
            for (Map.Entry<String, Integer> value : inner.entrySet()) {
                int count = inner.size();

                if (innerCount == count - 1){
                    System.out.print(value.getKey() + " => " + value.getValue() + ".");
                }else {
                    innerCount++;
                    System.out.print(value.getKey() + " => " + value.getValue() + ", ");
                }

            }
            System.out.println();

        }

    }
}
