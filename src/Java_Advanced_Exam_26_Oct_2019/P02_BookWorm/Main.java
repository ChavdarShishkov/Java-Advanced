package Java_Advanced_Exam_26_Oct_2019.P02_BookWorm;

import java.util.Scanner;

public class Main {
    public static int playerRow = 0;
    public static int playerCol = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder initialString = new StringBuilder(sc.nextLine());
        int sizeSquareM = Integer.parseInt(sc.nextLine());

        String[][] matrix = new String[sizeSquareM][sizeSquareM];

        readMatrix(matrix, sc);

        String powerBook;
        while (!(powerBook = sc.nextLine()).equals("end")) {
            switch (powerBook) {
                case "up":
                    matrix[playerRow][playerCol] = "-";
                    int A = playerRow;
                    int B = playerCol;
                    playerRow -= 1;
                    initialString = getStringBuilder(initialString, matrix, A, B);
                    break;
                case "down":
                    matrix[playerRow][playerCol] = "-";
                    int A1 = playerRow;
                    int B1 = playerCol;
                    playerRow += 1;
                    initialString = getStringBuilder(initialString, matrix, A1, B1);
                    break;
                case "left":
                    matrix[playerRow][playerCol] = "-";
                    int A2 = playerRow;
                    int B2 = playerCol;
                    playerCol -= 1;
                    initialString = getStringBuilder(initialString, matrix, A2, B2);
                    break;
                case "right":
                    matrix[playerRow][playerCol] = "-";
                    int A3 = playerRow;
                    int B3 = playerCol;
                    playerCol += 1;
                    initialString = getStringBuilder(initialString, matrix, A3, B3);
                    break;
            }
        }

        System.out.println(initialString);
        printMatrix(matrix);
    }

    private static StringBuilder getStringBuilder(StringBuilder initialString, String[][] matrix, int a, int b) {
        if (checkIndex(matrix, playerRow, playerCol)) {
            if (!matrix[playerRow][playerCol].equals("-")) {
                String toAdd = matrix[playerRow][playerCol];
                initialString.append(toAdd);
            }
            matrix[playerRow][playerCol] = "P";
        } else {
            if (initialString.length() > 0) {
                int end = initialString.length() - 1;
                initialString = new StringBuilder(initialString.substring(0, end));
                matrix[a][b] = "P";
            }
        }
        return initialString;
    }

    private static void readMatrix(String[][] matrix, Scanner scanner) {
        for (int r = 0; r < matrix.length; r++) {
            String input = scanner.nextLine();
            for (int c = 0; c < matrix[r].length; c++) {
                matrix[r][c] = input.charAt(c) + "";
                if (matrix[r][c].equals("P")) {
                    playerRow = r;
                    playerCol = c;
                    matrix[r][c] = "-";
                }
            }
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.print(string + "");
            }
            System.out.println();
        }
    }

    private static boolean checkIndex(String[][] matrix, int a, int b) {
        return a >= 0 && a < matrix.length && b >= 0 && b < matrix[a].length;
    }
}

