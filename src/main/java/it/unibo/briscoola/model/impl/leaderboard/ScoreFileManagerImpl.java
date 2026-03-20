package it.unibo.briscoola.model.impl.leaderboard;

import com.google.gson.Gson;
import it.unibo.briscoola.model.api.leaderboard.Leaderboard;
import it.unibo.briscoola.model.api.leaderboard.ScoreEntry;
import it.unibo.briscoola.model.api.leaderboard.ScoreFileManager;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ScoreFileManagerImpl implements ScoreFileManager {

    Path path = Paths.get(System.getProperty("user.home"), ".briscoola", "leaderboard.json");

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(Leaderboard list) {
        Gson gson = new Gson();
        String toWrite = gson.toJson(list.getEntries(),list.getEntries().getClass());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ScoreEntry> load() {
        return List.of();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clearLeaderBoard() {

    }
}
