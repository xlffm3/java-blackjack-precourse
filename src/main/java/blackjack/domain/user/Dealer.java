package blackjack.domain.user;

import blackjack.domain.card.Card;
import blackjack.domain.card.CardDeque;
import blackjack.domain.card.Cards;
import blackjack.dto.CardDto;

import java.util.ArrayList;
import java.util.List;

public class Dealer {
    private static final int ONE_CARD_INDEX = 0;

    private final Cards cards = new Cards(new ArrayList<>());

    public void addCard(Card card) {
        cards.addCard(card);
    }

    public void drawDefaultCards(CardDeque cardDeque) {
        List<Card> defaultCards = cardDeque.drawDefaultCards();
        defaultCards.forEach(this::addCard);
    }

    public List<CardDto> getCardDtos() {
        return cards.getCardDtos();
    }

    public CardDto getOneCardDto() {
        return getCardDtos().get(ONE_CARD_INDEX);
    }
}
