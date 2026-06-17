package it.unibo.briscoola.model.impl.player.cpu;

import java.util.List;

import it.unibo.briscoola.model.api.card.Card;
import it.unibo.briscoola.model.api.player.PlayStrategy;
import it.unibo.briscoola.model.impl.game.RoundStateImpl;
import it.unibo.briscoola.model.impl.player.PlayerImpl;

/**
 * Unextendable class that represent a singular CpuPlayer.
 * Extends @link{PlayerImpl}
 */
public final class CpuPlayer extends PlayerImpl {

    private final PlayStrategy strategy;

    /**
     * Constructor of a CPU player with its id and the strategy to follow.
     *
     * @param id id of the player
     * @param strategy Strategy to adapt based on the {@link StrategyFactory}
     */
    public CpuPlayer(final int id, final PlayStrategy strategy) {
        super(id);
        this.strategy = strategy;
    }

    public CpuPlayer(final int id, final int points, final List<Card> hand, final List<Card> pile, final PlayStrategy strategy) {
        super(id, points, hand, pile);
        this.strategy = strategy;
    }

    public CpuPlayer copy() {
        return new CpuPlayer(this.getId(), this.getPoints(), this.getHand(), this.getPile(), this.strategy);
    }

    @Override
    public Card playCard(final RoundStateImpl state) {
        final int index = strategy.cardIndex(this.getHand(), state);
        return this.getHand().get(index);
    }

}
