package it.unibo.briscoola.model.impl.player;

import it.unibo.briscoola.model.api.attributes.Difficulty;
import it.unibo.briscoola.model.api.card.Card;

public class CPUPlayer extends PlayerImpl{

    private final Difficulty difficulty;

    public CPUPlayer(int id, Difficulty difficulty) {
        super(id);
        this.difficulty = difficulty;
    }

    public Card chooseCard(){
        return null;

    }

    public Difficulty getDifficulty(){
        return this.difficulty;
    }
}
