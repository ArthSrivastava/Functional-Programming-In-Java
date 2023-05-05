package MapAndFlatMap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomerDao {
    public static List<Customer> getAll() {
        return Stream.of(
                new Customer(1, "John", "john@gmail.com", Arrays.asList("345522132", "23135443634")),
                new Customer(2, "Smith", "smith@gmail.com", Arrays.asList("9873213231", "983912831")),
                new Customer(3, "Peter", "peter@gmail.com", Arrays.asList("909749384932", "75512233643")),
                new Customer(4, "Kelly", "kelly@gmail.com", Arrays.asList("8342039324", "65413242132"))
        ).collect(Collectors.toList());
    }
}
