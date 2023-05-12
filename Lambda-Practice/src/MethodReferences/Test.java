package MethodReferences;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Test {
    public static void m2() {
        System.out.println("Static method");
    }

    public void m1() {
        System.out.println("Instance method");
    }

    public static void main(String[] args) {
        Test.m2();
        //Static method reference
        //Test::m2;

        Test test = new Test();
        test.m1();
        //instance method reference
        //test::m1;
        EmployeeDao employeeDao = new EmployeeDao();
/*
        //Anonymous implementation
        employeeDao.getEmployees()
                .forEach(new Consumer<Employee>() {
                    @Override
                    public void accept(Employee employee) {
                        System.out.println(employee);
                    }
                });

        System.out.println("++++++++++++++++++++++++");
        //converting to lambdas
        employeeDao.getEmployees()
                .forEach((employee) -> {
                    System.out.println(employee);
                });

        System.out.println("++++++++++++++++++++++++");

        //Custom method reference
        employeeDao.getEmployees()
                .forEach(Test::print);

        System.out.println("++++++++++++++++++++++++");
        //Already defined class reference
        employeeDao.getEmployees()
                .forEach(System.out::println);*/

        /*//Anonymous implementation
        List<EmployeeDO> employeeDOList = employeeDao.getEmployees()
                .stream()
                .map(new Function<Employee, EmployeeDO>() {
                    @Override
                    public EmployeeDO apply(Employee employee) {
                        return EmployeeMapper.convert(employee);
                    }
                }).toList();
        System.out.println(employeeDOList);

        //Lambda implementation
        System.out.println(
                employeeDao.getEmployees()
                .stream()
                .map(employee -> EmployeeMapper.convert(employee))
                .toList()
                );

        //method reference
        //if non-static method then use EmployeeMapper object for method reference
        System.out.println(
                employeeDao.getEmployees()
                        .stream()
                        .map(EmployeeMapper::convert)
                        .toList()
        );*/

        //Very important concept
        List<String> nameList = employeeDao.getEmployees()
                .stream()
                .map(Employee::getName) //We can use getName here without Employee object as static
                                        //reference because getName() method contains no arguments
                                        //and hence it can be used as static method references in
                                        //stream api
                .toList();
        System.out.println(nameList);

        //reference: constructor -> new
        //if we have a functional interface which has an abstract method which returns an object
        //and that object we need then we go for constructor method reference

        //lambda
        EmployeeManager manager = () -> new Employee();
        manager.getEmployee().getEmployeeInfo();

        EmployeeManager manager1 = Employee::new;
        manager1.getEmployee().getEmployeeInfo();

        List<ArrayList<Object>> list = employeeDao.getEmployees()
                .stream()
                .map(Employee::getId)
                .map(ArrayList::new).collect(Collectors.toList());
        System.out.println(list);
    }

    public static void print(Employee employee) {
        System.out.println(employee);
    }
}
