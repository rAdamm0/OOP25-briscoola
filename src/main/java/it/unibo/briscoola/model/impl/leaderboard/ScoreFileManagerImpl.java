package it.unibo.briscoola.model.impl.leaderboard;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import it.unibo.briscoola.model.api.leaderboard.Leaderboard;
import it.unibo.briscoola.model.api.leaderboard.ScoreEntry;
import it.unibo.briscoola.model.api.leaderboard.ScoreFileManager;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ScoreFileManagerImpl implements ScoreFileManager {

    private final Path leaderboardPath = Paths.get(System.getProperty("user.home"), ".briscoola", "leaderboard.json");
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean save(final List<ScoreEntry> list) {
        if(list == null){
            return false;
        }
        try {
            if(Files.notExists(leaderboardPath.getParent())){
                Files.createDirectories(leaderboardPath.getParent());
            }
            if(Files.notExists(leaderboardPath)){
                Files.createFile(leaderboardPath);
            }
            String toWrite = gson.toJson(list);
            Files.writeString(leaderboardPath, toWrite);
            return true;
        }catch (IOException e){
            System.out.println(new Date().toString() + ": Error during the Manager save method-> " + e.getMessage());
            return false;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ScoreEntry> load() {
        if(Files.notExists(leaderboardPath)){
            return List.of();
        }
        try(Reader reader = new FileReader(leaderboardPath.toString());){
            TypeToken<ArrayList<ScoreEntryImpl>> listType = new TypeToken<>(){};
            Optional<ArrayList<ScoreEntry>> list = Optional.of(gson.fromJson(reader,listType.getType()));
            return list.orElse(new ArrayList<>());

        } catch (Exception e) {
            System.out.println(new Date().toString() + ": Error during the Manager load method-> " + e.getMessage());
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
