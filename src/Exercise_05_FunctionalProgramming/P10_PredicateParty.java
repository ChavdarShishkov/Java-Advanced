package Exercise_05_FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P10_PredicateParty {
    static List<String> names = null;

    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));

        names = Arrays.stream(reader.readLine().split("\\s+")).collect(Collectors.toList());
        String input = reader.readLine();

        while (!input.equals("Party!")) {
            String[] commands = input.split("\\s+");
            switch (commands[0]) {
                case "Double" -> addOneMore(getPredicate(commands));
                case "Remove" -> removeName(getPredicate(commands));
            }
            input = reader.readLine();
        }
        if (names.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            System.out.println(names.toString().replaceAll("([\\[\\]])", "") + " are going to the party!");
        }
    }

    private static void removeName(Predicate<String> predicate) {
        names.removeIf(predicate);
    }

    private static void addOneMore(Predicate<String> predicate) {
        List<String> namesToAdd = new ArrayList<>();
        names.stream().filter(predicate).forEach(namesToAdd::add);
        names.addAll(namesToAdd);
    }

    public static Predicate<String> getPredicate(String[] commands) {
        Predicate<String> predicate = null;

        if (commands[1].equals("StartsWith")) {
            predicate = name -> name.startsWith(commands[2]);
        } else if (commands[1].equals("EndsWith")) {
            predicate = name -> name.endsWith(commands[2]);
        } else {
            predicate = name -> name.length() == Integer.parseInt(commands[2]);
        }
        return predicate;
    }
}
