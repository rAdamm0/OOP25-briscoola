package it.unibo.briscoola.model.impl.card;

import it.unibo.briscoola.model.api.attributes.CardSeed;
import it.unibo.briscoola.model.api.attributes.CardValue;
import it.unibo.briscoola.model.api.card.Card;

/**
 * Implementation of {@link Card} interface.
 */
public class StandardCardImpl implements Card {

    private final CardSeed seed;
    private final CardValue value;

    /**
     * Constructs a new {@code StandardCardImpl} with the specified value and seed.
     * 
     * @param value of the cards
     * @param seed of the cards
     */
    public StandardCardImpl(final CardValue value, final CardSeed seed) {
        this.value = value;
        this.seed = seed;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CardSeed getCardSeed() {
        return this.seed;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CardValue getCardValue() {
        return this.value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getCardPoints() {
        return this.value.getPointCard();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getCardPower() {
        return this.value.getPowerCard();
    }

}
