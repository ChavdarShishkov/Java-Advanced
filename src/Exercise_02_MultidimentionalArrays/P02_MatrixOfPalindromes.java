package Exercise_02_MultidimentionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class P02_MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] tokens = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        char a = 'a', b = 'a';

        char[][] matrix = new char[tokens[0]][tokens[1]];

        for (int row = 0; row < tokens[0]; row++) {
            for (int col = 0; col < tokens[1]; col++) {
                System.out.printf("%c%c%c ", a, b, a);
                b++;
            }
            System.out.println();
            a++;
            b = a;
        }
    }
}
