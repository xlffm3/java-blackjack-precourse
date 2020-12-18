package blackjack;

import blackjack.domain.card.CardDeque;
import blackjack.view.InputView;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner);
        CardDeque cardDeque = CardDeque.initiate();
        BlackJackGame blackJackGame = new BlackJackGame(inputView, cardDeque);
        blackJackGame.run();
        scanner.close();
    }
}
