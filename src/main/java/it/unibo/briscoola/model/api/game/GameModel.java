package it.unibo.briscoola.model.api.game;

import java.util.Optional;

import it.unibo.briscoola.model.api.card.Card;

public interface GameModel {

    /**
     * start the match giving 3 cards to each player
     */
    void startMatch();
    
    /**
     * I dont have now access to the class Player but is how i think that:
     * Player winnerOfHand(Map<Player, Card> table);
     */

     Optional<Card> getBriscolaSeed();

     /**
      * checks if the game is ended, 
      * that happens when 
      * all the players used all they cards.
      * When players have the Hand empty.
      */
     boolean isGameOver();
}
