package Lambdas;

@FunctionalInterface
public interface HotelFilteringCondition {
    boolean test(Hotel hotel);
}
