package it.unibo.briscoola.view.impl;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * represents the view of the deck of cards taken by the player.
 */
public class PileView extends JPanel {

    /**
     * card counting graphic label. --> Initialized to "0", private for security ù
     */
    private final JLabel labelForCount = new JLabel("0");

    /**
     * Dedicated label to contain the image of the back
     */
    private final JLabel imageLabel = new JLabel();

    /**
     * builds a specific panel for displaying the cards.
     * @param ownerName The name of the deck owner : "CPU" or "Player".
     */
    public PileView(String ownerName) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder(ownerName + " Pile "));
        setPreferredSize(new Dimension(150, 100));

        /**
         * representation of the deck 
         */
        URL backUrl = getClass().getResource("/cards/backside.png");

        if (backUrl != null) {
            ImageIcon icon = new ImageIcon(backUrl);
            /**
             * Resize the back to fit in the panel.
             */
            Image img = icon.getImage().getScaledInstance(75, 110, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(img));
        }else {
            /**
             * Fallback if the image is not there, 
             * so it doesn't crash and is visible text "BACK"
             */
            imageLabel.setText("BACK");
            imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
            imageLabel.setOpaque(true);
            imageLabel.setBackground(new Color(100, 149, 237));
            imageLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }

        labelForCount.setHorizontalAlignment(SwingConstants.CENTER);
        labelForCount.setForeground(Color.WHITE);

        add(imageLabel, BorderLayout.CENTER); 
        add(labelForCount, BorderLayout.SOUTH);
        
        /**
         * At the start of the game the pile is empty, so we hide the back
         */
        imageLabel.setVisible(false);
    }

    /**
     * updates the number of cards displayed
     * transform the entire "count" into a string and set it in the label
     * @param count hte new number of the cards won to show
     */
    public void updateCount(final int count) {
        /**
         * If the player or the CPU has taken at least one card, we show the back on the table
         */
        if (count > 0) {
            this.imageLabel.setVisible(true);
        } else {
            this.imageLabel.setVisible(false);
        }
        this.labelForCount.setText(String.valueOf(count));
    }
}