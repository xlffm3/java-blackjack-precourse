package blackjack.domain.card;

import java.util.List;

public class Cards {

    private final List<Card> cards;

    public Cards(List<Card> cards) {
        this.cards = cards;
    }

    public void addCard(Card card) {
        cards.add(card);
    }
}
