package it.unibo.briscoola.view.impl;

import javax.swing.*;
import java.awt.*;

import it.unibo.briscoola.model.api.attributes.Difficulty;
import it.unibo.briscoola.view.impl.menu.DifficultySelectionPanel;
import it.unibo.briscoola.view.impl.menu.MainMenu;
import it.unibo.briscoola.view.impl.menu.PlayerSelectionsPanel;

import java.awt.event.ActionListener;
import java.util.function.BiConsumer;

public class StartScreen extends JPanel{

    /**
     * it simply includes the two sub-panels 
     * and manages the exchange via CardLayout
     */
    private static final String MAIN_MENU = "MAIN";
    private static final String PLAYER_SELECTION = "SELECTION";
    private static final String DIFFICULTY_SELECTION = "DIFFICULTY";

    private final CardLayout cardLayout;
    private int temporarySelectedPlayers = 2;

    /**
     * creates a new StartScreen
     * @param onSetupComplete callback triggered when both players count and difficulty are choosen
     * @param onQuit callback triggered when the user wants to exit the application
     */
    public StartScreen(final BiConsumer<Integer,Difficulty> onSetupComplete, final ActionListener onQuit){
        this.cardLayout = new CardLayout();
        this.setLayout(this.cardLayout);
        this.setBackground(new Color(30,100, 72));

        /**
         * main menu
         */
        final JPanel mainMenu = new MainMenu(
            e -> cardLayout.show(this, PLAYER_SELECTION), 
            onQuit
        );

        /**
         * selection number of players
         */
        final JPanel playerSelection = new PlayerSelectionsPanel(
            num -> {
                /**
                 * move to the selection of difficulty
                 */
                this.temporarySelectedPlayers = num; 
                cardLayout.show(this, DIFFICULTY_SELECTION); 

            }, 
            e -> cardLayout.show(this, MAIN_MENU)
        );

        final JPanel difficultySelection = new DifficultySelectionPanel(
            diff -> onSetupComplete.accept(this.temporarySelectedPlayers, diff),
            e -> cardLayout.show(this, PLAYER_SELECTION)
        );

        this.add(mainMenu, MAIN_MENU);
        this.add(playerSelection, PLAYER_SELECTION);
        this.add(difficultySelection, DIFFICULTY_SELECTION);

    }
    
}
