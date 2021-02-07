package Exercise_06_DefiningClasses.P07_Google;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String inputs = reader.readLine();
        while (!inputs.equals("End")) {
            String[] tokens = inputs.split("\\s+");

            List<Company> companies = new ArrayList<>();
            List<Pokemon> pokemons = new ArrayList<>();
            List<Parents> parents = new ArrayList<>();
            List<Children> children = new ArrayList<>();
            List<Car> cars = new ArrayList<>();


            switch (tokens[1]) {
                case "company":
                    companies.add(new Company(tokens[0], tokens[2], tokens[3], Double.parseDouble(tokens[4])));
                    boolean contains = companies.stream().anyMatch(o->o.getName())
                    break;
                case "pokemon":
                    pokemons.add(new Pokemon(tokens[0], tokens[2], tokens[3]));
                    break;
                case "parents":
                    parents.add(new Parents(tokens[0], tokens[2], tokens[3]));
                    break;
                case "children":
                    children.add(new Children(tokens[0], tokens[2], tokens[3]));
                    break;
                case "car":
                    cars.add(new Car(tokens[0], tokens[2], tokens[3]));
                    break;
            }
            inputs = reader.readLine();
        }
        String search = reader.readLine();
    }
}
