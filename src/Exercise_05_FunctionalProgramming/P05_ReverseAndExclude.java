package Exercise_05_FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class P05_ReverseAndExclude {
    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers =
                Arrays.stream(reader.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        int divider = Integer.parseInt(reader.readLine());

        Collections.reverse(numbers);
        numbers.stream().filter(e -> e % divider != 0).forEach(e -> System.out.print(e + " "));

    }
}
