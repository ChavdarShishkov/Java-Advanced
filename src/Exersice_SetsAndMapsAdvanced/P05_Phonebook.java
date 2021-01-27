package Exersice_SetsAndMapsAdvanced;

import java.util.HashMap;
import java.util.Scanner;

public class P05_Phonebook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<String, String> phonebook = new HashMap<>();

        String input = sc.nextLine();

        while (!input.equals("search")) {
            String[] tokens = input.split("-");
            if (!phonebook.containsKey(tokens[0])) {
                phonebook.put(tokens[0], tokens[1]);
            } else {
                phonebook.put(phonebook.get(tokens[0]), tokens[1]);
            }
            input = sc.nextLine();
        }
        String input2 = sc.nextLine();

        while (!input2.equals("stop")) {

            if (!phonebook.containsKey(input2)) {
                System.out.println("Contact " + input2 + " does not exist.");
            } else {
                System.out.println(input2 + " -> " + phonebook.get(input2));
            }
            input2 = sc.nextLine();
        }
    }
}
