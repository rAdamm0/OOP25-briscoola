package it.unibo.briscoola.model.api.player;

import it.unibo.briscoola.model.api.card.Card;

import java.util.List;

public interface PlayStrategy {

    /**
     * Returns the card to be played by the CPU
     * @param hand cards in hand of the CPU
     * @return the card to be played
     */
    int playCard(List<Card> hand);
}
