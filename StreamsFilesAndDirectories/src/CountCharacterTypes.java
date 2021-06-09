import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountCharacterTypes {
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
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
            int vowels = 0;
            int punctuations = 0;
            int consonants = 0;
            for (String line : lines) {
                for (char symbol : line.toCharArray()) {
                    if (isVowel(symbol)) {
                        vowels++;
                    } else if (isPunctuation(symbol)) {
                        punctuations++;
                    } else {
                        if (symbol != ' ') {
                            consonants++;
                        }
                    }
                }
            }
            writer.write("Vowels: " + vowels);
            writer.newLine();
            writer.write("Consonants: " + consonants);
            writer.newLine();
            writer.write("Punctuation: " + punctuations);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static boolean isPunctuation(char symbol) {
        return symbol == '!' || symbol == ',' || symbol == '.' || symbol == '?';
    }

    private static boolean isVowel(char symbol) {
        if (symbol == 'a' || symbol == 'e' || symbol == 'i' || symbol == 'o' || symbol == 'u') {
            return true;
        }
        return false;
    }
}
