package Collection;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        List<String> data = Arrays.stream(scanner.nextLine().split("\\s+"))
                .skip(1)
                .collect(Collectors.toList());

        ListyIterator listyIterator = new ListyIterator(data);

        String command = scanner.nextLine();
        while (!command.equals("END")){

            if (command.equals("HasNext")){
                System.out.println(listyIterator.hasNext());
            }else if (command.equals("Move")){
                System.out.println(listyIterator.move());
            }else if (command.equals("Print")){
                listyIterator.print();
            }else if (command.equals("PrintAll")){
                listyIterator.printAll();
            }
            command = scanner.nextLine();
        }
    }
}
