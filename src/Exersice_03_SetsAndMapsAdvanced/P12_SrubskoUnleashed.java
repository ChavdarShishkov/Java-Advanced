package Exersice_03_SetsAndMapsAdvanced;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P12_SrubskoUnleashed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String command = sc.nextLine();

        LinkedHashMap<String, LinkedHashMap<String, Long>> venues = new LinkedHashMap<>();
        LinkedHashMap<String, Long> countryPopulation = new LinkedHashMap<>();

        while (!command.equals("End")) {
            if (inputIsValid(command)) {
                String[] extractedData = extractData(command);
                String venue = extractedData[1];
                String singer = extractedData[0];

                int ticketPrice = Integer.parseInt(extractedData[2]);
                int ticketCount = Integer.parseInt(extractedData[3]);

                long concertAmount = (long) ticketPrice * ticketCount;

                if (!venues.containsKey(venue)) {
                    LinkedHashMap<String, Long> singers = new LinkedHashMap<>();
                    singers.put(singer, concertAmount);
                    venues.put(venue, singers);
                } else if (!venues.get(venue).containsKey(singer)) {
                    venues.get(venue).put(singer, concertAmount);

                } else {
                    venues.get(venue).put(singer, venues.get(venue).get(singer) + concertAmount);
                }
            }
            command = sc.nextLine();
        }

        venues.entrySet().forEach(venue -> {
            System.out.println(venue.getKey());
            venues.get(venue.getKey()).entrySet().stream().sorted(Map.Entry.comparingByValue(Collections.reverseOrder())).forEach(singer -> System.out.println("#  " + singer.getKey() + " -> " + singer.getValue()));
        });
    }

    private static String[] extractData(String command) {

        String[] result = new String[4];
        String[] tokens = command.split(" @");
        String singer = tokens[0];
        result[0] = singer;
        String remainingData = tokens[1];
        String[] remainingTokens = remainingData.split(" ");

        if (remainingTokens.length == 3) {
            String venue = remainingTokens[0];
            result[1] = venue;
            result[2] = remainingTokens[1];
            result[3] = remainingTokens[2];

        } else {

            StringBuilder venue = new StringBuilder();
            for (int i = 0; i < remainingTokens.length - 3; i++) {
                venue.append(remainingTokens[i]).append(" ");
            }
            venue.append(remainingTokens[remainingTokens.length - 3]);
            result[1] = venue.toString();
            result[2] = remainingTokens[remainingTokens.length - 2];
            result[3] = remainingTokens[remainingTokens.length - 1];
        }
        return result;
    }

    private static boolean inputIsValid(String command) {
        String[] tokens = command.split(" @");
        if (tokens.length != 2) {
            return false;
        }
        String singer = tokens[0];
        String remainingData = tokens[1];
        String[] remainingTokens = remainingData.split(" ");
        try {
            int ticketPrice = Integer.parseInt(remainingTokens[remainingTokens.length - 1]);
            int ticketCount = Integer.parseInt(remainingTokens[remainingTokens.length - 2]);
            long concertAmount = (long) ticketPrice * ticketCount;
        } catch (NumberFormatException e) {
            return false;
        }
        return remainingTokens.length >= 3;

    }
}
