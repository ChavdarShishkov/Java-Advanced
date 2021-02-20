package Java_Advanced_Exam_20_Feb_2021.P02_Bomb;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(reader.readLine());

        String[] tokens = reader.readLine().split(",");

        char[][] matrix = new char[size][size];

        int sapperRowPosition = 0;
        int sapperColPosition = 0;


        for (int row = 0; row < size; row++) {
            String line = reader.readLine().replaceAll(" ", "");
            matrix[row] = line.toCharArray();
            for (int col = 0; col < size; col++) {
                if (matrix[row][col] == 's') {
                    sapperRowPosition = row;
                    sapperColPosition = col;
                }
            }
        }

        int totalBombs = totalBombs(matrix);

        for (String token : tokens) {
            switch (token) {
                case "left":
                    sapperColPosition--;
                    if (sapperColPosition >= 0) {

                        if (matrix[sapperRowPosition][sapperColPosition] == 'B') {
                            matrix[sapperRowPosition][sapperColPosition] = '+';

                            System.out.println("You found a bomb!");
                            totalBombs--;
                        }
                        if (matrix[sapperRowPosition][sapperColPosition] == 'e') {
                            printResult(sapperRowPosition, sapperColPosition, totalBombs);
                            break;
                        }
                    } else {
                        sapperColPosition++;
                    }
                    break;

                case "right":

                    sapperColPosition++;
                    if (sapperColPosition < size) {
                        if (matrix[sapperRowPosition][sapperColPosition] == 'B') {
                            matrix[sapperRowPosition][sapperColPosition] = '+';

                            System.out.println("You found a bomb!");
                            totalBombs--;
                        }
                        if (matrix[sapperRowPosition][sapperColPosition] == 'e') {
                            printResult(sapperRowPosition, sapperColPosition, totalBombs);
                            break;
                        }
                    } else {
                        sapperColPosition--;
                    }
                    break;

                case "up":
                    sapperRowPosition--;
                    if (sapperRowPosition >= 0) {

                        if (matrix[sapperRowPosition][sapperColPosition] == 'B') {
                            matrix[sapperRowPosition][sapperColPosition] = '+';

                            System.out.println("You found a bomb!");
                            totalBombs--;
                        }
                        if (matrix[sapperRowPosition][sapperColPosition] == 'e') {
                            printResult(sapperRowPosition, sapperColPosition, totalBombs);
                            break;
                        }
                    } else {
                        sapperRowPosition++;
                    }
                    break;

                case "down":

                    sapperRowPosition++;
                    if (sapperRowPosition < size) {
                        if (matrix[sapperRowPosition][sapperColPosition] == 'B') {
                            matrix[sapperRowPosition][sapperColPosition] = '+';

                            System.out.println("You found a bomb!");
                            totalBombs--;
                        }
                        if (matrix[sapperRowPosition][sapperColPosition] == 'e') {
                            printResult(sapperRowPosition, sapperColPosition, totalBombs);
                            break;
                        }
                    } else {
                        sapperRowPosition--;
                    }
                    break;
            }
        }
    }

    private static void printResult(int sapperRowPosition, int sapperColPosition, int totalBombs) {
        if (totalBombs > 0) {
            System.out.printf("END! %d bombs left on the field", totalBombs);
        } else if (totalBombs == 0) {
            System.out.println("Congratulations! You found all bombs!");
        } else {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", totalBombs, sapperRowPosition,
                    sapperColPosition);
        }
    }

    private static int totalBombs(char[][] matrix) {
        int bombCounter = 0;
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                if (aChar == 'B') {
                    bombCounter++;
                }
            }
        }
        return bombCounter;
    }

}