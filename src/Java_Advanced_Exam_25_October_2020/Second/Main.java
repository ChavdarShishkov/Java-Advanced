package Java_Advanced_Exam_25_October_2020.Second;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] rowsCols = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int rows = rowsCols[0];
        int cols = rowsCols[1];

        int[][] matrix = new int[rows][cols];

        String input = reader.readLine();
        while (!input.equals("Bloom Bloom Plow")) {

            int[] tokens = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();

            int rowValue = tokens[0];
            int colValue = tokens[1];

            if (isInRange(rows, cols, rowValue, colValue)) {

                bloomVertical(matrix, colValue);
                bloomHorizontal(matrix, rowValue, colValue);
            }

            input = reader.readLine();
        }
        printMatrix(matrix);
    }

    private static void bloomHorizontal(int[][] matrix, int rowValue, int colValue) {
        for (int col = 0; col < matrix[rowValue].length; col++) {
            if (col != colValue) {
                matrix[rowValue][col]++;
            }
        }
    }

    private static void bloomVertical(int[][] matrix, int colValue) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row][colValue]++;
        }
    }

    private static boolean isInRange(int rows, int cols, int rowValue, int colValue) {
        if (rowValue > rows || colValue > cols) {
            System.out.println("Invalid coordinates.");
            return false;
        }
        return true;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] rows : matrix) {
            for (int cols : rows) {
                System.out.print(cols + " ");
            }
            System.out.println();
        }
    }
}
