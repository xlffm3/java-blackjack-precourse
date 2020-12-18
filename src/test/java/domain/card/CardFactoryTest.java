package domain.card;

import blackjack.domain.card.Card;
import blackjack.domain.card.CardFactory;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CardFactoryTest {
    @Test
    void create() {
        List<Card> cards = CardFactory.createCards();
        assertThat(cards).hasSize(52);
        System.out.println(cards);
    }
}
