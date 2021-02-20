package Java_Advanced_Exam_26_Oct_2019.P01_DatingApp;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String[] malesInput = scanner.nextLine().split("\\s+");
        String[] femalesInput = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> maleQueue = new ArrayDeque<>();
        ArrayDeque<Integer> femaleStack = new ArrayDeque<>();

        int matches = 0;

        for (int i = malesInput.length - 1; i >= 0; i--) {
            maleQueue.add(Integer.parseInt(malesInput[i]));
        }

        for (int i = femalesInput.length - 1; i >= 0; i--) {
            femaleStack.push(Integer.parseInt(femalesInput[i]));
        }

        while (maleQueue.size() > 0 && femaleStack.size() > 0) {

            int male = maleQueue.peek();
            int female = femaleStack.peek();

            if (male > 0 && female > 0) {
                if (male % 25 == 0 || female % 25 == 0) {

                    if (male % 25 == 0) {
                        if (maleQueue.size() > 1) {
                            maleQueue.remove();
                            maleQueue.remove();
                        } else {
                            maleQueue.remove();
                        }
                    }

                    if (female % 25 == 0) {
                        if (femaleStack.size() > 1) {
                            femaleStack.pop();
                            femaleStack.pop();
                        } else {
                            femaleStack.pop();
                        }
                    }
                    continue;
                }
            }

            if (male <= 0 || female <= 0) {

                if (male <= 0) {
                    maleQueue.remove();
                }
                if (female <= 0) {
                    femaleStack.pop();
                }
                continue;
            }

            if (male == female) {
                matches++;
                maleQueue.remove();
                femaleStack.pop();
            } else {
                femaleStack.pop();
                male -= 2;
                maleQueue.remove();

                ArrayDeque<Integer> setQueue = new ArrayDeque<>();
                setQueue.add(male);
                for (int i = 0; i < maleQueue.size(); i++) {
                    int current = maleQueue.remove();
                    setQueue.add(current);
                    i--;
                }
                maleQueue = setQueue;
            }
        }

        System.out.println("Matches: " + matches);

        System.out.println("Males left: " + getElementsInfo(maleQueue));
        System.out.println("Females left: " + getElementsInfo(femaleStack));

    }

    private static String getElementsInfo(ArrayDeque<Integer> deque) {
        return deque.isEmpty() ? "none" : deque.stream().map(String::valueOf).collect(Collectors.joining(", "));
    }
}