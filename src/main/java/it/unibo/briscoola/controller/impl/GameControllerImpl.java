package it.unibo.briscoola.controller.impl;

import it.unibo.briscoola.controller.api.GameController;
import it.unibo.briscoola.model.api.attributes.CardSeed;
import it.unibo.briscoola.model.api.attributes.CardValue;
import it.unibo.briscoola.model.api.card.Card;
import it.unibo.briscoola.model.api.game.GameModel;
import it.unibo.briscoola.model.api.game.RoundManager;
import it.unibo.briscoola.model.api.player.Player;
import it.unibo.briscoola.model.impl.card.StandardCardImpl;
import it.unibo.briscoola.model.impl.game.GameModelImpl;
import it.unibo.briscoola.model.impl.game.RoundManagerImpl;
import it.unibo.briscoola.model.impl.game.RoundWinner;
import it.unibo.briscoola.model.impl.player.cpu.CpuPlayer;
import it.unibo.briscoola.view.api.View;
import it.unibo.briscoola.view.impl.GameViewImpl;

public class GameControllerImpl implements GameController {

    private final GameModel model;
    private final View view;

    public GameControllerImpl(GameModel model, View view) {
        this.model = model;
        this.view = view;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void startGame() {
        model.startMatch();
        manageTurn();
    }

    /**
     * Handles a singular turn making requests to the model.
     */
    @Override
    public void manageTurn() {
        if(model.isGameOver()){
            // TODO: View shows the end of the game screen
            return;
        }
        if(model.isRoundOver()){
            RoundWinner winner = model.endRound();
            // TODO: View shows to screen the RoundWinner and the points
            manageTurn();
            return;
        }

        Player currentPlayer = model.getCurrentPlayer();
        // TODO: View gets updated with model.getRoundState() the change of player

        if(currentPlayer instanceof CpuPlayer cpu){
            Card chosenCard = cpu.playCard(model.getCurrentRoundState());
            model.makeMove(cpu, chosenCard);
            manageTurn();
        }else{
            //TODO: View handles the player's need of an input
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void handleHumanCardSelection(String value, String seed) {
        // TODO: View disables the human card selection
        Player human = model.getCurrentPlayer();
        Card selectedCard = new StandardCardImpl(CardValue.valueOf(value), CardSeed.valueOf(seed));
        model.makeMove(human, selectedCard);
        manageTurn();
    }

}
