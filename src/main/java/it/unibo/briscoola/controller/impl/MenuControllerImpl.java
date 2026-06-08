package it.unibo.briscoola.controller.impl;

import java.util.List;
import java.util.ArrayList;

import it.unibo.briscoola.view.api.View;
import it.unibo.briscoola.controller.api.MenuController;
import it.unibo.briscoola.model.api.game.GameModel;
import it.unibo.briscoola.model.api.player.Player;
import it.unibo.briscoola.model.impl.player.PlayerImpl;

public class MenuControllerImpl implements MenuController {

    private final GameModel model;
    private final View view;

    public MenuControllerImpl( final GameModel model, final View view){
        this.model=model;
        this.view=view;
    }



    /**
     * {@inheritDoc}
     */
    @Override
    public void startGame(final int numPlayers) {
        if(numPlayers !=2 && numPlayers != 4){
            throw new IllegalArgumentException("Il gioco supporta solo modalità a 2 o 4 giocatori");
        }
        /**
        * Creation of players
        */
        final List<Player> players = new ArrayList<>();
        for(int i=1;i <= numPlayers; i++){
            players.add(new PlayerImpl(i));
        }

        /**
         * Configure the game model
         * to remove the comment
         * this.model.setPlayers(players);
         */
        this.model.startMatch();

        /**
         * to remove the comment
         * this.view.initGameLayout(numPlayers); 
         */
    }
    
}
