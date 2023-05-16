package InterviewQuestions;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
public class Main {
    public static void main(String[] args) {
        String s = "ilovejavatechie";

        //Count occurrence of each character in the string
        Map<String, Long> occurrenceMap = Arrays.stream(s.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(occurrenceMap);

        //Find all duplicate elements in a string
        List<String> duplicateList = Arrays.stream(s.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();
        System.out.println(duplicateList);

        //Find first non-repeat element from a string
        String firstNonRepeat = Arrays.stream(s.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream().filter(
                        e -> e.getValue() == 1
                ).findFirst().get().getKey();
        System.out.println(firstNonRepeat);

        //Find second highest number from array
        int[] nums = {5, 9, 11, 2, 8, 21, 1};
        Integer secondHighest = Arrays.stream(nums)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .get();
        System.out.println(secondHighest);

        //Find longest string from given array
        String[] strArray = {"java", "spring", "hibernate", "microservices"};
        String longestLengthString = Arrays.stream(strArray)
                .sorted((s1, s2) -> s2.length() - s1.length())
                .findFirst()
                .get();

        //or
        String s1 = Arrays.stream(strArray)
                .reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2)
                .get();
        System.out.println(s1);

        //Find all elements from array which starts with 1
        List<String> startsWith1 = Arrays.stream(nums)
                .boxed()
                .map(num -> num + "")
                .filter(str -> str.startsWith("1"))
                .toList();
        System.out.println(startsWith1);

        //String.join method
        List<String> nos = Arrays.asList("1", "2", "3", "4");
        String joinedString = String.join("-", nos);
        System.out.println(joinedString);

        //skip and limit, print 2 to 9
        IntStream.rangeClosed(1, 10)
                .skip(1)
                .limit(8)
                .forEach(System.out::println);


    }
}
