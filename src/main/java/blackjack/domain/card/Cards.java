package blackjack.domain.card;

import blackjack.dto.CardDto;

import java.util.List;
import java.util.stream.Collectors;

public class Cards {
    private static final int BLACKJACK_SCORE = 21;
    private static final int MAXIMUM_ACE_SCORE = 11;
    private static final int DEFAULT_MINIMUM_ACE_SCORE = 1;
    private static final int FIRST_CARD_INDEX = 0;
    private static final int BLACKJACK_CARD_SIZE = 2;

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
        if (this.containsAce() && score <= MAXIMUM_ACE_SCORE) {
            return score + MAXIMUM_ACE_SCORE - DEFAULT_MINIMUM_ACE_SCORE;
        }
        return score;
    }

    private boolean containsAce() {
        return cards.stream()
                .anyMatch(Card::isAce);
    }

    public boolean isBlackJack() {
        List<Card> subCards = cards.subList(FIRST_CARD_INDEX, BLACKJACK_CARD_SIZE);
        Cards blackjackCards = new Cards(subCards);
        int score = blackjackCards.getScore();
        return score == BLACKJACK_SCORE;
    }

    public boolean isBust() {
        return getScore() > BLACKJACK_SCORE;
    }

    public List<CardDto> getCardDtos() {
        return cards.stream()
                .map(CardDto::from)
                .collect(Collectors.toList());
    }

    public boolean hasScoreLessOrEqual(int score) {
        return getScore() <= score;
    }

    public boolean hasScoreGreater(int score) {
        return getScore() > score;
    }

    public boolean hasScoreEqual(int playerScore) {
        return getScore() == playerScore;
    }
}
