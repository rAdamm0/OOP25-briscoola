package it.unibo.briscoola.model.impl.game;
import java.util.List;

import it.unibo.briscoola.model.api.card.Card;
import it.unibo.briscoola.model.api.player.Player;

public record RoundWinner(Player player, List<Card> wonCards) {
    
    public RoundWinner(Player player, List<Card> wonCards){
        this.player = player.copy();
        this.wonCards = List.copyOf(wonCards); 
    }

    @Override
    public Player player() {
        return this.player.copy();
    }
    
    @Override
    public List<Card> wonCards() {
        return List.copyOf(this.wonCards);
    }
}