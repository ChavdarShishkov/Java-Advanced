package Exersice_StreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

public class P03_AllCapitals {
    private static final String INPUT_PATH = "/home/chocho/IdeaProjects" +
            "/JavaAdvancedExerciseStreamsFilesAndDirectories/src" + "/resources/04. " + "Java-Advanced-Files-and" +
            "-Streams-Exercises-Resources/input.txt";
    private static final String OUTPUT_PATH = "output.txt";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_PATH)); PrintWriter writer =
                new PrintWriter(OUTPUT_PATH)) {

            String line = reader.readLine();

            while (line != null) {
                writer.println(line.toUpperCase());
                line = reader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
