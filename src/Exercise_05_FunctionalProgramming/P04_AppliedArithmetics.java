package Exercise_05_FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;

public class P04_AppliedArithmetics {
    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Function<int[], int[]> addOne = arr -> Arrays.stream(arr).map(num -> num += 1).toArray();

        Function<int[], int[]> multiplyByTwo = arr -> Arrays.stream(arr).map(num -> num * 2).toArray();

        Function<int[], int[]> subtractOne = arr -> Arrays.stream(arr).map(num -> num -= 1).toArray();

        Consumer<int[]> printer = num -> Arrays.stream(num).forEach(n -> System.out.print(n + " "));

        String command = reader.readLine();
        while (!command.equals("end")) {
            switch (command) {
                case "add" -> numbers = addOne.apply(numbers);
                case "multiply" -> numbers = multiplyByTwo.apply(numbers);
                case "subtract" -> numbers = subtractOne.apply(numbers);
                case "print" -> {
                    printer.accept(numbers);
                    System.out.println();
                }
            }
            command = reader.readLine();
        }
    }
}
