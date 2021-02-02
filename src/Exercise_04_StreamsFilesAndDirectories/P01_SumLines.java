package Exercise_04_StreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.FileReader;

public class P01_SumLines {
    private static final String PATH =
            "/home/chocho/IdeaProjects/JavaAdvancedExerciseStreamsFilesAndDirectories/src" + "/resources/04. " +
                    "Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH))) {
            String line = reader.readLine();
            while (line != null) {
                int sum = 0;
                for (int i = 0; i < line.length(); i++) {
                    sum += line.charAt(i);
                }
                System.out.println(sum);
                line = reader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
