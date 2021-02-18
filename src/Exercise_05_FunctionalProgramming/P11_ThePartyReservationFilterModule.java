package Exercise_05_FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class P11_ThePartyReservationFilterModule {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] names = reader.readLine().split(" ");

        String line;

        Map<String, Predicate<String>> predicates = new HashMap<>();

        while (!"Print".equals(line = reader.readLine())) {
            String[] tokens = line.substring(line.indexOf(";") + 1).split(";");
            String name = tokens[0] + tokens[1];

            if (line.contains("Add")) {
                Predicate<String> predicate = switch (tokens[0]) {
                    case "Starts with" -> str -> str.startsWith(tokens[1]);
                    case "Ends with" -> str -> str.endsWith(tokens[1]);
                    case "Length" -> str -> str.length() == Integer.parseInt(tokens[1]);
                    case "Contains" -> str -> str.contains(tokens[1]);
                    default -> null;
                };
                predicates.putIfAbsent(name, predicate);

            } else {
                predicates.remove(name);
            }
        }
        for (String name : names) {
            boolean isValid = true;
            for (String predicateName : predicates.keySet()) {
                if (predicates.get(predicateName).test(name)) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                System.out.print(name + " ");
            }
        }
    }
}