package blackjack.domain.card;

public class Card {

    private final Symbol symbol;
    private final Type type;

    public Card(Symbol symbol, Type type) {
        this.symbol = symbol;
        this.type = type;
    }

    public boolean isAce() {
        return symbol.isAce();
    }

    public int getScore() {
        return symbol.getScore();
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public Type getType() {
        return type;
    }
}
