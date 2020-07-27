package io.pillopl.testablearch.ex2.acl.reconciliation;

import java.util.Arrays;
import java.util.List;

public class CompositeReaction implements Reconciliation.Reaction {

    private final List<Reconciliation.Reaction> reactions;

    CompositeReaction(Reconciliation.Reaction... reactions) {
        this.reactions = Arrays.asList(reactions);
    }

    @Override
    public void reactTo(Diff diff) {
        reactions.forEach(reaction -> reaction.reactTo(diff));
    }

    private void disableToggle() {
        //..
    }

    private void sendMail() {
        //..
    }
}
