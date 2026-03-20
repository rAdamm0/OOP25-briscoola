package it.unibo.briscoola.model.api.leaderboard;

import java.io.IOException;
import java.util.List;

public interface ScoreFileManager {

    /**
     *  Saves the given LeaderBoard inside the leaderboard file
     * @return true if the save was successful, false otherwise
     */
    boolean save(List<ScoreEntry> list);

    /**
     * Retrieves the data saved inside the leaderboard file
     * @return the list of entries a leaderboard if it exists, an empty leaderboard otherwise
     */
    List<ScoreEntry> load();

    /**
     * Clears every data present inside the leaderboard file
     */
    void clearLeaderBoard();
}
