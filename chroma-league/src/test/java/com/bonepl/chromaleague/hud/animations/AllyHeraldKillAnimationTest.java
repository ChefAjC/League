package com.bonepl.chromaleague.hud.animations;

import org.junit.jupiter.api.Test;

class AllyHeraldKillAnimationTest {

    @SuppressWarnings("JUnitTestMethodWithNoAssertions")
    @Test
    void testAllyHeraldKillAnimation() {
        new AnimationTester().testAnimation(new AllyHeraldKillAnimation());
    }
}