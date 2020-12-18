package blackjack.domain.card;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CardDeque {
    private static final int DEFAULT_CARD_COUNTS = 2;

    private final Deque<Card> cardDeque;

    private CardDeque(Deque<Card> cardDeque) {
        this.cardDeque = cardDeque;
    }

    public static CardDeque initiate() {
        List<Card> cards = CardFactory.createCards();
        return new CardDeque(new ArrayDeque<>(cards));
    }

    public List<Card> drawDefaultCards() {
        return Stream.generate(cardDeque::pop)
                .limit(DEFAULT_CARD_COUNTS)
                .collect(Collectors.toList());
    }

    public Card drawCard() {
        return cardDeque.pop();
    }
}
