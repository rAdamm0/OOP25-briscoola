package it.unibo.briscoola.model.api.leaderboard;

public interface ScoreEntry {

    /**
     * Retrieves the score associated of the entry
     * @return the score points associated to the Entry
     */
    int getScore();

    /**
     * Retrieves the name of the entry
     * @return the name associated to the entry
     */
    String getName();
}
