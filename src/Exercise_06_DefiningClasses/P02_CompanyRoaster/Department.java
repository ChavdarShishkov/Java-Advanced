package Exercise_06_DefiningClasses.P02_CompanyRoaster;

import java.util.List;

public class Department {
    private String name;
    private List<Employee> employee;
    private double avgSalary;

    Department(String name, List<Employee> employee) {
        this.name = name;
        this.employee = employee;
        this.avgSalary = employee.stream().mapToDouble(Employee::getSalary).average().getAsDouble();
    }

    double getAvgSalary() {
        return avgSalary;
    }

    String getName() {
        return name;
    }

    List<Employee> getEmployee() {
        return employee;
    }
}
