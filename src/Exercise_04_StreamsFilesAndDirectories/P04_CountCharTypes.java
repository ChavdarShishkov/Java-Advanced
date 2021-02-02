package Exercise_04_StreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Set;

public class P04_CountCharTypes {
    private static final String INPUT_PATH = "/home/chocho/IdeaProjects" +
            "/JavaAdvancedExerciseStreamsFilesAndDirectories/src" + "/resources/04. " + "Java-Advanced-Files-and" +
            "-Streams-Exercises-Resources/input.txt";
    private static final String OUTPUT_PATH = "output.txt";

    public static void main(String[] args) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        Set<Character> punctuation = Set.of('!', ',', '.', '?');
        int vowelsCount = 0, constantsCount = 0, punctuationCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_PATH)); PrintWriter writer =
                new PrintWriter(OUTPUT_PATH)) {
            String line = reader.readLine();

            while (line != null) {
                for (int i = 0; i < line.length(); i++) {
                    char symbol = line.charAt(i);
                    if (vowels.contains(symbol)) {
                        vowelsCount++;
                    } else if (punctuation.contains(symbol)) {
                        punctuationCount++;
                    } else if (' ' != symbol) {
                        constantsCount++;
                    }
                    line = reader.readLine();
                }
            }
            writer.printf("Vowels: %d", vowelsCount);
            writer.printf("Constants: %d", constantsCount);
            writer.printf("Punctuation: %d", punctuationCount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
