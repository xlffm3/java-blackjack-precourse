package blackjack.domain.user;

public class PlayerDuplicationException extends RuntimeException {
    private static final String ERROR_MESSAGE = "게임 플레이어 이름은 중복될 수 없습니다.";

    public PlayerDuplicationException() {
        super(ERROR_MESSAGE);
    }
}
