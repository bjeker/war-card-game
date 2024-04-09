package main;

import views.MainMenuView;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.setRoundLimit("150");
        game.playGame();
        game.playGame();
        game.playGame();

        MainMenuView mmView = new MainMenuView();
        mmView.displayMainMenu();
    }
}
