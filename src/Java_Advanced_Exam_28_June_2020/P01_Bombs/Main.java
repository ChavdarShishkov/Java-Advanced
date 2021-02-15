package Java_Advanced_Exam_28_June_2020.P01_Bombs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> bombEffects =
                Arrays.stream(reader.readLine().split(",\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> bombCasings = new ArrayDeque<>();
        Arrays.stream(reader.readLine().split(",\\s+")).map(Integer::parseInt).forEach(bombCasings::push);

        int daturaBombs = 0;
        int cherryBombs = 0;
        int smokeBombs = 0;

        boolean allBombs = false;


        while (!bombEffects.isEmpty() && !bombCasings.isEmpty()) {
            int currentBombEffect = bombEffects.peek();
            int currentBombCasing = bombCasings.peek();

            int total = currentBombCasing + currentBombEffect;

            if (total == 40) {

                daturaBombs++;
                bombCasings.pop();
                bombEffects.poll();
            } else if (total == 60) {

                cherryBombs++;
                bombCasings.pop();
                bombEffects.poll();
            } else if (total == 120) {

                smokeBombs++;
                bombCasings.pop();
                bombEffects.poll();
            } else {
                bombCasings.pop();
                bombCasings.push(currentBombCasing - 5);
            }

            if (daturaBombs >= 3 && cherryBombs >= 3 && smokeBombs >= 3) {
                allBombs = true;
                break;
            }
        }
        if (allBombs) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        System.out.println("Bomb Effects: " + getElementsInfo(bombEffects));
        System.out.println("Bomb Casings: " + getElementsInfo(bombCasings));

        System.out.println("Cherry Bombs: " + cherryBombs);
        System.out.println("Datura Bombs: " + daturaBombs);
        System.out.println("Smoke Decoy Bombs: " + smokeBombs);
    }

    private static String getElementsInfo(ArrayDeque<Integer> deque) {
        return deque.isEmpty() ? "empty" : deque.stream().map(String::valueOf).collect(Collectors.joining(", "));
    }

}
