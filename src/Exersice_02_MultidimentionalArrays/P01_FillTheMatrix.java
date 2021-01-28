package Exersice_02_MultidimentionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class P01_FillTheMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] tokens = Arrays.stream(sc.nextLine().split(", ")).toArray(String[]::new);

        int size = Integer.parseInt(tokens[0]);

        String pattern = tokens[1];

        int[][] matrix = new int[size][size];

        int i = 1;
        if (pattern.equals("A")) {
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[col][row] = i;
                    i++;

                }
            }
        }
        if (pattern.equals("B")) {
            for (int row = 0; row < size; row++) {
                if (row % 2 == 0) {
                    for (int col = 0; col < size; col++) {
                        matrix[col][row] = i;
                        i++;
                    }
                } else {
                    for (int col = size - 1; col >= 0; col--) {
                        matrix[col][row] = i;
                        i++;

                    }
                }
            }

        }

        for (int j = 0; j < size; j++) {
            for (int k = 0; k < size; k++) {
                System.out.print(matrix[j][k] + " ");
            }
            System.out.println();
        }
    }
}
