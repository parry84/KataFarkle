package io.github.parry84;


import java.util.ArrayList;
import java.util.List;

public class Rules {
    private final List<Rule> rules;

    public Rules() {
        rules = new ArrayList<>();

        rules.add(Rule.of(5, Dice.SIX, 1800));
        rules.add(Rule.of(4, Dice.SIX, 1200));
        rules.add(Rule.of(3, Dice.SIX, 600));

        rules.add(Rule.of(5, Dice.FIVE, 1500));
        rules.add(Rule.of(4, Dice.FIVE, 1000));
        rules.add(Rule.of(3, Dice.FIVE, 500));

        rules.add(Rule.of(5, Dice.FOUR, 1200));
        rules.add(Rule.of(4, Dice.FOUR, 800));
        rules.add(Rule.of(3, Dice.FOUR, 400));

        rules.add(Rule.of(5, Dice.THREE, 900));
        rules.add(Rule.of(4, Dice.THREE, 600));
        rules.add(Rule.of(3, Dice.THREE, 300));

        rules.add(Rule.of(5, Dice.TWO, 600));
        rules.add(Rule.of(4, Dice.TWO, 400));
        rules.add(Rule.of(3, Dice.TWO, 200));

        rules.add(Rule.of(5, Dice.ONE, 3000));
        rules.add(Rule.of(4, Dice.ONE, 2000));
        rules.add(Rule.of(3, Dice.ONE, 1000));

        rules.add(Rule.of(1, Dice.ONE, 100));

        rules.add(Rule.of(1, Dice.FIVE, 50));
    }

    public int score(Throwing throwing) {
        PartialScore partial = PartialScore.of(0, throwing);
        while (anyApplicableRule(partial.getResidual())) {
            partial = applyRules(partial);
        }
        return partial.getScore();
    }

    private PartialScore applyRules(PartialScore partial) {
        for (Rule rule : rules) {
            partial = rule.apply(partial);
        }
        return partial;
    }

    private boolean anyApplicableRule(Throwing throwing) {
        return rules.stream()
                .anyMatch(rule -> rule.match(throwing));
    }
}
