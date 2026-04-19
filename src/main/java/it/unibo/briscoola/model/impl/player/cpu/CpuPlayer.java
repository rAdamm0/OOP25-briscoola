package it.unibo.briscoola.model.impl.player.cpu;

import it.unibo.briscoola.model.api.card.Card;
import it.unibo.briscoola.model.api.player.PlayStrategy;
import it.unibo.briscoola.model.impl.game.RoundStateImpl;
import it.unibo.briscoola.model.impl.player.PlayerImpl;

import java.util.function.Consumer;

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
    public Card playCard(RoundStateImpl state, Consumer<Card> callback) {
        final int index = strategy.cardIndex(this.getHand(), state);
        callback.accept(this.getHand().get(index));
        return super.playCard(index);
    }

}
