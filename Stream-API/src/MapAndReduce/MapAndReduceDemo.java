package MapAndReduce;

import FilterAndForEach.EmployeeExampleDemo.EmployeeDao;

import java.util.Arrays;
import java.util.List;

public class MapAndReduceDemo {
    public static void main(String[] args) {
//        List<Integer> numbers =
//                Arrays.asList(3, 7, 23, 6, 14);
//        int sum = numbers
//                .stream()
//                .mapToInt(i -> i)
//                .sum();
//        System.out.println(sum);
//        Integer reduceSum = numbers.stream()
//                .reduce(
//                        0,
//                        (a, b) -> a + b
//                );
//        System.out.println(reduceSum);
//
//        Integer maxMarks = numbers.stream()
//                .reduce(0, (a, b) -> a > b ? a : b);
//        System.out.println(maxMarks);
//
//        List<String> words = Arrays.asList("corejava", "spring", "hibernate");
//        String s = words.stream()
//                .reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2)
//                .get();
//        System.out.println(s);

        //get employee with grade A
        //get salary
        double avgSalary = EmployeeDao
                .getEmployeeList()
                .stream()
                .filter(
                        employee -> employee.getGrade().equalsIgnoreCase("A")
                )
                .map(employee -> employee.getSalary())
                .mapToDouble(integer -> integer)
                .average().getAsDouble();
        System.out.println(avgSalary);

    }
}
