package StreamSort;

import FilterAndForEach.EmployeeExampleDemo.Employee;
import FilterAndForEach.EmployeeExampleDemo.EmployeeDao;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortList {
    public static void main(String[] args) {
        List<Employee> list = EmployeeDao.getEmployeeList();

        //Traditional way
//        Collections.sort(list, (e1, e2) -> e1.getSalary() - e2.getSalary());
        System.out.println(list);
//        list.stream()
//                .sorted((e1, e2) -> e1.getSalary() - e2.getSalary())
//                        .forEach(System.out::println);
//        list.stream()
//                .sorted(Comparator.comparing(employee -> employee.getSalary()))
//                .forEach(System.out::println);
        list.stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .forEach(System.out::println);
    }
}
