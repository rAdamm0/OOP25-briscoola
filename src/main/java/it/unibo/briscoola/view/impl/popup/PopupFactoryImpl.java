package it.unibo.briscoola.view.impl.popup;

import it.unibo.briscoola.view.api.popup.PopupFactory;
import it.unibo.briscoola.view.api.popup.Popups;

import javax.swing.*;
import java.awt.*;

public class PopupFactoryImpl implements PopupFactory {

    /**
     * {@inheritDoc}
     */
    @Override
    public Popup create(JRootPane root, Popups popup, String message) {
        switch (popup){
            case WINNER -> {
                return this.roundWinnerPopup(root, message);
            }
            case ENDGAME -> {
                return this.endGamePopup(root, message);
            }
        }
        return /*TODO*/ null;
    }

    private Popup roundWinnerPopup(final JRootPane root, final String message){
        String trophy = new String(Character.toChars(1096));
        JComponent component = new JPanel(new GridLayout(0,1));
        component.add(new JLabel(trophy));
        component.add(new JLabel(message));
        return javax.swing.PopupFactory.getSharedInstance().getPopup(
                root,
                component,
                0,
                0
        );
    }

    private Popup endGamePopup(final JRootPane root, final String message){
        String trophy = new String(Character.toChars(1098));
        JComponent component = new JPanel(new GridLayout(0,1));
        component.add(new JLabel(trophy));
        component.add(new JLabel(message));
        return javax.swing.PopupFactory.getSharedInstance().getPopup(
                root,
                null,
                0,
                0
        );
    }
}
