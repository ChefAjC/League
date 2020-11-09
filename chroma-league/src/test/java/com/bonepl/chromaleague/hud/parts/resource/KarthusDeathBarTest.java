package com.bonepl.chromaleague.hud.parts.resource;

import com.bonepl.chromaleague.IntSteps;
import com.bonepl.chromaleague.hud.animations.AnimationTester;
import org.junit.jupiter.api.Test;

class KarthusDeathBarTest {
    @Test
    void testKarthusDeathBar() {
        final IntSteps intSteps = new IntSteps(100, 0, 5);
        final KarthusDeathBar karthusDeathBar = new KarthusDeathBar();

        new AnimationTester()
                .withBeforeIterationAction(i -> ManaBarTest.mockResource(intSteps.nextInt(), 100))
                .testAnimation(karthusDeathBar, 20);
    }
}