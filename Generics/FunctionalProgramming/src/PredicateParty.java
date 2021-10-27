import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("Party!")) {

            BiPredicate<String, String> predicate = null;

            String[] tokens = command.split("\\s+");

            switch (tokens[1]) {
                case "StartsWith":
                    predicate = (n, s) -> n.startsWith(s);
                    break;
                case "EndsWith":
                    predicate = (n, e) -> n.endsWith(e);
                    break;
                case "Length":
                    predicate = (n, l) -> {
                        int len = Integer.parseInt(l);
                        return n.length() == len;
                    };
                    break;
            }
            String removeOrDouble = tokens[0];
            if (removeOrDouble.equals("Double")) {
              int startSize = names.size();
                for (int i = 0; i < startSize; i++) {
                    if (predicate.test(names.get(i), tokens[2])){
                        names.add(names.get(i));
                    }
                }
            } else if (removeOrDouble.equals("Remove")) {
                for (int i = 0; i < names.size(); i++) {
                    if (predicate.test(names.get(i), tokens[2])){
                        names.remove(i);
                        i--;
                    }
                }
            }

            command = scanner.nextLine();
        }

        names = names.stream().sorted(String::compareTo).collect(Collectors.toList());

        for (int i = 0; i < names.size(); i++) {
            if (i == names.size() - 1){
                System.out.print(names.get(i) + " ");
            }else {
                System.out.print(names.get(i) + ", ");
            }
        }
        if (names.size() > 0){
            System.out.print("are going to the party!");
        }else {
            System.out.println("Nobody is going to the party!");
        }
    }
}
