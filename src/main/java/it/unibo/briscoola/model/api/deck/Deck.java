package it.unibo.briscoola.model.api.deck;

import java.util.List;
import java.util.Optional;

import it.unibo.briscoola.model.api.card.Card;

public interface Deck <T extends Card> {

    /**
     * Shuffle the deck randomicaly
     */
    void shuffle();

    /**
     * Try to draw a card from the top, that is considered the end of the Deck 
     * @return an Optional
     */
    Optional<T> draw();

    /**
     * @return the Dominant seed for the match
     * but is not removing any card
     * is used only to display the card at the start of the match
     */
    Optional<T> getBriscolaSeed();

    /**
     * @return the number of cards left in the deck to display in yhe game
     */
    int getActualSize();

    /**
     * @return a boolean, to check if the deck is empty
     */
    boolean isEmpty();

    /**
     * restart the deck when the match is over,
     * if the player want to start a new match but also to save the winning streak 
     */
    void refillDeck(List<T> newInitialSetOfCards);
}
