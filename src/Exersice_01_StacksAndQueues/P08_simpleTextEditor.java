package Exersice_01_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P08_simpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String text = "";

        ArrayDeque<String> history = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            String[] cmd = scanner.nextLine().split(" ");

            switch (cmd[0]) {
                case "1":
                    history.push(text);
                    text += cmd[1];
                    break;
                case "2":
                    history.push(text);
                    int count = Integer.parseInt(cmd[1]);
                    for (int j = 0; j < count; j++) {

                        text = text.substring(0, text.length() - 1);
                    }
                    break;
                case "3":
                    int index = Integer.parseInt(cmd[1]);
                    try {
                        System.out.println(text.charAt(index - 1));
                    } catch (Exception e) {

                    }
                    break;
                case "4":
                    text = history.pop();
                    break;
            }
        }
    }
}
