package FilterAndForEach;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForEach {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("A", "B", "AC", "D", "E");

        //forEach accepts the Consumer functional interface
        //forEach works without stream() method also but then we can't chain more method that
        //are available with the stream() method
//        list.stream().forEach(a -> System.out.println(a));
//
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");
        map.put(4, "d");
//        map.forEach((key, value) -> System.out.println(key + ":" + value));
//        map.entrySet().stream().forEach(obj -> System.out.println(obj));


        //filter method
        list.stream()
                .filter(s -> s.startsWith("A"))
//                .forEach(s -> System.out.println(s));
                .forEach(System.out::println);

        map.entrySet()
                .stream()
                .filter(obj -> obj.getKey() % 2 == 0)
                .forEach(obj -> System.out.println(obj));
    }
}
