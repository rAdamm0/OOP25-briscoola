package it.unibo.briscoola.model.impl.game;

import it.unibo.briscoola.model.api.card.Card;
import it.unibo.briscoola.model.api.player.Player;
import it.unibo.briscoola.model.impl.leaderboard.ScoreEntryImpl;

import java.util.Objects;

public record RoundPlay(Player player, Card card) {

    public RoundPlay(final Player player, final Card card) {
        this.player = player.copy();
        this.card = card;
    }

    @Override
    public Player player() {
        return this.player.copy();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final RoundPlay that = (RoundPlay) o;
        return Objects.equals(player, that.player) && Objects.equals(card, that.card);
    }
}
