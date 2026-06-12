package it.unibo.briscoola.model.api.game;


public interface GameBuilder {


    /**
     * It generate a new istance of GameModel,
     * starting the deck, giving the values and seed
     * to each card of the deck
     */
    GameModel build();
}
