package Exercise_04_StreamsFilesAndDirectories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class P08_GetFolderSize {
    public static void main(String[] args) throws IOException, IOException {
        String basePath = "C:\\Users\\Chavdar\\Documents\\JAVA\\JavaFund\\" + "08.Files And Directories - " +
                "Exercises\\resources\\Exercises Resources";
        Path folder = Paths.get(basePath);
        long size = Files.walk(folder).filter(p -> p.toFile().isFile()).filter(p -> !p.toFile().getName().equals(
                "output.txt")).filter(p -> !p.toFile().getName().equals("result.txt")).mapToLong(p -> p.toFile().length()).sum();

        System.out.printf("Folder size: %d%n", size);
    }
}
