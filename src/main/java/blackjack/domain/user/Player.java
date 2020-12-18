package blackjack.domain.user;

import blackjack.domain.card.Card;
import blackjack.domain.card.CardDeque;
import blackjack.domain.card.Cards;
import blackjack.dto.CardDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Player {
    private static final int MINIMUM_NAME_LENGTH = 2;
    private static final int MINIMUM_BETTING_MONEY = 1;
    private static final int MAXIMUM_SCORE_TOTAL = 21;
    private static final int ZERO_PROFIT = 0;
    private static final int LOSS_PROFIT = -1;
    private static final double BLACKJACK_PROFIT_RATIO = 1.5;

    private final String name;
    private final long bettingMoney;
    private final Cards cards = new Cards(new ArrayList<>());

    public Player(String name, long bettingMoney) {
        validateName(name);
        validateBettingMoney(bettingMoney);
        this.name = name;
        this.bettingMoney = bettingMoney;
    }

    private void validateName(String name) {
        if (Objects.isNull(name)) {
            throw new PlayerNameException(name);
        }
        int trimNameLength = name.trim().length();
        if (trimNameLength < MINIMUM_NAME_LENGTH) {
            throw new PlayerNameException(name);
        }
    }

    private void validateBettingMoney(long bettingMoney) {
        if (bettingMoney < MINIMUM_BETTING_MONEY) {
            throw new PlayerBettingMoneyException(bettingMoney);
        }
    }

    private void addCard(Card card) {
        cards.addCard(card);
    }

    public void drawDefaultCards(CardDeque cardDeque) {
        List<Card> defaultCards = cardDeque.drawDefaultCards();
        defaultCards.forEach(this::addCard);
    }

    public void drawCard(CardDeque cardDeque) {
        Card card = cardDeque.drawCard();
        addCard(card);
    }

    public boolean isAbleToDrawCard() {
        return cards.hasScoreLessOrEqual(MAXIMUM_SCORE_TOTAL);
    }

    public int getScore() {
        return cards.getScore();
    }

    public int calculateResult(Dealer dealer) {
        if (dealer.isBlackJack()) {
            return calculateIfDealerIsBlackJack();
        }
        if (dealer.isBust() && !cards.isBust()) {
            return (int) bettingMoney;
        }
        if (cards.isBlackJack()) {
            return (int) (bettingMoney * BLACKJACK_PROFIT_RATIO);
        }
        if (cards.isBust()) {
            return (int) bettingMoney * LOSS_PROFIT;
        }
        return calculate(dealer);
    }

    private int calculate(Dealer dealer) {
        int playerScore = getScore();
        if (dealer.hasScoreGreater(playerScore)) {
            return (int) (bettingMoney * LOSS_PROFIT);
        }
        if (dealer.hasScoreEqual(playerScore)) {
            return ZERO_PROFIT;
        }
        return (int) bettingMoney;
    }

    private int calculateIfDealerIsBlackJack() {
        if (cards.isBlackJack()) {
            return ZERO_PROFIT;
        }
        return (int) bettingMoney * LOSS_PROFIT;
    }

    public String getName() {
        return name;
    }

    public List<CardDto> getCardDtos() {
        return cards.getCardDtos();
    }
}
