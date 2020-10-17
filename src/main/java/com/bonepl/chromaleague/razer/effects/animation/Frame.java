package com.bonepl.chromaleague.razer.effects.animation;

import com.bonepl.chromaleague.razer.effects.Color;
import com.bonepl.chromaleague.razer.effects.keyboard.CustomEffect;
import com.bonepl.chromaleague.razer.sdk.RzKey;

import java.util.EnumMap;
import java.util.List;

public class Frame implements IFrame {
    private final EnumMap<RzKey, Color> keysToColors = new EnumMap<>(RzKey.class);

    public Frame() {
    }

    public Frame(RzKey rzKey, Color color) {
        keysToColors.put(rzKey, color);
    }

    public Frame(List<RzKey> rzKeys, Color color) {
        rzKeys.forEach(rzKey -> keysToColors.put(rzKey, color));
    }

    public Frame(EnumMap<RzKey, Color> keysToColors) {
        this.keysToColors.putAll(keysToColors);
    }

    public EnumMap<RzKey, Color> getKeysToColors() {
        return keysToColors;
    }

    public CustomEffect toCustomEffect() {
        return new CustomEffect(getKeysToColors());
    }

    @Override
    public boolean hasFrame() {
        return true;
    }

    @Override
    public Frame getFrame() {
        return this;
    }
}
