package BiMethods;

import java.util.function.BiPredicate;

public class BiPredicateExample {
    public static void main(String[] args) {
        BiPredicate<String, String> biPredicate = (s1, s2) -> {
            return s1.equals(s2);
        };
        BiPredicate<String, String> lengthPredicate = (s1, s2) -> {
            return s1.length() == s2.length();
        };
        boolean output1 = lengthPredicate.and(biPredicate).test("madam", "madam");
        System.out.println("Output:" + output1);

        //similarly with or method
        System.out.println(biPredicate.test("madam", "madam"));
    }
}
