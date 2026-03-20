package it.unibo.briscoola.leaderboard;

import it.unibo.briscoola.model.api.leaderboard.Leaderboard;
import it.unibo.briscoola.model.api.leaderboard.ScoreEntry;
import it.unibo.briscoola.model.impl.leaderboard.LeaderboardImpl;
import it.unibo.briscoola.model.impl.leaderboard.ScoreEntryImpl;
import it.unibo.briscoola.model.impl.leaderboard.ScoreFileManagerImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

public class LeaderboardTest {
    private Leaderboard board;
    private List<ScoreEntry> testingList;

    @BeforeEach
    void init(){
        this.board = new LeaderboardImpl(new ScoreFileManagerImpl());
        this.testingList = new ArrayList<>(List.of(
                new ScoreEntryImpl("Adam", 300),
                new ScoreEntryImpl("Giacomo", 400),
                new ScoreEntryImpl("Francesca", 350),
                new ScoreEntryImpl("Marta", 500)
        ));
    }

    @Test void leaderboardTest(){
        for(ScoreEntry e : testingList){
            assertTrue(this.board.addEntry(e));
        }
        assertEquals(this.board.getEntries(),this.testingList.stream().sorted(Comparator.comparing(ScoreEntry::getScore)).toList());
        assertThrows(NullPointerException.class,()-> this.board.addEntry(null));
        assertFalse(this.board.addEntry(new ScoreEntryImpl("Gino", 0)));
    }
}
