package main.views;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class PlayGameView {
    private JFrame gameFrame;
    private JComboBox<String> playerTypeComboBox;
    private JTextField roundLimitField;

    public void display()
    {
        gameFrame = new JFrame("Game Setup");
        gameFrame.setSize(400, 200);
        gameFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel mainPanel = new JPanel(new GridLayout(3, 1));

        JPanel playerTypePanel = new JPanel(new FlowLayout());
        JLabel playerTypeLabel = new JLabel("Select Opponent Type: ");
        playerTypeComboBox = new JComboBox<>(new String[]{"CPU", "Player"});
        playerTypePanel.add(playerTypeLabel);
        playerTypePanel.add(playerTypeComboBox);

        JPanel roundLimitPanel = new JPanel(new FlowLayout());
        JLabel roundLimitLabel = new JLabel("Enter Round Limit: ");
        roundLimitField = new JTextField(10);
        roundLimitPanel.add(roundLimitLabel);
        roundLimitPanel.add(roundLimitField);

        // Start Game Button
        JPanel startGamePanel = new JPanel(new FlowLayout());
        JButton startGameButton = new JButton("Start Game");
//need functionality for start game button

        startGamePanel.add(startGameButton);

        mainPanel.add(playerTypePanel);
        mainPanel.add(roundLimitPanel);
        mainPanel.add(startGamePanel);

        gameFrame.add(mainPanel);
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setVisible(true);
    }
}