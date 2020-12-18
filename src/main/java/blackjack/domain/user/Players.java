package blackjack.domain.user;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Players {
    private static final int MINIMUM_PLAYER_COUNTS = 2;
    private static final int MAXIMUM_PLAYER_COUNTS = 8;

    private List<Player> players;

    private Players(List<Player> players) {
        this.players = players;
    }

    public static Players from(List<String> playerNames, List<Long> bettingMoneys) {
        validatePlayerCounts(playerNames, bettingMoneys);
        int playerCounts = playerNames.size();
        List<Player> players = IntStream.range(0, playerCounts)
                .mapToObj(i -> new Player(playerNames.get(i), bettingMoneys.get(i)))
                .collect(Collectors.toList());
        return new Players(players);
    }

    private static void validatePlayerCounts(List<String> playerNames, List<Long> bettingMoneys) {
        int playerCounts = playerNames.size();
        int bettingMoneyCounts = bettingMoneys.size();
        int distinctPlayerCounts = (int) playerNames.stream().distinct().count();
        if (playerCounts != bettingMoneyCounts) {
            throw new IllegalArgumentException();
        }
        if (playerCounts < MINIMUM_PLAYER_COUNTS || playerCounts > MAXIMUM_PLAYER_COUNTS) {
            throw new PlayerCountsException(playerCounts);
        }
        if (playerCounts != distinctPlayerCounts) {
            throw new PlayerDuplicationException();
        }
    }
}
