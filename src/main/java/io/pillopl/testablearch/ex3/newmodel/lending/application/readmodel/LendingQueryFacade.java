package io.pillopl.testablearch.ex3.newmodel.lending.application.readmodel;


import io.pillopl.testablearch.ex3.newmodel.lending.domain.patron.PatronId;
import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public class LendingQueryFacade {



    public PlacedOnHoldBooksView placedOnHoldBy(PatronId patronId) {
        //new model implementation
        return null;
    }

    public CollectedBooksView collectedBy(PatronId patronId) {
        //new model implementation
        return null;
    }



}
