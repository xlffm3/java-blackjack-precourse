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

    public int getScore() {
        int score = cards.stream()
                .mapToInt(Card::getScore)
                .sum();
        if (containsAce() && score <= 11) {
            return score + 10;
        }
        return score;
    }

    private boolean containsAce() {
        return cards.stream()
                .anyMatch(Card::isAce);
    }

    public List<CardDto> getCardDtos() {
        return cards.stream()
                .map(CardDto::from)
                .collect(Collectors.toList());
    }
}
