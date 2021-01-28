package Exersice_03_SetsAndMapsAdvanced;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P04_CountSymbols {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        Map<Character, Integer> charOccurrences = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);

            if (!charOccurrences.containsKey(symbol)) {
                charOccurrences.put(symbol, 1);
            } else {
                charOccurrences.put(symbol, charOccurrences.get(symbol) + 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : charOccurrences.entrySet()) {
            System.out.printf("%c: %d time/s%n", entry.getKey(), entry.getValue());
        }
    }
}
