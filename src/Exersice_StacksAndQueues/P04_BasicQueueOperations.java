package Exersice_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P04_BasicQueueOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] commands = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int n = commands[0];
        int s = commands[1];
        int x = commands[2];

        ArrayDeque<Integer> queue =
                Arrays.stream(sc.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        for (int i = 0; i < s; i++) {
            queue.pop();
        }
        if (queue.isEmpty()) {
            System.out.println(0);
        } else {
            if (queue.contains(x)) {
                System.out.println("true");
            } else {
                System.out.println(Collections.min(queue));
            }
        }
    }
}
