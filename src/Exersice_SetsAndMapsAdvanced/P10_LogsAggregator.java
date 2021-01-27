package Exersice_SetsAndMapsAdvanced;

import java.util.Scanner;
import java.util.TreeMap;

public class P10_LogsAggregator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        TreeMap<String, TreeMap<String, Integer>> logs = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(" ");

            String ip = input[0];


            String name = input[1];
            int dur = Integer.parseInt(input[2]);
            if (!logs.containsKey(name)) {
                logs.put(name, new TreeMap<>());
                logs.get(name).put(ip, dur);

            } else {
                if ((!logs.get(name).containsKey(ip))) {
                    logs.get(name).put(ip, dur);
                } else {

                }
            }
        }

        int sum = 0;

        for (String name : logs.keySet()) {
            System.out.print(name + ": ");

            for (int dur : logs.get(name).values()) {
                sum += dur;
            }
            System.out.print(sum + " ");
            System.out.println(logs.get(name).keySet());
        }
    }
}
