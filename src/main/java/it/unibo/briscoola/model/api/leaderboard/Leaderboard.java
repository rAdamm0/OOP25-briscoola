package it.unibo.briscoola.model.api.leaderboard;

import java.util.List;

public interface Leaderboard {

    /**
     * Adds an entry to the instanced leaderboard
     * @param entry new entry to add into the leaderboard
     */
    void addEntry(ScoreEntry entry);

    /**
     * Retrieves every element inside the leaderboard
     * @return a list of every entry present inside the leaderboard
     */
    List<ScoreEntry> getEntries();
}
