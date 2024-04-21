package views;

import main.Deck;
import main.Hand;
import main.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePlayView {

    public void display() {
        JFrame gameFrame = new JFrame("War: A Card Game");
        JFrame handFrame = new JFrame("Player 1 Hand");
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
                handFrame.dispose();
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
        panel.add(playButton);
        panel.add(returnButton);
        panel.add(exitButton);
        gameFrame.add(panel);

        //center game frame above the hand
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int gf_x = (screenSize.width - gameFrame.getWidth()) / 2;
        int gf_y = 0;

        // Set the frame location
        gameFrame.setLocation(gf_x, gf_y);

        //below starts funcitonality for the game and hand
        Deck deck = new Deck();
        Player p1 = new Player();
        Player p2 = new Player();
        deck.shuffle();
        deck.deal(p1,p2);

        Hand hand1 = new Hand(p1.getDeck());
        Hand hand2 = new Hand(p2.getDeck());
        HandView handView = new HandView(hand1.getCards());
        //prevents the user from losing access to their hand
        handFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        handFrame.getContentPane().add(handView);
        handFrame.pack();

        // Adjust handFrame size based on the number of cards
        int cardWidth = 40;
        int overlap = 20; // Amount of overlap between cards
        int frameWidth = hand1.getCards().size() * (cardWidth-3); // Add some padding
        int frameHeight = 100; // Set initial height
        handFrame.setSize(frameWidth, frameHeight);

        int h_x = (screenSize.width - handFrame.getWidth()) / 2; // Center horizontally
        int h_y = gameFrame.getHeight() + 30; // Position below the game JFrame
        handFrame.setLocation(h_x, h_y);

        handFrame.setVisible(true);
        //hand functionality finished

        gameFrame.setVisible(true);
    }
}
