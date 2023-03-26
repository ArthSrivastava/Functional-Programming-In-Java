package Lambdas;

import java.util.ArrayList;
import java.util.List;

public class HotelService {
    private List<Hotel> hotels;
    public HotelService() {
        hotels = new ArrayList<>();
        hotels.add(new Hotel(5000, 5, HotelType.FIVE_STAR));
        hotels.add(new Hotel(3000, 3, HotelType.THREE_STAR));
        hotels.add(new Hotel(4000, 4, HotelType.FIVE_STAR));
        hotels.add(new Hotel(2000, 2, HotelType.TWO_STAR));
        hotels.add(new Hotel(1000, 1, HotelType.ONE_STAR));
    }

    public List<Hotel> filterHotels(HotelFilteringCondition hotelFilteringCondition) {
        List<Hotel> hotelList = new ArrayList<>();
        for(Hotel hotel: hotels) {
            if(hotelFilteringCondition.test(hotel)) {
                hotelList.add(hotel);
            }
        }
        return hotelList;
    }
}
