package io.pillopl.testablearch.ex3.newmodel.lending.infrastructure;

import io.pillopl.testablearch.ex3.newmodel.lending.application.LendingFacade;
import io.pillopl.testablearch.ex3.newmodel.lending.application.readmodel.LendingQueryFacade;
import io.pillopl.testablearch.ex3.newmodel.lending.application.CollectService;
import io.pillopl.testablearch.ex3.newmodel.lending.application.PlaceOnHoldService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NewModelConfig {

    @Bean
    LendingFacade lendingFacade(CollectService collectService, PlaceOnHoldService placeOnHoldService, LendingQueryFacade lendingQueryFacade) {
       return new LendingFacade(collectService, placeOnHoldService, lendingQueryFacade);
    }

    @Bean
    LendingQueryFacade lendingQueryFacade() {
        return new LendingQueryFacade();
    }


    @Bean
    PlaceOnHoldService placeOnHoldService() {
        return new PlaceOnHoldService();
    }

    @Bean
    CollectService collectService() {
        return new CollectService();
    }
}
