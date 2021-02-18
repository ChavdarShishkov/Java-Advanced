package Java_Advanced_Retake_Exam_17_Dec_2019.P01_SantasPresentFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    private static int dolls = 0;
    private static int woodenTrains = 0;
    private static int teddyBears = 0;
    private static int bicycles = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> boxOfMaterialsStack = new ArrayDeque<>();
        Arrays.stream(reader.readLine().split("\\s+")).map(Integer::parseInt).forEach(boxOfMaterialsStack::push);

        ArrayDeque<Integer> magicLevelQueue =
                Arrays.stream(reader.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));


        boolean allPresents = false;

        while (!boxOfMaterialsStack.isEmpty() && !magicLevelQueue.isEmpty()) {
            int material = boxOfMaterialsStack.peek();
            int magicLevel = magicLevelQueue.peek();

            int total = material * magicLevel;
            if (total < 0) {
                int sum = material + magicLevel;
                boxOfMaterialsStack.pop();
                magicLevelQueue.poll();
                boxOfMaterialsStack.push(sum);
                continue;
            }
            if (!checkCraftedIItems(total) && total > 0) {
                magicLevelQueue.poll();
                boxOfMaterialsStack.pop();
                boxOfMaterialsStack.push(material + 15);
                continue;
            }
            if (material == 0) {
                boxOfMaterialsStack.pop();
            } else if (magicLevel == 0) {
                magicLevelQueue.poll();
            }

            if (checkCraftedIItems(total)) {
                craftedItems(total);
                magicLevelQueue.poll();
                boxOfMaterialsStack.pop();
            }

            if (dolls > 1 && woodenTrains > 1 || teddyBears > 1 && bicycles > 1) {
                allPresents = true;
            }
        }
        if (allPresents) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }
        if (!boxOfMaterialsStack.isEmpty()) {
            System.out.println("Materials left: " + getElementsInfo(boxOfMaterialsStack));
        } else if (!magicLevelQueue.isEmpty()) {
            System.out.println("Magic left: " + getElementsInfo(magicLevelQueue));
        }

        if (bicycles > 1) {
            System.out.println("Bicycle: " + bicycles);
        } else if (dolls > 1) {
            System.out.println("Doll: " + dolls);
        } else if (teddyBears > 1) {
            System.out.println("Teddy bear: " + teddyBears);
        } else if (woodenTrains > 1) {
            System.out.println("Wooden train: " + woodenTrains);
        }

    }

    private static String getElementsInfo(ArrayDeque<Integer> deque) {
        return deque.stream().map(String::valueOf).collect(Collectors.joining(", "));
    }

    private static boolean checkCraftedIItems(int total) {
        if (total == 150) {
            return true;
        } else if (total == 250) {
            return true;
        } else if (total == 300) {
            return true;
        } else return total == 400;
    }

    private static void craftedItems(int total) {
        if (total == 150) {
            dolls++;
        } else if (total == 250) {
            woodenTrains++;
        } else if (total == 300) {
            teddyBears++;
        } else if (total == 400) {
            bicycles++;
        }
    }
}
