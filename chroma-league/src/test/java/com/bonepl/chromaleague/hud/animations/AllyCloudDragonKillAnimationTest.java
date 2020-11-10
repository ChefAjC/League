package com.bonepl.chromaleague.hud.animations;

import com.bonepl.chromaleague.hud.AnimationTester;
import org.junit.jupiter.api.Test;

class AllyCloudDragonKillAnimationTest {

    @SuppressWarnings("JUnitTestMethodWithNoAssertions")
    @Test
    void playAllyCloudDragonKillAnimation() {
        new AnimationTester().testAnimation(new AllyCloudDragonKillAnimation());
    }
}