package StreamSort;

import FilterAndForEach.EmployeeExampleDemo.Employee;

import java.util.*;

public class SortMap {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("five", 5);
        map.put("nine", 9);
        map.put("three", 3);
        map.put("four", 4);

        //Traditional way
        List<Map.Entry<String, Integer>> entries =
                new ArrayList<>(map.entrySet());
//        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
//            @Override
//            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
//                return o1.getValue().compareTo(o2.getValue());
//            }
//        });


        //Lambda
//        Collections.sort(entries, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));
//
//        for(Map.Entry<String, Integer> entry: entries) {
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        }

        //Stream
            //By key
//        map.entrySet().stream()
//                .sorted(Map.Entry.comparingByKey())
//                .forEach(System.out::println);
//        System.out.println("+++++++++++++++++++++++++++++++++");
//            //By value
//        map.entrySet().stream()
//                .sorted(Map.Entry.comparingByValue())
//                .forEach(System.out::println);

        Map<Employee, Integer> employeesMap = new TreeMap<>((e1, e2) -> e1.getSalary() - e2.getSalary());
        employeesMap.put(new Employee(1, "E1", "CSE", "B", 500000), 200);
        employeesMap.put(new Employee(2, "E2", "CS", "A", 400000), 60);
        employeesMap.put(new Employee(3, "E3", "IT", "A", 600000), 90);
        employeesMap.put(new Employee(4, "E4", "CSIT", "C", 800000), 10);
        employeesMap.put(new Employee(5, "E5", "ECE","D", 1200000), 70);
//        System.out.println(employeesMap);

//        employeesMap.entrySet()
//                .stream()
//                .sorted((entry1, entry2) -> entry1.getKey().getDept().compareTo(entry2.getKey().getDept()))
//                .forEach(System.out::println);
        //Or
        employeesMap.entrySet()
                .stream()
                .sorted(Comparator.comparing(entry -> entry.getKey().getDept()))
                .forEach(System.out::println);


    }
}
