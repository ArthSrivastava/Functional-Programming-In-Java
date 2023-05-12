package MethodReferences;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class EmployeeDao {

    public List<Employee> getEmployees() {
        return IntStream
                .rangeClosed(1, 10)
                .mapToObj(i -> new Employee(
                        i,
                        "emp" + i,
                        "dept" + i,
                        "Grade:" + i,
                        (int) (Math.random() * 2000)
                )).toList();
    }
}
