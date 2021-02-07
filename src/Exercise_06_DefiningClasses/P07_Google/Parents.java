package Exercise_06_DefiningClasses.P07_Google;

public class Parents extends PersonName{
    private String parentName;
    private String parentBirthday;

    public Parents(String name, String parentName, String parentBirthday) {
        super(name);
        this.parentName = parentName;
        this.parentBirthday = parentBirthday;
    }
}
