package com.bonepl.chromaleague.hud.parts;

import com.bonepl.chromaleague.hud.animations.AnimationTester;
import com.bonepl.chromaleague.rest.eventdata.DragonType;
import com.bonepl.chromaleague.state.GameState;
import com.bonepl.chromaleague.state.GameStateHelper;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

class DragonSoulBarTest {

    @SuppressWarnings("JUnitTestMethodWithNoAssertions")
    @Test
    void playCloudDragonSoulAnimation() {
        testDragonSoulAnimation(DragonType.CLOUD);
    }

    @SuppressWarnings("JUnitTestMethodWithNoAssertions")
    @Test
    void playInfernalDragonSoulAnimation() {
        testDragonSoulAnimation(DragonType.INFERNAL);
    }

    @SuppressWarnings("JUnitTestMethodWithNoAssertions")
    @Test
    void playMountainDragonSoulAnimation() {
        testDragonSoulAnimation(DragonType.MOUNTAIN);
    }

    @SuppressWarnings("JUnitTestMethodWithNoAssertions")
    @Test
    void playOceanDragonSoulAnimation() {
        testDragonSoulAnimation(DragonType.OCEAN);
    }

    private static void testDragonSoulAnimation(DragonType dragonType) {
        switchToDragon(dragonType);
        new AnimationTester().testAnimation(new DragonSoulBar(), 80);
    }

    private static void switchToDragon(DragonType dragonType) {
        GameState.getEventData().resetCounters();
        IntStream.range(0, 4).forEach(i -> GameStateHelper.addKilledDragon(dragonType));
    }
}