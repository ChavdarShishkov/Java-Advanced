package Exercise_03_SetsAndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01_UniqueUsernames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<String> uniqueNames = new LinkedHashSet<>();

        int n = Integer.parseInt(sc.nextLine());
        while (n-- > 0) {
            String name = sc.nextLine();
            uniqueNames.add(name);
        }
        for (String name : uniqueNames) {
            System.out.println(name);
        }
    }
}
