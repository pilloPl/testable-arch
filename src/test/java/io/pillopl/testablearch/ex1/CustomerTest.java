package io.pillopl.testablearch.ex1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {


    @Test
    void canRentOneCar() {
        //given
        Customer aCustomer = aCustomerWithRentals(0);

        //expect
        assertTrue(customerRentsACar(aCustomer));
    }

    @Test
    void canRentTwoCars() {
        //given
        Customer aCustomer = aCustomerWithRentals(1);

        //expect
        assertTrue(customerRentsACar(aCustomer));
    }

    @Test
    void canRentThreeCars() {
        //given
        Customer aCustomer = aCustomerWithRentals(2);

        //expect
        assertTrue(customerRentsACar(aCustomer));
    }

    @Test
    void cannotRentFourCars() {
        //given
        Customer aCustomer = aCustomerWithRentals(3);

        //expect
        assertFalse(customerRentsACar(aCustomer));

    }

    private boolean customerRentsACar(Customer customer) {
        //for the time being the rule result is true/false - could be Result class or exception throwing
        return customer.rentACar();
        //return false;
    }

    private Customer aCustomerWithRentals(int numberOfRentals) {
        return new Customer(1L, "Jack", numberOfRentals);
    }
}
