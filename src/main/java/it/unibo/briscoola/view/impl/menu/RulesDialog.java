package it.unibo.briscoola.view.impl.menu;

import javax.swing.*;
import java.awt.*;

public class RulesDialog extends JDialog {

    public RulesDialog(JFrame parentFrame) {
        super(parentFrame, "Rules of the Game", true);

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setSize(550, 600);
        setLocationRelativeTo(parentFrame);

        Color lightGreenBg = new Color(190, 225, 190);
        Color pinkButtonColor = new Color(255, 180, 200);

        JTextArea textArea = new JTextArea(getRulesText());
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Arial", Font.BOLD, 14));
        textArea.setBackground(lightGreenBg);
        textArea.setForeground(Color.BLACK);
        textArea.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBorder(null);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JButton closeButton = new JButton("CLOSE");
        closeButton.setFont(new Font("Arial", Font.BOLD, 16));
        closeButton.setBackground(pinkButtonColor);
        closeButton.setFocusPainted(false);
        closeButton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(10, 30, 10, 30)
        ));

        closeButton.addActionListener(e -> dispose());

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 15));
        buttonPanel.setBackground(lightGreenBg);
        buttonPanel.add(closeButton);

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private String getRulesText() {
        return "BRISCOLA GAME RULES\n\n" +
                "1. SETUP\n" +
                "• The player enters an optional name.\n" +
                "• The player is required to choose the game Difficulty.\n" +
                "• Each player is given 3 cards.\n" +
                "• The Briscola card gets chosen and put on the table face up.\n\n" +
                "4. CARD EXPLANATION:\n"+
                "The Cards follow a power logic following the order of the sequent list\n"+
                "In which there will be listed the points of each card as well\n"+
                "TWO -> 0\n"+
                "FOUR -> 0\n"+
                "FIVE -> 0\n"+
                "SIX -> 0\n"+
                "SEVEN -> 0\n"+
                "EIGHT/SOLDIER -> 2\n"+
                "NINE/HORSE -> 3\n"+
                "TEN/KING -> 4\n"+
                "THREE -> 10\n"+
                "ONE/ACE -> 11\n"+
                "3. YOUR TURN\n" +
                "Select the card to be played based on:\n\n" +
                " - Cards on the table:\n"+
                "       Remember that the briscola seed rules over every other\n"+
                "       If there is no briscola on the table the leadSeed rules\n\n"+
                "4. CPU TURN\n"+
                "The CPU elaborates what is on the table and makes its move\n"+
                "based on the chosen difficulty"+
                "5. DETERMINE WINNER\n"+
                "The game decides the winner of the round and starts a new round\n"+
                "The next round is started by the winner of the latest\n"+
                "This process repeats until the deck and every player's hand is empty\n"+
                "6. LEADERBOARD SCORING\n"+
                "The player will see his points on the leaderboard\n" +
                "If high enough"                ;
    }
}
