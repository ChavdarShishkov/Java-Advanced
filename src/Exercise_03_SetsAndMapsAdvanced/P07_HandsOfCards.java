package Exercise_03_SetsAndMapsAdvanced;

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

        String regex = "([0-9]+|[JQKA])([CHDS])";

        Pattern pattern = Pattern.compile(regex);

        for (Map.Entry<String, Set<String>> entry : playersCards.entrySet()) {
            String name = entry.getKey();
            int playerScore = 0;
            for (String ignored : entry.getValue()) {
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
        return switch (type) {
            case "S" -> 4;
            case "H" -> 3;
            case "D" -> 2;
            case "C" -> 1;
            default -> 0;
        };
    }

    private static int getValueByPower(String power) {
        return switch (power) {
            case "J" -> 11;
            case "Q" -> 12;
            case "K" -> 13;
            case "A" -> 14;
            default -> Integer.parseInt(power);
        };
    }
}
