package Exercise_05_FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P07_FindTheSmallestElement {
    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers =
                Arrays.stream(reader.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>, Integer> getLastIndexOfMinElement =
                list -> list.lastIndexOf(list.stream().min(Integer::compare).get());

        System.out.println(getLastIndexOfMinElement.apply(numbers));

    }
}
