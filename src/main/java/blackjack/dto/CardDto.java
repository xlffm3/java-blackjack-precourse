package blackjack.dto;

import blackjack.domain.card.Card;
import blackjack.domain.card.Symbol;
import blackjack.domain.card.Type;

public class CardDto {

    private final Symbol symbol;
    private final Type type;

    private CardDto(Symbol symbol, Type type) {
        this.symbol = symbol;
        this.type = type;
    }

    public static CardDto from(Card card) {
        return new CardDto(card.getSymbol(), card.getType());
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public Type getType() {
        return type;
    }
}
