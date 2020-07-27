package io.pillopl.testablearch.ex2.newmodel.lending.application;

import io.pillopl.testablearch.ex2.newmodel.lending.application.readmodel.LendingQueryFacade;
import io.pillopl.testablearch.ex2.newmodel.lending.application.readmodel.CollectedBooksView;
import io.pillopl.testablearch.ex2.newmodel.lending.application.readmodel.PlacedOnHoldBooksView;
import io.pillopl.testablearch.ex2.newmodel.lending.domain.patron.PatronId;

public class LendingFacade {

    private final CollectService collectService;
    private final PlaceOnHoldService placeOnHoldService;
    private final LendingQueryFacade queryFacade;

    public LendingFacade(CollectService collectService, PlaceOnHoldService placeOnHoldService, LendingQueryFacade queryFacade) {
        this.collectService = collectService;
        this.placeOnHoldService = placeOnHoldService;
        this.queryFacade = queryFacade;
    }

    public Result execute(PlaceOnHoldCommand command) {
        return placeOnHoldService.placeOnHold(command);
    }

    public Result execute(CollectCommand command) {
        return collectService.placeOnHold(command);
    }

    public PlacedOnHoldBooksView booksPlacedOnHoldBy(PatronId patronId) {
        return queryFacade.placedOnHoldBy(patronId);
    }

    public CollectedBooksView booksCollectedBy(PatronId patronId) {
        return queryFacade.collectedBy(patronId);
    }

}

