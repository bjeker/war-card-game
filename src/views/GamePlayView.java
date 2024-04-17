package views;

import main.Card;
import main.Game;
import main.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePlayView {

    public void display() {
        JFrame gameFrame = new JFrame("War: A Card Game");
        gameFrame.setSize(800,500);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new FlowLayout());
        JButton playButton = new JButton("Play Again");
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action to perform when "Play Again" button is clicked
                gameFrame.dispose();
                GameSetupView gameSetupView = new GameSetupView();
                gameSetupView.display();
            }
        });
        JButton returnButton = new JButton("Return to Main Menu");
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action to perform when "Return to Main Menu" button is clicked
                gameFrame.dispose();
                MainMenuView mainMenuView = new MainMenuView();
                mainMenuView.displayMainMenu();
            }
        });
        JButton exitButton = new JButton("Exit Game");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action to perform when "Exit Game" button is clicked
                System.exit(0);
            }
        });

        //play card btn
        JButton playCardButton = new JButton("Play Card");
        playCardButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Player player = new Player();
                Game myGame = new Game();
                player.playCard();
                Card pCard = player.playCard();System.out.println("Round " + myGame.getCurrentRound());
                System.out.print(player.getName() + " card: ");
                pCard.display();
                PlayListener();
            }
        });

        panel.add(playButton);
        panel.add(returnButton);
        panel.add(exitButton);
        panel.add(playCardButton);
        gameFrame.add(panel);

        gameFrame.setVisible(true);
    }

    //play card btn listener
    public void PlayListener()
    {
        Game myGame = new Game();
        myGame.setCurrentRound();
    }
}
