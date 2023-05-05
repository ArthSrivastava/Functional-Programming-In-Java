package FilterAndForEach.EmployeeExampleDemo;

import java.util.List;

public class EmployeeService {
    public static List<Employee> evaluateTaxPayers(String input) {
        return (input.equalsIgnoreCase("tax"))
                ? (
                EmployeeDao.getEmployeeList().stream()
                        .filter(employee -> employee.getSalary() > 500000)
                        .toList()
        ) : (
                EmployeeDao.getEmployeeList().stream()
                        .filter(employee -> employee.getSalary() <= 500000)
                        .toList()
        );
    }

    public static void main(String[] args) {
        System.out.println(evaluateTaxPayers("non-tax"));
    }
}
