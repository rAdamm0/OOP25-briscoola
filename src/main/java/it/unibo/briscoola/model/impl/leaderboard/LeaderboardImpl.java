package it.unibo.briscoola.model.impl.leaderboard;

import it.unibo.briscoola.model.api.leaderboard.Leaderboard;
import it.unibo.briscoola.model.api.leaderboard.ScoreEntry;
import it.unibo.briscoola.model.api.leaderboard.ScoreFileManager;

import java.util.*;

public class LeaderboardImpl implements Leaderboard {

    private final List<ScoreEntry> list;

    public LeaderboardImpl(final ScoreFileManager files) {
        this.list = new ArrayList<>(files.load());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean addEntry(final ScoreEntry entry) {
        if(entry.getScore() == 0){
            return false;
        }
        return this.list.add(Objects.requireNonNull(entry, "The entry cannot be null"));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean addEntries(Collection<? extends ScoreEntry> entryCollection) {
        Objects.requireNonNull(entryCollection, "The entry collection cannot be null");
        return entryCollection.stream()
                .map(this::addEntry)
                .reduce(false, (a, b) -> a || b);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ScoreEntry> getEntries() {
        return this.list.stream().sorted(Comparator.comparing(ScoreEntry::getScore)).toList();
    }
}
