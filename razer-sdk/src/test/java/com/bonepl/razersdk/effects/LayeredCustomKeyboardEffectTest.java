package com.bonepl.razersdk.effects;

import com.bonepl.razersdk.RazerSDKClient;
import com.bonepl.razersdk.animation.AnimatedFrame;
import com.bonepl.razersdk.animation.Color;
import com.bonepl.razersdk.animation.LayeredFrame;
import com.bonepl.razersdk.animation.SimpleFrame;
import com.bonepl.razersdk.sdk.RzKey2;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class LayeredCustomKeyboardEffectTest {

    @Test
    @SuppressWarnings("JUnitTestMethodWithNoAssertions")
    void testLayeredKeyboardEffect() throws InterruptedException {
        try (RazerSDKClient razerSDKClient = new RazerSDKClient()) {
            final AnimatedFrame firstAnimatedFrame = createFramesFromEnum(7, 18, Color.GREEN);
            final AnimatedFrame secondAnimatedFrame = createFramesFromEnum(0, 11, Color.BLUE);
            for (int i = 0; i <= 100; i += 5) {
                LayeredFrame layeredFrame = new LayeredFrame();
                layeredFrame.addFrame(new SimpleFrame(new Color(30, 30, 0)));
                layeredFrame.addFrame(firstAnimatedFrame);
                layeredFrame.addFrame(secondAnimatedFrame);
                if (i % 10 == 0) {
                    layeredFrame.addFrame(new SimpleFrame(RzKey2.RZKEY_SPACE, Color.RED));
                }
                razerSDKClient.createKeyboardEffect(layeredFrame);
                Thread.sleep(100);
            }
        }
    }

    private static AnimatedFrame createFramesFromEnum(int from, int to, Color color) {
        final List<RzKey2> keys = Arrays.stream(RzKey2.values())
                .skip(from).limit(to)
                .collect(Collectors.toList());
        final AnimatedFrame animatedFrame = new AnimatedFrame();
        for (int i = 0; i < to; i++) {
            animatedFrame.addAnimationFrame(2, new SimpleFrame(keys.subList(0, i), color));
        }
        return animatedFrame;
    }
}