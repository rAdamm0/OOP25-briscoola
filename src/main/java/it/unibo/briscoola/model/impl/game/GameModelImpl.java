package it.unibo.briscoola.model.impl.game;

import java.util.List;
import java.util.Optional;

import it.unibo.briscoola.model.api.card.Card;
import it.unibo.briscoola.model.api.deck.Deck;
import it.unibo.briscoola.model.api.game.GameModel;
import it.unibo.briscoola.model.api.player.Player;

public class GameModelImpl implements GameModel{

    private final Deck<Card> deck;
    private final List<Player> players;
    private Card briscolaCard;

    public GameModelImpl(final List<Player> players, final Deck<Card> deck) {
        this.players = players;
        this.deck = deck;
        this.assignBriscola();
    }

    /** 
     * {@inheritDoc}
     */
    @Override
    public void startMatch() {
        this.assignBriscola();
        this.dealInitialCards();
         
    }

    /** 
     * {@inheritDoc}
     */
    @Override
    public Optional<Card> getBriscolaSeed() {
        return Optional.ofNullable(this.briscolaCard);
    }

    /** 
     * {@inheritDoc}
     */
    @Override
    public void assignBriscola() {
        this.briscolaCard= this.deck.getBriscolaSeed().orElseThrow();
    }

    /** 
     * {@inheritDoc}
     */
    @Override
    public void dealInitialCards() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dealInitialCards'");
    }

    /** 
     * {@inheritDoc}
     */
    @Override
    public void drawAfterTrick(Player winner, Player loser) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'drawAfterTrick'");
    }

    /** 
     * {@inheritDoc}
     */
    @Override
    public Card playCard(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'playCard'");
    }

    /** 
     * {@inheritDoc}
     */
    @Override
    public boolean isGameOver() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isGameOver'");
    }
}
