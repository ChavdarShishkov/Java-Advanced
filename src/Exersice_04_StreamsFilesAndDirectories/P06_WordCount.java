package Exersice_04_StreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class P06_WordCount {
    public static final String WORDS_INPUT_PATH = "/home/chocho/IdeaProjects" +
            "/JavaAdvancedExerciseStreamsFilesAndDirectories" + "/src/resources/04. Java-Advanced-Files-and-Streams" + "-Exercises-Resources/words.txt";
    public static final String TEXT_INPUT_PATH = "/home/chocho/IdeaProjects" +
            "/JavaAdvancedExerciseStreamsFilesAndDirectories/src/resources/04. " + "Java-Advanced-Files-and-Streams" + "-Exercises-Resources/text.txt";

    public static final String OUTPUT_PATH = "result.txt";

    public static void main(String[] args) {
        try (BufferedReader wordsReader = new BufferedReader(new FileReader(WORDS_INPUT_PATH)); BufferedReader textReader = new BufferedReader(new FileReader(TEXT_INPUT_PATH)); PrintWriter writer = new PrintWriter(OUTPUT_PATH)) {

            String[] words = wordsReader.readLine().split("\\s+");
            Map<String, Integer> wordsOccurrence = new HashMap<>();

            for (String word : words) {
                wordsOccurrence.put(word, 0);
            }

            String[] text = textReader.readLine().split("\\s+");

            for (String word : text) {
                if (wordsOccurrence.containsKey(word)) {
                    wordsOccurrence.put(word, wordsOccurrence.get(word) + 1);
                }
            }

            wordsOccurrence.entrySet().stream().sorted((k, v) -> v.getValue().compareTo(k.getValue())).forEach(w -> writer.printf("%s - %d%n", w.getKey(), w.getValue()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
