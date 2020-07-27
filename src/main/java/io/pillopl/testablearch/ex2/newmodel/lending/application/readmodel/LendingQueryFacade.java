package io.pillopl.testablearch.ex2.newmodel.lending.application.readmodel;


import io.pillopl.testablearch.ex2.newmodel.lending.domain.patron.PatronId;
import lombok.AllArgsConstructor;

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
