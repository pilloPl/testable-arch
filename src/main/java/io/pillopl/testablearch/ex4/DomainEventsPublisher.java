package io.pillopl.testablearch.ex4;


import io.pillopl.testablearch.ex4.model.DomainEvent;

/**
 * @author Jakub Pilimon
 */
public interface DomainEventsPublisher {

    void publish(DomainEvent domainEvent);
}
