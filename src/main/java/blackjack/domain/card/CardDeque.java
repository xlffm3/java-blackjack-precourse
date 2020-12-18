package blackjack.domain.card;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Stream;

public class CardDeque {

    private final Deque<Card> cardDeque;

    private CardDeque(Deque<Card> cardDeque) {
        this.cardDeque = cardDeque;
    }

    public static CardDeque initiate() {
        Deque<Card> cardDeque = new ArrayDeque<>();
        addCards(cardDeque);
        return new CardDeque(cardDeque);
    }

    private static void addCards(Deque<Card> cardDeque) {
        Arrays.stream(Symbol.values())
                .flatMap(CardDeque::createCard)
                .forEach(cardDeque::add);
    }

    private static Stream<Card> createCard(Symbol symbol) {
        return Arrays.stream(Type.values())
                .map(type -> new Card(symbol, type));
    }
}
