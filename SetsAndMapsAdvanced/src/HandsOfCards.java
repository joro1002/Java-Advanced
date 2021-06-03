import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Set<String>> map = new LinkedHashMap<>();

        String command = scanner.nextLine();

        while (!command.equals("JOKER")) {
            String[] tokens = command.split(": ");
            String name = tokens[0];
            String[] cards = tokens[1].split(", ");

            Set<String> cardsOnPerson = new LinkedHashSet<>();

            cardsOnPerson.addAll(Arrays.asList(cards));

            if (!map.containsKey(name)) {
                map.put(name, cardsOnPerson);
            } else {
                Set<String> current = map.get(name);
                current.addAll(cardsOnPerson);
                map.put(name, current);
            }

            command = scanner.nextLine();
        }

        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
            int points = getSumPoints(entry.getValue());
            System.out.println(entry.getKey() + ": " + points);
        }

    }

    private static int getSumPoints(Set<String> cards) {
        int sum = 0;
        for (String card : cards) {
            if (card.contains("10")) {
                sum += 10 * getSumType(card.charAt(2));
            } else {
                Character power = card.charAt(0);
                Character type = card.charAt(1);

                switch (power) {
                    case '2':
                        sum+= 2 * getSumType(type);
                        break;
                    case '3':
                        sum+= 3 * getSumType(type);
                        break;
                    case '4':
                        sum+= 4 * getSumType(type);
                        break;
                    case '5':
                        sum+= 5 * getSumType(type);
                        break;
                    case '6':
                        sum+= 6 * getSumType(type);
                        break;
                    case '7':
                        sum+= 7 * getSumType(type);
                        break;
                    case '8':
                        sum+= 8 * getSumType(type);
                        break;
                    case '9':
                        sum+= 9 * getSumType(type);
                        break;
                    case 'J':
                        sum+= 11 * getSumType(type);
                        break;
                    case 'Q':
                        sum+= 12 * getSumType(type);
                        break;
                    case 'K':
                        sum+= 13 * getSumType(type);
                        break;
                    case 'A':
                        sum+= 14 * getSumType(type);
                        break;

                }
            }
        }
        return sum;
    }

    public static int getSumType(Character character) {
        int sum = 0;
        if (character.equals('S')) {
            sum += 4;
        } else if (character.equals('H')) {
            sum += 3;
        } else if (character.equals('D')) {
            sum += 2;
        } else {
            sum += 1;
        }
        return sum;
    }
}
