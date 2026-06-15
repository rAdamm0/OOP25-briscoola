package it.unibo.briscoola.controller.impl;

import java.util.List;
import java.util.ArrayList;

import it.unibo.briscoola.view.api.View;
import it.unibo.briscoola.controller.api.MenuController;
import it.unibo.briscoola.model.api.attributes.Difficulty;
import it.unibo.briscoola.model.api.game.GameBuilder;
import it.unibo.briscoola.model.api.game.GameModel;
import it.unibo.briscoola.model.api.player.Player;
import it.unibo.briscoola.model.impl.game.GameBuilderImpl;
import it.unibo.briscoola.model.impl.player.PlayerImpl;

public class MenuControllerImpl implements MenuController {

    private GameModel model;
    private View view;

    public MenuControllerImpl( final GameModel model, final View view){
        this.model=model;
        this.view=view;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void startGame(final int numPlayers,final Difficulty difficulty) {
        if(numPlayers !=2 && numPlayers != 4){
            throw new IllegalArgumentException("Il gioco supporta solo modalità a 2 o 4 giocatori");
        }
        if(difficulty == null){
            throw new IllegalArgumentException("La difficolta non puo essere nulla");
        }

        final GameBuilderImpl builder = new GameBuilderImpl();
        builder.setDifficulty(difficulty);

        /**
         * Id cof CPU starts from 1, because 0 is reserved for Human player
         */
        for(int i=1 ; i< numPlayers; i++){
            builder.addPlayer();
        }
        this.model=builder.build();


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
        this.view.initGame(); 
    }
    
}
