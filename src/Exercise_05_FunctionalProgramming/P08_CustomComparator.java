package Exercise_05_FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class P08_CustomComparator {
    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers =
                Arrays.stream(reader.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        Comparator<Integer> comparator = (o1, o2) -> {
            if (o1 % 2 == 0 && o2 % 2 != 0) {
                return -1;
            } else if (o1 % 2 != 0 && o2 % 2 == 0) {
                return 1;
            }
            return o1.compareTo(o2);
        };

        numbers.stream().sorted(comparator).forEach(e -> System.out.print(e + " "));
    }
}
