package io.github.parry84;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Play {

    private static final Integer PLAYERS_COUNT = 2;
    private final List<Player> players;

    public Play() {
        final Rules rules = new Rules();
        players = IntStream
                .range(0, PLAYERS_COUNT)
                .mapToObj(i -> new Player(rules))
                .collect(Collectors.toUnmodifiableList());
    }

    public void play() {
        while (noWinner()) {
            round();
        }
    }

    private void round() {
        for (Player player : players) {
            mayThrow(player);
        }
    }

    private void mayThrow(Player player) {
        if (noWinner()) {
            player.throwDices();
        }
    }

    private boolean noWinner() {
        return players
                .stream()
                .noneMatch(Player::isWinner);
    }
}
