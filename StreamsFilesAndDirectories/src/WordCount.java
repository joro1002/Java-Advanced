import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class WordCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String path = "D:\\JavaAdvanced2021\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
        String pathInput = "D:\\JavaAdvanced2021\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";

        List<String> words = new ArrayList<>();

        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

        try {
            words = Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] tokens = words.get(0).split("\\s+");
        map.putIfAbsent(tokens[0], 0);
        map.putIfAbsent(tokens[1], 0);
        map.putIfAbsent(tokens[2], 0);

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("result.txt"));
            for (String line : Files.readAllLines(Path.of(pathInput))) {
                for (String word : line.split("\\s+")) {
                    if (map.containsKey(word)) {
                        map.put(word, map.get(word) + 1);
                    }
                }
            }

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                writer.write(entry.getKey() + " - " + entry.getValue());
                writer.newLine();
            }
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
