package Optional;

import MapAndFlatMap.Customer;
import MapAndFlatMap.CustomerDao;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalDemo {

    public static Customer getCustomerByEmailId(String email) throws Exception {
        List<Customer> customers = CustomerDao.getAll();
        return customers.stream()
                .filter(customer -> customer.getEmail().equals(email))
                .findAny()
                .orElseThrow(() -> new Exception("no customer present"));
    }

    public static void main(String[] args) throws Exception {
        Customer customer = new Customer(
                1,
                "Customer 1",
                null,
                Arrays.asList("78362131", "88997921")
        );
        //Creates an empty optional
        Optional<Object> empty = Optional.empty();
        System.out.println(empty);

        //Throws null pointer exception if value provided is null else
        //creates an optional with the provided value
//        Optional<String> emailOptional = Optional.of(customer.getEmail());
//        System.out.println(emailOptional);

        //Use this if you know passing value may or may not be null
        Optional<String> emailOptional2 = Optional.ofNullable(customer.getEmail());
//        System.out.println(emailOptional2);
//        if(emailOptional2.isPresent()) {
//            System.out.println(emailOptional2.get());
//        }

//        System.out.println(emailOptional2.orElse("default@gmail.com"));
//        System.out.println(emailOptional2.orElseThrow(() -> new IllegalArgumentException("email not present!")));

//        System.out.println(emailOptional2.map(String::toUpperCase).orElseGet(() -> "default email..."));

        System.out.println(getCustomerByEmailId("john@gmail.com"));
    }
}
