package Java_Advanced_Exam_28_June_2020.P02_Snake;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(reader.readLine());

        char[][] matrix = new char[size][size];

        int snakeRowPosition = 0;
        int snakeColPosition = 0;
        int snakeLength = 1;
        int foodCounter = 0;

        for (int row = 0; row < size; row++) {
            matrix[row] = reader.readLine().toCharArray();
            for (int col = 0; col < size; col++) {
                if (matrix[row][col] == 'S') {
                    snakeRowPosition = row;
                    snakeColPosition = col;
                }
            }
        }

        while (true) {
            String commands = reader.readLine();
            matrix[snakeRowPosition][snakeColPosition] = '.';
            switch (commands) {
                case "up":
                    snakeRowPosition--;
                    if (snakeRowPosition >= 0) {
                        if (matrix[snakeRowPosition][snakeColPosition] == '*') {
                            foodCounter++;
                        } else if (matrix[snakeRowPosition][snakeColPosition] == 'B') {
                            matrix[snakeRowPosition][snakeColPosition] = '.';
                            for (int rows = 0; rows < size; rows++) {
                                for (int cols = 0; cols < size; cols++) {
                                    if (matrix[rows][cols] == 'B') {
                                        snakeRowPosition = rows;
                                        snakeColPosition = cols;
                                    }
                                }
                            }
                        }
                    } else {
                        System.out.println("Game over!");
                        break;
                    }
                    break;

                case "down":
                    snakeRowPosition++;
                    if (snakeRowPosition < size) {
                        if (matrix[snakeRowPosition][snakeColPosition] == '*') {
                            foodCounter++;
                        } else if (matrix[snakeRowPosition][snakeColPosition] == 'B') {
                            matrix[snakeRowPosition][snakeColPosition] = '.';
                            for (int rows = 0; rows < size; rows++) {
                                for (int cols = 0; cols < size; cols++) {
                                    if (matrix[rows][cols] == 'B') {
                                        snakeRowPosition = rows;
                                        snakeColPosition = cols;
                                    }
                                }
                            }
                        }
                    } else {
                        System.out.println("Game over!");
                        break;
                    }
                    break;
                case "left":
                    snakeColPosition--;
                    if (snakeColPosition >= 0) {
                        if (matrix[snakeRowPosition][snakeColPosition] == '*') {
                            foodCounter++;
                        } else if (matrix[snakeRowPosition][snakeColPosition] == 'B') {
                            matrix[snakeRowPosition][snakeColPosition] = '.';
                            for (int rows = 0; rows < size; rows++) {
                                for (int cols = 0; cols < size; cols++) {
                                    if (matrix[rows][cols] == 'B') {
                                        snakeRowPosition = rows;
                                        snakeColPosition = cols;
                                    }
                                }
                            }
                        }
                    } else {
                        System.out.println("Game over!");
                        break;
                    }
                    break;
                case "right":
                    snakeColPosition++;
                    if (snakeColPosition < size) {
                        if (matrix[snakeRowPosition][snakeColPosition] == '*') {
                            foodCounter++;
                        } else if (matrix[snakeRowPosition][snakeColPosition] == 'B') {
                            matrix[snakeRowPosition][snakeColPosition] = '.';
                            for (int rows = 0; rows < size; rows++) {
                                for (int cols = 0; cols < size; cols++) {
                                    if (matrix[rows][cols] == 'B') {
                                        snakeRowPosition = rows;
                                        snakeColPosition = cols;
                                    }
                                }
                            }
                        }
                    } else {
                        System.out.println("Game over!");
                        break;
                    }
                    break;
            }
            if (foodCounter == 10) {
                System.out.println("You won! You fed the snake.");
                matrix[snakeRowPosition][snakeColPosition] = 'S';
                break;
            }
        }
        System.out.println("Food eaten: " + foodCounter);

        for (int rows = 0; rows < size; rows++) {
            for (int cols = 0; cols < size; cols++) {
                System.out.print(matrix[rows][cols]);
            }
            System.out.println();
        }
    }
}



