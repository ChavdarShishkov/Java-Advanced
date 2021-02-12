package Java_Advanced_Exam_25_October_2020.First;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> tasks =
                Arrays.stream(reader.readLine().split(",\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> threads =
                Arrays.stream(reader.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        int taskToKill = Integer.parseInt(reader.readLine());

        while (tasks.peek() != taskToKill) {
            if (threads.peek() >= tasks.peek()) {
                tasks.pop();
                threads.poll();
            } else {
                threads.poll();
            }
        }

        System.out.printf("Thread with value %d killed task %d%n", threads.peek(), tasks.peek());
        threads.forEach(a -> System.out.print(a + " "));
    }
}
