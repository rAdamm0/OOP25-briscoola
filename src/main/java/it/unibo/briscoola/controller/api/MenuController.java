package it.unibo.briscoola.controller.api;

public interface MenuController {
    /**
     * Manager of the initial menu and setup of the Briscola game.
     */


    /**
     * Officially start game by configuring the model and view
     * based on the number of players selected.
     * * @param numPlayers the number of players (only accepts 2 or 4)
     */
    void startGame(int numPlayers);
}
