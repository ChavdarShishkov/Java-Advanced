package Java_Advanced_Exam_28_June_2020.P01_firs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> bombEffectsQueue =
                Arrays.stream(reader.readLine().split(",\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> bombsCasingsStack = new ArrayDeque<>();
        Arrays.stream(reader.readLine().split(",\\s+")).map(Integer::parseInt).forEach(bombsCasingsStack::push);

        int daturaBombs = 0;
        int cheeryBombs = 0;
        int smokeBomb = 0;

        boolean allBombs = false;
        while (!bombEffectsQueue.isEmpty() || !bombsCasingsStack.isEmpty()) {
            int bombEffect = bombEffectsQueue.peekFirst();
            int bombCasing = bombsCasingsStack.peekFirst();

            int total = bombCasing + bombEffect;

            if (total == 40) {
                daturaBombs++;
                popPoll(bombEffectsQueue, bombsCasingsStack);
            } else if (total == 60) {
                cheeryBombs++;
                popPoll(bombEffectsQueue, bombsCasingsStack);
            } else if (total == 120) {
                smokeBomb++;
                popPoll(bombEffectsQueue, bombsCasingsStack);
            } else {
                bombsCasingsStack.pop();
                bombsCasingsStack.add(bombCasing - 5);
            }
            if (daturaBombs >= 3 && cheeryBombs >= 3 && smokeBomb >= 3) {
                allBombs = true;
                break;
            }
        }

        if (allBombs) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        if (bombEffectsQueue.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            System.out.println("Bomb Effects: " + bombEffectsQueue.toString().replaceAll("\\[", "").replaceAll("]",
                    "").trim());
        }

        if (bombsCasingsStack.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            System.out.println("Bomb Casings: " + bombsCasingsStack.toString().replaceAll("\\[", "").replaceAll("]",
                    "").trim());
        }

        System.out.println("Cherry Bombs: " + cheeryBombs);
        System.out.println("Datura Bombs: " + daturaBombs);
        System.out.println("Smoke Decoy Bombs: " + smokeBomb);
    }

    private static void popPoll(ArrayDeque<Integer> bombEffectsQueue, ArrayDeque<Integer> bombsCasingsStack) {
        bombEffectsQueue.poll();
        bombsCasingsStack.pop();
    }
}
