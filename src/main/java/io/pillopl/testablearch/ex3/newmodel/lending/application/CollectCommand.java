package io.pillopl.testablearch.ex3.newmodel.lending.application;

import io.pillopl.testablearch.ex3.newmodel.catalogue.BookId;
import io.pillopl.testablearch.ex3.newmodel.lending.domain.patron.CollectDuration;
import io.pillopl.testablearch.ex3.newmodel.lending.domain.patron.PatronId;
import lombok.NonNull;
import lombok.Value;

@Value
public class CollectCommand {

    @NonNull
    CollectDuration collectDuration;
    @NonNull
    BookId bookId;
    @NonNull
    PatronId patronId;
}
