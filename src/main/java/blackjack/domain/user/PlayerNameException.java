package blackjack.domain.user;

public class PlayerNameException extends RuntimeException {
    private static final String ERROR_MESSAGE = "플레이어의 이름은 공백이 아닌 2글자 이상이어야 합니다. (값 : %s)";

    public PlayerNameException(String name) {
        super(String.format(ERROR_MESSAGE, name));
    }
}
