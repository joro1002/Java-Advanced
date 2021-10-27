package CustomList;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        Box<String> box = new Box<>();

        while (!command.equals("END")) {
            String[] tokens = command.split("\\s+");
            String nameCommand = tokens[0];

            switch (nameCommand) {
                case "Add":
                    String element = tokens[1];
                    box.add(element);
                    break;
                case "Remove":
                    List<String> elements = box.getElements();
                    int index = Integer.parseInt(tokens[1]);
                    if (index >= 0 && index < elements.size()) {
                        box.remove(index);
                    }
                    break;
                case "Contains":
                    System.out.println(box.contains(tokens[1]));
                    break;
                case "Swap":
                    List<String> elementsSwap = box.getElements();
                    int indexFirst = Integer.parseInt(tokens[1]);
                    int indexSecond = Integer.parseInt(tokens[2]);
                    if (indexFirst >= 0 && indexFirst < elementsSwap.size()
                            && indexSecond >= 0 && indexSecond < elementsSwap.size()) {
                        box.swap(indexFirst, indexSecond);
                    }
                    break;
                case "Greater":
                    System.out.println(box.countGreaterThan(tokens[1]));
                    break;
                case "Max":
                    System.out.println(box.getMax());
                    break;
                case "Min":
                    System.out.println(box.getMin());
                    break;
                case "Print":
                    List<String> print = box.getElements();
                    for (String el : print) {
                        System.out.println(el);
                    }

                    break;
            }

            command = scanner.nextLine();
        }
    }
}
