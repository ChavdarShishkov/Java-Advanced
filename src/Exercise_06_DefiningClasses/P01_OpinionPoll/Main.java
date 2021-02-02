package Exercise_06_DefiningClasses.P01_OpinionPoll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        ArrayList<Person> people = new ArrayList<>();

        while (n-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            Person person = new Person(name, age);
            people.add(person);
        }
        people.stream().filter(p -> p.getAge() > 30).sorted(Comparator.comparing(Person::getName)).forEach(p1 -> System.out.println(p1.toString()));
    }
}
