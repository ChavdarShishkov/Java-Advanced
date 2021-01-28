package Exersice_03_SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class P06_AMinerTask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedHashMap<String, Integer> resources = new LinkedHashMap<>();

        String input = sc.nextLine();

        while (!input.equals("stop")) {
            int quantity = Integer.parseInt(sc.nextLine());
            if (!resources.containsKey(input)) {
                resources.put(input, quantity);
            } else {
                resources.put(input, resources.get(input) + quantity);
            }
            input = sc.nextLine();
        }
        resources.forEach((k, v) -> System.out.printf("%s -> %s%n", k, v));
    }
}
