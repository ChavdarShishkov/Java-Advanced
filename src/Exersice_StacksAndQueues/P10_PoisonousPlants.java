package Exersice_StacksAndQueues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class P10_PoisonousPlants {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, Integer> indexPesticidesCount = new LinkedHashMap<>(Integer.parseInt(consoleReader.readLine()));

        String[] inputTokens = new String[0];

        try {
            inputTokens = consoleReader.readLine().split(" ");
        } catch (IOException e) {
            e.printStackTrace();
        }

        consoleReader.close();

        for (int i = 0; i < inputTokens.length; i++) {
            indexPesticidesCount.put(i, Integer.parseInt(inputTokens[i]));
        }

        int daysCounter = 0;
        List<Integer> indicesOfPlantsToBeRemoved = new ArrayList<>();

        while (true) {
            Map.Entry<Integer, Integer> previousEntry = null;

            for (Map.Entry<Integer, Integer> currentEntry : indexPesticidesCount.entrySet()) {
                if (previousEntry == null) {
                    previousEntry = currentEntry;
                    continue;
                }

                if (previousEntry.getValue() < currentEntry.getValue()) {

                    indicesOfPlantsToBeRemoved.add(currentEntry.getKey());
                }

                previousEntry = currentEntry;
            }

            if (indicesOfPlantsToBeRemoved.isEmpty()) {
                break;
            }

            daysCounter++;

            for (int i = 0; i < indicesOfPlantsToBeRemoved.size(); i++) {
                indexPesticidesCount.remove(indicesOfPlantsToBeRemoved.get(i));
            }

            indicesOfPlantsToBeRemoved.clear();
        }

        System.out.println(daysCounter);
    }
}
