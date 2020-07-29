package io.pillopl.testablearch.ex2.acl;

import io.pillopl.testablearch.ex2.acl.toggles.NewModelToggles;
import io.pillopl.testablearch.ex2.bigballofmud.BigBallOfMud;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.togglz.core.manager.FeatureManager;
import org.togglz.junit.TogglzRule;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {BigBallOfMud.class, AclConfiguration.class})
public class SanityFeatureToggleTest {

    @Autowired
    FeatureManager manager;

    @Rule
    TogglzRule togglzRule = TogglzRule.allDisabled(NewModelToggles.class);

    @Test
    public void makeSureNewModelIsDisabledOnProd() {

        togglzRule.disable(NewModelToggles.RECONCILE_NEW_MODEL);

        assertThat(manager.getFeatureState(NewModelToggles.RECONCILE_AND_USE_NEW_MODEL).isEnabled()).isFalse();
    }

}