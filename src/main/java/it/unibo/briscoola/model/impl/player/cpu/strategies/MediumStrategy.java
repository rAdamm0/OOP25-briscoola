package it.unibo.briscoola.model.impl.player.cpu.strategies;

import it.unibo.briscoola.model.api.card.Card;
import it.unibo.briscoola.model.api.player.PlayStrategy;

import java.util.List;

/**
 * Strategy of the CPU for choosing the card to be played in Medium Difficulty
 */
public class MediumStrategy implements PlayStrategy {

    /**
     * {@inheritDoc}
     */
    @Override
    public int cardIndex(final List<Card> hand) {
        return 0;
    }
}
