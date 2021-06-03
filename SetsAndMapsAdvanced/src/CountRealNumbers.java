import javax.script.ScriptContext;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<Double, Integer> map = new LinkedHashMap<>();

        double[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        for (double number : numbers) {
           if (!map.containsKey(number)){
               map.put(number, 1);
           }else {
               map.put(number, map.get(number) + 1);
           }
        }

        for (Map.Entry<Double, Integer> number: map.entrySet()) {
            System.out.println(number.getKey() + " -> " + number.getValue());
        }
    }
}
