package it.unibo.briscoola.model.api.leaderboard;

public interface ScoreFileManager {

    /**
     *  Saves the given LeaderBoard inside the leaderboard file
     */
    void save(Leaderboard list);

    /**
     * Retrieves the data saved inside the leaderboard file
     * @return the list of entries a leaderboard if it exists, an empty leaderboard otherwise
     */
    Leaderboard load();

    /**
     * Clears every data present inside the leaderboard file
     */
    void clearLeaderBoard();
}
