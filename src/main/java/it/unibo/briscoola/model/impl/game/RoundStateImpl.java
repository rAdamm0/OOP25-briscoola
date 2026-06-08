package it.unibo.briscoola.model.impl.game;

import it.unibo.briscoola.model.api.attributes.CardSeed;

import java.util.List;
import java.util.Optional;

public record RoundStateImpl(List<RoundPlay> playedCards, CardSeed briscola, Optional<CardSeed> leadSeed) {


    /**
     * {@inheritDoc}
     */
    @Override
    public List<RoundPlay>  playedCards() {
        return List.copyOf(this.playedCards);
    }
}
