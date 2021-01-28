package Exercise_05_FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;

public class P02_KnightsOfHonour {
    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));

        Consumer<String> consumer = n -> System.out.println("Sir " + n);

        Arrays.stream(reader.readLine().split("\\s+")).forEach(consumer);
    }
}
