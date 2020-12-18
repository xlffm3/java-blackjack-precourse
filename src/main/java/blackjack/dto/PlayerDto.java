package blackjack.dto;

import blackjack.domain.user.Player;

import java.util.List;

public class PlayerDto {

    private final String playerName;
    private final List<CardDto> cardDtos;

    private PlayerDto(String playerName, List<CardDto> cardDtos) {
        this.playerName = playerName;
        this.cardDtos = cardDtos;
    }

    public static PlayerDto from(Player player) {
        return new PlayerDto(player.getName(), player.getCardDtos());
    }

    public String getPlayerName() {
        return playerName;
    }

    public List<CardDto> getCardDtos() {
        return cardDtos;
    }
}
