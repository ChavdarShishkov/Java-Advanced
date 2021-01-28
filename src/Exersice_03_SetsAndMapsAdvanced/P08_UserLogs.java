package Exersice_03_SetsAndMapsAdvanced;

import java.util.*;

public class P08_UserLogs {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String line = console.nextLine();

        TreeMap<String, LinkedHashMap<String, Integer>> result = new TreeMap<>();

        while (!line.equals("end")) {

            String[] input = line.split(" ");
            String ip = input[0].split("=")[1];
            String user = input[2].split("=")[1];

            if (!result.containsKey(user)) {
                result.put(user, new LinkedHashMap<>());
            }
            if (!result.get(user).containsKey(ip)) {
                result.get(user).put(ip, 0);
            }
            result.get(user).put(ip, result.get(user).get(ip) + 1);

            line = console.nextLine();
        }
        for (Map.Entry<String, LinkedHashMap<String, Integer>> user : result.entrySet()) {

            List<String> ipRow = new ArrayList<>();

            System.out.printf("%s:%n", user.getKey());

            for (Map.Entry<String, Integer> entry : user.getValue().entrySet()) {
                ipRow.add(entry.getKey() + " => " + entry.getValue());
            }
            System.out.print(String.join(", ", ipRow));
            if (ipRow.size() > 0) {
                System.out.println(".");
            }
        }
    }
}
