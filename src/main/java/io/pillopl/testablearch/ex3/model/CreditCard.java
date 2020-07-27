package io.pillopl.testablearch.ex3.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * @author Jakub Pilimon
 */
@Entity
public class CreditCard {


    @Id
    private UUID cardNo = UUID.randomUUID();
    private String pesel;
    private BigDecimal cardLimit;

    private CreditCard(String pesel, BigDecimal limit) {
        this.pesel = pesel;
        this.cardLimit = limit;
    }

    public CreditCard() {
    }

    public static CreditCard withDefaultLimit(String pesel) {
        return new CreditCard(pesel, new BigDecimal(2000));
    }

    public BigDecimal getCardLimit() {
        return cardLimit;
    }

    public UUID getCardNo() {
        return cardNo;
    }
}
