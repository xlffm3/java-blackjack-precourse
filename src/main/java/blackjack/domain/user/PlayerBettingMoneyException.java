package blackjack.domain.user;

public class PlayerBettingMoneyException extends RuntimeException {
    private static final String ERROR_MESSAGE = "플레이어 배팅 금액은 최소 1 이상의 정수여야 합니다. (값 : %d)";

    public PlayerBettingMoneyException(long bettingMoney) {
        super(String.format(ERROR_MESSAGE, bettingMoney));
    }
}
