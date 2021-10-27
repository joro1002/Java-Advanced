package SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, Car> map = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String model = tokens[0];
            double fuelAmount = Double.parseDouble(tokens[1]);
            double fuelKilometer = Double.parseDouble(tokens[2]);

            Car car = new Car(model, fuelAmount, fuelKilometer);

            map.put(model, car);

        }
        String command = scanner.nextLine();

        while (!command.equals("End")) {

            String[] tokens = command.split("\\s+");
            String carModel = tokens[1];
            int distanceToDrive = Integer.parseInt(tokens[2]);

            Car carToDrive = map.get(carModel);

            if (!carToDrive.drive(distanceToDrive)) {
                System.out.println("Insufficient fuel for the drive");
            }

            command = scanner.nextLine();
        }
        map.values().forEach(e -> System.out.println(e.toString()));
    }
}
