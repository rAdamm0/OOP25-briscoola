package it.unibo.briscoola.controller.api;

import it.unibo.briscoola.model.api.attributes.Difficulty;
import it.unibo.briscoola.view.api.View;

/**
 * Manages the initial menu and setup of the Briscola game.
 * 
 * @author Andrea Reggiani
 */
public interface MenuController {

    /**
     * Officially start game by configuring the model and view
     * based on the number of players selected.
     * 
     * @param numPlayers the number of players (only accepts 2 or 4)
     * @param difficulty the selecred difficulty level
     * @param view the view istance to interact with
     */
    void startGame(String namePlayer, Difficulty difficulty, View view);
}
