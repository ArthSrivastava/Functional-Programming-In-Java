package FilterAndForEach.EmployeeExampleDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EmployeeDao {
    public static List<Employee> getEmployeeList() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "E1", "CSE", "B", 500000));
        employees.add(new Employee(2, "E2", "CS", "A", 400000));
        employees.add(new Employee(3, "E3", "IT", "A", 600000));
        employees.add(new Employee(4, "E4", "CSIT", "C", 800000));
        employees.add(new Employee(5, "E5", "ECE","D", 1200000));
        return employees;
    }

    public static List<Employee> getThousandEmployees() {
        List<Employee> employees = new ArrayList<>();
        for(int i = 1; i <= 1000; i++) {
            employees.add(new Employee(i, "E" + i, "CSE", "A", (int)(Math.random()*20000)));
        }
        return employees;
    }
}
