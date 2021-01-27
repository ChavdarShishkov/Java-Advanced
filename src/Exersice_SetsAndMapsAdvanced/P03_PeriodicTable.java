package Exersice_SetsAndMapsAdvanced;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P03_PeriodicTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        Set<String> elements = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().split("\\s+");
            elements.addAll(Arrays.asList(tokens));
        }
        for (String element : elements) {
            System.out.print(element + " ");
        }
    }
}
