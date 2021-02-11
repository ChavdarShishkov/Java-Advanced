package Exersice_08_IteratorsAndComparators.P01_ListyIterator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> data = Arrays.stream(reader.readLine().split("\\s+")).skip(1).collect(Collectors.toList());

        ListyIterator listyIterator = new ListyIterator(data);

        String line = "";

        while (!"END".equals(line = reader.readLine())) {
            switch (line) {
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "Print":
                    try {
                        listyIterator.print();
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }
    }
}
