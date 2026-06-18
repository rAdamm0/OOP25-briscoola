package it.unibo.briscoola.model.impl.deck;

import it.unibo.briscoola.model.api.attributes.CardSeed;
import it.unibo.briscoola.model.api.attributes.CardValue;
import it.unibo.briscoola.model.api.card.Card;
import it.unibo.briscoola.model.impl.card.StandardCardImpl;

<<<<<<< HEAD
/**
 * Concrete implementation of a deck of cards .
 * This class extends {@link AbstractDeckImpl} and generate the deck by combining
 * all the seeds and values.
 */
public class DeckImpl extends AbstractDeckImpl<Card> {

    /**
     * Constructs and initializes a deck
     * and shuffles the deck to ensure
     * randomness at the start of the match.
     */
=======
public class DeckImpl extends AbstractDeckImpl<Card> {
>>>>>>> 7624f18840a5bc0afd9dfb609c79db98fdb52eb2
    public DeckImpl() {
        super();
        this.initializeBriscolaDeck();

        this.shuffle();
    }

<<<<<<< HEAD
    /**
     * Populates the deck.
     */
=======
>>>>>>> 7624f18840a5bc0afd9dfb609c79db98fdb52eb2
    private void initializeBriscolaDeck() {
        for (final CardSeed seed : CardSeed.values()) {
            for (final CardValue value : CardValue.values()) {
                this.addCard(new StandardCardImpl(value, seed));
            }
        }
    }
}
