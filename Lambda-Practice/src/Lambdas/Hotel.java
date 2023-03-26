package Lambdas;

public class Hotel {
    private long pricePerDay;
    private int rating;
    private HotelType hotelType;

    public Hotel(long pricePerDay, int rating, HotelType hotelType) {
        this.pricePerDay = pricePerDay;
        this.rating = rating;
        this.hotelType = hotelType;
    }

    public long getPricePerDay() {
        return pricePerDay;
    }

    public int getRating() {
        return rating;
    }

    public HotelType getHotelType() {
        return hotelType;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "pricePerDay=" + pricePerDay +
                ", rating=" + rating +
                ", hotelType=" + hotelType +
                '}';
    }
}
