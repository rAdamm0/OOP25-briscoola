package it.unibo.briscoola.view.impl.menu;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.function.Consumer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import it.unibo.briscoola.model.api.attributes.Difficulty;

public class DifficultySelectionPanel extends JPanel{
    /**
     * Constructs a panel for selecting the difficulty.
     * @param chooseDifficulty the consumer triggered when a difficulty button is clicked
     */
    public DifficultySelectionPanel(final Consumer<Difficulty> chooseDifficulty, final ActionListener backClicked) {
        /**
         * Use GridBagLayout for flexible component centering and layout alignment
         */
        this.setLayout(new GridBagLayout());
        this.setOpaque(false);

        /**
         * Layout Rows (Y-axis placement):
         * gridy = 0 -> Panel Header Title
         * gridy = 1 -> Easy Difficulty Option
         * gridy = 2 -> Medium Difficulty Option
         * gridy = 3 -> Hard Difficulty Option
         * gridy = 4 -> Navigation Back Button
         */
        final GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.gridx = 0;

        final JLabel title = new JLabel("Select CPU Difficulty");
        title.setFont(new Font("Serif", Font.BOLD, 60));
        title.setForeground(Color.WHITE);
        gbc.gridy = 0;
        this.add(title, gbc);

        final JButton btnEasy = new JButton("Easy");
        btnEasy.setPreferredSize(new Dimension(200, 50));
        btnEasy.addActionListener(e -> chooseDifficulty.accept(Difficulty.EASY));
        gbc.gridy = 1;
        this.add(btnEasy, gbc);

        final JButton btnMedium = new JButton("Medium");
        btnMedium.setPreferredSize(new Dimension(200, 50));
        btnMedium.addActionListener(e -> chooseDifficulty.accept(Difficulty.MEDIUM));
        gbc.gridy = 2;
        this.add(btnMedium, gbc);

        final JButton btnHard = new JButton("Hard");
        btnHard.setPreferredSize(new Dimension(200, 50));
        btnHard.addActionListener(e -> chooseDifficulty.accept(Difficulty.HARD));
        gbc.gridy = 3;
        this.add(btnHard, gbc);

        final JButton btnBack = new JButton("Back");
        btnBack.setPreferredSize(new Dimension(200, 50));
        btnBack.addActionListener(backClicked);
        gbc.gridy = 4;
        this.add(btnBack, gbc);
    }
}
