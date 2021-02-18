package Java_Advanced_Retake_Exam_17_Dec_2019.P01_SantasPresentFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> materialStack = new ArrayDeque<>();
        Arrays.stream(reader.readLine().split("\\s+")).map(Integer::parseInt).forEach(materialStack::push);

        ArrayDeque<Integer> magicValuesQueue =
                Arrays.stream(reader.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        TreeMap<String, Integer> toys = new TreeMap<>();

        while (magicValuesQueue.size() > 0 && materialStack.size() > 0) {
            int values = magicValuesQueue.peek();
            int boxes = materialStack.peek();
            int product = values * boxes;

            if (product < 0) {
                int result = values + boxes;
                magicValuesQueue.poll();
                materialStack.pop();
                materialStack.push(result);

            } else if (boxes == 0 || values == 0) {
                if (boxes == 0) {
                    materialStack.pop();
                }
                if (values == 0) {
                    magicValuesQueue.poll();
                }

            } else if (product == 150 || product == 250 || product == 300 || product == 400) {
                String gift;
                if (product == 150) {

                    gift = "Doll";

                    magicValuesQueue.poll();
                    materialStack.pop();

                    toys.putIfAbsent(gift, 0);
                    toys.put(gift, toys.get(gift) + 1);

                } else if (product == 250) {

                    gift = "Wooden train";

                    magicValuesQueue.poll();
                    materialStack.pop();

                    toys.putIfAbsent(gift, 0);
                    toys.put(gift, toys.get(gift) + 1);

                } else if (product == 300) {
                    gift = "Teddy bear";
                    magicValuesQueue.poll();
                    materialStack.pop();
                    toys.putIfAbsent(gift, 0);
                    toys.put(gift, toys.get(gift) + 1);
                } else {
                    gift = "Bicycle";
                    magicValuesQueue.poll();
                    materialStack.pop();
                    toys.putIfAbsent(gift, 0);
                    toys.put(gift, toys.get(gift) + 1);
                }
            } else if (product > 0) {
                magicValuesQueue.poll();
                boxes += 15;
                materialStack.pop();
                materialStack.push(boxes);
            }
        }

        if (toys.containsKey("Doll") && toys.containsKey("Wooden train")) {
            System.out.println("The presents are crafted! Merry Christmas!");

        } else if (toys.containsKey("Teddy bear") && toys.containsKey("Bicycle")) {
            System.out.println("The presents are crafted! Merry Christmas!");

        } else {
            System.out.println("No presents this Christmas!");
        }

        if (materialStack.size() > 0) {
            System.out.println("Materials left: " + getElementsInfo(materialStack));
        }

        if (magicValuesQueue.size() > 0) {
            System.out.println("Magic left: " + getElementsInfo(magicValuesQueue));
        }

        for (Map.Entry<String, Integer> entry : toys.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static String getElementsInfo(ArrayDeque<Integer> deque) {
        return deque.stream().map(String::valueOf).collect(Collectors.joining(", "));
    }
}
