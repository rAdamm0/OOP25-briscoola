package it.unibo.briscoola.model.api.game;

import java.util.List;

import it.unibo.briscoola.model.api.player.Player;

public interface GameFactory {

        /**
         * It generate a new istance of GameModel, 
         * starting the deck, giving the values and seed
         * to each card of the deck 
         */
        GameModel createStandardGame(List<Player> players);
}
