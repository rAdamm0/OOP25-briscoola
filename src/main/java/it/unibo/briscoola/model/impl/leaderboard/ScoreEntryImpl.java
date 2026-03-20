package it.unibo.briscoola.model.impl.leaderboard;

import it.unibo.briscoola.model.api.leaderboard.ScoreEntry;

import java.util.Objects;

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

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScoreEntryImpl that = (ScoreEntryImpl) o;
        return score == that.score && Objects.equals(name, that.name);
    }

}
