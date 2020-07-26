package io.pillopl.testablearch.ex3.newmodel.lending.application.readmodel;

import io.pillopl.testablearch.ex3.newmodel.catalogue.BookId;
import io.pillopl.testablearch.ex3.newmodel.lending.domain.patron.PatronId;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class PlacedOnHoldBooksView {

    PlacedOnHoldBooksView(PatronId patronId) {
        this.patronId = patronId;
    }

    private PatronId patronId;

    @Getter private List<BookId> books = new ArrayList<>();

    void addBook(BookId book) {
        books.add(book);
    }

    void removeBook(BookId book) {
        books.remove(book);
    }


}


