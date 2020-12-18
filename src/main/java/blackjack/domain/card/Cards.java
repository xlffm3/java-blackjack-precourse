package blackjack.domain.card;

import blackjack.dto.CardDto;

import java.util.List;
import java.util.stream.Collectors;

public class Cards {

    private final List<Card> cards;

    public Cards(List<Card> cards) {
        this.cards = cards;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public int getScoreTotal() {
        return cards.stream()
                .mapToInt(Card::getScore)
                .sum();
    }

    public List<CardDto> getCardDtos() {
        return cards.stream()
                .map(CardDto::from)
                .collect(Collectors.toList());
    }
}
