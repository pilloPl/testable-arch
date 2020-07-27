package io.pillopl.testablearch.ex2.acl;

import io.pillopl.testablearch.ex2.acl.reconciliation.Reconciliation;
import io.pillopl.testablearch.ex2.newmodel.lending.application.LendingFacade;
import io.pillopl.testablearch.ex2.newmodel.lending.infrastructure.NewModelConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(NewModelConfig.class)
public
class AclConfiguration {

    @Bean
    LendingACL lendingACL(LendingFacade lendingFacade) {
        return new LendingACL(new Reconciliation<>(Reconciliation.Reaction.justLog()), lendingFacade);
    }

}
