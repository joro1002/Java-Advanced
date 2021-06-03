import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        Set<String> vip = new TreeSet<>();
        Set<String> regular = new TreeSet<>();

        while (!command.equals("PARTY")){

            if (Character.isDigit(command.charAt(0))){
                vip.add(command);
            }else {
                regular.add(command);
            }
            command = scanner.nextLine();
        }
        command = scanner.nextLine();

        while (!command.equals("END")){
            if (Character.isDigit(command.charAt(0))){
                vip.remove(command);
            }else {
                regular.remove(command);
            }
            command = scanner.nextLine();
        }
        System.out.println(vip.size() + regular.size());
        if (!vip.isEmpty()) {
            System.out.println(String.join(System.lineSeparator(), vip));
        }
        if (!regular.isEmpty()) {
            System.out.println(String.join(System.lineSeparator(), regular));
        }
    }
}
