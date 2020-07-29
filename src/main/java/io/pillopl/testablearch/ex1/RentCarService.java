package io.pillopl.testablearch.ex1;

//1. Refactor to object-oriented model - separate rules from the process
//2. Make the integration test pass (happy path for rental process)
//3. Make the unit tests for the customer object model pass
//4. What happens if database/application crashes after sending an e-mail? How to prevent that?
//5. Do I want to test if the e-mail gets sent after not successful rental?

import org.springframework.stereotype.Component;

@Component
public class RentCarService {

    private final CustomerRepository customerRepository;
    private final EmailService emailService;

    public RentCarService(CustomerRepository customerRepository, EmailService emailService) {
        this.customerRepository = customerRepository;
        this.emailService = emailService;
    }

    void rentDefaultCarFor(Long customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(IllegalArgumentException::new);

        //can only have up to 3 rentals
        if (customer.rentACar()) {
            //if managed to rent - send a nice e-mail
            //what happens if database crashes after sending an e-mail?
            emailService.sendEmail(customer.getName(), "You got it");
            customerRepository.save(customer);
        } else {
            //if did not manage to rent - send something else
            emailService.sendEmail(customer.getName(), "¯\\_(ツ)_/¯");
            //do I want to test that?
        }
    }

}
