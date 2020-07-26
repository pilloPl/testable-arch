package io.pillopl.testablearch.ex3.newmodel.lending.application;

import io.pillopl.testablearch.ex3.newmodel.catalogue.BookId;
import io.pillopl.testablearch.ex3.newmodel.lending.domain.book.AvailableBook;

import java.util.Optional;

public interface FindAvailableBook {

    Optional<AvailableBook> find(BookId bookId);
}
