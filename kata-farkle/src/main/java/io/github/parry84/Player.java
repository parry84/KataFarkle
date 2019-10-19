package io.github.parry84;

public class Player {
    private static final Integer GOAL = 10_000;
    private static final Integer BONUS = 500;
    private Rules rules;
    private Integer score;

    public Player(Rules rules) {
        this.rules = rules;
    }

    public void throwDices() {
        Throwing throwing = Throwing.of(
                Dice.random(), Dice.random(), Dice.random(),
                Dice.random(), Dice.random(), Dice.random());
        Integer score = rules.score(throwing);
        this.score += score;
        if (canRethrow() && !isWinner()) {
            throwDices();
        }
    }

    public boolean isWinner() {
        return score >= GOAL;
    }

    private boolean canRethrow() {
        return score >= BONUS;
    }
}
