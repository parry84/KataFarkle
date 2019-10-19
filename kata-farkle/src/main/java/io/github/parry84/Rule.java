package io.github.parry84;

class Rule {

    private Integer score;
    private Integer quantity;
    private Dice dice;

    private Rule(Integer quantity, Dice dice, Integer score) {
        this.quantity = quantity;
        this.dice = dice;
        this.score = score;
    }

    public static Rule of(int quantity, Dice dice, int score) {
        return new Rule(quantity, dice, score);
    }

    public PartialScore apply(PartialScore partial) {
        if (match(partial.getResidual())) {
            return PartialScore.of(
                    partial.getScore() + this.score,
                    partial.getResidual().remove(this.dice, this.quantity));

        }
        return partial;
    }

    public Boolean match(Throwing throwing) {
        Integer frequency = throwing.frequency(this.dice);
        return frequency >= quantity;
    }

    @Override
    public String toString() {
        return "(" + quantity + " " + dice + ") -> " + score + " points";
    }
}
