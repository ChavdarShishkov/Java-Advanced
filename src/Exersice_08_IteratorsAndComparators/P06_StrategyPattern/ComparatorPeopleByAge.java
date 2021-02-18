package Exersice_08_IteratorsAndComparators.P06_StrategyPattern;

import java.util.Comparator;

public class ComparatorPeopleByAge implements Comparator<Person> {

    @Override
    public int compare(Person first, Person second) {
        return first.getAge() - second.getAge();
    }
}
