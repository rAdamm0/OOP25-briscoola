package it.unibo.briscoola.leaderboard;

import it.unibo.briscoola.model.api.leaderboard.Leaderboard;
import it.unibo.briscoola.model.api.leaderboard.ScoreEntry;
import it.unibo.briscoola.model.api.leaderboard.ScoreFileManager;
import it.unibo.briscoola.model.impl.leaderboard.LeaderboardImpl;
import it.unibo.briscoola.model.impl.leaderboard.ScoreEntryImpl;
import it.unibo.briscoola.model.impl.leaderboard.ScoreFileManagerImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ScoreFileManagerTest {
    private ScoreFileManager manager = new ScoreFileManagerImpl();
    private Leaderboard board;
    private List<ScoreEntry> testingList;

    @BeforeEach
    void init(){
        this.board = new LeaderboardImpl(manager);
        this.testingList = new ArrayList<>(List.of(
                new ScoreEntryImpl("Adam", 300),
                new ScoreEntryImpl("Giacomo", 400),
                new ScoreEntryImpl("Francesca", 350),
                new ScoreEntryImpl("Marta", 500)
        ));
    }

    @Test void saveTest(){
        this.board.addEntries(testingList);
        assertTrue(manager.save(board.getEntries()));
        assertEquals(manager.load(), this.testingList.stream().sorted(Comparator.comparing(ScoreEntry::getScore)).toList());
    }

    @Test void loadTest(){
        assertEquals(manager.load(), List.of());
    }

    @AfterEach
    void clear(){
        this.manager.clearLeaderBoard();
    }
}
