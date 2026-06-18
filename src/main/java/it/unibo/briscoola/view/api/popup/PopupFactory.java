package it.unibo.briscoola.view.api.popup;

public interface PopupFactory {

    /**
     * Based on the enum element of type {@link Popups} deploys the correct JPanel.
     *
     * @param popup of enum {@link Popups}
     * @param message is a {@link String} to show on the popup
     * @return a {@link PopUp} element
     */
    PopUp create (Popups popup, String message);
}
