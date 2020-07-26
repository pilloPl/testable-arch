package io.pillopl.testablearch.ex1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class RentCarServiceIntegrationTest {

    @MockBean
    EmailService emailService;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    RentCarService rentCarService;

    @Autowired
    RentalsView rentalsView;

    @Test
    void shouldSendAnEmailWhenCarIsRented() {
        //given
        Customer customer = newCustomerWithNumberOfRentals(2, "Jack");

        //when
        rentCarService.rentDefaultCarFor(customer.getId());

        //then
        Assertions.assertThat(rentalsView.getSummary()).contains("Jack has 3 rentals");

        //and
        Mockito.verify(emailService).sendEmail("Jack", "You got it");
    }

    private Customer newCustomerWithNumberOfRentals(int numberOrRentals, String name) {
        return customerRepository.save(new Customer(1L, name, numberOrRentals));
    }

}