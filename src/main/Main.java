package main;

import main.views.LeaderboardView;
import main.views.mainMenuView;

public class Main {
    public static void main(String[] args) {
        LeaderboardView lbView = new LeaderboardView();
        mainMenuView mmView = new mainMenuView();

        Game game = new Game();
        mmView.displayMainMenu();

        game.setRoundLimit(150);
        game.playGame();
        game.playGame();
        game.playGame();
    }

}
