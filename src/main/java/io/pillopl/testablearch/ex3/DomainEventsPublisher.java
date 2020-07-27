package io.pillopl.testablearch.ex3;


import io.pillopl.testablearch.ex3.model.DomainEvent;

/**
 * @author Jakub Pilimon
 */
public interface DomainEventsPublisher {

    void publish(DomainEvent domainEvent);
}
