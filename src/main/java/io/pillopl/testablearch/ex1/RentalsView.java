package io.pillopl.testablearch.ex1;

import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

//1. Refactor to object-oriented model - separate rules from the process
//2. Make the integration test pass (happy path for rental process)
//3. Make the unit tests for the customer object model pass

@Component
public class RentalsView {

    private final CustomerRepository customerRepository;

    public RentalsView(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    String getSummary() {
        return customerRepository
                .findAll()
                .stream()
                .map(customer -> customer.getName() + " has " + customer.getNumberOfRentals() + " rentals")
                .collect(Collectors.toSet())
                .toString();
    }

}
