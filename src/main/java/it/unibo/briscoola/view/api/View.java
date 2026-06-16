package it.unibo.briscoola.view.api;

import java.util.List;

import it.unibo.briscoola.controller.api.GameController;
import it.unibo.briscoola.controller.api.MenuController;
import it.unibo.briscoola.model.api.card.Card;

public interface View {
        
    /**
     * Set the menuController fopr handling initial configuration
     * @param menuController istance 
     */
    void setMenuController(MenuController menuController);

    /**
     * Set the gameController for handling the round mechanics and turns
     * @param gameController istance 
     */
    void setGameController(GameController gameController);

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

    /**
     * Updates the graphical representation of the card
     * @param seed
     * @param value
     */
    void updateBriscola(String seed, String value);

    /**
     * Close the app
     */
    void quit();

}
