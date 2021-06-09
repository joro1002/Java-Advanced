import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SumLines {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String path = "D:\\JavaAdvanced2021\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        List<String> lines = new ArrayList<>();

        try {
            lines = Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String line: lines) {
            int sum = 0;
            for (char symbol: line.toCharArray()) {
                sum += symbol;
            }
            System.out.println(sum);
        }
    }
}
