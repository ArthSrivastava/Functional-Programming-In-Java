package BiMethods;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class BiConsumerExample {
    public static void main(String[] args) {
        BiConsumer<String, Integer> biConsumer = (str, i1) -> {
                    System.out.println("Input1:" + str +
                            " input2: " + i1);
                };
        biConsumer.accept("Test User", 3000);

        Map<String, Integer> map = new HashMap<>();
        map.put("Test1", 400);
        map.put("Test2", 500);
        map.put("Test3", 600);
        map.forEach(biConsumer);
    }
}

