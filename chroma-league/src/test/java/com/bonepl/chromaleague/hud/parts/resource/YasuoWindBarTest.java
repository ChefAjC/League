package com.bonepl.chromaleague.hud.parts.resource;

import com.bonepl.chromaleague.IntSteps;
import com.bonepl.chromaleague.hud.AnimationTester;
import org.junit.jupiter.api.Test;

class YasuoWindBarTest extends AbstractResourceTest {
    @Test
    void testYasuoWindBar() {
        final IntSteps intSteps = new IntSteps(0, 100, 5);
        final YasuoWindBar yasuoWindBar = new YasuoWindBar();

        new AnimationTester()
                .withBeforeIterationAction(i -> {
                    if (i >= 20 && i <= 50) {
                        mockResource(100, 100);
                    } else {
                        mockResource(intSteps.nextInt(), 100);
                    }
                })
                .testAnimation(yasuoWindBar, 70);

    }
}