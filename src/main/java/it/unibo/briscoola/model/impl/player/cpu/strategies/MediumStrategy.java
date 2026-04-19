package it.unibo.briscoola.model.impl.player.cpu.strategies;

import it.unibo.briscoola.model.api.card.Card;
import it.unibo.briscoola.model.api.player.PlayStrategy;
import it.unibo.briscoola.model.impl.game.RoundStateImpl;

import java.util.List;

/**
 * Strategy of the CPU for choosing the card to be played in Medium Difficulty.
 * Points to use the best fit for the card present on the table.
 */
public class MediumStrategy implements PlayStrategy {

    /**
     * {@inheritDoc}
     */
    @Override
    public int cardIndex(final List<Card> hand, RoundStateImpl state) {
        return 0;
    }
}
