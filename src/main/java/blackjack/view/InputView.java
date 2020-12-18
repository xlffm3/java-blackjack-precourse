package blackjack.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_PLAYER_NAMES_NOTICE = "게임에 참여할 사람의 이릅을 입력하세요.(쉼표 기준으로 분리)";
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
}
