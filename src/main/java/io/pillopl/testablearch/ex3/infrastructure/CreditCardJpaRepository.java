package io.pillopl.testablearch.ex3.infrastructure;


import io.pillopl.testablearch.ex3.model.CreditCard;
import io.pillopl.testablearch.ex3.model.CreditCardRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

/**
 * @author Jakub Pilimon
 */
interface CreditCardJpaRepository extends CrudRepository<CreditCard, UUID>, CreditCardRepository {
}
