package MapAndFlatMap;

import java.util.List;
import java.util.stream.Collectors;

public class MapvsFlatMap {
    public static void main(String[] args) {
        List<Customer> customerList = CustomerDao.getAll();

        //List<Customer> convert to List<String> -> data transformation
        //mapping: customer -> customer.getEmail()  (one to one mapping as one customer has one email)
        List<String> emails = customerList.stream()
                .map(customer -> customer.getEmail()).collect(Collectors.toList());
        System.out.println(emails);

        //customer -> customer.getPhoneNumbers() (one to many mapping)
        List<List<String>> phoneNumbers = customerList.stream()
                .map(customer -> customer.getPhoneNumbers()).collect(Collectors.toList());
        System.out.println(phoneNumbers);

        //flattens a stream of stream to a single stream
        List<String> numbers = customerList.stream()
                .flatMap(customer -> customer.getPhoneNumbers().stream())
                .collect(Collectors.toList());
        System.out.println(numbers);
    }
}
