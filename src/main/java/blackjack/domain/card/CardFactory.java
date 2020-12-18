package blackjack.domain.card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class CardFactory {

    private CardFactory() {
    }

    public static List<Card> createCards() {
        List<Card> cards = new ArrayList<>();
        Arrays.stream(Symbol.values())
                .flatMap(CardFactory::createCard)
                .forEach(cards::add);
        Collections.shuffle(cards);
        return cards;
    }

    private static Stream<Card> createCard(Symbol symbol) {
        return Arrays.stream(Type.values())
                .map(type -> new Card(symbol, type));
    }
}
