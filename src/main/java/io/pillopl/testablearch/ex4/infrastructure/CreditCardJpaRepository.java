package io.pillopl.testablearch.ex4.infrastructure;


import io.pillopl.testablearch.ex4.model.CreditCard;
import io.pillopl.testablearch.ex4.model.CreditCardRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

/**
 * @author Jakub Pilimon
 */
interface CreditCardJpaRepository extends CrudRepository<CreditCard, UUID>, CreditCardRepository {
}
