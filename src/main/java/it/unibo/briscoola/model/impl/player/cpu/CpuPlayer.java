package it.unibo.briscoola.model.impl.player.cpu;

import it.unibo.briscoola.model.api.card.Card;
import it.unibo.briscoola.model.api.player.PlayStrategy;
import it.unibo.briscoola.model.impl.player.PlayerImpl;

public class CpuPlayer extends PlayerImpl {

    private final PlayStrategy strategy;

    public CpuPlayer(int id, PlayStrategy strategy) {
        super(id);
        this.strategy = strategy;
    }


    @Override
    public Card playCard() {
        int index = strategy.playCard(this.getHand());
        return super.playCard(index);
    }

}
