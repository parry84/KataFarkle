package io.github.parry84;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThrowingTest {
    private Rules rules = new Rules();

    @DisplayName("Calculate score according to Farkle rules")
    @ParameterizedTest(name = "throwing ({0}, {1}, {2}, {3}, {4}, {5}) gives {6}")
    @CsvSource({
            "5, 6, 1, 2, 2, 5, 200",
            "6, 6, 6, 6, 5, 5, 1300",
            "2, 2, 4, 4, 6, 6, 0",
            "1, 2, 4, 4, 6, 6, 100",
            "1, 1, 4, 4, 6, 6, 200",
            "1, 5, 4, 4, 6, 6, 150",
            "5, 5, 4, 4, 6, 6, 100",
            "5, 5, 5, 4, 6, 6, 500",
            "1, 1, 1, 4, 6, 6, 1000",
    })
    public void calculateScoreAccordingToFarkleRules(
            int dice1, int dice2, int dice3, int dice4, int dice5, int dice6, int expectedScore) {
        final Throwing throwing = Throwing.of(
                Dice.of(dice1), Dice.of(dice2), Dice.of(dice3),
                Dice.of(dice4), Dice.of(dice5), Dice.of(dice6));

        int actualScore = rules.score(throwing);

        assertEquals(expectedScore, actualScore);
    }
}