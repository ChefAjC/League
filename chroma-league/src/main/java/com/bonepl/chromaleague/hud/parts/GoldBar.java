package com.bonepl.chromaleague.hud.parts;

import com.bonepl.chromaleague.state.GameStateHelper;
import com.bonepl.razersdk.animation.*;
import com.bonepl.razersdk.sdk.RzKey;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static com.bonepl.chromaleague.hud.PredefinedKeySets.*;
import static com.bonepl.razersdk.sdk.RzKey.*;

public class GoldBar extends Animation {
    public static final int GOLD_FULL = 3000;
    public static final List<RzKey> GOLD_BAR_KEYS = Arrays.asList(RZKEY_NUMPAD_DECIMAL, RZKEY_NUMPAD0,
            RZKEY_NUMPAD2, RZKEY_NUMPAD_ENTER, RZKEY_NUMPAD3, RZKEY_NUMPAD5, RZKEY_NUMPAD1,
            RZKEY_NUMPAD6, RZKEY_NUMPAD8, RZKEY_NUMPAD4, RZKEY_NUMPAD_ADD, RZKEY_NUMPAD9,
            RZKEY_NUMPAD_DIVIDE, RZKEY_NUMPAD7, RZKEY_NUMPAD_MULTIPLY, RZKEY_NUMLOCK, RZKEY_NUMPAD_SUBTRACT);
    private static final Random random = new Random();

    private final double goldDiffToSpawnCoin;
    private final int millisecondsForGoldCount;

    private Double lastGold;
    private LocalTime lastGoldCheck;

    public GoldBar() {
        this(10, 1000);
    }

    //FOR TEST ONLY
    public GoldBar(double goldDiffToSpawnCoin, int millisecondsForGoldCount) {
        this.goldDiffToSpawnCoin = goldDiffToSpawnCoin;
        this.millisecondsForGoldCount = millisecondsForGoldCount;
    }

    @Override
    public Frame getFrame() {
        addToFront(createGoldBar());
        spawnCoinIfNeeded();
        return super.getFrame();
    }

    private static ProgressBar createGoldBar() {
        return new ProgressBar(GOLD_BAR_KEYS, GameStateHelper.getGoldPercentage(), Color.YELLOW);
    }

    private void spawnCoinIfNeeded() {
        if (ChronoUnit.MILLIS.between(getLastGoldCheck(), LocalTime.now()) >= millisecondsForGoldCount) {
            final double currentGold = GameStateHelper.getGold();
            if (currentGold - getLastGold() >= goldDiffToSpawnCoin) {
                spawnCoin();
            }
            lastGold = currentGold;
            lastGoldCheck = LocalTime.now();
        }
    }

    public void spawnCoin() {
        final int i = random.nextInt(4);
        switch (i) {
            case 0 -> addToBack(fallingCoin(FIRST_NUMPAD_COLUMN));
            case 1 -> addToBack(fallingCoin(SECOND_NUMPAD_COLUMN));
            case 2 -> addToBack(fallingCoin(THIRD_NUMPAD_COLUMN));
            case 3 -> addToBack(fallingCoin(FOURTH_NUMPAD_COLUMN));
        }
    }

    private AnimatedFrame fallingCoin(List<RzKey> rzKeys) {
        final AnimatedFrame animatedFrames = new AnimatedFrame();
        rzKeys.forEach(rzKey -> animatedFrames.addAnimationFrame(new SimpleFrame(rzKey, Color.YELLOW)));
        return animatedFrames;
    }

    public LocalTime getLastGoldCheck() {
        if (lastGoldCheck == null) {
            lastGoldCheck = LocalTime.now();
        }
        return lastGoldCheck;
    }

    public double getLastGold() {
        if (lastGold == null) {
            lastGold = GameStateHelper.getGold();
        }
        return lastGold;
    }
}
