package Google;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        HashMap<String, Person> data = new HashMap<>();

        while (!command.equals("End")) {
            String[] tokens = command.split("\\s+");
            String name = tokens[0];
            data.putIfAbsent(name, new Person());
            String element = tokens[1];

            switch (element) {
                case "company":
                    String companyName = tokens[2];
                    String department = tokens[3];
                    double salary = Double.parseDouble(tokens[4]);
                    Company company = new Company(companyName, department, salary);
                    data.get(name).setCompany(company);
                    break;
                case "pokemon":
                    String pokemonName = tokens[2];
                    String pokemonType = tokens[3];
                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    data.get(name).getPokemons().add(pokemon);
                    break;
                case "parents":
                    String parentName = tokens[2];
                    String parentBirthday = tokens[3];
                    Parent parent = new Parent(parentName, parentBirthday);
                    data.get(name).getParents().add(parent);
                    break;
                case "children":
                    String childName = tokens[2];
                    String childBirthday = tokens[3];
                    Child child = new Child(childName, childBirthday);
                    data.get(name).getChildren().add(child);
                    break;
                case "car":
                    String carName = tokens[2];
                    int carSpeed = Integer.parseInt(tokens[3]);
                    Car car = new Car(carName, carSpeed);
                    data.get(name).setCar(car);
                    break;
            }
            command = scanner.nextLine();
        }

        String name = scanner.nextLine();

        Person person = data.get(name);
        System.out.println(name);

        String print = person.toString();
        System.out.println(print);
    }
}
