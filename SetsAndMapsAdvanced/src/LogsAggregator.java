import java.util.*;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, Integer> users = new TreeMap<>();
        TreeMap<String, Set<String>> ips = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String ip = tokens[0];
            String user = tokens[1];
            int duration = Integer.parseInt(tokens[2]);

            users.putIfAbsent(user, 0);
            users.put(user, users.get(user) + duration);

            ips.putIfAbsent(user, new TreeSet<>());
            ips.get(user).add(ip);
        }

        for (Map.Entry<String, Integer> entry : users.entrySet()) {
            System.out.print(entry.getKey() + ": " + entry.getValue() + " ");
            for (Map.Entry<String, Set<String>> setEntry : ips.entrySet()) {
                if (entry.getKey().equals(setEntry.getKey())) {
                    System.out.print("[");
                    int innerCount = 0;
                    for (String s : setEntry.getValue()) {
                        innerCount++;
                        int count = setEntry.getValue().size();
                        if (count == innerCount){
                            System.out.print(s);
                        }else {
                            System.out.print(s + ", ");
                        }
                    }
                    System.out.print("]");
                }
            }

            System.out.println();

        }

    }
}
