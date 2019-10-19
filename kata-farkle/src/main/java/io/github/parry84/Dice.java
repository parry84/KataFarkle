package io.github.parry84;

import java.util.Random;

public enum Dice {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6);

    private Integer value;

    Dice(Integer value) {
        this.value = value;
    }

    public static Dice random() {
        return of(new Random().nextInt(Dice.values().length));
    }

    public static Dice of(Integer value) {
        switch (value) {
            case 1:
                return ONE;
            case 2:
                return TWO;
            case 3:
                return THREE;
            case 4:
                return FOUR;
            case 5:
                return FIVE;
            case 6:
                return SIX;
        }
        return null;
    }
}
