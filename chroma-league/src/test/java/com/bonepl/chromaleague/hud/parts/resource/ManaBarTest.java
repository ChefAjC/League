package com.bonepl.chromaleague.hud.parts.resource;

import com.bonepl.chromaleague.IntSteps;
import com.bonepl.chromaleague.hud.AnimationTester;
import org.junit.jupiter.api.Test;

class ManaBarTest extends AbstractResourceTest {
    @Test
    void testManaBar() {
        final IntSteps intSteps = new IntSteps(0, 100, 5);
        final ManaBar manaBar = new ManaBar();

        new AnimationTester()
                .withBeforeIterationAction(i -> mockResource(intSteps.nextInt(), 100))
                .testAnimation(manaBar, 40);
    }
}