package blackjack;

import blackjack.domain.card.CardDeque;
import blackjack.domain.user.Dealer;
import blackjack.domain.user.Player;
import blackjack.domain.user.Players;
import blackjack.dto.CardDto;
import blackjack.dto.PlayerDto;
import blackjack.view.InputView;
import blackjack.view.OutputView;

import java.util.List;

public class BlackJackGame {

    private final InputView inputView;
    private final CardDeque cardDeque;

    public BlackJackGame(InputView inputView, CardDeque cardDeque) {
        this.inputView = inputView;
        this.cardDeque = cardDeque;
    }

    public void run() {
        List<String> playerNames = inputView.inputPlayerNames();
        List<Long> bettingMoneys = inputView.inputBettingMoney(playerNames);
        Players players = Players.from(playerNames, bettingMoneys);
        Dealer dealer = new Dealer();
        distributeDefaultCards(players, dealer);
        drawPlayerCards(players);
        drawDealerCards(dealer);
        OutputView.printDealerCardState(dealer.getCardDtos(), dealer.getScore());
        OutputView.printCardState(players.getPlayerDtos());
        OutputView.printResultHeader();
        OutputView.printDealerProfit(dealer.calculateProfit(players));
        OutputView.printPlayerProfits(playerNames, players.calculateProfits(dealer));
    }

    private void distributeDefaultCards(Players players, Dealer dealer) {
        List<String> playerNames = players.getPlayerNames();
        OutputView.printDefaultCardsDistribution(playerNames);
        dealer.drawDefaultCards(cardDeque);
        players.drawDefaultCards(cardDeque);
        CardDto dealerCardDto = dealer.getOneCardDto();
        List<PlayerDto> playerDtos = players.getPlayerDtos();
        OutputView.printDefaultCardsState(dealerCardDto, playerDtos);
    }

    private void drawPlayerCards(Players players) {
        List<Player> playerList = players.getPlayers();
        playerList.forEach(this::drawEachPlayerCards);
    }

    private void drawEachPlayerCards(Player player) {
        while (player.isAbleToDrawCard()) {
            String playerName = player.getName();
            String playerChoice = inputView.inputChoiceToDrawCard(playerName);
            if (playerChoice.equals("n")) { //todo : refactor
                return;
            }
            drawPlayerCardWithChoice(player);
        }
    }

    private void drawPlayerCardWithChoice(Player player) {
        player.drawCard(cardDeque);
        PlayerDto playerDto = PlayerDto.from(player);
        OutputView.printEachCardState(playerDto);
    }

    private void drawDealerCards(Dealer dealer) {
        if (dealer.isAbleToDrawCard()) {
            OutputView.printDealerRedraw();
            dealer.drawCard(cardDeque);
        }
    }
}
