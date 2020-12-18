package blackjack.domain.user;

public class PlayerCountsException extends RuntimeException {
    private static final String ERROR_MESSAGE = "게임 플레이어는 2명 이상 8명 이하여야 합니다. (값 : %d)";

    public PlayerCountsException(int playerCounts) {
        super(String.format(ERROR_MESSAGE, playerCounts));
    }
}
