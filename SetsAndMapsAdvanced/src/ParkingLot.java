import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> parkingLot = new LinkedHashSet<>();

        String command = scanner.nextLine();

        while (!command.equals("END")){
            String[] tokens = command.split(", ");
            String direction = tokens[0];
            String carNumber = tokens[1];

            if (direction.equals("IN")){
                parkingLot.add(carNumber);
            }else {
                parkingLot.remove(carNumber);
            }

            command = scanner.nextLine();
        }
        if (parkingLot.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }else {
            System.out.println(String.join(System.lineSeparator(), parkingLot));
        }
    }
}
