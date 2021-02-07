package Exercise_06_DefiningClasses.P07_Google;

public class Company extends PersonName {
    private String companyName;
    private String department;
    private double salary;

    public Company(String name, String companyName, String department, double salary) {
        super(name);
        this.companyName = companyName;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%s %s %.2f%n",this.companyName,this.department,this.salary);
    }
}
