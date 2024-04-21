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
        panel.add(playButton);
        panel.add(returnButton);
        panel.add(exitButton);
        gameFrame.add(panel);


        Deck deck = new Deck();
        Player p1 = new Player();
        Player p2 = new Player();
        deck.shuffle();
        deck.deal(p1,p2);

        Hand hand1 = new Hand(p1.getDeck());
        Hand hand2 = new Hand(p2.getDeck());
        HandView handView = new HandView(hand1.getCards());
        JFrame frame = new JFrame("Player 1 Hand");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(handView);
        frame.pack();

        // Adjust frame size based on the number of cards
        int cardWidth = 40; // Width of each card
        int overlap = 10; // Amount of overlap between cards
        int frameWidth = hand1.getCards().size() * (cardWidth - overlap) + 50; // Add some padding
        int frameHeight = 100; // Set initial height
        frame.setSize(frameWidth, frameHeight);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - frame.getWidth()) / 2; // Center horizontally
        int y = (int) (screenSize.height * 0.75); // Position below the game JFrame
        frame.setLocation(x, y);

        frame.setVisible(true);


        gameFrame.setVisible(true);
    }
}
