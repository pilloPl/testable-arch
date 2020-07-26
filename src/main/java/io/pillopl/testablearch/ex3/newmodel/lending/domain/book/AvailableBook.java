package io.pillopl.testablearch.ex3.newmodel.lending.domain.book;

import io.pillopl.testablearch.ex3.newmodel.catalogue.BookId;
import lombok.NonNull;
import lombok.Value;

@Value
public class AvailableBook {

    @NonNull
    BookId bookId;
    @NonNull BookType bookType;

    public boolean isRestricted() {
        return bookType.equals(BookType.Restricted);
    }
}

