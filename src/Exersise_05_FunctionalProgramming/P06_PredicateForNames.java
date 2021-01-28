package Exersise_05_FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Predicate;

public class P06_PredicateForNames {
    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(reader.readLine());

        String[] names = reader.readLine().split("\\s+");

        Predicate<String> lengthCompare = name -> name.length() <= length;

        Arrays.stream(names).filter(lengthCompare).forEach(System.out::println);
    }
}
