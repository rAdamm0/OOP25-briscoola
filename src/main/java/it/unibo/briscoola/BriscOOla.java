package it.unibo.briscoola;

import it.unibo.briscoola.controller.api.MenuController;
import it.unibo.briscoola.controller.impl.MenuControllerImpl;
import it.unibo.briscoola.model.api.game.GameModel;
import it.unibo.briscoola.view.impl.GameViewImpl;

/**
 * Class that handles the launch of the game.
 */
public final class BriscOOla {

    private BriscOOla() { }

    /**
     * Launches the application.
     * @param args a string with the movie/series name.
     */
    public static void main(final String[] args) {
        
            final GameModel initialMode = null;

            GameViewImpl gameView = new GameViewImpl(null);

            final MenuController menuController = new MenuControllerImpl(initialMode, gameView);

            gameView.setMenuController(menuController);

            gameView.start(); 
             
    }
}
