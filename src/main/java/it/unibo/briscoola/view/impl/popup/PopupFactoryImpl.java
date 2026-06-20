package it.unibo.briscoola.view.impl.popup;

import it.unibo.briscoola.controller.impl.utils.Pair;
import it.unibo.briscoola.view.api.popup.PopupFactory;
import it.unibo.briscoola.view.api.popup.Popups;
import it.unibo.briscoola.view.impl.GameViewImpl;
import it.unibo.briscoola.view.impl.leaderboard.LeaderboardView;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;

/**
 * Factory class that hallows the creation of a specific {@link Popup}
 * through the use of a {@link Popups} element and the
 * message to be displayed.
 *
 * @author Adam Paolo Razzino
 */
public class PopupFactoryImpl implements PopupFactory {

    private final JButton exit;
    private final JRootPane root;
    private final Supplier<List<Pair<String, String>>> leaderboardSupplier;
    private final Toolkit toolkit = Toolkit.getDefaultToolkit();
    private final int BG_R = 30;
    private final int BG_G = 100;
    private final int BG_B = 72;
    private final int rows = 0;
    private final int cols = 1;
    private final int hGap = 0;
    private final int vGap = 15;
    private int x;
    private int y;
    private boolean isShowing = false;

    public PopupFactoryImpl(final JRootPane root,
                            final Supplier<List<Pair<String, String>>> leaderboardSupplier) {
        this.root = root;
        this.leaderboardSupplier = leaderboardSupplier;
        this.exit = new JButton("Exit");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Popup create(final Popups popup, final String message) {
        switch (popup) {
            case WINNER -> {
                return this.roundWinnerPopup(message);
            }
            case ENDGAME -> {
                return this.endGamePopup(message);
            }
            case PAUSE ->{
                return this.pausePopup();
            }
        }
        return null;
    }

    private Popup roundWinnerPopup(final String message) {
        Popup localPopup[] = new Popup[1];
        final int codePoint = 1096;
        final String trophy = new String(Character.toChars(codePoint));
        final JComponent contentPane = new JPanel(new GridLayout(this.rows, this.cols, this.hGap, this.vGap));
        contentPane.setPreferredSize(new java.awt.Dimension(300, 200));
        Border line = BorderFactory.createLineBorder(Color.getHSBColor(30, 100, 72), 2);
        Border padding = BorderFactory.createEmptyBorder(20, 20, 20, 20);
        contentPane.setBorder(BorderFactory.createCompoundBorder(line, padding));
        contentPane.setBackground(new Color(this.BG_R, this.BG_G, this.BG_B));
        final JLabel trophyLabel = new JLabel(trophy, SwingConstants.CENTER);
        final JLabel messageLabel = new JLabel(message, SwingConstants.CENTER);
        trophyLabel.setSize(contentPane.getSize().width/3, contentPane.getSize().height/3);
        messageLabel.setSize(contentPane.getSize().width/3, contentPane.getSize().height/3);
        trophyLabel.setForeground(Color.WHITE);
        messageLabel.setForeground(Color.WHITE);
        trophyLabel.setFont(new Font("Serif", Font.BOLD, 32));
        messageLabel.setFont(new Font("Serif", Font.PLAIN, 24));
        final JButton hideButton = new JButton("Ok");
        hideButton.addActionListener(e->{
            this.isShowing = false;
            localPopup[0].hide();
        });
        contentPane.add(trophyLabel);
        contentPane.add(messageLabel);
        contentPane.add(hideButton);
        if (root.isShowing()) {
            java.awt.Point parentLocation = root.getLocationOnScreen();
            x = parentLocation.x + (root.getWidth() - contentPane.getPreferredSize().width) / 2;
            y = parentLocation.y + (root.getHeight() - contentPane.getPreferredSize().height) / 2;
        } else {
            java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
            x = (screenSize.width - contentPane.getPreferredSize().width) / 2;
            y = (screenSize.height - contentPane.getPreferredSize().height) / 2;
        }
        this.isShowing = true;
        localPopup[0] =  javax.swing.PopupFactory.getSharedInstance().getPopup(
                root,
                contentPane,
                x,
                y
        );
        return localPopup[0];
    }

    private Popup endGamePopup(final String message) {
        final Popup[] localPopupReference = new Popup[1];
        final int codePoint = 1098;
        final String trophy = new String(Character.toChars(codePoint));
        final JComponent contentPane = new JPanel(new GridLayout(this.rows, this.cols, this.hGap, this.vGap));
        contentPane.setPreferredSize(new java.awt.Dimension(300, 200));
        Border line = BorderFactory.createLineBorder(Color.getHSBColor(30, 100, 72), 2);
        Border padding = BorderFactory.createEmptyBorder(20, 20, 20, 20);
        contentPane.setBorder(BorderFactory.createCompoundBorder(line, padding));
        contentPane.setBackground(new Color(this.BG_R, this.BG_G, this.BG_B));
        contentPane.setSize(toolkit.getScreenSize().width, toolkit.getScreenSize().height);
        final JLabel trophyLabel = new JLabel(trophy, SwingConstants.CENTER);
        final JLabel messageLabel = new JLabel(message, SwingConstants.CENTER);
        trophyLabel.setSize(contentPane.getSize().width/3, contentPane.getSize().height/3);
        messageLabel.setSize(contentPane.getSize().width/3, contentPane.getSize().height/3);
        trophyLabel.setForeground(Color.WHITE);
        messageLabel.setForeground(Color.WHITE);
        trophyLabel.setFont(new Font("Serif", Font.BOLD, 32));
        messageLabel.setFont(new Font("Serif", Font.PLAIN, 24));

        exit.setSize(contentPane.getSize().width/3, contentPane.getSize().height/3);
        exit.addActionListener(
                e -> {
                    this.isShowing = false;
                    localPopupReference[0].hide();
                }
        );
        final JButton returnHome = new JButton("Home");
        returnHome.addActionListener(e -> {
            Window frame = SwingUtilities.getWindowAncestor(root);
            if (frame instanceof GameViewImpl gameView) {
                gameView.showMainMenu();
            }
            if (localPopupReference[0] != null) {
                localPopupReference[0].hide();
            }
        });
        final JButton leaderboard = getLeaderboard();
        final int width = toolkit.getScreenSize().width / 5;
        final int height = toolkit.getScreenSize().height / 5;
        contentPane.setSize(width, height);
        contentPane.add(trophyLabel);
        contentPane.add(messageLabel);
        contentPane.add(returnHome);
        contentPane.add(leaderboard);
        contentPane.add(exit);
        if (root.isShowing()) {
            java.awt.Point parentLocation = root.getLocationOnScreen();
            x = parentLocation.x + (root.getWidth() - contentPane.getPreferredSize().width) / 2;
            y = parentLocation.y + (root.getHeight() - contentPane.getPreferredSize().height) / 2;
        } else {
            java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
            x = (screenSize.width - contentPane.getPreferredSize().width) / 2;
            y = (screenSize.height - contentPane.getPreferredSize().height) / 2;
        }
        localPopupReference[0] = javax.swing.PopupFactory.getSharedInstance().getPopup(
                root,
                contentPane,
                x,
                y
        );
        this.isShowing = true;
        return localPopupReference[0];
    }

    private Popup pausePopup() {
        final Popup[] localPopupReference = new Popup[1];

        final JComponent contentPane = new JPanel(new GridLayout(rows, cols, hGap, vGap));
        contentPane.setPreferredSize(new java.awt.Dimension(300, 200));
        Border line = BorderFactory.createLineBorder(Color.getHSBColor(30, 100, 72), 2);
        Border padding = BorderFactory.createEmptyBorder(20, 20, 20, 20);
        contentPane.setBorder(BorderFactory.createCompoundBorder(line, padding));
        contentPane.setBackground(new Color(this.BG_R, this.BG_G, this.BG_B));
        final JLabel pauseLabel = new JLabel("PAUSE", SwingConstants.CENTER);
        pauseLabel.setSize(contentPane.getSize().width/3, contentPane.getSize().height/3);
        pauseLabel.setFont(new Font("Serif", Font.BOLD, 32));
        pauseLabel.setForeground(Color.WHITE);
        contentPane.add(pauseLabel);
        final JButton returnHome = new JButton("Home");
        returnHome.addActionListener(e -> {
            Window frame = SwingUtilities.getWindowAncestor(root);
            if (frame instanceof GameViewImpl gameView) {
                gameView.showMainMenu();
            }
            if (localPopupReference[0] != null) {
                localPopupReference[0].hide();
            }
        });
        contentPane.add(returnHome);
        exit.addActionListener(e -> {
            this.isShowing = false;
                    Window frame = SwingUtilities.getWindowAncestor(root);
                    frame.dispose();
                    System.exit(0);
                }
        );
        contentPane.add(exit);
        contentPane.invalidate();
        java.awt.Dimension actualSize = contentPane.getPreferredSize();
        if (root.isShowing()) {
            java.awt.Point parentLocation = root.getLocationOnScreen();
            x = parentLocation.x + (root.getWidth() - actualSize.width) / 2;
            y = parentLocation.y + (root.getHeight() - actualSize.height) / 2;
        } else {
            java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
            x = (screenSize.width - actualSize.width) / 2;
            y = (screenSize.height - actualSize.height) / 2;
        }
        localPopupReference[0] = javax.swing.PopupFactory.getSharedInstance().getPopup(
                this.root,
                contentPane,
                x,
                y
        );
        this.isShowing = true;
        return localPopupReference[0];
    }

    private JButton getLeaderboard() {
        final JButton leaderboard = new JButton("Leaderboard");
        leaderboard.addActionListener(e -> {
                    Window parentFrame = SwingUtilities.getWindowAncestor(root);
                    List<Pair<String, String>> scoreboard = this.leaderboardSupplier.get();
                    LeaderboardView leaderboardView = new LeaderboardView(scoreboard);
                    JDialog dialog = new JDialog(parentFrame, "Leaderboard", Dialog.ModalityType.APPLICATION_MODAL);
                    dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    dialog.add(leaderboardView, BorderLayout.CENTER);
                    dialog.setSize(leaderboardView.getSize());
                    dialog.setLocationRelativeTo(parentFrame);
                    dialog.setVisible(true);
                }
        );
        return leaderboard;
    }

    public boolean isShowing(){
        return this.isShowing;
    }
}
