package Exercise_06_DefiningClasses.P07_Google;

public class Children extends PersonName {
    private String childName;
    private String childBirthday;

    public Children(String name, String childName, String childBirthday) {
        super(name);
        this.childName = childName;
        this.childBirthday = childBirthday;
    }
}
