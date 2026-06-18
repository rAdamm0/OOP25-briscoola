package it.unibo.briscoola.view.impl.popup;

import it.unibo.briscoola.view.api.popup.PopupFactory;
import it.unibo.briscoola.view.api.popup.Popups;

import javax.swing.*;

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
        return javax.swing.PopupFactory.getSharedInstance().getPopup(
                root,
                null,
                0,
                0
        );
    }

    private Popup endGamePopup(final JRootPane root, final String message){
        return javax.swing.PopupFactory.getSharedInstance().getPopup(
                root,
                null,
                0,
                0
        );
    }
}
