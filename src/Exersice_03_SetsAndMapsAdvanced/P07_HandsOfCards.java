package Exersice_03_SetsAndMapsAdvanced;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P07_HandsOfCards {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Set<String>> playersCards = new LinkedHashMap<>();

        String input = sc.nextLine();
        while (!input.equals("JOKER")) {

            String[] tokens = input.split(": ");
            String[] cards = tokens[1].split(",\\s+");

            if (!playersCards.containsKey(tokens[0])) {
                playersCards.put(tokens[0], new HashSet<>());
            }
            for (String card : cards) {
                playersCards.get(tokens[0]).add(card.trim());
            }
            input = sc.nextLine();
        }

        String regex = "([0-9]+|[JQKA])([CHDS]{1})";

        Pattern pattern = Pattern.compile(regex);

        for (Map.Entry<String, Set<String>> entry : playersCards.entrySet()) {
            String name = entry.getKey();
            int playerScore = 0;
            for (String card : entry.getValue()) {
                Matcher matcher = pattern.matcher(regex);

                if (matcher.find()) {

                    String power = matcher.group(1);
                    String type = matcher.group(2);

                    int value = getValueByPower(power);
                    int multiplier = getMultiplier(type);
                    int score = value * multiplier;
                    playerScore += score;
                }
            }
            System.out.printf("%s: %d%n", name, playerScore);

        }
    }

    private static int getMultiplier(String type) {
        int multiplier = 0;
        switch (type) {
            case "S":
                multiplier = 4;
                break;

            case "H":
                multiplier = 3;
                break;

            case "D":
                multiplier = 2;
                break;

            case "C":
                multiplier = 1;
                break;
        }
        return multiplier;
    }

    private static int getValueByPower(String power) {
        int value;
        switch (power) {
            case "J":
                value = 11;
                break;
            case "Q":
                value = 12;
                break;
            case "K":
                value = 13;
                break;
            case "A":
                value = 14;
                break;
            default:
                value = Integer.parseInt(power);
                break;

        }
        return value;
    }
}
