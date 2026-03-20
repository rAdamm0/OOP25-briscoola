package it.unibo.briscoola.model.impl.leaderboard;

import it.unibo.briscoola.model.api.leaderboard.ScoreEntry;

public class ScoreEntryImpl implements ScoreEntry {

    private final int score;
    private final String name;

    public ScoreEntryImpl(final String name, final int score) {
        this.name = name;
        this.score = score;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getScore() {
        return this.score;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return this.name;
    }
}
