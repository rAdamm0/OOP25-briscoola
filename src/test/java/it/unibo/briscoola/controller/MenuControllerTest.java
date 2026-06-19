package it.unibo.briscoola.controller;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;

import it.unibo.briscoola.controller.api.GameController;
import it.unibo.briscoola.controller.api.MenuController;
import it.unibo.briscoola.controller.impl.MenuControllerImpl;
import it.unibo.briscoola.model.api.card.Card;
import it.unibo.briscoola.view.api.View;

/**
 * Test class created to check the correct funcitioning of {@link MenuControllerImpl}
 * 
 * @author Andrea Reggiani
 */
class MenuControllerTest {
    
    private MenuController testMenuController;
    private View testView;

    @BeforeEach
    final void init() {
        this.testView= new View() {
            @Override 
            public void setMenuController(final MenuController menuControllerTest) {}

            @Override
            public void setGameController(final GameController gameControllerTest) {}

            @Override
            public void start() {}

            @Override
            public void initGame() {}

            @Override
            public void updateHand(int playerIdTest, List<Card> handCardsTest) {}

            @Override
            public void updatePile(int cardsCountTest, boolean playerTest) {}

            @Override
            public void displayMessage(String messageTest) {}

            @Override
            public void updateBriscola(String seedTest, String valueTest) {}

            @Override
            public void quit() {}

            @Override
            public void updateTable(String playerSeedTest, String playerValuetest, String cpuSeedTest, String cpuValueTest) {}
        };
        this.testMenuController= new MenuControllerImpl(null, this.testView);
    }
    

    
}
