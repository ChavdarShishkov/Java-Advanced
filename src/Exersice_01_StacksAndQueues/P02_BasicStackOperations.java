package Exersice_01_StacksAndQueues;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

public class P02_BasicStackOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] commands = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int n = commands[0];
        int s = commands[1];
        int x = commands[2];

        Stack<Integer> stack =
                Arrays.stream(sc.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(Stack::new));

        for (int i = 0; i < s; i++) {
            stack.pop();
        }
        if (stack.isEmpty()) {
            System.out.println(0);
        } else {
            if (stack.contains(x)) {
                System.out.println("true");
            } else {
                System.out.println(Collections.min(stack));
            }
        }
    }
}
