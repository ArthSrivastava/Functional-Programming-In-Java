package ParallelStream;

import FilterAndForEach.EmployeeExampleDemo.Employee;
import FilterAndForEach.EmployeeExampleDemo.EmployeeDao;

import java.util.List;
import java.util.stream.IntStream;

public class ParallelStreamDemo {
    public static void main(String[] args) {
        long start = 0;
        long end = 0;
//        start = System.currentTimeMillis();
//        IntStream.range(1, 100).forEach(System.out::println);
//        end = System.currentTimeMillis();
//        System.out.println("Normal stream took time: " + (end - start));
//
//        System.out.println("+++++++++++++++++++++++++++++++++++++");
//        start = System.currentTimeMillis();
//        IntStream.range(1, 100).parallel().forEach(System.out::println);
//        end = System.currentTimeMillis();
//        System.out.println("Parallel stream took time: " + (end - start));

//        IntStream.range(1, 10).forEach(x -> {
//            System.out.println("Normal Stream Thread: " + Thread.currentThread().getName() + " : " + x);
//        });
//
//        IntStream.range(1, 10).parallel().forEach(x -> {
//            System.out.println("Parallel Stream Thread: " + Thread.currentThread().getName() + " : " + x);
//        });

        List<Employee> thousandEmployees = EmployeeDao.getThousandEmployees();

        //normal stream
        start = System.currentTimeMillis();
        double avgNormalSalary = thousandEmployees.stream()
                .map(Employee::getSalary)
                .mapToDouble(integer -> integer)
                .average()
                .getAsDouble();
        end = System.currentTimeMillis();
        System.out.println("Normal stream execution time:" + (end - start) + " avg sal:" + avgNormalSalary);

        start = System.currentTimeMillis();
        double avgParallelSalary = thousandEmployees.parallelStream()
                .map(Employee::getSalary)
                .mapToDouble(integer -> integer)
                .average()
                .getAsDouble();
        end = System.currentTimeMillis();
        System.out.println("Parallel stream execution time:" + (end - start) + " avg salary:" + avgParallelSalary);
    }
}
