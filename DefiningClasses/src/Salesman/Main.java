package Salesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Engine> engines = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String model = tokens[0];
            int power = Integer.parseInt(tokens[1]);

            Engine engine;

            if (tokens.length == 3) {
                if (stringOrInt(tokens[2])) {
                    int displacement = Integer.parseInt(tokens[2]);
                    engine = new Engine(model, power, displacement);
                } else {
                    String efficiency = tokens[2];
                    engine = new Engine(model, power, efficiency);
                }
            } else if (tokens.length == 4) {
                int displacement = Integer.parseInt(tokens[2]);
                String efficiency = tokens[3];
                engine = new Engine(model, power, displacement, efficiency);
            } else {
                engine = new Engine(model, power);
            }
            engines.add(engine);
        }

        int m = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String model = tokens[0];
            String engine = tokens[1];

            Car car;

            if (tokens.length == 3) {
                if (stringOrInt(tokens[2])) {
                    int weight = Integer.parseInt(tokens[2]);
                    car = new Car(model, engine, weight);
                } else {
                    String color = tokens[2];
                    car = new Car(model, engine, color);
                }
            } else if (tokens.length == 4) {
                int weight = Integer.parseInt(tokens[2]);
                String color = tokens[3];
                car = new Car(model, engine, weight, color);
            } else {
                car = new Car(model, engine);
            }
            cars.add(car);

        }

        cars.forEach(car -> {
            System.out.println(car.getModel() + ":");
            System.out.println(car.getEngine() + ":");
            engines.forEach(engine ->{
                if (engine.getModel().equals(car.getEngine())){
                    System.out.print(engine.toString());
                }
            });
            System.out.print(car.toString());
        });
    }

    public static boolean stringOrInt(String element) {
        for (Character e : element.toCharArray()) {
            if (Character.isDigit(e)) {
                return true;
            }
        }
        return false;
    }

}
