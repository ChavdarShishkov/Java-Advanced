package Exercise_06_DefiningClasses.P07_Google;

public class PersonName {
    private String name;

    public PersonName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%s%n", this.name);
    }
}
