package main;

import views.MainMenuView;

/**
 * Game Initializer for the main meny.
 */
public class Main {
    public static void main(String[] args) {
        MainMenuView mmView = new MainMenuView();
        mmView.displayMainMenu();
    }
}
