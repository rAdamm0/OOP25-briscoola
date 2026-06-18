package it.unibo.briscoola.view.api;

import java.awt.event.ActionListener;

public interface CardView {

    /**
     * Show the card on the screen, if one of the parameters is null show the back.
     * 
     * @param seed The seed of the card.
     * @param value The value of the card.
     */
    void renderCard(String seed, String value);

    /**
     * For managing the click on the card.
     * 
     * @param listener the action to perform on click
     */
    void addCardClickListener(ActionListener listener);
}
