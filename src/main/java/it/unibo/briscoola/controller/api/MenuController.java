package it.unibo.briscoola.controller.api;

import it.unibo.briscoola.controller.impl.utils.Pair;
import it.unibo.briscoola.model.api.attributes.Difficulty;

import java.util.List;
import it.unibo.briscoola.model.api.leaderboard.Leaderboard;

/**
 * Manages the initial menu and setup of the Briscola game.
 */
public interface MenuController {

    /**
     * Officially start game by configuring the model and view
     * based on the number of players selected.
     * 
     * @param numPlayers the number of players (only accepts 2 or 4)
     * @param difficulty the selecred difficulty level
     */
    void startGame(int numPlayers, Difficulty difficulty);

    /**
     * Method that retrieves the leaderboard from the {@link Leaderboard} and
     * manipulates it to return a {@link List} of {@link Pair} of {@link String}.
     *
     * @return a {@link List} of pairs of strings matching each player with the highscore
     */
    List<Pair<String, String>> getLeaderboardDate();
}
