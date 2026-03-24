package it.unibo.briscoola.model.impl.player.cpu;

import it.unibo.briscoola.model.api.card.Card;
import it.unibo.briscoola.model.api.player.PlayStrategy;
import it.unibo.briscoola.model.impl.player.PlayerImpl;

/**
 * Unextendable class that represent a singular CpuPlayer.
 * Extends @link{PlayerImpl}
 */
public final class CpuPlayer extends PlayerImpl {

    private final PlayStrategy strategy;

    /**
     * Constructor of a CPU player with 2 parameters
     *
     * @param id id of the player
     * @param strategy Strategy to adapt based on the @link{StrategyFactory}
     */
    public CpuPlayer(final int id, final PlayStrategy strategy) {
        super(id);
        this.strategy = strategy;
    }

    @Override
    public Card playCard() {
        final int index = strategy.playCard(this.getHand());
        return super.playCard(index);
    }

}
