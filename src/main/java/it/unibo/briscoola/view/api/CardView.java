package it.unibo.briscoola.view.api;

import java.awt.event.ActionListener;

public interface CardView {

    /**
     * Mostra la carta a schermo, se uno dei parametri è null mostra il retro.
     * @param seed  Il seme della carta.
     * @param value Il valore della carta.
     */
    void renderCard(String seed, String value);

    /**
     * Per la gestione del click sulla carta
     * @param listener l'azione da eseguire al click
     */
    void addCardClickListener(ActionListener listener);
}
