package blackjack.view;

import blackjack.dto.CardDto;
import blackjack.dto.PlayerDto;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String DEFAULT_CARDS_DISTRIBUTION_NOTICE = "\n딜러와 %s에게 2장의 카드를 나누어주었습니다.";
    private static final String DEALER_CARD_STATE_FORMAT = "\n딜러: %s%s";
    private static final String PLAYER_CARD_STATE_FORMAT = "\n%s카드: %s";
    private static final String COMMA_DELIMITER = ",";

    private OutputView() {
    }

    public static void printDefaultCardsDistribution(List<String> playerNames) {
        String joinedPlayerNamesWithDelimiter = String.join(COMMA_DELIMITER, playerNames);
        System.out.printf(DEFAULT_CARDS_DISTRIBUTION_NOTICE, joinedPlayerNamesWithDelimiter);
    }

    public static void printDefaultCardsState(CardDto dealerCardDto, List<PlayerDto> playerDtos) {
        System.out.printf(DEALER_CARD_STATE_FORMAT, dealerCardDto.getSymbol().toString(), dealerCardDto.getType().toString());
        playerDtos.forEach(OutputView::printEachCardState);
        System.out.println();
    }

    private static void printEachCardState(PlayerDto playerDto) {
        List<String> playerCards = playerDto.getCardDtos()
                .stream()
                .map(cardDto -> cardDto.getSymbol().toString() + cardDto.getType().toString())
                .collect(Collectors.toList());
        String joinedPlayerCardsWithDelimiter = String.join(COMMA_DELIMITER, playerCards);
        System.out.printf(PLAYER_CARD_STATE_FORMAT, playerDto.getPlayerName(), joinedPlayerCardsWithDelimiter);
    }
}
