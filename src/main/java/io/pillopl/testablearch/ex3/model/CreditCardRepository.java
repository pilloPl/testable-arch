package io.pillopl.testablearch.ex3.model;

import java.util.Optional;
import java.util.UUID;

/**
 * @author Jakub Pilimon
 */
public interface CreditCardRepository {

    CreditCard save(CreditCard creditCard);

    Optional<CreditCard> findById(UUID uuid);
}
