package Exersice_08_IteratorsAndComparators.P03_StackIterator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        CustomStack customStack = new CustomStack();
        String[] initialValues = reader.readLine().split(",\\s+");


        customStack.push(Integer.parseInt(initialValues[0].split("\\s+")[1]));

        for (int i = 1; i < initialValues.length; i++) {
            customStack.push(Integer.parseInt(initialValues[i].trim()));
        }

        String line = "";
        while (!"END".equals(line = reader.readLine())) {
            if (line.equals("Pop")) {
                try {
                    customStack.pop();
                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                customStack.push(Integer.parseInt(line.split("\\s+")[1]));
            }
        }
        for (int i = 0; i < 2; i++) {
            for (Integer integer : customStack) {
                System.out.println(integer);
            }
        }
    }
}
