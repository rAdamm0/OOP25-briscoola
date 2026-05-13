package it.unibo.briscoola.model.impl.player.cpu.strategies;

import it.unibo.briscoola.model.api.card.Card;
import it.unibo.briscoola.model.api.player.PlayStrategy;
import it.unibo.briscoola.model.impl.game.RoundStateImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Strategy of the CPU for choosing the card to be played in Medium Difficulty.
 * Points to use the best fit for the card present on the table.
 */
public class MediumStrategy implements PlayStrategy {

    private final Logger logger = LoggerFactory.getLogger(MediumStrategy.class);
    /**
     * {@inheritDoc}
     */
    @Override
    public int cardIndex(final List<Card> hand, RoundStateImpl state) {
        Optional<Card> canBeat = hand.stream()
                .filter(card ->
                        state.playedCards().stream()
                                .allMatch(it->
                                        card.getCardPower() > it.card().getCardPower()))
                .limit(1).findFirst();
        return canBeat.map(hand::indexOf).orElseGet(() -> hand.indexOf(hand.stream().min(Comparator.comparingInt(Card::getCardPower)).orElseThrow()));
    }
}
