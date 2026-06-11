package it.unibo.briscoola.view.api;

import java.util.List;
import it.unibo.briscoola.model.api.card.Card;

public interface View {
    
    /**
     * Shows the inital screen
     */
    void start();

    /**
     * Initialize the game table
     */
    void initGame();

    /**
     * Updates the card in the player's hand after the draw
     * @param playerID
     * @param handCard
     */
    void updateHand(int playerID, List<Card> handCards);

    /**
     * Updates the card count in a player's deck
     * @param cardsCount
     * @param player
     */
    void updatePile(int cardsCount, boolean player);

    /**
     * Shows amessage for the end of the game or the turn 
     * @param message
     */
    void displayMessage(String message);

    /*
     * Close the app
     */
    void quit();
}
