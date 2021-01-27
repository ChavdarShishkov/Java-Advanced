package Exersice_StreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

public class P05_LineNumbers {
    public static final String INPUT_PATH = "/home/chocho/IdeaProjects/JavaAdvancedExerciseStreamsFilesAndDirectories"
            + "/src/resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputLineNumbers.txt";
    public static final String OUTPUT_PATH = "output.txt";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_PATH)); PrintWriter writer =
                new PrintWriter(OUTPUT_PATH)) {

            String line = reader.readLine();
            int counter = 1;
            while (line != null) {
                writer.printf("%d. %s%n", counter, line);
                counter++;
                line = reader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
