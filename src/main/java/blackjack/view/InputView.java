package blackjack.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_PLAYER_NAMES_NOTICE = "게임에 참여할 사람의 이릅을 입력하세요.(쉼표 기준으로 분리)";
    private static final String INPUT_BETTING_MONEY_NOTICE = "\n%s의 배팅 금액은?\n";
    private static final String INPUT_CHOICE_TO_DRAW_CARD_NOTICE = "\n%s는 한 장의 카드를 더 받겠습니까?\n";
    private static final String COMMA_DELIMITER = ",";
    private static final int SPLIT_RESULT_THRESHOLD = -1;

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> inputPlayerNames() {
        System.out.println(INPUT_PLAYER_NAMES_NOTICE);
        String[] playerNames = scanner.nextLine()
                .split(COMMA_DELIMITER, SPLIT_RESULT_THRESHOLD);
        return Arrays.stream(playerNames)
                .collect(Collectors.toList());
    }

    public List<Long> inputBettingMoney(List<String> playerNames) {
        List<Long> bettingMoneys = new ArrayList<>();
        playerNames.forEach(playerName -> inputEachBettingMoney(playerName, bettingMoneys));
        return bettingMoneys;
    }

    private void inputEachBettingMoney(String playerName, List<Long> bettingMoneys) {
        System.out.printf(INPUT_BETTING_MONEY_NOTICE, playerName);
        long playerBettingMoney = Long.parseLong(scanner.nextLine());
        bettingMoneys.add(playerBettingMoney);
    }

    public String inputChoiceToDrawCard(String name) {
        System.out.printf(INPUT_CHOICE_TO_DRAW_CARD_NOTICE, name);
        return scanner.nextLine();
    }
}
