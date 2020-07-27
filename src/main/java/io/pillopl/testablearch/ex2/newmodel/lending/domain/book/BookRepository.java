package io.pillopl.testablearch.ex2.newmodel.lending.domain.book;

import io.pillopl.testablearch.ex2.newmodel.catalogue.BookId;

import java.util.Optional;

public interface BookRepository {

    Optional<Book> findById(BookId bookId);

    void save(Book book);

}


