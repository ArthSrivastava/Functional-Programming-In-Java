package LambdaExceptionHandling;

import FilterAndForEach.EmployeeExampleDemo.Employee;
import FilterAndForEach.EmployeeExampleDemo.EmployeeDao;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Demo {
    public static void main(String[] args) {
        List<String> strNum = Arrays.asList("123", "45", "xyz");

        //1st method to handle
//        strNum.forEach(s -> {
//            //not recommended -> keep it one liner
//            try {
//                System.out.println(Integer.parseInt(s));
//            } catch (Exception ex) {
//                System.out.println("Exception occurred: " + ex.getMessage());
//            }
//        });

        //2nd method
//        strNum.forEach(Demo::printList);

        //3rd method
//        strNum.forEach(handleExceptionIfAny(s -> System.out.println(Integer.parseInt(s))));

//        strNum.forEach(handleGenericException(s -> System.out.println(Integer.parseInt(s)), NumberFormatException.class));

        //handle checked exception
        List<Integer> list2 = Arrays.asList(10, 20);
//        list2.forEach(i -> {
//            try {
//                Thread.sleep(i);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        });

        //better way
//        list2.forEach(handleCheckedExceptionConsumer(i -> {
//            Thread.sleep(i);
//            System.out.println(i);
//        }));

        //Just for testing out stream debugger plugin
        List<Employee> employees = EmployeeDao.getEmployeeList();
        employees.stream()
                .filter(employee -> employee.getSalary() > 500000)
                .map(employee -> employee.getName())
                .distinct()
                .sorted()
                .limit(2)
                .forEach(System.out::println);
    }

    public static void printList(String s) {
        try {
            System.out.println(Integer.parseInt(s));
        } catch (Exception ex) {
            System.out.println("Exception occurred: " + ex.getMessage());
        }
    }

    public static Consumer<String> handleExceptionIfAny(Consumer<String> payload) {
        return obj -> {
            try {
                System.out.println("obj: " + obj);
                payload.accept(obj);
            }  catch (Exception e) {
                System.out.println("Exception occurred: " + e.getMessage());
            }
        };
    }

    public static <Target, ExObj extends Exception> Consumer<Target> handleGenericException(Consumer<Target> targetConsumer,
                                                                                          Class<ExObj> exObjClass) {
        return obj -> {
            try {
                targetConsumer.accept(obj);
            }  catch (Exception e) {
                try {
                    ExObj exObj = exObjClass.cast(e);
                    System.out.println("exception: " + exObj.getMessage());
                } catch (ClassCastException exception) {
                    throw exception;
                }
            }
        };
    }

    public static <Target> Consumer<Target> handleCheckedExceptionConsumer(
            CheckedExceptionHandlerConsumer<Target, Exception> handlerConsumer
    ) {
        return obj -> {
            try {
                handlerConsumer.accept(obj);
            }  catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }

}
