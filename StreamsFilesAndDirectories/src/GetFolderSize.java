import java.io.File;

public class GetFolderSize {
    public static void main(String[] args) {
        String path = "D:\\JavaAdvanced2021\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";

        File folder = new File(path);

        int size = 0;

        for (File file: folder.listFiles()) {
            size += file.length();
        }
        System.out.println("Folder size: " + size);
    }
}
