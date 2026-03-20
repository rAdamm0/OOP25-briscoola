package it.unibo.briscoola.model.impl.deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import it.unibo.briscoola.model.api.card.Card;
import it.unibo.briscoola.model.api.deck.Deck;

public abstract class AbstractDeckImpl<T extends Card> implements Deck<T>{

    private final List<T> deckOfCards;

    public AbstractDeckImpl(){
        this.deckOfCards=new ArrayList<>();
    }

    public AbstractDeckImpl(final List<T> initialSetOfCards){
        this.deckOfCards=new ArrayList<>(initialSetOfCards);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void shuffle(){
        if(!deckOfCards.isEmpty()){
            Collections.shuffle(deckOfCards);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final Optional<T> draw(){
        if(deckOfCards.isEmpty()){
           return Optional.empty(); 
        }else{
            /**
             * Draw the last element of the list, that is on the top
             */
            return Optional.of(deckOfCards.remove(0));
            /**
             * each iteraction is obv reducing the Deck
             */
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final Optional<T> getBriscolaSeed(){
        if(deckOfCards.isEmpty()){
            return Optional.empty();
        }else{
            return Optional.of(deckOfCards.get((deckOfCards.size())-1));

        }
    }

    /**
    * {@inheritDoc }
    */
    @Override
    public final int getActualSize(){
        return deckOfCards.size();
    }

    /**
     * {@inheritDoc} 
     */
    @Override
    public final void refillDeck(final List<T> newInitialSetOfCards){
        if(newInitialSetOfCards!=null && !newInitialSetOfCards.isEmpty()){
            this.deckOfCards.addAll(newInitialSetOfCards);
        }
    }
    
    /*
     * Allows DeckImpl to add cards to the deck, 
     * during the creation of the deck it self
     */
    protected final void addCard(final T card){
        this.deckOfCards.add(card);
    }
}
