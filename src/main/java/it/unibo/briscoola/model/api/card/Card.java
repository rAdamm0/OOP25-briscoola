package it.unibo.briscoola.model.api.card;

import it.unibo.briscoola.model.api.attributes.CardSeed;
import it.unibo.briscoola.model.api.attributes.CardValue;

public interface Card {
        
    /**
    * @return the seed of the card 
    */
    CardSeed getCardSeed();

    /**
    * @return the value of the card 
    */
    CardValue getCardValue();

    /**
     * @return the points of the card 
     */
    int getCardPoints();

    /**
     * @return the Strength of the card 
     */
    int getCardPower();
}
