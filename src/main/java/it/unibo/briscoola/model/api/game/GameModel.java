package it.unibo.briscoola.model.api.game;

import java.util.Optional;

import it.unibo.briscoola.model.api.card.Card;
import it.unibo.briscoola.model.api.player.Player;

public interface GameModel {

    /**
     * start the match giving 3 cards to each player
     */
    void startMatch();
    
    /**
     * @return th Card defined as Briscola, to choose se Seed 
     */
    Optional<Card> getBriscolaSeed();

     /**
      * checks if the game is ended, 
      * that happens when 
      * all the players used all they cards.
      * When players have the Hand empty.
      */
    boolean isGameOver();

    /**
     * Picks the first card from the deck -> that will be the briscola
     * and put it at the bottom of the deck.
     */
    void assignBriscola();

    /**
     * At first, deals 3 cards to each player, alternating between them
     */
    void dealInitialCards();

    /**
     * After a trick, the winner draws first, then the loser. 
     * If the deck is empty, nobody will draw.
     * @param winner the player who won the trick
     * @param loser the player who lost the trick
     */
    void drawAfterTrick(Player winner, Player loser);

    /**
     * Plays the card at the given index (from the human player's hand)
     * @param index is the position of the card in hand (0, 1 or 2)
     * @return the played card
     */
    Card playCard(int index);
}
