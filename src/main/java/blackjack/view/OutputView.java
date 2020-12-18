package blackjack.view;

import blackjack.dto.CardDto;
import blackjack.dto.PlayerDto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {
    private static final String DEFAULT_CARDS_DISTRIBUTION_NOTICE = "\n딜러와 %s에게 2장의 카드를 나누어주었습니다.";
    private static final String DEALER_CARD_STATE_FORMAT = "\n딜러: %s%s\n";
    private static final String PLAYER_CARD_STATE_FORMAT = "%s카드: %s\n";
    private static final String PLAYER_CARD_STATE_WITH_SCORE_FORMAT = "%s카드: %s - 결과:%d\n";
    private static final String COMMA_DELIMITER = ", ";
    private static final String DEALER_REDRAW_NOTICE = "\n딜러는 16이하라 한장의 카드를 더 받았습니다.\n";
    private static final String GAME_RESULT_PRINT_HEADER = "\n## 최종 수익";
    private static final String RESULT_FORMAT = "%s: %d\n";
    private static final String DEALER_MESSAGE_HEADER = "딜러: ";
    private static final String DEALER = "딜러";
    private static final int ZERO_INDEX = 0;

    private OutputView() {
    }

    public static void printDefaultCardsDistribution(List<String> playerNames) {
        String joinedPlayerNamesWithDelimiter = String.join(COMMA_DELIMITER, playerNames);
        System.out.printf(DEFAULT_CARDS_DISTRIBUTION_NOTICE, joinedPlayerNamesWithDelimiter);
    }

    public static void printDefaultCardsState(CardDto dealerCardDto, List<PlayerDto> playerDtos) {
        System.out.printf(DEALER_CARD_STATE_FORMAT, dealerCardDto.getSymbol().toString(), dealerCardDto.getType().toString());
        playerDtos.forEach(OutputView::printEachCardState);
    }

    public static void printEachCardState(PlayerDto playerDto) {
        List<String> playerCards = getCardDisplays(playerDto.getCardDtos());
        String joinedPlayerCardsWithDelimiter = String.join(COMMA_DELIMITER, playerCards);
        System.out.printf(PLAYER_CARD_STATE_FORMAT, playerDto.getPlayerName(), joinedPlayerCardsWithDelimiter);
    }

    public static void printDealerRedraw() {
        System.out.println(DEALER_REDRAW_NOTICE);
    }

    public static void printDealerCardState(List<CardDto> cardDtos, int score) {
        List<String> playerCards = getCardDisplays(cardDtos);
        String joinedPlayerCardsWithDelimiter = String.join(COMMA_DELIMITER, playerCards);
        System.out.printf(PLAYER_CARD_STATE_WITH_SCORE_FORMAT, DEALER, joinedPlayerCardsWithDelimiter, score);

    }

    public static void printCardState(List<PlayerDto> players) {
        players.forEach(OutputView::printEachCardStateWithScore);
    }

    private static void printEachCardStateWithScore(PlayerDto playerDto) {
        List<String> playerCards = getCardDisplays(playerDto.getCardDtos());
        String joinedPlayerCardsWithDelimiter = String.join(COMMA_DELIMITER, playerCards);
        System.out.printf(PLAYER_CARD_STATE_WITH_SCORE_FORMAT, playerDto.getPlayerName(), joinedPlayerCardsWithDelimiter, playerDto.getScore());
    }

    public static void printResultHeader() {
        System.out.println(GAME_RESULT_PRINT_HEADER);
    }

    public static void printDealerProfit(int calculateProfit) {
        System.out.println(DEALER_MESSAGE_HEADER + calculateProfit);
    }

    public static void printPlayerProfits(List<String> playerNames, List<Integer> profits) {
        int playerCounts = playerNames.size();
        IntStream.range(ZERO_INDEX, playerCounts)
                .forEach(i -> System.out.printf(RESULT_FORMAT, playerNames.get(i), profits.get(i)));
    }

    private static List<String> getCardDisplays(List<CardDto> cardDtos) {
        return cardDtos.stream()
                .map(cardDto -> cardDto.getSymbol().toString() + cardDto.getType().toString())
                .collect(Collectors.toList());
    }
}
