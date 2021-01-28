package Exersice_02_MultidimentionalArrays;

import java.util.Scanner;

public class P03_DiagonalDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        int[][] matrix = new int[n][n];

        int firstSum = 0;
        int secondSum = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                matrix[row][col] = sc.nextInt();
                if (row == col) {
                    firstSum += matrix[row][col];
                }
                if ((row + col) == n - 1) {
                    secondSum += matrix[row][col];
                }
            }
        }

        System.out.println(Math.abs(firstSum - secondSum));

    }
}
