package it.unibo.briscoola.controller.api;

import it.unibo.briscoola.model.api.attributes.Difficulty;

/**
<<<<<<< HEAD
 * Manager of the initial menu and setup of the Briscola game.
=======
 * Manages the initial menu and setup of the Briscola game.
>>>>>>> 7624f18840a5bc0afd9dfb609c79db98fdb52eb2
 */
public interface MenuController {

    /**
     * Officially start game by configuring the model and view
     * based on the number of players selected.
     * 
     * @param numPlayers the number of players (only accepts 2 or 4)
<<<<<<< HEAD
     * @param difficulty the difficulty of the match
=======
     * @param difficulty the selecred difficulty level
>>>>>>> 7624f18840a5bc0afd9dfb609c79db98fdb52eb2
     */
    void startGame(int numPlayers, Difficulty difficulty);
}
