package blackjack.domain.user;

import blackjack.domain.card.Card;
import blackjack.domain.card.CardDeque;
import blackjack.domain.card.Cards;

import java.util.ArrayList;
import java.util.List;

/**
 * 게임 딜러를 의미하는 객체
 */
public class Dealer {

    private final Cards cards = new Cards(new ArrayList<>());

    public void addCard(Card card) {
        cards.addCard(card);
    }

    public void drawDefaultCards(CardDeque cardDeque) {
        List<Card> defaultCards = cardDeque.drawDefaultCards();
        defaultCards.forEach(this::addCard);
    }
}
