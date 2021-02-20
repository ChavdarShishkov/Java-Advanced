package Java_Advanced_Exam_20_Feb_2021.P01_MagicBox;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> firstBox =
                Arrays.stream(reader.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> secondBox = new ArrayDeque<>();
        Arrays.stream(reader.readLine().split("\\s+")).map(Integer::parseInt).forEach(secondBox::push);

        int claimedItems = 0;

        while (!firstBox.isEmpty() && !secondBox.isEmpty()) {
            int first = firstBox.peek();
            int second = secondBox.peek();

            int total = first + second;
            if (!(total % 2 == 0)) {

                firstBox.offerLast(secondBox.pop());
            } else {
                firstBox.poll();
                secondBox.pop();
                claimedItems += total;
            }
        }
        if (firstBox.isEmpty()) {
            System.out.println("First magic box is empty.");
        } else {
            System.out.println("Second magic box is empty.");
        }
        if (claimedItems >= 90) {
            System.out.println("Wow, your prey was epic! Value: " + claimedItems);
        } else {
            System.out.println("Poor prey... Value: " + claimedItems);
        }
    }
}
