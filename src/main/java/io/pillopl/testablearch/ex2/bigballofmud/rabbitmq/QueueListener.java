package io.pillopl.testablearch.ex2.bigballofmud.rabbitmq;


import io.pillopl.testablearch.ex2.bigballofmud.dtos.BookRequest;
import io.pillopl.testablearch.ex2.bigballofmud.services.BookHolderService;
import io.pillopl.testablearch.ex2.bigballofmud.services.BookService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class QueueListener {

    private final BookService bookService;
    private final BookHolderService bookHolderService;


    public QueueListener(BookService bookService, BookHolderService bookHolderService) {
        this.bookService = bookService;
        this.bookHolderService = bookHolderService;
    }

    @Transactional
    public boolean collect(BookRequest bookRequest) {
        try {
            bookService.removeHold(bookRequest.getHolderId(), bookRequest.getBookId());
            bookHolderService.createCollectedBook(bookRequest.getHolderId(), bookRequest.getBookId(), bookRequest.getDays());
            return true;
        } catch (Exception e) {
            return false;
        }

    }

}
