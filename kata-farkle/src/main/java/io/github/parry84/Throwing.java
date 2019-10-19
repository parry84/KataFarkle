package io.github.parry84;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;

public class Throwing {

    private EnumMap<Dice, Integer> frequencies;

    private Throwing(EnumMap<Dice, Integer> frequencies) {
        this.frequencies = frequencies;
    }

    public static Throwing of(Dice dice1, Dice dice2, Dice dice3, Dice dice4, Dice dice5, Dice dice6) {
        List<Dice> dices = new ArrayList<>();
        dices.add(dice1);
        dices.add(dice2);
        dices.add(dice3);
        dices.add(dice4);
        dices.add(dice5);
        dices.add(dice6);

        final EnumMap<Dice, Integer> frequencies = new EnumMap<>(Dice.class);
        for (Dice dice : Dice.values()) {
            frequencies.put(dice, Collections.frequency(dices, dice));
        }
        return new Throwing(frequencies);
    }

    public Integer frequency(Dice dice) {
        return frequencies.get(dice);
    }

    public Throwing remove(Dice dice, Integer quantity) {
        final EnumMap<Dice, Integer> updatedFreq = new EnumMap<>(Dice.class);
        updatedFreq.putAll(frequencies);
        updatedFreq.computeIfPresent(dice, (key, value) -> value - quantity);
        return new Throwing(updatedFreq);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Throwing)) {
            return false;
        }

        Throwing c = (Throwing) o;

        return c.frequencies.equals(this.frequencies);
    }
}
