package blackjack.domain.user;

import java.util.Objects;

public class Player {
    private static final int MINIMUM_NAME_LENGTH = 2;
    private static final int MINIMUM_BETTING_MONEY = 1;

    private final String name;
    private final long bettingMoney;

    public Player(String name, long bettingMoney) {
        validateName(name);
        validateBettingMoney(bettingMoney);
        this.name = name;
        this.bettingMoney = bettingMoney;
    }

    private void validateName(String name) {
        if (Objects.isNull(name)) {
            throw new PlayerNameException(name);
        }
        int trimNameLength = name.trim().length();
        if (trimNameLength < MINIMUM_NAME_LENGTH) {
            throw new PlayerNameException(name);
        }
    }

    private void validateBettingMoney(long bettingMoney) {
        if (bettingMoney < MINIMUM_BETTING_MONEY) {
            throw new PlayerBettingMoneyException(bettingMoney);
        }
    }
}
