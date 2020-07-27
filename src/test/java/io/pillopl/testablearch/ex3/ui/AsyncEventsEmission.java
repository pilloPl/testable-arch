package io.pillopl.testablearch.ex3.ui;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.messaging.Message;

import java.util.concurrent.BlockingQueue;

/**
 * @author Jakub Pilimon
 */
@SpringBootTest
class AsyncEventsEmission {

    @Autowired
    CreditCardApplicationController cardApplicationController;

    @Autowired
    Source source;

    @Autowired
    MessageCollector messageCollector;

    BlockingQueue<Message<?>> events;

    @BeforeEach
    public void setup() {
        events = messageCollector.forChannel(source.output());
    }

    @Test
    void shouldSendCardGrantedEvent() {
        //given
        cardApplicationController.applyForCard(new CardApplication("70345678"));

        //expect
        //..
    }

    boolean emittedEventWas(String eventName) {
        //how to check that?
        return false;
    }

    @Test
    void shouldSendCardRejectedEvent() {
        //given
        cardApplicationController.applyForCard(new CardApplication("61345678"));

        //expect
        //..
    }

}