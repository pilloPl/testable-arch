package io.pillopl.testablearch.ex2.bigballofmud.exceptions;

public class InvalidBookLendingStateException extends RuntimeException {

    public InvalidBookLendingStateException(String msg) {
        super(msg);
    }
}
