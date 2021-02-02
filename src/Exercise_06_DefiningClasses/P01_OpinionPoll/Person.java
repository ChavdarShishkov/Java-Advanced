package Exercise_06_DefiningClasses.P01_OpinionPoll;

public class Person {
    private String name;
    private int Age;

    public Person(String name, int age) {
        this.name = name;
        Age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    @Override
    public String toString() {
        return String.format("%s - %d", getName(), getAge());
    }
}
