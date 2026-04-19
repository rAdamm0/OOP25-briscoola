package it.unibo.briscoola.model.api.game;

import java.util.Map;

import it.unibo.briscoola.model.api.attributes.CardSeed;
import it.unibo.briscoola.model.api.card.Card;
import it.unibo.briscoola.model.api.player.Player;

public interface TrickCardHandler {

    /**
     * Determine the winner of the hand 
     * @param plays the map of the players and their deck
     * @param firstPlayer the pplayer that started the hand 
     * @param briscola the seed with higher position in hierarchy
     * @return the player that won the ghand
     */
    Player resolveTrick(Map<Player, Card> plays, Player firstPlayer, CardSeed briscola);
}
