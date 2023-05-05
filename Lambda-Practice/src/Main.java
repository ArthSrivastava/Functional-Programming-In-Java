import Lambdas.Hotel;
import Lambdas.HotelFilteringCondition;
import Lambdas.HotelService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;


public class Main {
    private int field;
    public HotelFilteringCondition getLambdaExp() {
        int PRICE = 4000;
        List<Integer> list = new ArrayList<>();
        HotelFilteringCondition lambdaExp = hotel -> {
            this.field = 5; // VERY IMPORTANT: here 'this' does not refer to 'this' of anonymous class
                            // which implements this interface, rather it is the local context 'this' of Main class
                            // hence we can access this.field
//            PRICE++; //We can't change the value of local variable that we are using, it must be final or
                     // compiler will treat it as effectively final i.e. its value won't change

//            list.add(1); //Can be done
//            list = new ArrayList<>(); //Error
            return hotel.getPricePerDay() < list.size();
        };

//      PRICE++; //This can't be done also since we are using PRICE in lambda expression so it must be final
        //Reason for PRICE to be final: When we call this method it will return the lambdaExp and this getLambdaExp()
        //method will be removed from the stack, so PRICE variable will not be present inside the lambda expression
        //so hotel.getPricePerDay() < PRICE; this line is converted to hotel.getPricePerDay() < 2000 using value
        //capturing, hence the local variable should be constant as there should be some consistent value

        //***What if we try to use a local reference type inside lambdaExp?***
        //Suppose we make List<Integer> list = new ArrayList<>() in getLambdaExp() method
        //We can now use list inside the lambdaExp
        //If after lambda exp we do list.add(1), no error will be thrown since the 'list' reference still
        //points to the same object in the heap
        //Whereas if we do list = new ArrayList<>(), it throws an error because now our reference has changed
        //and it is pointing to new Object so the consistency is now gone
        return lambdaExp;
    }

    //So basically instead of creating our own interface for basic boolean testing methods
    //we can use Predicate interface
    public void predicateTest() {
//        Predicate<Integer> divisibleBy2 = no -> no % 2 == 0;
//        Predicate<Integer> divisibleBy3 = no -> no % 3 == 0;
//        Predicate<Integer> divisibleBy6 = divisibleBy2.and(divisibleBy3);

        //We have primitive type for these to avoid continuous autoboxing and unboxing
        IntPredicate divisibleBy2 = no -> no % 2 == 0;
        IntPredicate divisibleBy3 = no -> no % 3 == 0;
        IntPredicate divisibleBy6 = divisibleBy2.and(divisibleBy3);
        System.out.println(divisibleBy6.test(13));
    }


    //Consumer interface -> as the name says, it consumes some value
    public void consumerTest() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Consumer<Integer> consumer = a -> System.out.println(a);
        list.forEach(consumer);
        //or
        list.forEach(System.out::println);
    }

    //Supplier interface -> it does not take any value rather returns some value
    public void supplierTest() {
        Supplier<Double> supplier = () -> Math.random();
        System.out.println(supplier.get());
    }

    //Function interface -> takes some type of argument and returns other type of argument
    public void functionTest() {
        Function<String, Integer> strLenMap = str -> str.length();
        System.out.println(strLenMap.apply("hello"));

        Function<Integer, Integer> squares = a -> a * a;
        Function<Integer, Integer> addOne = a -> a + 1;
        System.out.println(squares.andThen(addOne).apply(3));
    }
    public static void main(String[] args) {
        HotelService hotelService = new HotelService();

        //Passing functions without lambdas
        /*
        //Filter based on 5 stars
        List<Hotel> fiveStarHotelList = hotelService.filterHotels(new HotelWithFiveStarFilter());
        System.out.println("With Five Star Type: " + fiveStarHotelList);

        //Or use anonymous class
        List<Hotel> lessThan4000 = hotelService.filterHotels(new HotelFilteringCondition() {
            @Override
            public boolean test(Hotel hotel) {
                return hotel.getPricePerDay() < 4000;
            }
        });
        */

        /*
        // Lambdas

        List<Hotel> lessThan4000 = hotelService.filterHotels((hotel) -> {
            return hotel.getPricePerDay() < 4000;
        });
        System.out.println("Less than 4000 price:" + lessThan4000);

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Collections.sort(list, (Integer a, Integer b) -> {
            return b - a;
        });
        System.out.println(list);
         */
        /*
        Main main = new Main();
        HotelFilteringCondition lambdaExp = main.getLambdaExp();
        hotelService.filterHotels(lambdaExp);
         */
        Main main = new Main();
//        main.predicateTest();
//        main.consumerTest();
//        main.supplierTest();
//        main.functionTest();


        //Method references
        //We can use it when we only have one line in lambda, and it is calling another function
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        //Case 1:
        list.forEach(System.out::println);

        List<String> str = Arrays.asList("hi", "abc", "pqr");


//        str.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
        //This can be written as
        str.sort(String::compareToIgnoreCase);
        System.out.println(str);

    }
}