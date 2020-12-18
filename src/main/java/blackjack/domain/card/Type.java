package blackjack.domain.card;

public enum Type {
    SPADE("스페이드"),
    DIAMOND("다이아몬드"),
    HEART("하트"),
    CLUB("클로버");

    private final String koreanName;

    private Type(String koreanName) {
        this.koreanName = koreanName;
    }

    @Override
    public String toString() {
        return koreanName;
    }
}
