package it.unibo.briscoola.controller.impl;

import it.unibo.briscoola.controller.api.GameController;
import it.unibo.briscoola.model.api.card.Card;
import it.unibo.briscoola.model.api.game.GameModel;
import it.unibo.briscoola.model.api.player.Player;
import it.unibo.briscoola.model.impl.game.RoundWinner;
import it.unibo.briscoola.model.impl.player.cpu.CpuPlayer;
import it.unibo.briscoola.view.api.View;

public class GameControllerImpl implements GameController {

    private final GameModel model;
    private final View view;

    public GameControllerImpl(final GameModel model,final View view) {
        this.model = model;
        this.view = view;
        this.view.setGameController(this);
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
            view.displayMessage("The game is finished.");
            return;
        }

        if (model.isRoundOver()){
            RoundWinner winner = model.endRound();
            view.displayMessage("Round won by: " + winner.player().getId() + ", with " + winner.player().getPoints() + " points!");
            // TODO: update pile
            manageTurn();
            return;
        }

        Player currentPlayer = model.getCurrentPlayer();
        // TODO: View gets updated with model.getRoundState() the change of player
        view.displayMessage("It's " + ((currentPlayer.getId() == 0) ? "Player" : "CPU"));

        if(currentPlayer instanceof CpuPlayer cpu){
            Card chosenCard = cpu.playCard(model.getCurrentRoundState());
            model.makeMove(cpu, chosenCard);
            // TODO : update Table
            manageTurn();
        }else{
            // TODO: View handles the player's need of an input (human player do nothing here)
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void handlesHumanCardSelection(final int selectedIndex) {
        final Player human = model.getCurrentPlayer();
        final Card card = human.getHand().get(selectedIndex);
        
        model.makeMove(human, card);
        view.updateHand(0, human.getHand()); 
        
        manageTurn();
    }

}
