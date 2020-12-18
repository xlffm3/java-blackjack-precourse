package blackjack.domain.card;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CardDeque {
    private static final int DEFAULT_CARD_COUNTS = 2;

    private final Deque<Card> cardDeque;

    private CardDeque(Deque<Card> cardDeque) {
        this.cardDeque = cardDeque;
    }

    public static CardDeque initiate() {
        List<Card> cards = new ArrayList<>();
        addCards(cards);
        Collections.shuffle(cards);
        return new CardDeque(new ArrayDeque<>(cards));
    }

    private static void addCards(List<Card> cards) {
        Arrays.stream(Symbol.values())
                .flatMap(CardDeque::createCard)
                .forEach(cards::add);
    }

    private static Stream<Card> createCard(Symbol symbol) {
        return Arrays.stream(Type.values())
                .map(type -> new Card(symbol, type));
    }

    public List<Card> drawDefaultCards() {
        return Stream.generate(cardDeque::pop)
                .limit(DEFAULT_CARD_COUNTS)
                .collect(Collectors.toList());
    }
}
