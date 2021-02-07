package Exercise_06_DefiningClasses.P09_CatLady;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Cat> cats = new HashMap<>();

        String input = reader.readLine();
        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");

            String type = tokens[0];
            String name = tokens[1];
            double attribute = Double.parseDouble(tokens[2]);

            switch (type) {

                case "Siamese":
                    Siamese siamese = new Siamese(name, type, attribute);
                    cats.put(name, siamese);
                    break;

                case "Cymric":
                    Cymric cymric = new Cymric(name, type, attribute);
                    cats.put(name, cymric);
                    break;

                case "StreetExtraordinaire":
                    StreetExtraordinaire streetExtraordinaire = new StreetExtraordinaire(name, type, attribute);
                    cats.put(name, streetExtraordinaire);
                    break;
            }
            input = reader.readLine();
        }
        String info = reader.readLine();
        System.out.println(cats.get(info).toString());

    }
}
