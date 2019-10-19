package io.github.parry84;

class PartialScore {
    private int score;
    private Throwing residual;

    private PartialScore(int score, Throwing residual) {
        this.score = score;
        this.residual = residual;
    }

    public static PartialScore of(int score, Throwing residual) {
        return new PartialScore(score, residual);
    }

    public int getScore() {
        return score;
    }

    public Throwing getResidual() {
        return residual;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof PartialScore)) {
            return false;
        }

        PartialScore c = (PartialScore) o;

        return c.residual.equals(this.residual);
    }
}
