package Exersice_StreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

public class P07_MergeTwoFiles {
    public static final String FIRST_INPUT_PATH = "/home/chocho/IdeaProjects" +
            "/JavaAdvancedExerciseStreamsFilesAndDirectories/src/resources/04. " + "Java-Advanced-Files-and-Streams" + "-Exercises-Resources/inputOne.txt";
    public static final String SECOND_INPUT_PATH = "/home/chocho/IdeaProjects" +
            "/JavaAdvancedExerciseStreamsFilesAndDirectories/src/resources/04. " + "Java-Advanced-Files-and-Streams" + "-Exercises-Resources/inputTwo.txt";

    public static final String OUTPUT_PATH = "result.txt";

    public static void main(String[] args) {
        try (BufferedReader firstInput = new BufferedReader(new FileReader(FIRST_INPUT_PATH)); BufferedReader secondInput = new BufferedReader(new FileReader(SECOND_INPUT_PATH)); PrintWriter writer = new PrintWriter(OUTPUT_PATH)) {

            String line = firstInput.readLine();
            while (line != null) {
                writer.println(line);
                line = firstInput.readLine();
            }
            line = secondInput.readLine();
            while (line != null) {
                writer.println(line);
                line = secondInput.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
