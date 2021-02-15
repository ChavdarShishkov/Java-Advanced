package Java_Advanced_Exam_28_June_2020.P02_second;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(reader.readLine());

        char[][] matrix = new char[size][size];

        String[] commands = reader.readLine().split(",\\s+");

        int snakePositionRow = 0;
        int snakePositionCol = 0;
        int snakeLength = 1;
        int foodCount = 0;

        for (int i = 0; i < size; i++) {
            matrix[i] = reader.readLine().toCharArray();
        }

        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] x : matrix) {
            for (int y : x) {
                System.out.print((char) y + " ");
            }
            System.out.println();
        }
    }
}
