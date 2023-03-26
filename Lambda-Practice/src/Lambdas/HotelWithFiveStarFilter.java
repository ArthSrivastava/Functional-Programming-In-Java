package Lambdas;

public class HotelWithFiveStarFilter implements HotelFilteringCondition{
    @Override
    public boolean test(Hotel hotel) {
        return hotel.getHotelType() == HotelType.FIVE_STAR;
    }
}
