package BiMethods;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Stream;

public class BiFunctionExample implements BiFunction<List<Integer>, List<Integer>, List<Integer>> {

    @Override
    public List<Integer> apply(List<Integer> l1, List<Integer> l2) {
        return Stream.of(l1, l2)
                .flatMap(Collection::stream)
                .distinct()
                .toList();
    }

    public static void main(String[] args) {
        List<Integer> l1 = List.of(5, 7, 2, 5, 25);
        List<Integer> l2 = List.of(23, 78, 23, 3, 5);

        //normal way
//        BiFunctionExample biFunctionExample = new BiFunctionExample();
//        System.out.println(biFunctionExample.apply(l1, l2));
//
//        BiFunction<List<Integer>, List<Integer>, List<Integer>>
//                biFunction = new BiFunction<>() {
//            @Override
//            public List<Integer> apply(List<Integer> l1, List<Integer> l2) {
//                return Stream.of(l1, l2)
//                        .flatMap(Collection::stream)
//                        .distinct()
//                        .toList();
//            }
//        };
//        System.out.println(biFunction.apply(l1, l2));
//
        BiFunction<List<Integer>, List<Integer>, List<Integer>>
                biFunction2 = (list1, list2) -> {
                return Stream.of(list1, list2)
                        .flatMap(Collection::stream)
                        .distinct()
                        .toList();
        };

        Function<List<Integer>, List<Integer>> sortedFunc =
                (list) -> list.stream()
                                .sorted()
                                        .toList();
        System.out.println(biFunction2.andThen(sortedFunc).apply(l1, l2));

        Map<String, Integer> map = new HashMap<>();
        map.put("Test1", 400);
        map.put("Test2", 500);
        map.put("Test3", 600);
        BiFunction<String, Integer, Integer>
                biFunction = new BiFunction<String, Integer, Integer>() {
            @Override
            public Integer apply(String s, Integer integer) {
                return integer + 200;
            }
        };
//        map.replaceAll(biFunction);
        map.replaceAll((key, value) -> value + 300);
        System.out.println(map);
    }
}
