package it.unibo.briscoola.model.impl.leaderboard;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import it.unibo.briscoola.model.api.leaderboard.ScoreEntry;
import it.unibo.briscoola.model.api.leaderboard.ScoreFileManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * A JSON-based implementation of the {@link ScoreFileManager} interface.
 *
 * <p>
 * This class handles the serialization and deserialization of leaderboard data
 * using the Google Gson library. Data is persisted to a local JSON file
 * located in the user's home directory under the {@code .briscoola} folder.
 */
public class ScoreFileManagerImpl implements ScoreFileManager {

    /**
     * The name of the hidden directory for game configuration.
     */
    private static final String FOLDER_NAME = ".briscoola";

    /**
     * The name of the file for game leaderboard.
     */
    private static final String FILE_NAME = "leaderboard.json";

    /**
     * The path to the JSON file where the leaderboard is stored.
     */
    private final Path leaderboardPath = Paths.get(System.getProperty("user.home"), FOLDER_NAME, FILE_NAME);

    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private final Logger logger = LoggerFactory.getLogger(ScoreFileManagerImpl.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean save(final List<ScoreEntry> list) {
        if (list == null) {
            return false;
        }
        try {
            final Path parentDir = leaderboardPath.getParent();
            if (parentDir != null && Files.notExists(parentDir)) {
                Files.createDirectories(parentDir);
            }
            if (Files.notExists(leaderboardPath)) {
                Files.createFile(leaderboardPath);
            }
            final String toWrite = gson.toJson(list);
            Files.writeString(leaderboardPath, toWrite);
            return true;
        } catch (final IOException e) {
            logger.error("{}: Error during the Manager save method-> {}", Instant.now(), e.getMessage());
            return false;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ScoreEntry> load() {
        if (Files.notExists(leaderboardPath)) {
            return List.of();
        }
        try (Reader reader = Files.newBufferedReader(leaderboardPath, StandardCharsets.UTF_8)) {
            final TypeToken<List<ScoreEntryImpl>> listType = new TypeToken<>() {
            };
            final Optional<List<ScoreEntry>> list = Optional.ofNullable(gson.fromJson(reader, listType.getType()));
            return list.orElse(new ArrayList<>());

        } catch (final IOException e) {
            logger.error("{}: Error during the Manager load method-> {}", Instant.now(), e.getMessage());
            return List.of();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clearLeaderBoard() {
        this.save(List.of());
    }
}
