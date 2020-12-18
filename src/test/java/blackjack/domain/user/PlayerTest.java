package blackjack.domain.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

class PlayerTest {

    @DisplayName("Player 생성 실패 : 이름이 null, 공백, 2글자 미만인 경우")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"잉", "  \t"})
    void Player_유효하지_않은_이름_예외가_발생한다(String name) {
        assertThatCode(() -> {
            new Player(name, 1000);
        }).isInstanceOf(PlayerNameException.class)
                .hasMessageContaining("플레이어의 이름은 공백이 아닌 2글자 이상이어야 합니다.");
    }

    @DisplayName("Player 생성 실패 : 배팅 금액이 1 미만인 경우")
    @ParameterizedTest
    @ValueSource(longs = {-1, 0})
    void Player_유효하지_않은_배팅금액_예외가_발생한다(long bettingMoney) {
        assertThatCode(() -> {
            new Player("pobi", bettingMoney);
        }).isInstanceOf(PlayerBettingMoneyException.class)
                .hasMessageContaining("플레이어 배팅 금액은 최소 1 이상의 정수여야 합니다.");
    }
}
