package it.unibo.briscoola.model.impl.deck;

import it.unibo.briscoola.model.api.attributes.CardSeed;
import it.unibo.briscoola.model.api.attributes.CardValue;
import it.unibo.briscoola.model.api.card.Card;
import it.unibo.briscoola.model.impl.card.StandardCardImpl;

public class DeckImpl  extends AbstractDeckImpl<Card>{
    public DeckImpl(){
        super();
        this.initializeBriscolaDeck();

        this.shuffle();
    }
    
    private void initializeBriscolaDeck(){
        for ( CardSeed seed : CardSeed.values()){
            for(CardValue value : CardValue.values()){
                this.addCard(new StandardCardImpl(value, seed));
            }
        }
    }
}
