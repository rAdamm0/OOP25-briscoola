package it.unibo.briscoola.view.impl.menu;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.function.Consumer;


public class PlayerSelectionsPanel extends JPanel {
    /**
     * is only showing the options for the number of players.
     * letting choose the type of match : 
     * 2 or 4 players 
     */
    public PlayerSelectionsPanel(final Consumer<Integer> chosePlayer, final ActionListener backClicked){

        this.setLayout(new GridBagLayout());
        this.setOpaque(false);

        final GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15); /* this define empty space around the components / buttons */
        gbc.gridx = 0; /*all in one central column */

        /**
         * to be sure.
         * "gbc.gridy" defines the row (Y) of the grid in which to place the component.
         * By increasing "gridy", components are stacked vertically. 
         * "gridy" = 0 -> "title" , "gridy" = 1 -> "Button : Play" , "gridy" = 2 -> "Button : Exit"
         */

        final JLabel title = new JLabel("Select Number of Players");
        title.setFont(new Font("Serif", Font.BOLD, 70));
        title.setForeground(Color.WHITE);
        gbc.gridy = 0;
        this.add(title, gbc);


        /**
         * button for 2 players 
         */
        final JButton btn2Players = new JButton("2 Players");
        btn2Players.setPreferredSize(new Dimension(200, 50));
        btn2Players.addActionListener(e -> chosePlayer.accept(2)); 
        /**
         * the 2 is the exactly number to give to the consumer, 
         * that will move that value out in the view 
         */
        gbc.gridy = 1;
        add(btn2Players, gbc);

        /**
         * button for 4 players 
         */
        final JButton btn4Players = new JButton("4 Players");
        btn4Players.setPreferredSize(new Dimension(200, 50));
        btn4Players.addActionListener(e -> chosePlayer.accept(4)); 
        gbc.gridy = 2;
        add(btn4Players, gbc);


        /**
         * button of exit
         */
        JButton btnQuit = new JButton("Back");
        btnQuit.setPreferredSize(new Dimension(200, 50));
        btnQuit.addActionListener(backClicked);
        gbc.gridy = 3;
        add(btnQuit, gbc);
    }
    
}
