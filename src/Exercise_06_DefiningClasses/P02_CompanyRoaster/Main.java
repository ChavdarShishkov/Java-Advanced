package Exercise_06_DefiningClasses.P02_CompanyRoaster;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        var reader = new BufferedReader(new InputStreamReader(System.in));

        List<Employee> employees = new ArrayList<>();

        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split("\\s+");

            Employee employee = new Employee();

            employee.setName(input[0]);
            employee.setSalary(Double.parseDouble(input[1]));
            employee.setPosition(input[2]);
            employee.setDepartment(input[3]);

            switch (input.length) {
                case 5:
                    if (input[4].contains("@")) {
                        employee.setEmail(input[4]);
                    } else {
                        employee.setAge(Integer.parseInt(input[4]));
                    }
                    break;
                case 6:
                    if (input[4].contains("@")) {
                        employee.setEmail(input[4]);
                        employee.setAge(Integer.parseInt(input[5]));
                    } else {
                        employee.setAge(Integer.parseInt(input[4]));
                        employee.setEmail(input[5]);
                    }
                    break;
            }

            employees.add(employee);
        }

        List<String> departmentsList =
                employees.stream().map(Employee::getDepartment).distinct().collect(Collectors.toList());

        List<Department> departments = new ArrayList<>();
        for (String department : departmentsList) {
            departments.add(new Department(department,
                    employees.stream().filter(employee -> employee.getDepartment().equals(department)).collect(Collectors.toList())));
        }

        departments.sort(Comparator.comparingDouble(Department::getAvgSalary).reversed());
        Department department = departments.get(0);
        department.getEmployee().sort(Comparator.comparingDouble(Employee::getSalary).reversed());

        System.out.printf("Highest Average Salary: %s%n", department.getName());
        for (Employee employee : department.getEmployee()) {
            System.out.printf("%s %.2f %s %d%n", employee.getName(), employee.getSalary(), employee.getEmail(),
                    employee.getAge());
        }

    }
}
