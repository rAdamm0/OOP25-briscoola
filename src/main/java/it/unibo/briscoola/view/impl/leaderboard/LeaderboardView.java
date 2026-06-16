package it.unibo.briscoola.view.impl.leaderboard;

import it.unibo.briscoola.controller.impl.utilis.Pair;
import it.unibo.briscoola.view.api.Leaderboard;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class LeaderboardView extends JPanel implements Leaderboard {

    private final Integer SCREEN_RATIO = 5;

    private final List<Pair<String,String>> scoreboard;

    public LeaderboardView(List<Pair<String,String>> scoreboard){
        this.scoreboard = List.copyOf(scoreboard);
        this.setLayout(new GridLayout());
        this.setBackground(Color.GRAY);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        this.setSize(toolkit.getScreenSize().width/SCREEN_RATIO, toolkit.getScreenSize().height/SCREEN_RATIO);
        scoreboard.forEach(pair->
                this.add(new JLabel(pair.x() + " - " + pair.y()))
        );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showLeaderboard() {
        this.setVisible(true);
    }
}
