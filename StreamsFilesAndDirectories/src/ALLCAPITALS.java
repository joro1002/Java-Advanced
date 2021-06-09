import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ALLCAPITALS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String path = "D:\\JavaAdvanced2021\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        List<String> lines = new ArrayList<>();

        try {
            lines = Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));
            for (String line: lines) {
                writer.write(line.toUpperCase());
                writer.println();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
