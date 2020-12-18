package blackjack.dto;

import blackjack.domain.user.Player;

import java.util.List;

public class PlayerDto {

    private final String playerName;
    private final List<CardDto> cardDtos;
    private final int score;

    private PlayerDto(String playerName, List<CardDto> cardDtos, int score) {
        this.playerName = playerName;
        this.cardDtos = cardDtos;
        this.score = score;
    }

    public static PlayerDto from(Player player) {
        return new PlayerDto(player.getName(), player.getCardDtos(), player.getScore());
    }

    public String getPlayerName() {
        return playerName;
    }

    public List<CardDto> getCardDtos() {
        return cardDtos;
    }

    public int getScore() {
        return score;
    }
}
