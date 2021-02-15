package Java_Advanced_Exam_25_October_2020.P01_SchegulingProblem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> tasks = new ArrayDeque<>();
        Arrays.stream(reader.readLine().split(",\\s+")).map(Integer::parseInt).forEach(tasks::push);

        ArrayDeque<Integer> threads =
                Arrays.stream(reader.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        int taskToKill = Integer.parseInt(reader.readLine());

        while (tasks.peek() != taskToKill) {
            int currentThread = threads.peekFirst();
            int currentTask = tasks.peekFirst();

            if (currentThread >= currentTask) {
                tasks.poll();
                threads.pop();
            } else {
                threads.pop();
            }
        }

        System.out.printf("Thread with value %d killed task %d%n", threads.peek(), tasks.peek());
        threads.forEach(a -> System.out.print(a + " "));
    }
}
