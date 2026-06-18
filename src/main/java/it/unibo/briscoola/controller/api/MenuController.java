package it.unibo.briscoola.controller.api;

import it.unibo.briscoola.model.api.attributes.Difficulty;

/**
 * Manager of the initial menu and setup of the Briscola game.
 */
public interface MenuController {

    /**
     * Officially start game by configuring the model and view
     * based on the number of players selected.
     * 
     * @param numPlayers the number of players (only accepts 2 or 4)
     * @param difficulty the difficulty of the match
     */
    void startGame(int numPlayers, Difficulty difficulty);
}
